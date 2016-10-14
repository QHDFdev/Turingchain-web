angular.module('controllers', ['myDirectives'])

.controller('IndexController',['$scope','$rootScope','$http','$location','$cookies','$cookieStore',
   function($scope , $rootScope , $http , $location ,$cookies ,$cookieStore){
	var userName = $cookieStore.get("userName");
	if(userName){
		$rootScope.userName=userName;//用户名
	}
	
	var noderName = $cookieStore.get("noderName");
	if(noderName){
		$rootScope.noderName=noderName;//节点用户名
		$rootScope.noderType=$cookieStore.get("noderType");//节点用户类型  销售 3  生产商 0 原材料 1  物流 2
   	}
	
	var bcAdmName = $cookieStore.get("bcAdmName");
		$rootScope.bcAdmName=bcAdmName;//区块链用户名
  }])


.controller('UserController',['$scope','$rootScope','$http','$location','$cookies','$cookieStore',
    function($scope , $rootScope , $http , $location ,$cookies ,$cookieStore) {

		$scope.queryLogin = function() {
				var email = $scope.email;
				var password = $scope.password;
				$rootScope.email=email;//将email地址存放到全局空间里
				
		       $http.get('queryLogin/'+ email + '/' + password + '.do',{
		    	   cache : true
		       }).success(function(user){
		    	   $rootScope.userName = user.userName; //  将用户名存放到全局scope
		    	   $rootScope.id = user.id;             //  同上
		    	   $rootScope.password = user.password; //  同上
		    	   
		    	   $cookieStore.put("userName", user.userName); //userName存放到cookie中
		    	   var userName = $cookieStore.get("userName"); 
		    	   
		    	   if($rootScope.userName != undefined){
		    		   Showbo.Msg.alert($rootScope.userName + "登陆成功 ！");	
		    	   }else{
		    		   Showbo.Msg.alert("用户名或密码不正确，请重新登陆 ！");	   
		    	   }
		           $location.path('/home');
		       }).error(function(){
		    	   Showbo.Msg.alert("登陆请求失败,请重试 ！");
		       });
		   };
		   
		   $scope.addUser = function(){
				$http
				.post('user.do',$scope.user)
		   		.success(function(data){
		   			console.info(data.msg); 
		   			Showbo.Msg.alert($scope.user.userName +" 注册成功!");
		   			$scope.addAlert = function() {
		   				$scope.alerts.push({msg: "Another alert!"});
		   			};
		   			$location.path('/home');
		   		});	
			};
	 
    
		  $scope.logout = function(){
		    	Showbo.Msg.alert($rootScope.userName +"退出 ！")
		    	$cookieStore.remove("userName");
				$rootScope.userName = null;
				$rootScope.password =null;
				$location.path('/home');
			};
			
		$scope.queryEmail = function(){
			var email = $scope.user.email;
			$http
			.get('queryEmail/'+ email +'.do')
	  		.success(function(data){
	  			console.info(data); 
	  			$scope.emailInfo = data;
	  		});
		}

}])


.controller('UserInfoController',['$scope','$rootScope','$http','$location','$document','$timeout',
    function($scope,$rootScope, $http, $location , $document , $timeout) {
	
	var userName = $rootScope.userName;
	
	$http.get('findByName/' + userName + '.do').success(function(data){
        $scope.user = data;
	});
	 
	$scope.updatePwd = function(){
		
		var userName= $rootScope.userName;
		var newPassword = $scope.user.newPassword;
		
		$http.put('user/' + userName + '/' + newPassword + '.do').success(function(data){
			 Showbo.Msg.alert("修改成功,请重新登录!");
			 $rootScope.userName = null;
			 $rootScope.password = null;
			 $location.path('/home');
		 });
		
	};
	
	angular.element(document.querySelector('#userImg')).bind("change", function(){
		$timeout(function(){
			var file = $scope.user.userImg;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadImg.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        }).success(function(data){
		    	   	$scope.user.userImg = data.fileName;
		    	   	console.log($scope.user);
		    	   	$http.post('upUserImg.do',$scope.user)
		    	   		.success(function(data){
		    	   		});
		   			$scope.upload = 1;
		        });
		})
	});
	
}])

