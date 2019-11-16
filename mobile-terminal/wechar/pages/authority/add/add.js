// pages/authority/add/add.js
Page({

  /**
   * Initial data of the page
   */
  data: {
    username:'',
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
  submitButton: function () {
    if (this.data.username == ""){
      wx.showModal({
        showCancel: false,
        title: 'wrong',
        content: 'Username can not be empty',
        confirmText: "Confirm",
      })
    }
    else{
      if (this.data.password == "") {
        wx.showModal({
          showCancel: false,
          title: 'wrong',
          content: 'password can not be empty',
          confirmText: "Confirm",
        })
      }
      else{
        if (this.data.username == "admin") {
          wx.showModal({
            showCancel: false,
            title: 'wrong',
            content: 'Username already exists',
            confirmText: "Confirm",
          })
        }
        else{
          if(this.data.hx_index==0){
            wx.showModal({
              showCancel: false,
              title: 'wrong',
              content: 'Please set the role',
              confirmText: "Confirm",
            })
          }
          else{
            wx.showToast({
              title: 'success',//提示文字
              duration: 2000,//显示时长
              mask: true,//是否显示透明蒙层，防止触摸穿透，默认：false  
              icon: 'success', //图标，支持"success"、"loading" 
            })
            var app = getApp();
            app.globalData.userFlag=true;
            this.onLoad();
          }
        }
      }
    }
    
  },
  cancelButton:function(){
    this.onLoad();
  },
  usernameInput: function (e) {
    this.setData({
      username: e.detail.value
    })
    // console.log(e.detail.value)
  },
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
    // console.log(e.detail.value)
  },
  phoneInput: function (e) {
    this.setData({
      phone: e.detail.value
    })
    // console.log(e.detail.value)
  },
  nicknameInput: function (e) {
    this.setData({
      nickname: e.detail.value
    })
    // console.log(e.detail.value)
  },
  firstnameInput: function (e) {
    this.setData({
      firstname: e.detail.value
    })
    // console.log(e.detail.value)
  },
  lastnameInput: function (e) {
    this.setData({
      lastname: e.detail.value
    })
    // console.log(e.detail.value)
  },
  emailInput: function (e) {
    this.setData({
      email: e.detail.value
    })
    // console.log(e.detail.value)
  },
  roleInput: function (e) {
    this.setData({
      role: e.detail.value
    })
    // console.log(e.detail.value)
  },
  commodityButton:function(){
wx.navigateTo({
  url: '/pages/authority/update/update',
})
  },
})