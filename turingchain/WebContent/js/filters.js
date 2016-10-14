var myFilters = angular.module('myFilters', []);
myFilters.filter('isodateFilter', function(){
	return function(x){
		if(x==null){
			return '';
		}else{
			var time=new Date(x);
			var time1=time.valueOf();
			var date=new Date(time1);
			Y = date.getFullYear() + '-';
			M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			D = date.getDate() + ' ';
			h = date.getHours() + ':';
			m = date.getMinutes() + ':';
			s = date.getSeconds(); 
			return Y+M+D+h+m+s;
		}
	}
});