//权限升级
.controller('ApplyController',['$scope','$rootScope','$http','$location',
    function($scope , $rootScope , $http , $location ) {
	
		var userId = $rootScope.id;
		
		$http.get('getApplyById/' + userId + '.do').success(function(data){
	       
		console.log(data);
		$rootScope.isRegister = data ;
		});
	  		
		$scope.add = function() {
			
			$scope.apply.userId=$rootScope.id;
		   	$scope.apply.userName= $rootScope.userName;
			$scope.apply.userProvince=$scope.selectedDistrict.name;
			$scope.apply.userCity=$scope.selectedUnit.name;
			$scope.apply.userCounty=$scope.selectedPosition.name;
			$scope.apply.applyType='原材料生产商';
			
			console.log($scope.apply.userProvince);
			console.log($scope.apply.userCity);
			console.log($scope.apply.userCounty);
			console.log($scope.apply.applyType);
			   
			var file = $scope.apply.file;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadFile.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        })
	       .success(function(data){
	    	   
	    	   $scope.apply.file = data.fileName;
	    	   console.info(data.msg);
	    	   console.log($scope.noder);

	    	   $http.post('apply.do',$scope.apply)
	    	   		.success(function(data){
	    	   			console.info(data.msg); 
	    	   			$location.path('/home');
		        });
	        });
	   }
		
		$http.get("json/city.json").success(function(data){
			var jsonString = angular.toJson(data);
			
			$scope.districts = angular.fromJson(jsonString);
			console.log($scope.districts);
		});
}])

//权限升级2
.controller('ApplyController2',['$scope','$rootScope','$http','$location',
    function($scope , $rootScope , $http , $location ) {
	
		var userId = $rootScope.id;
		
		$http.get('getApplyById/' + userId + '.do').success(function(data){
	       
		console.log(data);
		$rootScope.isRegister = data ;
		});
	  		
	   $scope.add2 = function(){
		   
		   	$scope.apply.userId=$rootScope.id;
		   	$scope.apply.userName= $rootScope.userName;
			$scope.apply.userProvince=$scope.selectedDistrict.name;
			$scope.apply.userCity=$scope.selectedUnit.name;
			$scope.apply.userCounty=$scope.selectedPosition.name;
			$scope.apply.applyType='产品生产商';
			
			console.log($scope.apply.userProvince);
			console.log($scope.apply.userCity);
			console.log($scope.apply.userCounty);
			console.log($scope.apply.applyType);
			
			$http
			.post('apply.do',$scope.apply)
	   		.success(function(data){
	   			console.info(data.msg); 
	   			$location.path('/home');
        });	
		};
		
		$http.get("json/city.json").success(function(data){
			var jsonString = angular.toJson(data);
			
			$scope.districts = angular.fromJson(jsonString);
			console.log($scope.districts);
		});
}])

//权限升级3
.controller('ApplyController3',['$scope','$rootScope','$http','$location',
    function($scope , $rootScope , $http , $location ) {
	
		var userId = $rootScope.id;
		
		$http.get('getApplyById/' + userId + '.do').success(function(data){
	       
		console.log(data);
		$rootScope.isRegister = data ;
		});
	  		
	   $scope.add3 = function(){
		   
		   	$scope.apply.userId=$rootScope.id;
		   	$scope.apply.userName= $rootScope.userName;
			$scope.apply.userProvince=$scope.selectedDistrict.name;
			$scope.apply.userCity=$scope.selectedUnit.name;
			$scope.apply.userCounty=$scope.selectedPosition.name;
			$scope.apply.applyType='物流运输方';
			
			console.log($scope.apply.userProvince);
			console.log($scope.apply.userCity);
			console.log($scope.apply.userCounty);
			console.log($scope.apply.applyType);
			
			$http
			.post('apply.do',$scope.apply)
	   		.success(function(data){
	   			console.info(data.msg); 
	   			$location.path('/home');
        });	
		};
		
		$http.get("json/city.json").success(function(data){
			var jsonString = angular.toJson(data);
			
			$scope.districts = angular.fromJson(jsonString);
			console.log($scope.districts);
		});
}])

