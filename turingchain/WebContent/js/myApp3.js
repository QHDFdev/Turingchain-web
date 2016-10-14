angular.module('myApp3',['ngRoute','ngAnimate','ngCookies','ngMessages','ui.bootstrap','BillService','myBillDirectives','myFilters'])
.config(['$routeProvider',function($routeProvider){
	$routeProvider
		.when('/home',{
			templateUrl:'tpls/billHome.html',
			controller:'homeController'
		})
		.when('/billShow',{
			templateUrl:'tpls/billShow.html',
			controller:'showController'
		})
		.when('/userInfo',{
	       templateUrl:'tpls/billUserInfo.html',
	       controller:'UserInfoController'
		})
		.when('/inssuance',{
	       templateUrl:'tpls/bill_issuance.html',
	       controller:'NoderController'
		})
		.when('/discounting',{
	       templateUrl:'tpls/bill_discounting.html',
	       controller:'NoderController'
		})
		.when('/discountinglist',{
	       templateUrl:'tpls/bill_discounting_list.html',
	       controller:'NoderController'
		})
		.when('/payment',{
	       templateUrl:'tpls/bill_payment.html',
	       controller:'NoderController'
		})
		.when('/payoff',{
	       templateUrl:'tpls/bill_payoff.html',
	       controller:'NoderController'
		})
		.when('/payroll',{
	       templateUrl:'tpls/bill_payroll.html',
	       controller:'NoderController'
		})
		.when('/discount',{
	       templateUrl:'tpls/bill_discount.html',
	       controller:'NoderController'
		})
		.when('/history',{
	       templateUrl:'tpls/bill_history.html',
	       controller:'homeController'
		})
		.when('/detail',{
	       templateUrl:'tpls/bill_detail.html',
	       controller:'BillDetailController'
		})
		.when('/;',{
	       templateUrl:'tpls/bill_discount.html',
	       controller:'NoderController'
		})
//		.when('/Login',{
//			templateUrl:'tpls/billLogin.html',
//			controller:'loginController'
//		})
//		.when('/register',{
//			templateUrl:'',
//			// controller:'loginController'
//		})
		.otherwise({
			redirectTo:'/home'
		})
}])

//跨页面跨控制器存取数据,就不用使用$rootScope了

.factory('myFactory',function(){
	 var myObject = {};
	 var billNoder={}
	 
	 var setter=function(data){
		 myObject=data;
	 }
	 var getter=function(){
		 return myObject;
	 }
	 var setBillNoder=function(data){
		 billNoder=data;
	 }
	 var getBillNoder=function(){
		 return billNoder;
	 }
	 
	 return{
		 setter:setter,
		 getter:getter,
		 setBillNoder:setBillNoder,
		 getBillNoder:getBillNoder
	 }
})

