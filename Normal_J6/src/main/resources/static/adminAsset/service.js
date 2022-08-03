app.factory("categoryFactory", ($http) => {
  var service = {};
  service.GetAll = GetAll;
  function GetAll() {
    return $http
      .get("/api/categories?entry=50")
      .then(handleSuccess, handleError("Không load được user"));
  }
function handleSuccess(res) {
    return res.data;
  }
  function handleError(error) {
    return function () {
      return { success: false, message: error };
    };
  }
  return service;
});

app.service("categoryService", function (categoryFactory) {
 	this.categoryGetAll = () => {
    return categoryFactory.GetAll();
  };
});



app.service('handleMsgService', function(checkMsgShow){
  this.handleMsg = (id,msg) =>{
    return checkMsgShow.checkMsg(id,msg);
  }
})