// pages/inventory/scan/sacn.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goodsName:'',
    barcode:'',
    price:'',
    brand:'',
    supplier:'',
    standard:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    wx.scanCode({
      onlyFromCamera:false,
      scanType:['qrCode','barCode'],
      success:function(res){
        console.log(res);
        wx.showLoading({});
        wx.request({
          url: 'https://www.mxnzp.com/api/barcode/goods/details',
          data: {
            barcode: res.result
          },
          success: function (res) {
            console.log(res);
            wx.hideLoading()
            that.setData({
              goodsName: res.data.data.goodsName,
              barcode: res.data.data.barcode,
              price: res.data.data.price,
              brand: res.data.data.brand,
              supplier: res.data.data.supplier,
              standard: res.data.data.standard
            });
          }
        })
      }
    })
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

  }
})