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