//权限升级4
.controller('ApplyController4',['$scope','$rootScope','$http','$location',
    function($scope , $rootScope , $http , $location ) {
	
		var userId = $rootScope.id;
		
		$http.get('getApplyById/' + userId + '.do').success(function(data){
	       
		console.log(data);
		$rootScope.isRegister = data ;
		});
	  		
	   $scope.add4 = function(){
		   
		   	$scope.apply.userId=$rootScope.id;
		   	$scope.apply.userName= $rootScope.userName;
			$scope.apply.userProvince=$scope.selectedDistrict.name;
			$scope.apply.userCity=$scope.selectedUnit.name;
			$scope.apply.userCounty=$scope.selectedPosition.name;
			$scope.apply.applyType='产品商家';
			
			console.log($scope.apply.userProvince);
			console.log($scope.apply.userCity);
			console.log($scope.apply.userCounty);
			console.log($scope.apply.applyType);
			
			$http
			.post('apply.do',$scope.apply)
	   		.success(function(data){
	   			console.info(data.msg); 
	   			$location.path('/home');
        });	
		};
		
		$http.get("json/city.json").success(function(data){
			var jsonString = angular.toJson(data);
			
			$scope.districts = angular.fromJson(jsonString);
			console.log($scope.districts);
		});
}])
	
//节点用户登录
.controller('NoderController',['$scope','$rootScope','$http','$location','$window','$cookies','$cookieStore',
    function($scope , $rootScope , $http , $location,$window ,$cookies,$cookieStore) {
	
	$scope.queryLogin = function() {
	       $http.post('noderLogin.do',$scope.noder).success(function(noder){
	    	   
	    	   var noderState = noder.noderState;
	    	   var id = noder.id;
	    	   console.log(noder);
	    	  
	    	   if(noderState == '未审核'){
	    		   $window.alert("您还没有审核！！！");
	    		   $location.path('/login');
	    	   }else if($scope.noderKey == noder.noderKey){
	    
	    		   $rootScope.id = noder.id;
	    		   $rootScope.noderName = noder.noderName;
		    	   $rootScope.password = noder.password;
		    	   $rootScope.noderType = noder.noderType;
		    	   
		    	   $cookieStore.put("noder", noder);//将noder存放到cookie里
		    	   $cookieStore.put("noderName", noder.noderName);
		    	   $cookieStore.put("noderType", noder.noderType);
		    	   
		    	   if($rootScope.noderType == '0'){
		    		   $http.get('getTransCount/'+id+'.do').success(function(data){
		    			   $rootScope.transnum = data;
		    			});
		    		   $http.get('purchase/'+id+'.do').success(function(data){
		    	   			$rootScope.prodnum = data;
			    	   });
		    	   }else if($rootScope.noderType == '1'){
		    		   $http.get('purchase/'+id+'.do').success(function(data){
		    	   			$rootScope.num = data;
			    	   });
		    	   }else if($rootScope.noderType == '2'){
		    		   $http.get('transRawmCount/'+id+'.do').success(function(data){
		    	   			$rootScope.rawmnum = data;
			    	   });
		    		   $http.get('transProdCount/'+id+'.do').success(function(data){
		    	   			$rootScope.prodnum = data;
			    	   });
		    	   }else{
		    		   $http.get('getTransCount/'+id+'.do').success(function(data){
		    			   $rootScope.transnum = data;
		    			});
		    	   }
		    	   $location.path('/home');
	    	   }else{
	    		   Showbo.Msg.alert("您的秘钥或密码有错！");
	    	   }
	       }).error(function(){
	    	   Showbo.Msg.alert("确认登录信息！");
	       });
	    }
	   
	   $scope.addNoder = function() {
		   
		    $scope.noder.noderProvince=$scope.selectedDistrict.name;
			$scope.noder.noderCity=$scope.selectedUnit.name;
			$scope.noder.noderCounty=$scope.selectedPosition.name;
			$scope.noder.authority ="";
	     	if($scope.a1){
	     		$scope.noder.authority=="" ?($scope.noder.authority += "新节点申请"):($scope.noder.authority += ",新节点申请");
	     	}
			var file = $scope.noder.noderFile;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadNoderFile.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        })
	       .success(function(data){
	    	   $scope.noder.noderFile = data.fileName;
	    	   $http.post('noder.do',$scope.noder)
	    	   		.success(function(data){
	    	   			Showbo.Msg.alert("注册节点用户成功！");
	    	   			$location.path('/home');
		        });
	        });
	   }
	   
	   $scope.add = function(){
		   
		   	$scope.noder.userId=$rootScope.id;
		   	$scope.noder.noderName= $rootScope.userName;
			$scope.noder.seqNumber=$scope.apply.idNumber;
			$scope.noder.comName=$scope.apply.companyName;
			$scope.noder.comNum=$scope.apply.companyId;
			$scope.noder.regDate=$scope.apply.companyRegist;
			
			console.log($scope.noder.comName);
			console.log($scope.noder.userId);
			console.log($scope.noder.seqNumber);
			
			
			$http
			.post('noder.do',$scope.noder)
	   		.success(function(data){
	   			console.info(data.msg); 
	   			$location.path('/home');
       });	
	};
	
	
    $scope.logout = function(){
    	$cookieStore.remove("noderName");
    	$cookieStore.remove("noder");
    	$cookieStore.remove("noderType");
		$rootScope.noderName = null;
		$rootScope.password =null;
		$location.path('/home');
	};
	
	$http.get("json/city.json").success(function(data){
		var jsonString = angular.toJson(data);
		
		$scope.districts = angular.fromJson(jsonString);
		console.log($scope.districts);
	});
	
	$scope.currentDate = new Date(); 
	 $scope.open = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
		$event.preventDefault();
		$event.stopPropagation();
		$scope.opened = true;
	} 
	$scope.disabled = function(date , mode){ 
		return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6))
	}
	$scope.dateOptions = {
		formatYear : 'yy',
		startingDay : 1
	}
	
	$scope.queryEmail = function(){
		var email = $scope.noder.email;
		$http
		.get('queryEmail/'+ email +'.do')
  		.success(function(data){
  			console.info(data); 
  			$scope.emailInfo = data;
  		});
	}
	
}])

