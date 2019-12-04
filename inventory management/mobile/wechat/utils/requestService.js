// 本服务用于封装请求
// 返回的是一个promisepromise


let sendRrquest = function (url, method, data, header) {
  let promise = new Promise(function (resolve, reject) {
    wx.request({
      data: data,
      method: method,
      header: header,
      success: resolve,
      fail: reject
    })
  });
  return promise;
};

module.exports.sendRrquest = sendRrquest 