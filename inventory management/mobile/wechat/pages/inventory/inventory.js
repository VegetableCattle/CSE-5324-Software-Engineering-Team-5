// pages/inventory/inventory.js

let http = require('../../utils/requestService.js');
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    warehouseArray: ['All warehouses', 'warehouse 1', 'warehouse 2', 'warehouse 3'],
    warehouseIndex: 0,
    wxSearch:false,

    inventoryList: [{
      brand: 'Haier',
      category:"Refrigerator",
      model:"BCD-217STPQ",
      num:2,
      warehouse:"Warehouse 1",
    }, {
        brand: 'Haier',
        category: "Heater",
        model: "BCD-230STPQ",
        num: 5,
        warehouse: "Warehouse 1",
    }]
  
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('onLoad');
    var that = this;
    var wxSearch = require("./../../wxSearch/wxSearch.js");
    console.log(wxSearch);
    var WxSearch =  wxSearch;
    //初始化的时候渲染wxSearchdata 第二个为你的search高度
    WxSearch.init(that, 168, ['refrigerator', 'air conditioner', 'washing machine', 'heater', 'television']);
    WxSearch.initMindKeys(['weappdev.com', '微信小程序开发', '微信开发', '微信小程序']);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.findInfo();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    this.findInfo();
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  /**
  * 仓库改变触发事件
  */
  bindWarehouseChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      warehouseIndex: e.detail.value
    })
  },


  wxSearchFn: function (e) {
    var that = this;
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchAddHisKey(that);
    that.findInfo();

  },
  wxSearchInput: function (e) {
    var that = this
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchInput(e, that);
  },
  wxSerchFocus: function (e) {
    var that = this
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchFocus(e, that);
  },
  wxSearchBlur: function (e) {
    var that = this
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchBlur(e, that);
  },
  wxSearchKeyTap: function (e) {
    var that = this
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchKeyTap(e, that);
  },
  wxSearchDeleteKey: function (e) {
    var that = this
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchDeleteKey(e, that);
  },
  wxSearchDeleteAll: function (e) {
    var that = this;
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchDeleteAll(that);
  },
  wxSearchTap: function (e) {
    var that = this
    var WxSearch = require("./../../wxSearch/wxSearch.js");
    WxSearch.wxSearchHiddenPancel(that);
  },

  findInfo(){
    var that = this;
    var warehouse = "";
    var category = "";
    console.log(that.data.warehouseArray[1]);

    if (that.data.warehouseIndex!=0){
      warehouse = that.data.warehouseArray[that.data.warehouseIndex];
    }
    let data = {};
    if (that.data.wxSearchData.value) {
      data = { findInfo: that.data.wxSearchData.value };
      category = data.findInfo;
    }
    console.log(data);
    console.log(warehouse);
    console.log(data.findInfo);
    wx.request({
      url: 'http://172.20.10.6:8761/find',
      data: {
        warehouse: warehouse,
        category: category
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success: function (res) {
        console.log(res.data)//打印到控制台
        that.setData({
          inventoryList: res.data
        });
        // wx.redirectTo({
        //   url: '/pages/commodity/commodity?commodityName=' + that.data.commodityName + '&commoditySuitAge=' + that.data.commoditySuitAge + '&commodityplace=' + that.data.commodityplace,
        // })
      }
    })
    
    // http.sendRrquest("http://172.20.10.6:8761/find", 'POST', data, {})
    // .then(function (res) {
    //   that.setData({
    //     inventoryList: res.data.message
    //   });
    //   console.log(res);
    // }, function (error) {
    //   console.log(error);
    // });
    
  },
  clickItem(e){
    var model = e.currentTarget.dataset.model //获取传递的值
    wx.navigateTo({
      //url: 'post-detail/post-detail' //跳转详情页 切记配置app.json文件
      url: 'itemDetails/itemDetails?model=' + model //传递参数
    })
  },
  clickOut(e){
    var that = this;
    var ilist=[];
    for (let i = 0; i < e.currentTarget.dataset.info.num; i++){
      var arr=i+1;
      ilist.push(arr.toString());
      if(i==5){
        break;
      }
    }
    console.log(ilist);
    console.log("点击了按钮");
    var data = e.currentTarget.dataset.info; //获取传递的值
    console.log(data);
    wx.showActionSheet({
      itemList: ilist,
      success: function (res) {
        console.log(res.tapIndex);
        data.outNum = res.tapIndex + 1;

        wx.request({
          url: 'http://172.20.10.6:8761/edit',
          data: {
            data: JSON.stringify(data)
          },
          method: 'POST',
          header: {
            'content-type': 'application/json;charset=UTF-8' // 默认值
          },
          success: function (res) {
            that.findInfo();
          }
        })

      },
      fail: function (res) {
        console.log(res.errMsg);
      }
    })
  }
})