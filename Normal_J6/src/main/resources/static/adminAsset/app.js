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
	$scope.name;
	//pagination for ui boostrap
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	categoryService.categoryGetAll().then(function(response) {
		$scope.category = response.data;
		});
	
	
	
	
	//for ng-click
	//using apply for refrest data table
	
	$scope.categoryCreate = function() {
		var categoryEntity = {
			name: $scope.name
		};
		
		//console.log(categoryEntity.name)
		categoryService.categoryCreate(categoryEntity).then(function successCallback(response){
			console.log(response.status)
		}, function errorCallback(response){
			//console.log(response.data.errors)
			$scope.alertError = [
				{type: 'danger', msg:response.data.errors.toString()}
			]
			console.log($scope.alertError)
		});
		
		setTimeout(function () {
         	$scope.$apply(function () {
         		categoryService.categoryGetAll().then(function(response) {
				$scope.category = response.data;
			});
         		})
        // AngularJS unaware of update to $scope
    }, 1), function(respone){
	console.log(respone);
};
    
    $scope.name = '';
	}
	
	
});
