var app = angular.module('BillService', []);

//节点用户注册
app.factory('NoderService', [ '$http','$q', function($http,$q) {
	var runLogin = function(noder) {
		 var deferred = $q.defer();
		$http({
			method : 'POST',
			url : 'billnoderLogin.do',
			data : noder
		}).success(function(data) {
			deferred.resolve(data);
		});
		 return deferred.promise;
	};
	return {
		runLogin : runLogin
	};
} ]);

//核心集团
app.factory('IssuanceService',['$http','$q',function($http,$q){
	//签发票据
	issuance=function(issuance){
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : 'issuanceBill.do',
			data : issuance
		}).success(function(data){
			deferred.resolve(data);
		});
		 return deferred.promise;
	};
	
	//查询票据
	function history(){
		var deferred = $q.defer();
		$http({
			method: 'GET',
			url:''
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	
	
	return{
		issuance: issuance,
		history:history
	}
}]);

//承贴机构 ----- 确认承贴
app.factory('discountingService',['$http','$q',function($http,$q){
	function discounting(discountingId){
		var deferred=$q.defer()
		$http({
			method: 'GET',
			url:'discountingBill/'+discountingId+'.do',
		}).success(function(data){
			console.log(data);
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	
	
	//查看需要承贴的钱
	function discountingList(noderId){
		var deferred=$q.defer()
		$http({
			method: 'GET',
			url:'needDiscounting/'+noderId+'.do',
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		discounting:discounting,
		discountingList:discountingList
	}
}]);
//支付机构
app.factory('paymentService',['$http','$q',function($http,$q){
	function payment(payment){
		var deferred=$q.defer()
		$http({
			method: 'POST',
			url:'paymentBill.do',
			data:payment
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		payment:payment,
	}
}]);


//发薪机构
app.factory('payoffService',['$http','$q',function($http,$q){
	function payoff(payoff){
		var deferred=$q.defer()
		$http({
			method: 'POST',
			url:'payoffBill.do',
			data:payoff
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		payoff:payoff,
	}
}]);

//提薪机构
app.factory('payrollService',['$http','$q',function($http,$q){
	function payroll(payroll){
		var deferred=$q.defer()
		$http({
			method: 'POST',
			url:'payrollBill.do',
			data:payroll
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		payroll:payroll,
	}
}]);

//贴现机构
app.factory('discountService',['$http','$q',function($http,$q){
	function discount(discount){
		var deferred=$q.defer()
		$http({
			method: 'POST',
			url:'discountBill.do',
			data:discount
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		discount:discount,
	}
}]);
//我的票据查询
app.factory('myBillsService',['$http','$q',function($http,$q){
	function billHistory(pubk){
		var deferred=$q.defer()
		$http({
			method: 'GET',
			url:'billHistory/'+pubk+'.do',
			data:pubk
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		billHistory:billHistory,
	}
}]);

//我的票据查询
app.factory('getTransferByIdService',['$http','$q',function($http,$q){
	function getTransfer(id){
		var deferred=$q.defer()
		$http({
			method: 'GET',
			url:'getTransactionByidRest/'+id+'.do',
			data:id
		}).success(function(data){
			deferred.resolve(data);
		});
		return deferred.promise;
	}
	return{
		getTransfer:getTransfer,
	}
}]);
//分页服务
app.factory('Paginator',function(){
	return function(fetchFunction,pageSize){
		var paginator={
				hasNextVar:false,
				next:function(){
					if(this.hasNextVar){
						this.currentOffset+=pageSize;
						this._load();
					}
				},
				_load:function(){
					var self=this;
					fetchFunction(this.currentOffset,pageSize+1,function(items){
						self.currentPageItems=items.slice(0,pageSize);
						self.hasNextVar=items.length===pageSize+1;
						console.log(self.currentPageItems);
					})
				},
				haxNext:function(){
					return this.hasNextVar;
				},
				previous:function(){
					if(this.hasPrevious){
						this.currentOffset-=pageSize;
						this._load();
					}
				},
				hasPrevious:function(){
					return this.currentOffset!==0;
				},
				getItems:function(){
					return self.currentPageItems;
				},
				currentPageItems:[],
				currentOffset:0
		};
		paginator._load();
		return paginator;
	}
})










