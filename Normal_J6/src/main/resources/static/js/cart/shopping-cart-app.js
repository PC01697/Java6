const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function($scope, $http){


$scope.cart = {
	items: [],
	
	add(id){

		var item = this.items.find(item => item.id == id);
		if(item){
			item.qty++;
			this.saveToLocalStorage();
		}else{	
			$http.get('/api/product/'+id).then(resp => {
				resp.data.qty = 1;
				this.items.push(resp.data);
				this.saveToLocalStorage();
			})
		}
	},
	//
	remove(id){
		var index = this.items.findIndex(item => item.id == id);
		this.items.splice(index, 1);
		this.saveToLocalStorage();
	},
	
	clear(){
		this.items= []
		this.saveToLocalStorage();
	},
	
	amt_of(item){},
	
	get count(){
		return this.items
		.map(item => item.qty)
		.reduce((total, qty) => total += qty,0);
	},
	
	get amount(){
		return this.items
		.map(item => item.qty * item.unitPrice)
		.reduce((total, qty) => total += qty,0);
	},
	
	saveToLocalStorage(){
		var json = JSON.stringify(angular.copy(this.items));
		localStorage.setItem("cart", json);
	},
	
	loadFromLocalStorage(){
		var json = localStorage.getItem("cart");
		this.items = json ? JSON.parse(json):[];
	},
}
$scope.cart.loadFromLocalStorage();


//Đặt hàng--------------------------------------------


$scope.order = {
	oderDate : new Date(),
	address: "",
	accounts: {id: $("#id").text()},
	get orderDtails(){
		return $scope.cart.items.map(item =>{
			
			return{
				idProduct:{id: item.id},
				unitPrice: item.unitPrice,
				quanlity: item.qty
			}
		});
	},
	purchase(){
		var order = angular.copy(this);
		
		$http.post("/api/orders",order).then(resp =>{
			alert("Đặt hàng thành công!");
			$scope.cart.clear();
			location.href = "/order/detail/" + resp.data.id;
	
		}).catch(error =>{
			alert("Đặt hàng lỗi")
			console.log("Lỗi: "+error)
		})
	}
	
}
}) 