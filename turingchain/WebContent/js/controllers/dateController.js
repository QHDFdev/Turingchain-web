angular.module('dateController',['myDirectives'])

//.controller('dateDemo',['$scope','$rootScope','$http','$location',function($scope,$rootScope,$http,$location){
//	$scope.today = function(){ 			// 创建一个方法， 
//		$scope.dt = new Date(); 		// 定义一个属性来接收当天日期
////		alert("today:"+$scope.dt);
//	};
//	$scope.today(); 					// 运行today方法 
//	 $scope.clear = function(){  		//当运行clear的时候将dt置为空
//		$scope.dt = null;
////		alert("clear:"+$scope.dt)
//	}
//	 $scope.open = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
//		$event.preventDefault();
//		$event.stopPropagation();
//		$scope.opened = true;
//		alert("open:"+$scope.dt + $scope.noder.lawerName);
//	} 
//	$scope.toggleMin = function(){
//		$scope.currentDate = new Date(); //3元表达式，没啥好说的
////		alert("toggleMin:"+$scope.dt);
//	}
//	$scope.toggleMin();
//	$scope.disabled = function(date , mode){ 
//		return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6))
//	}
//	$scope.dateOptions = {
//		formatYear : 'yy',
//		startingDay : 1
//	}
//}]);