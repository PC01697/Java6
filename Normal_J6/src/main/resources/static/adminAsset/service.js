app.factory("categoryFactory", ($http) => {
  var service = {};
  service.GetAll = GetAll;
  service.CreatCategory = CreatCategory;
  function GetAll() {
    return $http
      .get("/api/categories?entry=50")
      .then(handleSuccess, handleError("Không load được user"));
  }
  
  function CreatCategory(categoryObject){
	 return $http
    .post("/api/categories",user)
    .then(handleSuccess, handleError("Không kết nối được"));
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
  this.categoryCreate =() =>{
	return categoryFactory.CreatCategory(categoryObject);
	};
});

app.service('handleMsgService', function(checkMsgShow){
  this.handleMsg = (id,msg) =>{
    return checkMsgShow.checkMsg(id,msg);
  }
})