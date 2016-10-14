angular.module('BlockChainAdminController',['myDirectives'])

.controller('BlockChainAdminController',['$scope','$rootScope','$http','$location',
     	function($scope , $rootScope , $http , $location){
	
	$scope.load = function (){
		$(window).scrollTop="0px";
		/*if($(window).height() < $(window).width()){
			document.getElementsByName("homePic")[0].style.height=0.92 * $(window).height()-120 + "px";
			document.getElementsByName("homePic")[1].style.height=0.92 * $(window).scrollHeight()-120 + "px";
			document.getElementsByName("homePic")[2].style.height=0.92 * $(window).scrollHeight()-120 + "px";
		}*/
		
		document.getElementsByName("home")[0].style.fontSize=0.014 * $(window).height() + "px";
		document.getElementsByName("table")[0].style.paddingTop=0.0099 * $(window).height() + "px";
		document.getElementsByName("table")[1].style.paddingTop=0.0099 * $(window).height() + "px";
		document.getElementsByName("div")[0].style.paddingBottom=0.0099 * $(window).height() + "px";
		
		document.getElementsByName("title")[0].style.fontSize=0.0255623721881391 * $(window).height() + "px";
		document.getElementsByName("title")[1].style.fontSize=0.0255623721881391 * $(window).height() + "px";
		
    }

	$(document).ready(function(){
		$(window).resize(function() {
			/*if($(window).height() < $(window).width()){
				document.getElementsByName("homePic")[0].style.height=0.92 * $(window).height()-120 + "px";
				document.getElementsByName("homePic")[1].style.height=0.92 * $(window).height()-120 + "px";
				document.getElementsByName("homePic")[2].style.height=0.92 * $(window).height()-120 + "px";
			}*/
				
			document.getElementsByName("home")[0].style.fontSize=0.014 * $(window).height() + "px";
			document.getElementsByName("table")[0].style.paddingTop=0.0099 * $(window).height() + "px";
			document.getElementsByName("table")[1].style.paddingTop=0.0099 * $(window).height() + "px";
			document.getElementsByName("div")[0].style.paddingBottom=0.0099 * $(window).height() + "px";
			
			document.getElementsByName("title")[0].style.fontSize=0.0255623721881391 * $(window).height() + "px";
			document.getElementsByName("title")[1].style.fontSize=0.0255623721881391 * $(window).height() + "px";
				
		});
	});
	
     		$scope.addBlockChainAdmin = function(){
     			$scope.bcAdmin.address = "";
//     	$scope.bcAdmin.address = $scope.selectedDistrict1.name + $scope.selectedUnit1.name
//     			+ $scope.selectedPosition1.name + $scope.address1;
     	
     	$scope.bcAdmin.companyAddress = "";
     	$scope.bcAdmin.companyAddress = $scope.selectedDistrict2.name + $scope.selectedUnit2.name
     	+ $scope.selectedPosition2.name + $scope.companyAddress2;
     	
     	$scope.bcAdmin.authority ="";
     	if($scope.a1){
     		$scope.bcAdmin.authority=="" ?($scope.bcAdmin.authority += "增加子节点"):($scope.bcAdmin.authority += ",增加子节点");
     	}if($scope.a2){
     		$scope.bcAdmin.authority=="" ?($scope.bcAdmin.authority += "审核子节点"):($scope.bcAdmin.authority += ",审核子节点");
     	}if($scope.a3){
     		$scope.bcAdmin.authority=="" ?($scope.bcAdmin.authority += "注销子节点"):($scope.bcAdmin.authority += ",注销子节点");
     	}if($scope.a4){
     		$scope.bcAdmin.authority=="" ?($scope.bcAdmin.authority += "配置文件修改"):($scope.bcAdmin.authority += ",配置文件修改");
     	}if($scope.a5){
     		$scope.bcAdmin.authority=="" ?($scope.bcAdmin.authority += "子节点数据项修改"):($scope.bcAdmin.authority += ",子节点数据项修改");
     	}
     	
     	$http.post('blockChainAdmin.do',$scope.bcAdmin)
     	.success(function(data){
     		console.info(data.msg); 
     		Showbo.Msg.alert($scope.bcAdmin.bcAdmName +" 注册成功!");
     	$location.path('/home');
     		});
     	};
     	
     	$http.get("json/city.json").success(function(data){
     			var jsonString = angular.toJson(data);
     			
     			$scope.districts = angular.fromJson(jsonString);
     			console.log($scope.districts);
     	});
     	
     	$scope.queryEmail = function(){
    		var email = $scope.bcAdmin.email;
    		$http
    		.get('queryEmail/'+ email +'.do')
       		.success(function(data){
       			console.info(data); 
       			$scope.emailInfo = data;
       		});
    	}
     		
     	$scope.currentDate = new Date();
     	$scope.open1 = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
     		$event.preventDefault();
     		$event.stopPropagation();
     		$scope.registDateOpened = true;
     	} 
     	$scope.open2 = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
     		$event.preventDefault();
     		$event.stopPropagation();
     		$scope.applyDateOpened = true;
     	}
     	$scope.disabled = function(date , mode){ 
     		return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6))
     	}
     	$scope.dateOptions = {
     		formatYear : 'yy',
     		startingDay : 1
     	}	
     	
     	$scope.queryReferrerKey = function(){
 		   var adminName = $scope.bcAdmin.referrerName;
 		   var referrerKey = $scope.bcAdmin.referrerKey;
 		   $scope.referrerKeyInfo = null;
 		  $http
	  		.get('queryReferrerKey/'+ adminName + '/' + referrerKey +'.do')
	     		.success(function(admin){
	     			if(admin.adminName==undefined){
	     				$scope.referrerKeyInfo = "推荐人授权码不正确！";
	     			}
	     		});
 	   }
     		
     }])	