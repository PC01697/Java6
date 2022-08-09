var app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function($scope, $http){
alert("Giỏ hàng chưa sài dc ")

$scope.cart = {
	items: [],
	
	add(id){
		var item = this.items.find(item => item.id == id);
		if(item){
			item.qty++;
			this.saveToLocalStorage();
		}else{
			$http.get("/chitiet/${id}").then(resp => {
				resp.data.qty = 1;
				this.items.push(resp.data);
				this.saveToLocalStorage();
			} )
		}
	},
	
	remove(id){},
	
	clear(){},
	
	amt_of(item){},
	
	get count(){},
	
	get amount(){},
	
	saveToLocalStorage(){
		var json = JSON.stringify(angular.copy(this.items));
		localStorage.setltem("cart", json);
	},
	
	
}
}) 