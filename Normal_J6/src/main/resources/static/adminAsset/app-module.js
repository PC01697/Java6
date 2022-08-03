var app = angular.module('myApp', 
[
    'ui.router',
    'ngCookies',
    'uiBreadcrumbs',
    'ui.bootstrap'
]).filter("startForm" , function(){
	return function(data,start){
		start = 0 + start;
		return data.slice(start);
	}
});