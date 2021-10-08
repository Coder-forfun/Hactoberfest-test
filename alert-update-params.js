(function (params) {
  
  window.alert = function (desc, no = 1) {
    let newNo = no - 1
    if (newNo > 0) {
       alert(desc, newNo)
    }
    return params.apply(this, arguments)
  }
  
})(window.alert)

alert('hy Upkoding', 5)
