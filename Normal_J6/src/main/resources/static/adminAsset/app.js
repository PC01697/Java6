app.controller("header-footer", function ($scope) {
  $scope.navbar = "../adminAsset/components/navbar.html";
  $scope.aside = "../adminAsset/components/aside.html"
   $scope.footer = "../adminAsset/components/footer.html";
});

app.controller("categoryCrt",function ($scope,categoryService) {
	$scope.category = [];
	//pagination for ui boostrap
	$scope.currentPage= 1;
	$scope.pageSize = 5;
	categoryService.categoryGetAll().then(function(data){
		$scope.category = data;
		console.log($scope.category);
	});
	//for ng-click
	$scope.categoryCreate = function(){
		$scope.nameCategory;
		var categoryEntity = {
			nameCategory: $scope.nameCategory
		};
	}
});
