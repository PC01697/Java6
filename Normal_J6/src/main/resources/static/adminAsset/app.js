app.controller("header-footer", function ($scope) {
  $scope.navbar = "../adminAsset/components/navbar.html";
  $scope.aside = "../adminAsset/components/aside.html";
  $scope.footer = "../adminAsset/components/footer.html";
});

app.controller("categoryCrt", function ($scope, categoryService) {
  $scope.category = [];
  $scope.alertError = [];
  $scope.closeAlert = function (index) {
    $scope.alertError.splice(index, 1);
  };
  $scope.id;
  $scope.name;
  //pagination for ui boostrap
  $scope.currentPage = 1;
  $scope.pageSize = 5;

  function reloadTable() {
    setTimeout(function () {
      $scope.$apply(function () {
        categoryService.categoryGetAll().then(function (response) {
          $scope.category = response.data;
        });
      });
      // AngularJS unaware of update to $scope
    }, 100),
      function (respone) {
        console.log(respone);
      };
  }
  $scope.show = false;

  // clear form
  function clearForm() {
    $scope.id = null;
    $scope.name = null;
    $scope.show = false;
  }

  //for load table
  categoryService.categoryGetAll().then(function (response) {
    $scope.category = response.data;
  });

  //for ng-click
  //using apply for refrest data table
  $scope.categoryCreate = function () {
    var categoryEntity = {
      id: $scope.id,
      name: $scope.name,
    };

    //console.log(categoryEntity.name)
    categoryService.categoryCreate(JSON.stringify(categoryEntity)).then(
      function successCallback(response) {
        console.log(response.status);
        if (response.status == 201) {
          $scope.alertError = [
            {
              type: "success",
              msg: "Bạn đã thêm thành công: " + categoryEntity.name,
            },
          ];
          clearForm();
          categoryEntity.length = 0;
        }
      },
      function errorCallback(response) {
        //console.log(response.data.errors)
        if (response.status == 502) {
          $scope.alertError = [
            {
              type: "danger",
              msg: "Category đã tồn tại, vui lòng nhập tên khác",
            },
          ];
        }
      }
    );
    reloadTable();
  };
  //for edit
  $scope.editCategory = function (id, name) {
    $scope.id = id;
    $scope.name = name;
    $scope.show = true;
    //console.log($scope.test)
  };

  //for delete
  $scope.deleteCategory = function (id) {
    categoryService.categoryDelete(id).then(function successCallback(response) {
      $scope.alertError = [
        { type: "success", msg: "Bạn đã thêm xóa thành công" },
      ];
    });
    clearForm();
    reloadTable();
  };

  //for update category
  $scope.updateCategory = function () {
    categoryService
      .categoryUpdate($scope.id, JSON.stringify($scope.name))
      .then(function successCallback(response) {
        if (response.status == 200) {
          $scope.alertError = [
            { type: "success", msg: "Bạn đã cập nhật thành công" },
          ];
        }
      });

    reloadTable();
  };

  //for backToCreate
  $scope.backToCreate = function () {
    clearForm();
  };
});

//--------------------------------------------------------------------------