.controller('NoderInfoController',['$scope','$rootScope','$http','$location','$timeout',
    function($scope,$rootScope, $http, $location,$timeout) {
	
	var noderName = $rootScope.noderName;
	
	$http.get('findNoderByName/' + noderName + '.do').success(function(data){
        $scope.noder = data;
	});
	 
	$scope.updatePwd = function(){
		
		var newPassword = $scope.newPassword;
		
		$http.put('noder/' + noderName + '/' + newPassword + '.do').success(function(data){
			 Showbo.Msg.alert("修改成功,请重新登录!");
			 $rootScope.noderName = null;
			 $rootScope.password = null;
			 $location.path('/home');
		 });

	};
	
	angular.element(document.querySelector('#noderImg')).bind("change", function(){
		$timeout(function(){
			var file = $scope.noder.noderImg;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadImg.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        }).success(function(data){
		    	 $scope.noder.noderImg = data.fileName;
		    	 console.log($scope.noder);
		    	 $http.post('upNoderImg.do',$scope.noder)
		    	   .success(function(data){
		    	 });
		   		 $scope.upload = 1;
		    });
		})
	});	
	
	
	$scope.queryEmail = function(){
		var email = $scope.email;
		$http
		.get('queryEmail/'+ email +'.do')
   		.success(function(data){
   			console.info(data); 
   			$scope.emailInfo = data;
   		});
	}
	
}])	

.controller('PurcController',['$scope','$rootScope','$http','$location',
      function($scope , $rootScope , $http , $location ) {

  		   $scope.addPurchase = function(){
  			   $scope.purchase.purchaserId = $rootScope.id;
  				$http
  				.post('purchase.do',$scope.purchase)
  		   		.success(function(data){
  		   			console.info(data.msg); 
  		   			Showbo.Msg.alert("采购记录添加成功!");
  		   			$location.path('/home');
  		   		});
  			};
 }])
 
