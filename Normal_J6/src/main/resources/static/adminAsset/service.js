app.factory("categoryFactory", ($http) => {
  var service = {};
  service.GetAll = GetAll;
  service.CreatCategory = CreatCategory;
  service.DeleteCategory = DeleteCategory;
  function GetAll() {
    return $http
      .get("/api/categories");
  }
  
  function CreatCategory(categoryObject){
	 return $http
    .post("/api/categories",categoryObject);
}
function DeleteCategory(idCategory){
	 return $http
    .delete("/api/categories/" + idCategory);
}

	/* custom handle 
	
	function handleSuccess(res) {
     return res.data;
  }
    
  function handleError(error) {
    return function () {
      return { success: false, message: error};
    };
  }*/
		
  return service;
});

app.service("categoryService", function (categoryFactory) {
 	this.categoryGetAll = () => {
    return categoryFactory.GetAll();
  };
  this.categoryCreate =(categoryObject) =>{
	return categoryFactory.CreatCategory(categoryObject);
	};
	
  this.categoryDelete = (idCategory) =>{
	return categoryFactory.DeleteCategory(idCategory);
	};
});

app.service('handleMsgService', function(checkMsgShow){
  this.handleMsg = (id,msg) =>{
    return checkMsgShow.checkMsg(id,msg);
  }
})