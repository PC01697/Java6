app.config(function ($stateProvider,$urlRouterProvider,$locationProvider) {
  var productState = {
    name: "products",
    url: "/products",
    templateUrl: "../adminAsset/components/products.html"
  };

  $stateProvider.state(productState);
  $urlRouterProvider.otherwise("/");
  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
});
});