.controller('NoderPurcController',['$scope','$rootScope','$http','$location',
    function($scope,$rootScope, $http, $location) {
	var id = $rootScope.id;	
	$http.get('listPurchase/'+id+'.do').success(function(data){
        $scope.puchases = data;            //purchaseProdRecord.html 页面上输出
        $scope.puchaseSize = data.length;  //purchaseProdRecord.html 页面上验证有没有码数 空则无记录 非空则ng-repeat
	});

}])	

.controller('NoderRawmController',['$scope','$rootScope','$http','$location','$routeParams','$timeout',
    function($scope,$rootScope, $http, $location,$routeParams,$timeout) {
	
	var id = $routeParams.id;	
	if(id != null){
		$http.get('getPurchaseById/'+id+'.do').success(function(data){
	        $scope.purchase = data;
		}); 
	}
	
	var noderId = $rootScope.id;
	
	$http.get('purchase/'+noderId+'.do').success(function(data){
		$rootScope.num = data;
	});
	
	angular.element(document.querySelector('#rawmImg')).bind("change", function(){
		$timeout(function(){
			var file = $scope.rawm.image;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadImg.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        }).success(function(data){
	        	$scope.image = data.fileName;
	        	$scope.rawm.image = data.url;
		 });
		})
	});
	
	var sellerId = $rootScope.id;
	
	  $http.get('getTransCount/'+sellerId+'.do').success(function(data){
		   $rootScope.transnum = data;
		});
	  $http.get('purchase/'+sellerId+'.do').success(function(data){
 			$rootScope.prodnum = data;
	    });
	  
	  $http.get('rawmaterial/'+sellerId+'.do').success(function(data){
			$scope.rawmSize = data.length;
	        $scope.rawms = data;
		});
	
	$scope.addRawmaterial = function(){
		
		$scope.rawm.rawmName = $scope.purchase.articleName;
		$scope.rawm.rawmNum = $scope.purchase.articleNum;
		$scope.rawm.number = $scope.purchase.number;
		$scope.rawm.iu = $scope.purchase.iu;
		$scope.rawm.sellerId = $rootScope.id;
		$scope.rawm.purchaseId = $scope.purchase.purchaseid;
		$scope.rawm.purchaserId = $scope.purchase.purchaserId;
		
		console.log($scope.rawm);
		
		$http.post('rawmaterial.do',$scope.rawm)
		.success(function(data){
			 Showbo.Msg.alert("填写成功!");
			 $location.path('/sellerRawmPurchaseList');
        });
		
	};
	
}])	

.controller('RawmInfoController',['$scope','$rootScope','$http','$location','$routeParams',
    function($scope,$rootScope, $http, $location ,$routeParams) {
		var id = $routeParams.id;
		$http.get('getRawm/'+ id +'.do').success(function(data){
	        $scope.rawm = data;
	        console.log($scope.rawm);
		});
	
	
}])	

.controller('NoderProdController',['$scope','$rootScope','$http','$location','$routeParams','$timeout',
    function($scope,$rootScope, $http, $location,$routeParams,$timeout) {
	/*
	 *  #/product/:id
	 *  id 接收传递过来的 purchaseId
	 */
	var id = $routeParams.id;
	if(id != null){
		$http.get('getPurchaseById/'+id+'.do').success(function(data){
	        $scope.purchase = data;
		}); 
	}
	
	var noderId = $rootScope.id;
	
	$http.get('purchase/'+noderId+'.do').success(function(data){
		$rootScope.num = data;
	});
	
	angular.element(document.querySelector('#prodImg')).bind("change", function(){
		$timeout(function(){
			var file = $scope.prod.image;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadImg.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        }).success(function(data){
	        	$scope.image = data.fileName;
	        	$scope.prod.image = data.url;
		 });
		})
	});
	
	var sellerId = $rootScope.id;
	$http.get('product/'+sellerId+'.do').success(function(data){
		$scope.prodSize = data.length;
        $scope.prods = data;
	});
	
	$scope.addProduct = function(){
		
		$scope.prod.productName = $scope.purchase.articleName;
		$scope.prod.productNum = $scope.purchase.articleNum;
		$scope.prod.number = $scope.purchase.number;
		$scope.prod.iu = $scope.purchase.iu;
		$scope.prod.sellerId = $rootScope.id;
		$scope.prod.purchaseId = $scope.purchase.purchaseid;
		$scope.prod.purchaserId = $scope.purchase.purchaserId;
		
		console.log($scope.prod);
		
		$http.post('product.do',$scope.prod)
		.success(function(data){
			 Showbo.Msg.alert("填写成功!");
			 $location.path('/sellerProdPurchaseList');
        });
		
	};
	
}])	