/*主页以及导航*/
.controller('homeController',['$scope','$rootScope','$http','$location','$timeout','$interval','$cookies','$cookieStore','$window','NoderService','myBillsService','getTransferByIdService','myFactory','Paginator','$q',function($scope,$rootScope,$http,$location,$timeout,$interval,$cookies,$cookieStore,$window,NoderService,myBillsService,getTransferByIdService,myFactory,Paginator,$q){
	$scope.indexdown=function(){
		$('html,body').animate({'scrollTop':'900px'},1000);
	}
	function unUnicode(str){
		return unescape(str.replace(/\\u/g, "%u"));
	};
	$scope.$watch(function(){
		var str=null;
		var href=window.location.href;
		var index=href.indexOf('#/');
		if(index!=-1){
			str=href.substring(index);
		};
		$scope.natived=str;
	});
	$timeout(function(){mermaid.init();},1);
	
	//我的票据
	
	$scope.myBill=function(){
		var currentPages=0;
		var subPages=null;
		var billPageInfors=[];
		$rootScope.noPre=true;
		$rootScope.noNext=false;
		$scope.pubKey=$rootScope.billNoder.nodePubKey;
		console.log($scope.pubKey);
		myBillsService.billHistory($scope.pubKey).then(function(data){
			/*$scope.billBoxIndex=0;*/
			console.log(data);
			billPageInfors=data;
			$rootScope.bills=billPageInfors.slice(0,20);
			subPages=5;
			subPages=Math.ceil((billPageInfors.length)/20);
			console.log(billPageInfors.length);
			console.log(subPages);
			$location.path('/history');
			
			$rootScope.mybillnext=function(){
				if(currentPages==(subPages-1)){
					return;
				};
				if(currentPages==(subPages-2)){
					$rootScope.noPre=false;
					$rootScope.noNext=true;
					
				}else{
					$rootScope.noPre=false;
					$rootScope.noNext=false;
				}
				currentPages++;	
				var num=currentPages*20;
				var end=num+20;
				/*$scope.billBoxIndex=num;
				console.log($scope.billBoxIndex);*/
				
				$rootScope.bills=billPageInfors.slice(num,end);	
			}
			$rootScope.mybillprev=function(){
				if(currentPages==0){
					
					return;
				};
				if(currentPages==1){
					$rootScope.noPre=true;
					$rootScope.noNext=false;
					
				}else{
					$rootScope.noPre=false;
					$rootScope.noNext=false;
				}
				currentPages--;	
				var num=currentPages*20;
				var end=num+20;
				/*$scope.billBoxIndex=num;
				console.log($scope.billBoxIndex);*/
				
				$rootScope.bills=billPageInfors.slice(num,end);	
				
			}
		});
		
		
			
			
			
	};
	

	
	$scope.queryTxInfoRest = function(Id) {
		console.log(Id);
		getTransferByIdService.getTransfer(Id).then(function(data){
			myFactory.setter(data);
			console.log(data);
			 $location.path('/detail');
//		$http.get('getTransactionByidRest/'+ Id +'.do')
//        .success(function(data1){
//        	$rootScope.transferInfo={};
//        	$rootScope.transferInfo.originaler=unUnicode(data1.data.payload.bill.Bill_operator_name);
//        	$rootScope.transferInfo.receiver=unUnicode(data1.data.payload.bill.Bill_receiver_name);
//        	$rootScope.transferInfo.discountinger=unUnicode(data1.data.payload.bill.Guarantee_organization_name);
//        	$rootScope.transferInfo.billNumber=data1.data.payload.bill.Bill_id;
//        	$rootScope.transferInfo.moneySum=data1.data.payload.bill.Bill_amount_money;
//        	$rootScope.transferInfo.expireDate=data1.data.payload.bill.Bill_outdate;
//        	console.log($rootScope.transferInfo);
//    	   $location.path('/detail');
        });
	};
	
	//Cookies判断
	if($cookieStore.get('billNoder')!=null){
		$rootScope.billNoder=$cookieStore.get('billNoder');
	}
	
	$scope.queryLogin1 = function() {
		NoderService.runLogin($scope.noder).then(function(data){
		if(data.noderState == 0){
			$window.alert("您还没有审核！！！");
		}else if($scope.noderKey == data.noderKey){
			$('#loginModal').modal('hide');
				
			//设置空气时间
			  $cookieStore.put("billNoder", data,{
	                'expires': new Date(new Date().getTime() + 5000)
	            });
			  $rootScope.billNoder=data;
			//其他页面调用
			  myFactory.setBillNoder(data);
		}else{
//			$window.alert("您的秘钥或密码有错！！！");
			Showbo.Msg.alert("您的秘钥或密码有错！");
//			$location.path('/home');
		}
		}) ;
	 }
	
	$scope.logout = function(){
    	$cookieStore.remove("billNoder");
//		$cookies.remove("billNoder");
    	$rootScope.billNoder=null;
		$location.path('/home');
	};
}])
/*展示页面*/
.controller('showController',['$scope','$interval',function($scope,$interval){
	
	
}])
/*普通用户*/
.controller('ptUserController',['$scope','$rootScope','$http','$location',function($scope , $rootScope , $http , $location){

}])
/*节点用户*/
.controller('NoderController',['$scope','$rootScope','$http','$location','$window','$cookies','$cookieStore','NoderService','IssuanceService','discountingService','paymentService','payoffService','payrollService','discountService','myFactory','getTransferByIdService',
    function($scope , $rootScope , $http , $location,$window ,$cookies,$cookieStore,NoderService,IssuanceService,discountingService,paymentService,payoffService,payrollService,discountService,myFactory,getTransferByIdService) {
	//unicode转中文
	function unUnicode(str){
		return unescape(str.replace(/\\u/g, "%u"));
	};
	
	
	
	//签发
	$scope.IssuanceBill=function(){
		IssuanceService.issuance($scope.issuance).then(function(data){
			console.log(data);
			if(data.state==1){
				Showbo.Msg.alert("你已发起支付，等待节点投票！");
			}else{
				Showbo.Msg.alert("支付失败");;
			}
			$location.path('/inssuance');
		});
	};
	
	//查看需要承贴的
	$scope.showDiscountinglist=function(){
		console.log("test");
		$scope.billNoderId=$cookieStore.get("billNoder").id;
		discountingService.discountingList($scope.billNoderId).then(function(data){
			console.log(data);
			$rootScope.discountinglist=data;
			$location.path('/discountinglist');
		});
	}
	
	//确认承贴或不承贴
	$scope.discounting=function(id){
		getTransferByIdService.getTransfer(id).then(function(data){
			console.log(data);
			$rootScope.discounting=data;
			
			$rootScope.bill=$rootScope.discounting.transaction.data.payload.bill;
			
			$rootScope.originaler=unUnicode($scope.bill.Bill_operator_name);
			$rootScope.receiver=unUnicode($scope.bill.Bill_receiver_name);
			$rootScope.discountinger=unUnicode($scope.bill.Guarantee_organization_name);
			$rootScope.billNumber=$scope.bill.Bill_id;
			$rootScope.moneySum=$scope.bill.Bill_amount_money;
			$rootScope.expireDate=$scope.bill.Bill_outdate;
			
			 $location.path('/discounting');
        });
	}
	
	//承贴
	$scope.discountingBill=function(){
		discountingService.discounting($rootScope.discounting.id).then(function(data){
			console.log(data);
			if(data.state==2){
				Showbo.Msg.alert("您已确认承贴，等待节点投票！");
			}else{
				Showbo.Msg.alert("承贴失败");;
			}
			//$location.path('/discounting');
		});
	};
	//支付
	$scope.paymentBill=function(){
		paymentService.payment($scope.payment).then(function(data){
			console.log(data);
			if(data.state==1){
				Showbo.Msg.alert("你已发起支付，等待节点投票！");
			}else{
				Showbo.Msg.alert("支付失败");;
			}
			$location.path('/payment');
		});
	};
	//发薪
	$scope.payoffBill=function(){
		payoffService.payoff($scope.payoff).then(function(data){
			console.log(data);
			if(data.state==1){
				Showbo.Msg.alert("你已发起支付，等待节点投票！");
			}else{
				Showbo.Msg.alert("支付失败");;
			}
			$location.path('/payoff');
		});
	};
	//提薪
	$scope.payrollBill=function(){
		payrollService.payroll($scope.payroll).then(function(data){
			console.log(data);
			if(data.state==1){
				Showbo.Msg.alert("你已发起支付，等待节点投票！");
			}else{
				Showbo.Msg.alert("支付失败");
			}
			$location.path('/payroll');
		});
	};
	//贴现
	$scope.discountBill=function(){
		discountService.discount($scope.discount).then(function(data){
			console.log(data);
			if(data.state==1){
				Showbo.Msg.alert("你已发起支付，等待节点投票！");
			}else{
				Showbo.Msg.alert("支付失败");;
			}
			$location.path('/discount');
		});
	};
	
	
	
	$scope.queryLogin = function() {
//		NoderService.runLogin($scope.noder).then(function(data){
//			var noder=data;
//			if(noder.noderState == 0){
//	    		   $window.alert("您还没有审核！！！");
//	    		   $location.path('/login');
//			}else{
//				 $location.path('/home');
//			}
//		}) ;
	       $http.post('billnoderLogin.do',$scope.noder).success(function(noder){
	    	   var noderState = noder.noderState;
	    	   var id = noder.id;
	    	   console.log(noder);
	    	  
	    	   if(noderState == 0){
	    		   $window.alert("您还没有审核！！！");
	    	   }else if($scope.noderKey == noder.noderKey){
	    
	    		   $rootScope.id = noder.id;
	    		   //$rootScope.billNoderName = noder.noderName;
		    	   //$rootScope.password = noder.password;
		    	   //$rootScope.noderType = noder.noderType;
		    	   
	    		   myFactory.setBillNoder(noder);
//		    	   $cookieStore.put("billNoder", noder,{
//		                'expires': new Date(new Date().getTime() + 5000)
//		            });//将noder存放到cookie里

//		    	   $cookies.putObject("billNoder", noder,{'expires':new Date(new Date().getTime()+5000)});
		    	
		    	   
		    	   
		    	   $('#loginModal').modal('hide');
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
	    	   $http.post('billNoder.do',$scope.noder)
	    	   		.success(function(data){
	    	   			Showbo.Msg.alert("注册节点用户成功！");
	    	   			$('#registerModal').modal('hide');
	    	   			$location.path('/home');
		        });
	        });
	   }
	
	
	$http.get("json/city.json").success(function(data){
		var jsonString = angular.toJson(data);
		
		$scope.districts = angular.fromJson(jsonString);
		//console.log($scope.districts);
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
	
	
}])
/*超级管理员*/
.controller('AdminController',['$scope','$rootScope','$http','$location',function($scope , $rootScope , $http , $location){
	
}])
/*区块链管理员*/
.controller('BlockChainAdminController',['$scope','$rootScope','$http','$location',function($scope , $rootScope , $http , $location){

 	$http.get("json/city.json").success(function(data){
		var jsonString = angular.toJson(data);
		
		$scope.districts = angular.fromJson(jsonString);
		//console.log($scope.districts);
 	});
	$scope.currentDate = new Date();
 	$scope.open1 = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
 		$event.preventDefault();
 		$event.stopPropagation();
 		$scope.registDateOpened = true;
 	};
 	$scope.open2 = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
 		$event.preventDefault();
 		$event.stopPropagation();
 		$scope.applyDateOpened = true;
 	};
 	$scope.disabled = function(date , mode){ 
 		return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6))
 	};
 	$scope.dateOptions = {
 		formatYear : 'yy',
 		startingDay : 1
 	};	
}])
/* 用户个人信息 */
.controller('UserInfoController',['$scope',function($scope){
	
}])
//
.controller('BillDetailController',['$scope','myFactory',function($scope,myFactory){
	function unUnicode(str){
		return unescape(str.replace(/\\u/g, "%u"));
	};
	$scope.billsDetail=myFactory.getter();
	$scope.bill=$scope.billsDetail.transaction.data.payload.bill;
	
	$scope.originaler=unUnicode($scope.bill.Bill_operator_name);
	$scope.receiver=unUnicode($scope.bill.Bill_receiver_name);
	$scope.discountinger=unUnicode($scope.bill.Guarantee_organization_name);
	$scope.billNumber=$scope.bill.Bill_id;
	$scope.moneySum=$scope.bill.Bill_amount_money;
	$scope.expireDate=$scope.bill.Bill_outdate;
}])