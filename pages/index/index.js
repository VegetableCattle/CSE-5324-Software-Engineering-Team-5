// pages/index-commodity/index-commodity.js
// var commodityName='';
// var commoditySuitAge = '';
const app = getApp()
var dq_flag = 0;
var hx_flag = 0;
var shop_flag = 0;
Page({
  data: {
    //城市   这是一个本地的对象，然后绑定到页面上
    usernameInput:"username",
    passwordInput: "password",
    passwordPassword: false,
    bottomHidden: false,
  },
  usernameFocus:function(){
    if (this.data.usernameInput == 'username'){
      this.setData({   //给变量赋值
        usernameInput: "",
      })
    }
  },
  passwordFocus: function () {
    if (this.data.passwordInput == 'password') {
      this.setData({   //给变量赋值
        passwordInput: "",
        passwordPassword: true,
      })
    }
  },
  usernameBlur: function (e) {
    this.setData({
      usernameInput: e.detail.value
    })
    // console.log(e.detail.value)
  },
  passwordBlur: function (e) {
    this.setData({
      passwordInput: e.detail.value
    })
    // console.log(e.detail.value)
  },
  commodityButton: function () {
    wx.navigateTo({
      url: '/pages/index-face/index-face',
    })
  },
  confirmButton: function () {

    if (this.data.usernameInput != "admin") {
      if (this.data.usernameInput == "user" && getApp().globalData.userFlag == true) {
        if (this.data.passwordInput != "123") {
          wx.showModal({
            showCancel: false,
            title: 'wrong',
            content: 'Password is incorrect',
            confirmText: "Confirm",
          })
        }
        else {
          wx.navigateTo({
            url: '/pages/authority/add/add',
          })
        }
      }
      else{
        wx.showModal({
          showCancel: false,
          title: 'wrong',
          content: 'Username does not exist',
          confirmText: "Confirm",
        })
      }
      
    }
    else{
      if (this.data.passwordInput != "123") {
        wx.showModal({
          showCancel: false,
          title: 'wrong',
          content: 'Password is incorrect',
          confirmText: "Confirm",
        })
      }
      else{
        wx.navigateTo({
          url: '/pages/authority/add/add',
        })
      }
    }
  },
})