app.controller("accountsCrt", function ($scope, accountService) {
  $scope.account = [];
  
  $scope.alertError = [];
  $scope.closeAlert = function (index) {
    $scope.alertError.splice(index, 1);
  };
  $scope.id;
  $scope.username;
  $scope.password;
  $scope.fullname;
  $scope.email;
  
  //pagination for ui boostrap
  $scope.currentPage = 1;
  $scope.pageSize = 5;

  function reloadTable() {
    setTimeout(function () {
      $scope.$apply(function () {
        accountService.accountGetAll().then(function (response) {
          $scope.account = response.data;
        });
      });
      // AngularJS unaware of update to $scope
    }, 100),
      function (respone) {
        console.log(respone);
      };
  }
  $scope.show = false;

  // clear form
  function clearForm() {
  $scope.id = null;
  $scope.username = null;
  $scope.password = null;
  $scope.fullname = null;
  $scope.email = null;
  
  $scope.show = false;
  }

  //for load table
  accountService.accountGetAll().then(function (response) {
    $scope.account = response.data;
  });

  
 $scope.accountCreate = function () {
    var accountEntity = {
    
      username: $scope.username,
      password:$scope.password,
      fullname:$scope.fullname,
      email:$scope.email
    };
    

    console.log(accountEntity)
    accountService.accountCreate(JSON.stringify(accountEntity)).then(
      function successCallback(response) {
        console.log(response.status);
        if (response.status == 201) {
          $scope.alertError = [
            {
              type: "success",
              msg: "Bạn đã thêm thành công: " + accountEntity.username,
            },
          ];
          clearForm();
          accountEntity.length = 0;
        }
      },
      function errorCallback(response) {
        //console.log(response.data.errors)
        if (response.status == 502) {
          $scope.alertError = [
            {
              type: "danger",
              msg: "Username đã tồn tại, vui lòng nhập username khác",
            },
          ];
        }
        console.log(response)
      }
    );
    reloadTable();
  };

  //for edit
  $scope.editAccount = function (id,username,password,fullname,email) {
  $scope.id = id;
  $scope.username = username;
  $scope.password = password;
  $scope.fullname = fullname;
  $scope.email = email;
  $scope.show = true;
  $scope.accountEntity = {
	username:username,
	password:password,
	fullname:fullname,
	email:email
}
   console.log(JSON.stringify($scope.accountEntity))
  };

 
  $scope.deleteAccount = function (id) {
    accountService.accountDelete(id).then(function successCallback(response) {
      $scope.alertError = [
        { type: "success", msg: "Bạn đã xóa thành công" },
      ];
    });
    clearForm();
    reloadTable();
  };

   //for update account
  $scope.updateAccount = function () {
	  var accountEntity1 = {
    
      username: $scope.username,
      password:$scope.password,
      fullname:$scope.fullname,
      email:$scope.email
    };
	var x= JSON.parse(JSON.stringify(accountEntity1))
    accountService
      .accountUpdate($scope.id, accountEntity1)
      .then(function successCallback(response) {
	 
        if (response.status == 200) {
          $scope.alertError = [
            { type: "success", msg: "Bạn đã cập nhật thành công" },
          ];

        }
      
      },function errorCallback(resp){
			console.log(resp.data);
			});
  
    reloadTable();
  };

  //for backToCreate
  $scope.backToCreate = function () {
    clearForm();
  };
  $scope.roles = [
	'TRUNG'
];
  
});

//---------------------------------------------Product controler --------------------------------------------------------
app.controller("productCrt", function ($scope, productService,categoryService) {
  $scope.product = [];
  $scope.category = [];
  $scope.alertError = [];
  $scope.closeAlert = function (index) {
    $scope.alertError.splice(index, 1);
  };
  //pagination for ui boostrap
  $scope.currentPage = 1;
  $scope.pageSize = 5;
  
	function reloadTable() {
    setTimeout(function () {
      $scope.$apply(function () {
        productService.productGetAll().then(function (response) {
          $scope.product = response.data;
        });
      });
      // AngularJS unaware of update to $scope
    }, 100),
      function (respone) {
        console.log(respone);
      };
  }


// product get all
 	productService.productGetAll().then(function (resp) {
    	$scope.product = resp.data;
  	});
  	
// category get all
	categoryService.categoryGetAll().then(function (response) {
    $scope.category = response.data;
  });
  
// create category
$scope.createProduct = function (){
	 var formProduct = {
		name: $scope.nameProduct,
		unitPrice: $scope.priceProduct,
		category:{
			id: $scope.categoryId
		},
		quantity: $scope.quantity,
		description: $scope.description
	}

	
	productService.productCreateProduct(formProduct).then(function successCallback(resp){
		if(resp == 200){
			console.log("ok")
		}
	})
	console.log(JSON.stringify(formProduct))
	}
	

// delete product
	$scope.deleteProduct = function (id){
		productService.productDelete(id).then(function successCallback(resp){
			 $scope.alertError = [
        { type: "success", msg: "Bạn đã xóa thành công" },
      		];
		});
		reloadTable();
	}
	
  
});




