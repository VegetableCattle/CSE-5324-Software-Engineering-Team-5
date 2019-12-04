// pages/storage/storage.js

let http = require('../../utils/requestService.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    warehouseArray: ['Please choose', 'Warehouse 1', 'Warehouse 2', 'Warehouse 3'],
    warehouseIndex: 0,
    brandArray: ['Please choose', 'brand 1', 'brand 2', 'brand 3', 'brand 4', 'brand 5', 'brand 6'],
    brandIndex:0,
    categoryArray: ['Please choose', 'air conditioner', 'refrigerator', 'washing machine', 'heater', 'television', 'category 1', 'category 2', 'category 3'],
    categoryIndex: 0,
    model:"",
    num:0,
    
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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

  /**
   * 品牌改变触发事件
   */
  bindBrandChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      brandIndex: e.detail.value
    })
  },

  /**
   * 类别改变触发事件
   */
   bindCategoryChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      categoryIndex: e.detail.value
    })
  },


  /**
   * 提交添加入库
   */
  
  formSubmit: function (e) {
    var that = this;
    console.log('form发生了submit事件，携带数据为：', e.detail.value);
    if (e.detail.value.warehouse == 0 || e.detail.value.brand == 0 || e.detail.value.category == 0 || e.detail.value.model == "" || e.detail.value.num <= 0){
      
      wx.showToast({
        title: 'Please enter the correct information',
        icon: 'none',
        duration: 2000
      })
    }else{
      var that = this;
      let data = {
        warehouse: that.data.warehouseArray[that.data.warehouseIndex],
        brand: that.data.brandArray[that.data.brandIndex],                    //品牌
        category: that.data.categoryArray[that.data.categoryIndex],                      //类别
        model: e.detail.value.model,                     //型号
        num: e.detail.value.num,//数量
      };
      console.log(JSON.stringify(data))
      wx.request({
        url: 'http://172.20.10.6:8761/add',
        data: {
          data
        },
        method: 'POST',
        header: {
          'content-type': 'application/json;charset=UTF-8' // 默认值
        },
        success: function (res) {
          console.log(res.data);
          wx.showModal({
            title: 'Prompt',
            confirmText: "Confirm",
            cancelText: "Cancel",
            content: 'Successful,is continue to input?',
            success: function (res) {
              if (res.confirm) {
                that.setData({
                  warehouseIndex: 0,
                  brandIndex: 0,
                  model: "",
                  num: 0,
                  categoryIndex: 0,
                })
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消');
                wx.switchTab({
                  url: '/pages/inventory/inventory'
                })
              }
            }
          })
        }
      })
    }
    
  },
  
  formReset: function () {
    var that = this;
    console.log('form发生了reset事件');
    that.setData({
      warehouseIndex: 0,
      brandIndex: 0,
      model: "",
      num: 0,
      categoryIndex: 0,

    })
  }
  
})