.controller('ProdInfoController',['$scope','$rootScope','$http','$location','$routeParams',
    function($scope,$rootScope, $http, $location ,$routeParams) {
		var id = $routeParams.id;
		$http.get('getProd/'+ id +'.do').success(function(data){
	        $scope.prod = data;
	        console.log($scope.rawm);
		});
	
	
}])
.controller('TransController',['$scope','$rootScope','$http','$location',
       function($scope,$rootScope, $http, $location) {
   	
		var id = $rootScope.id;	
		$http.get('listTrans.do').success(function(data){
			$scope.tranSize = data.length;
			$scope.trans = data;
		});
  }])
.controller('TransRController',['$scope','$rootScope','$http','$location','$routeParams',
       function($scope,$rootScope, $http, $location,$routeParams) {
   	
		var id = $rootScope.id;	
		
		$http.get('transRawmCount/'+ id +'.do').success(function(data){
   			$rootScope.rawmnum = data;
	    });
		
		$http.get('listTransRawm/'+ id +'.do').success(function(data){
	        $scope.rawms = data;
	        $scope.rawmSize = data.length;
		});
		
  }])	
.controller('TransPController',['$scope','$rootScope','$http','$location','$routeParams',
       function($scope,$rootScope, $http, $location,$routeParams) {
   	
		var id = $rootScope.id;
		
		$http.get('transProdCount/'+id+'.do').success(function(data){
   			$rootScope.prodnum = data;
	    });
		
	    $http.get('listTransProd/'+ id +'.do').success(function(data){
		    $scope.prods = data;
		    $scope.prodSize = data.length;
	    });
  }])
 
.controller('TransRawmController',['$scope','$rootScope','$http','$location','$routeParams',
    function($scope,$rootScope, $http, $location ,$routeParams) {
		var id = $routeParams.id;
		
		if(id != null){
			$http.get('getRawm/'+ id +'.do').success(function(data){
				$scope.rawm = data;
				console.log($scope.rawm);
			});
			$http.get('getRawmPurc/'+ id +'.do').success(function(data){
				$scope.rawmp = data;
				console.log($scope.rawmp);
			});
		}
		
		$scope.addRawmTrans = function(){

			$scope.transRaw.articleName = $scope.rawm.rawmName;
			$scope.transRaw.articleNum = $scope.rawm.rawmNum;
			$scope.transRaw.transportId = $rootScope.id;
			$scope.transRaw.sellerId =  $scope.rawm.sellerId;
			$scope.transRaw.purchaseId = $scope.rawm.purchaseId;
			$scope.transRaw.purchaserId = $scope.rawm.purchaserId;
			
			console.log($scope.transRaw);
			
			$http.post('addRawmTrans.do',$scope.transRaw)
			.success(function(data){
				 Showbo.Msg.alert("填写成功!");
				 $location.path('/transRawmList');
	        });
		};
}])	

