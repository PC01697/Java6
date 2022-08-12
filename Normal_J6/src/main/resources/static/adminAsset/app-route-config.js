app.config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
  var productState = {
    name: "products",
    url: "/products",
    templateUrl: "../adminAsset/components/products.html",
    data: {
      label: "Products",
    },
    controller: "productCrt"
  };
  
  var productCreateState = {
	name: "createdProduct",
	url : "/test",
	templateUrl: "../adminAsset/components/test.html",
};

  var accountState = {
    name: "accounts",
    url: "/accounts",
    templateUrl: "../adminAsset/components/accounts.html",
    controller: "accountsCrt",
    
  };

   var authoritiesState = {
    name: "authorities",
    url: "/authorities",
    templateUrl: "../adminAsset/components/authrizing.html",
    controller: "authoritiesCrt",
    
  };
  var categoryState = {
    name: "categories",
    url: "/categories",
    templateUrl: "../adminAsset/components/categories.html",
    controller: "categoryCrt"
  };

$stateProvider.state(productCreateState);
  $stateProvider.state(productState);
  $stateProvider.state(accountState);
  $stateProvider.state(authoritiesState);
  $stateProvider.state(categoryState);
  $urlRouterProvider.otherwise("/");
  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false,
  });
});
