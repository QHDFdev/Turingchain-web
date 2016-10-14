angular.module('myDirectives', [])
.directive('selectAddress', function($http, $q, $compile) {
    var cityURL, delay, templateURL;
    delay = $q.defer();
    templateURL = 'template/index.html';
    cityURL = 'template/city.min.js';
    $http.get(cityURL).success(function(data) {
      return delay.resolve(data);
    });
    return {
      restrict: 'A',
      scope: {
        p: '=',
        a: '=',
        c: '=',
        d: '=',
        ngModel: '='
      },
      link: function(scope, element, attrs) {
        var popup;
        popup = {
          element: null,
          backdrop: null,
          show: function() {
            return this.element.addClass('active');
          },
          hide: function() {
            this.element.removeClass('active');
            return false;
          },
          resize: function() {
            if (!this.element) {
              return;
            }
            this.element.css({
              top: -this.element.height() - 30,
              'margin-left': -this.element.width() / 2
            });
            return false;
          },
          focus: function() {
            $('[ng-model="d"]').focus();
            return false;
          },
          init: function() {
            element.on('click keydown', function() {
              popup.show();
              event.stopPropagation();
              return false;
            });
            $(window).on('click', (function(_this) {
              return function() {
                return _this.hide();
              };
            })(this));
            this.element.on('click', function() {
              return event.stopPropagation();
            });
            return setTimeout((function(_this) {
              return function() {
                _this.element.show();
                return _this.resize();
              };
            })(this), 500);
          }
        };
        return delay.promise.then(function(data) {
          $http.get(templateURL).success(function(template) {
            var $template;
            $template = $compile(template)(scope);
            $('body').append($template);
            popup.element = $($template[2]);
            scope.provinces = data;
            return popup.init();
          });
          scope.aSet = {
            p: function(p) {
              scope.p = p;
              scope.c = null;
              scope.a = null;
              return scope.d = null;
            },
            c: function(c) {
              scope.c = c;
              scope.a = null;
              return scope.d = null;
            },
            a: function(a) {
              scope.a = a;
              scope.d = null;
              return popup.focus();
            }
          };
          scope.clear = function() {
            scope.p = null;
            scope.c = null;
            scope.a = null;
            return scope.d = null;
          };
          scope.submit = function() {
            return popup.hide();
          };
          scope.$watch('p', function(newV) {
            var v, _i, _len, _results;
            if (newV) {
              _results = [];
              for (_i = 0, _len = data.length; _i < _len; _i++) {
                v = data[_i];
                if (v.p === newV) {
                  _results.push(scope.cities = v.c);
                }
              }
              return _results;
            } else {
              return scope.cities = [];
            }
          });
          scope.$watch('c', function(newV) {
            var v, _i, _len, _ref, _results;
            if (newV) {
              _ref = scope.cities;
              _results = [];
              for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                v = _ref[_i];
                if (v.n === newV) {
                  _results.push(scope.dists = v.a);
                }
              }
              return _results;
            } else {
              return scope.dists = [];
            }
          });
          return scope.$watch(function() {
            scope.ngModel = '';
            if (scope.p) {
              scope.ngModel += scope.p;
            }
            if (scope.c) {
              scope.ngModel += " " + scope.c;
            }
            if (scope.a) {
              scope.ngModel += " " + scope.a;
            }
            if (scope.d) {
              scope.ngModel += " " + scope.d;
            }
            return popup.resize();
          });
        });
      }
    };
  })
  
.directive('fileModel', ['$parse', function ($parse) {
    return {
	        restrict: 'A',
	        link: function(scope, element, attrs) {
	            var model = $parse(attrs.fileModel);
	            var modelSetter = model.assign;
            
	        element.bind('change', function(){
	               scope.$apply(function(){
	            	   modelSetter(scope, element[0].files[0]);
                	});
	               
            	});
        	}
    	};
	}])
.directive('ensureNameunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				if(!val || val.length < 5 && val.length > 12){
					return;
				}
				
				$http({
					method:'POST',
					url : 'findByName.do',
					params:{
						userName : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('userNameAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('userNameAvi',true);
			
					}
				});
				return val;
			})
		}
	}
})

.directive('ensureEmailunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				$http({
					method:'POST',
					url : 'findByEmail.do',
					params:{
						email : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('emailAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('emailAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})
.directive('ensureNodernameunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				if(!val || val.length < 5 && val.length > 12){
					return;
				}
				
				$http({
					method:'POST',
					url : 'findNoderByName.do',
					params:{
						noderName : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('noderNameAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('noderNameAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})
.directive('ensureNoderemailunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				if(!val || val.length < 5 && val.length > 12){
					return;
				}
				
				$http({
					method:'POST',
					url : 'findNoderByEmail.do',
					params:{
						email : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('emailAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('emailAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})
.directive('ensureComnumunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				$http({
					method:'POST',
					url : 'findNoderByComNum.do',
					params:{
						comNum : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('comNumAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('comNumAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})
.directive('ensureComnameunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				$http({
					method:'POST',
					url : 'findNoderByComName.do',
					params:{
						comName : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('comNameAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('comNameAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})
.directive('ensureAdminnameunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				if(!val || val.length < 5 && val.length > 12){
					return;
				}
				
				$http({
					method:'POST',
					url : 'findAdminByName.do',
					params:{
						adminName : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('adminNameAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('adminNameAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})
.directive('ensureAdminemailunique',function($http){
	return{
		require: 'ngModel',
		link:function(scope,ele,attrs,ngModelCtrl){
			
			ngModelCtrl.$parsers.push(function(val){
				
				$http({
					method:'POST',
					url : 'findAdminByEmail.do',
					params:{
						email : val
					}
				}).success(function(data){
					console.log(data);
					if(data){
						ngModelCtrl.$setValidity('emailAvi',false);
					
					}else{
						ngModelCtrl.$setValidity('emailAvi',true);
			
					}
					
				});
				return val;
			})
		}
	}
})

.directive('hometableshow',function(){
	return {
		restrict:'A',
		link:function(scope,element,attr){
			element.css('cursor','pointer');
			element.on('click',function(){
				$(this).parent().parent().next().css('display','block');
			});
			element.on('mouseenter',function(){
				$(this).css('color','#dc143c');
			});
			element.on('mouseleave',function(){
				$(this).css('color','#ECE6E9');	
			});				
		}
	}
})
