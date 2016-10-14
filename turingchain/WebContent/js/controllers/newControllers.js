angular.module('newController', ['myDirectives'])

.controller('newHomeController',['$scope','$rootScope','$http','$location','$window','$interval','$anchorScroll','$cookies','$cookieStore','$timeout',
    function($scope , $rootScope , $http , $location ,$window ,$interval,$anchorScroll,$cookies,$cookieStore,$timeout){

		$scope.user=$cookieStore.get('User');
//	console.log($scope.user);
	$scope.$watch('user',function(newV,oldV,scope){
		console.log(newV);
		console.log(oldV);
	});
	
	$scope.indexdown=function(){
		$('html,body').animate({'scrollTop':'2000px'},'fast');
	}
	$('body').scrollspy({ target: '#header' })

	$scope.isActive = false;
	$scope.div1 = function(){
		$location.hash('div2');
        $anchorScroll();
    };
    $scope.div2 = function(){
    	$location.hash('div3');
        $anchorScroll();
    };
    /*$scope.div3 = function(){
    	$location.hash('div3');
    	$anchorScroll();
    };*/
    $scope.div4 = function(){
    	$location.hash('div4');
    	$anchorScroll();
    };
    $scope.div5 = function(){
    	$location.hash('div5');
    	$anchorScroll();
    };
    $scope.div6 = function(){
    	$location.hash('div6');
    	$anchorScroll();
    };
    $scope.div7 = function(){
    	$location.hash('div7');
    	$anchorScroll();
    };
    $scope.div8 = function(){
    	$location.hash('div8');
    	$anchorScroll();
    };
    $scope.div9 = function(){
    	$location.hash('div9');
    	$anchorScroll();
    };
    $scope.div10 = function(){
    	$location.hash('div10');
    	$anchorScroll();
    };
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

.controller('rotateImgController',['$scope','$rootScope','$http','$location','$window','$interval','$anchorScroll',
    function($scope){
	var r = r ||0;
	var element = document.getElementById("rotateImg");
	
	$scope.mouseOver=function(){
		r = r ||0;
		if($(window).width() > 992){
			element.style.MozTransform = " scale(1.30,1.30)";
			element.style.webkitTransform =" scale(1.30,1.30)";
			element.style.msTransform = " scale(1.30,1.30)";
			element.style.OTransform = " scale(1.30,1.30)";
			element.style.transform = " scale(1.30,1.30)";
		}
	}
	
	$scope.mouseUp=function(){
		r=r+72;
		if($(window).width() > 992){
			element.style.MozTransform = "rotate(" + r + "deg)" + " scale(1.30,1.30)";
			element.style.webkitTransform ="rotate(" + r + "deg)" + " scale(1.30,1.30)";
			element.style.msTransform = "rotate(" + r + "deg)" + " scale(1.30,1.30)";
			element.style.OTransform = "rotate(" + r + "deg)" + " scale(1.30,1.30)";
			element.style.transform = "rotate(" + r + "deg)" + " scale(1.30,1.30)";
		}else{
			element.style.MozTransform = "rotate(" + r + "deg)";
			element.style.webkitTransform ="rotate(" + r + "deg)";
			element.style.msTransform = "rotate(" + r + "deg)";
			element.style.OTransform = "rotate(" + r + "deg)";
			element.style.transform = "rotate(" + r + "deg)";
		}
		console.log("==>"+r+"\n");
	}
	
	$scope.mouseLeave=function(){
		element.style.MozTransform = " scale(1.0,1.0)";
		element.style.webkitTransform =" scale(1.0,1.0)";
		element.style.msTransform = " scale(1.0,1.0)";
		element.style.OTransform = " scale(1.0,1.0)";
		element.style.transform = " scale(1.0,1.0)";
		r = r ||0;
	}
	
}])