app=angular.module('myServices', []);
app.service('uniqueNameService', ['$http',
	  function($http) {
		var uniqueName = function(userName){
			return $http({
				method:'POST',
				url:'findByName.do',
				params:{
					userName : userName
				}
			});
		}
		return {
			isOnly : function(userName){
				return uniqueName(userName);
			}
		}
	}
]);
app.factory('loginServices',['$http','$q',function($http,$q){
	var login=function(address,user){
		var deferred=$q.defer();
		$http({
			method:	'POST',
			url:			address+'.do',
			data:			user
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(data){
			console.log('登陆出错！')
			Showbo.Msg.alert("您的秘钥或密码有错！");
		});
		return deferred.promise; 
	}
	return{
		login: login
	}
}]);