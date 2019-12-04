// pages/inventory/itemDetails/itemDetails.js
let http = require('../../../utils/requestService.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    infoNum:0,
    currentTab: 0, //预设当前项的值
    info:{},
    list:[
      
    ],
    recordList:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.model);
    var that = this;
    wx.request({
      url: 'http://172.20.10.6:8761/findByModel',
      data: {
        model: options.model
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success: function (res) {
        console.log(res.data)//打印到控制台
        let infoList = res.data;
        let inventoryList = res.data;
        let num = 0;
        for (let i = 0; i < infoList.length; i++) {
          num += infoList[i].num;
        }
        
        that.setData({
          infoNum: num,
          info: infoList[0],
          list: inventoryList
        });
        console.log(that.data.list);
        console.log(res);
      }
    })
    wx.request({
      url: 'http://172.20.10.6:8761/findRecord',
      data: {
        model: options.model
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success: function (res) {
        let recordList = [];
        let recordInfo = res.data;
        console.log(recordInfo);
        for (var i = 0; i < recordInfo.length; i++) {
          var date = new Date(recordInfo[i].time);
          var year = date.getFullYear() + '-';
          var moth = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
          var day = date.getDate() + ' ';
          var h = date.getHours() + ':';
          var m = date.getMinutes() + ':';
          var s = date.getSeconds(); 
          let str = recordInfo[i].operator + "," + year + moth + day + h + m + s + " at " + recordInfo[i].warehouse + "，" + recordInfo[i].operation + " " + recordInfo[i].num + " " + recordInfo[i].brand + " " + recordInfo[i].category + " "+ recordInfo[i].model;
          recordList.push(str);
        }
        that.setData({
          recordList: recordList,
        })
      }
    })
      /**
       * 查询记录
       */

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

  // 点击标题切换当前页时改变样式
  swichNav: function (e) {
    var cur = e.target.dataset.current;
    if (this.data.currentTaB == cur) { return false; }
    else {
      this.setData({
        currentTab: cur
      })
    }
  },


})