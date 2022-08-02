app.controller("header-footer", function ($scope) {
  $scope.navbar = "../adminAsset/components/navbar.html";
  $scope.aside = "../adminAsset/components/aside.html"
   $scope.footer = "../adminAsset/components/footer.html";
});

app.controller("categoryCrt",function ($scope,categoryService) {
	categoryService.categoryGetAll().then(function(data){
		$scope.category = data;
		console.log($scope.category);
	});
});
