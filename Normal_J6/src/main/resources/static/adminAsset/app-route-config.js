app.config(function ($stateProvider,$urlRouterProvider,$locationProvider) {
  var productState = {
    name: "products",
    url: "/products",
    templateUrl: "../adminAsset/components/products.html"
  };
  
  var accountState = {
    name: "accounts",
    url: "/accounts",
    templateUrl: "../adminAsset/components/accounts.html"
  };

  $stateProvider.state(productState);
  $stateProvider.state(accountState);
  $urlRouterProvider.otherwise("/");
  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
});
});