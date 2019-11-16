// pages/authority/update/update.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    flag:false,
    username: '',
    password: '',
    phone: '',
    nickname: '',
    firstname: '',
    lastname: '',
    email: '',
    role: '',
    pic_array: [
      { id: 13, name: '-------slect-------' },
      { id: 13, name: 'Administrator' },
      { id: 14, name: 'Decision Maker' },
      { id: 15, name: 'Inventory Manager' },
    ],
    hx_index: 0,
  },
  bindPickerChange_hx: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value);
    this.setData({   //给变量赋值
      hx_index: e.detail.value,
    })
  },
  onLoad: function (options) {
    this.setData({
      username: '',
      password: '',
      phone: '',
      nickname: '',
      firstname: '',
      lastname: '',
      email: '',
      role: '',
      hx_index: 0,
    })
  },
  shopButton:function(){
    wx.navigateBack({
      url: '/pages/authority/add/add',
    })
  },
  updateButton:function(){
    if (this.data.username == "") {
      wx.showModal({
        showCancel: false,
        title: 'wrong',
        content: 'Username can not be empty',
        confirmText: "Confirm",
      })
    }
    else {
      if (this.data.username != "user" || this.data.flag == true || getApp().globalData.userFlag == false) {
          wx.showModal({
            showCancel: false,
            title: 'wrong',
            content: 'Username does not exist',
            confirmText: "Confirm",
          })
        }
        else {
          if (this.data.hx_index == 0) {
            wx.showModal({
              showCancel: false,
              title: 'wrong',
              content: 'Please set the role',
              confirmText: "Confirm",
            })
          }
          else {
            wx.showToast({
              title: 'success',//提示文字
              duration: 2000,//显示时长
              mask: true,//是否显示透明蒙层，防止触摸穿透，默认：false  
              icon: 'success', //图标，支持"success"、"loading" 
            })
            this.onLoad();
          }
        }
    }
  },
  deleteButton: function () {
    if (this.data.username == "") {
      wx.showModal({
        showCancel: false,
        title: 'wrong',
        content: 'Username can not be empty',
        confirmText: "Confirm",
      })
    }
    else {
      if (this.data.username != "user" || this.data.flag == true || getApp().globalData.userFlag == false) {
        wx.showModal({
          showCancel: false,
          title: 'wrong',
          content: 'Username does not exist',
          confirmText: "Confirm",
        })
      }
      else {
          wx.showToast({
            title: 'success',//提示文字
            duration: 2000,//显示时长
            mask: true,//是否显示透明蒙层，防止触摸穿透，默认：false  
            icon: 'success', //图标，支持"success"、"loading" 
          })
          this.setData({
            flag:true
          })
        var app = getApp();
        app.globalData.userFlag = false;
          this.onLoad();
      }
    }
  },
  usernameInput: function (e) {
    this.setData({
      username: e.detail.value
    })
    // console.log(e.detail.value)
  },
})