.controller('TransProdController',['$scope','$rootScope','$http','$location','$routeParams',
    function($scope,$rootScope, $http, $location ,$routeParams) {
		var id = $routeParams.id;
		
		if(id != null){
			
			$http.get('getProd/'+ id +'.do').success(function(data){
		        $scope.prod = data;
		        console.log($scope.prod);
			});
			$http.get('getProdPurc/'+ id +'.do').success(function(data){
		        $scope.prodp = data;
		        console.log($scope.prodp);
			});
		}
		
		$scope.addProdTrans = function(){

			$scope.transPord.articleName = $scope.prod.productName;
			$scope.transPord.articleNum = $scope.prod.productNum;
			$scope.transPord.transportId = $rootScope.id;
			$scope.transPord.sellerId =  $scope.prod.sellerId;
			$scope.transPord.purchaseId = $scope.prod.purchaseId;
			$scope.transPord.purchaserId = $scope.prod.purchaserId;
			
			console.log($scope.transPord);
			
			$http.post('addProdTrans.do',$scope.transPord)
			.success(function(data){
				 Showbo.Msg.alert("填写成功!");
				 $location.path('/transProdList');
	        });
		};
}])	
 
 .controller('RawmProdDeliveryController',['$scope','$rootScope','$http','$location',
         function($scope,$rootScope, $http, $location) {
     	
  		var id = $rootScope.id;	
  		$http.get('listDelivered/'+ id +'.do').success(function(data){
  			$scope.trans = data;
  			$scope.tranSize = data.length;
  		});
 }])

 .controller('DeliveryController',['$scope','$rootScope','$http','$location',
         function($scope,$rootScope, $http, $location) {
     	
  		var id = $rootScope.id;	
  		$http.get('listDelivery/'+ id +'.do').success(function(data){
  			$scope.trans = data;
  			$scope.tranSize = data.length;
  		});
  		
  		$http.get('getTransCount/'+id+'.do').success(function(data){
  			$rootScope.transnum = data;
		});
  		
 }])	
 
 .controller('DeliveryInfoController',['$scope','$rootScope','$http','$location','$routeParams',
    function($scope,$rootScope, $http, $location, $routeParams) {
	 
		var id = $routeParams.id;
		
		$http.get('getTransPurchase/'+ id +'.do').success(function(data){
	        $scope.tp = data;
	        console.log($scope.tp);
		});
		$http.get('getTransTransport/'+ id +'.do').success(function(data){
	        $scope.tt = data;
	        console.log($scope.tt);
		});
		$http.get('getTransPurchaser/'+ id +'.do').success(function(data){
	        $scope.tpr = data;
	        console.log($scope.tpr);
		});
		$http.get('getTransSeller/'+ id +'.do').success(function(data){
	        $scope.ts = data;
	        console.log($scope.ts);
		});
		
		$scope.articleDelivery = function(){
			
			$scope.transDel.id = $scope.tp.id;
			$scope.transDel.purchaseId = $scope.tp.purchaseId;
			$scope.transDel.purchaserId = $scope.tp.purchaserId;
			$scope.transDel.transportId = $scope.tp.transportId;
			$scope.transDel.articleType = $scope.tp.articleType;
			
			console.log($scope.transDel);
			
			$http.post('delivery.do',$scope.transDel)
			.success(function(data){
				 Showbo.Msg.alert("收货成功!");
				 $location.path('/transList');
	        });
		};
}])


//管理员
.controller('AdminController',['$scope','$rootScope','$http','$location','$window',
    function($scope , $rootScope , $http , $location , $window ) {
	
	   $scope.addAdmin = function() {
		   
			var file = $scope.adminFile;
			var formdata = new FormData();
			formdata.append('file', file);
			console.log(file);
	        $http.post('uploadComFile.do',formdata,{
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        })
	       .success(function(data){
	    	   
	    	   $scope.admin.sonCompanyFile = data.fileName;
	    	   console.info(data.msg);
	    	   console.log($scope.admin);

	    	   $http.post('admin.do',$scope.admin)
	    	   		.success(function(data){
	    	   			console.info(data.msg); 
	    	   			$location.path('/home');
		        });
	        });
	   }
	   
	   $scope.queryEmail = function(){
			var email = $scope.admin.email;
			$http
			.get('queryEmail/'+ email +'.do')
	  		.success(function(data){
	  			console.info(data); 
	  			$scope.emailInfo = data;
	  		});
		}
	   
}])
 .controller('BannerCtrl',function( $scope){
    // 设置轮播图图片间隔
    $scope.myInterval = 5000;
    // 轮播图数据初始化
    var slides = $scope.slides = [];
    // 添加轮播图源
    slides.push({ image: '//tuling.oss-cn-hangzhou.aliyuncs.com/nanjing%2FTulingChain%2Fbg0.jpg', text: '亲爱的你，情人节快乐' });
    slides.push({ image: '//tuling.oss-cn-hangzhou.aliyuncs.com/nanjing%2FTulingChain%2Fbg1.jpg', text: '亲爱的你，情人节快乐' });
});
