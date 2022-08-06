app.controller("header-footer", function($scope) {
	$scope.navbar = "../adminAsset/components/navbar.html";
	$scope.aside = "../adminAsset/components/aside.html"
	$scope.footer = "../adminAsset/components/footer.html";
});




app.controller("categoryCrt", function($scope, categoryService) {
	$scope.category = [];
	$scope.alertError = [];
	  $scope.closeAlert = function(index) {
    $scope.alertError.splice(index, 1);
  };
  	$scope.id
	$scope.name;
	//pagination for ui boostrap
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	
	 function reloadTable (){
	setTimeout(function () {
         	$scope.$apply(function () {
         		categoryService.categoryGetAll().then(function(response) {
				$scope.category = response.data;
			});
         		})
        // AngularJS unaware of update to $scope
    }, 100), function(respone){
	console.log(respone);
};
}
	function clearForm(){
		$scope.id = null;
		$scope.name = null;
	}
	//for load table
	categoryService.categoryGetAll().then(function(response) {
		$scope.category = response.data;
		});
	
	//for ng-click
	//using apply for refrest data table
	$scope.categoryCreate = function() {
		var categoryEntity = {
			id: $scope.id,
			name: $scope.name
		};
		
		//console.log(categoryEntity.name)
		categoryService.categoryCreate(categoryEntity).then(function successCallback(response){
			console.log(response.status)
			if(response.status == 201){
				$scope.alertError = [
				{type: 'success', msg:"Bạn đã thêm thành công"}
			]
			clearForm();
			categoryEntity.length = 0;
			}
		}, function errorCallback(response){
			//console.log(response.data.errors)
			$scope.alertError = [
				{type: 'danger', msg:response.data.errors.toString()}
			]
			console.log($scope.alertError)
		});
		reloadTable();
	}
	$scope.show = false;
	$scope.editCategory = function(id, name){
		$scope.id = id;
		$scope.name = name;
		$scope.show = true;
	}
	$scope.deleteCategory = function(id){
		categoryService.categoryDelete(id).then(function successCallback(response){
			$scope.alertError = [
				{type: 'success', msg:"Bạn đã thêm xóa thành công"}
			]
		});
		clearForm();
		reloadTable();
	}
	
	
});
