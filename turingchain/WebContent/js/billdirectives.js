angular.module('myBillDirectives', [])
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
            })(this), 1000);
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
					url : 'findUserByName.do',//undone
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
					url : 'findUserByEmail.do',//undone
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
					url : 'findBillNoderByName.do',
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
					url : 'findBillNoderByEmail.do',
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
					url : 'findBillNoderByComNum.do',
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
					url : 'findAdminByName.do',//undone
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
					url : 'findAdminByEmail.do',//undone
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
	}//addtion
})
.directive('companyMainlist',function(){
	return{
		restrict:'A',
		link:function(scope,element,attr){
			element.children('li').css('width',$(window).width());
			element.css('width',$(window).width()*7);
			$(window).resize(function(){
				element.children('li').css('width',$(window).width());
				element.css('width',$(window).width()*7);
			});
			var obj=element.next();
			var x=$(window).width()-obj.children().width();
			var y=$(window).width();
			var n=0;
			var onOff=true;
			$('.bill-carousel1 .playOff').click(function(){
				if(n==0){
					billFlash1();
				}else if(n==1){
					billFlash2();
				}else if(n==2){
					billFlash3();
				}else if(n==3){
					billFlash4();
				}else if(n==4){
					billFlash5();
				}else if(n==5){
					billFlash6();
				}else if(n==6){
					billFlash7();
				}
				$('.bill-carousel1 .playOff').attr('disabled','disabled').html("<i class='icon-pause'></i> 演示中");
			})
			function billFlash1(){
				$('.bill-carousel1 .icon1').add('.bill-carousel1 .icon3').add('.bill-carousel1 .icon5').add('.bill-carousel1 .icon7').add('.bill-carousel1 .icon9').add('.bill-carousel1 .icon11').add('.bill-carousel1 .icon13').css('top','100px');
				$('.bill-carousel1 .icon2').add('.bill-carousel1 .icon4').add('.bill-carousel1 .icon6').add('.bill-carousel1 .icon8').add('.bill-carousel1 .icon10').add('.bill-carousel1 .icon12').add('.bill-carousel1 .icon14').css('top','140px');
				element.css('left',0);
				obj.css('left',0);
				obj.children().css('display','none').eq(0).css('display','block');
				$('.bill-carousel1 .icon1').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':x},5000,function(){
						$('.bill-carousel1 .icon2').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash2(){
				element.css('left',-y);
				obj.children().css('display','none').eq(1).css('display','block');
				$('.bill-carousel1 .icon3').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':0},5000,function(){
						$('.bill-carousel1 .icon4').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash3(){
				obj.children().css('display','none').eq(2).css('display','block');
				element.css('left',-2*y);
				$('.bill-carousel1 .icon5').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':x},5000,function(){
						$('.bill-carousel1 .icon6').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash4(){
				obj.children().css('display','none').eq(3).css('display','block');
				element.css('left',-3*y);
				$('.bill-carousel1 .icon7').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':0},5000,function(){
						$('.bill-carousel1 .icon8').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash5(){
				obj.children().css('display','none').eq(4).css('display','block');
				element.css('left',-4*y);
				$('.bill-carousel1 .icon9').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':x},5000,function(){
						$('.bill-carousel1 .icon10').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash6(){
				obj.children().css('display','none').eq(5).css('display','block');
				element.css('left',-5*y);
				$('.bill-carousel1 .icon11').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':0},5000,function(){
						$('.bill-carousel1 .icon12').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash7(){
				obj.children().css('display','none').eq(6).css('display','block');
				element.css('left',-6*y);
				$('.bill-carousel1 .icon13').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':x},5000,function(){
						$('.bill-carousel1 .icon14').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n=0;
							$('.bill-carousel1 .playOff').text('演示完成');
							obj.children().css('display','none').eq(7).css('display','block');
							setTimeout(function(){
								obj.children().eq(7).animate({'display':'none'},1000,function(){
									n=0;
									element.css('left',0);
									obj.css('left',0);
									obj.children().css('display','none').eq(0).css('display','block');
									$('.bill-carousel1 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 开始演示");;
								});
							},2000)
						});
					});
				}).animate({'opacity':'0'},1000);
			};
				/*obj.delay(1000).animate({'left':x},5000,function(){
					obj.children().css('display','none').eq(1).css('display','block');
					element.css('left',-y);
				}).delay(1000).animate({'left':0},5000,function(){
					obj.children().css('display','none').eq(2).css('display','block');
					element.css('left',-2*y);
				}).delay(1000).animate({'left':x},5000,function(){
					obj.children().css('display','none').eq(3).css('display','block');
					element.css('left',-3*y);
				}).delay(1000).animate({'left':0},5000,function(){
					obj.children().css('display','none').eq(4).css('display','block');
					element.css('left',-4*y);
				}).delay(1000).animate({'left':x},5000,function(){
					obj.children().css('display','none').eq(5).css('display','block');
					element.css('left',-5*y);
				}).delay(1000).animate({'left':0},5000,function(){
					obj.children().css('display','none').eq(6).css('display','block');
					element.css('left',-6*y);
				}).delay(1000).animate({'left':x},5000,function(){
					obj.children().css('display','none').eq(7).css('display','block');
					setTimeout(function(){
						resetFlash();
					},1000)
				})*/
				
				
			
		}
	}
})
.directive('companySublist',function(){
	return{
		restrict:'A',
		link:function(scope,element,attr){
			element.children('li').css('width',$(window).width());
			element.css('width',$(window).width()*4);
			$(window).resize(function(){
				element.children('li').css('width',$(window).width());
				element.css('width',$(window).width()*4);
			});
			var obj=element.next();
			var x=$(window).width()-obj.children().width();
			var y=$(window).width();
			var n=0;
			var onOff=true;
			$('.bill-carousel2 .playOff').click(function(){
				if(n==0){
					billFlash1();
				}else if(n==1){
					billFlash2();
				}else if(n==2){
					billFlash3();
				}else if(n==3){
					billFlash4();
				}
				$('.bill-carousel2 .playOff').attr('disabled','disabled').html("<i class='icon-pause'></i> 演示中");
			})
			function billFlash1(){
				$('.bill-carousel2 .icon1').add('.bill-carousel2 .icon3').add('.bill-carousel2 .icon5').add('.bill-carousel2 .icon7').css('top','100px');
				$('.bill-carousel2 .icon2').add('.bill-carousel2 .icon4').add('.bill-carousel2 .icon6').add('.bill-carousel2 .icon8').css('top','140px');
				element.css('left',0);
				obj.css('left',0);
				obj.children().css('display','none').eq(0).css('display','block');
				$('.bill-carousel2 .icon1').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':x},5000,function(){
						$('.bill-carousel2 .icon2').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel2 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash2(){
				element.css('left',-y);
				obj.children().css('display','none').eq(1).css('display','block');
				$('.bill-carousel2 .icon3').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':0},5000,function(){
						$('.bill-carousel2 .icon4').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel2 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash3(){
				obj.children().css('display','none').eq(2).css('display','block');
				element.css('left',-2*y);
				$('.bill-carousel2 .icon5').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':x},5000,function(){
						$('.bill-carousel2 .icon6').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							n++;
							$('.bill-carousel2 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 继续");
						});
					});
				}).animate({'opacity':'0'},1000);
			};
			function billFlash4(){
				obj.children().css('display','none').eq(3).css('display','block');
				element.css('left',-3*y);
				$('.bill-carousel2 .icon7').animate({'opacity':'1'},1000).animate({'top':'140px'},1000,function(){
					obj.animate({'left':0},5000,function(){
						$('.bill-carousel2 .icon8').animate({'opacity':'1'},1000).animate({'top':'100px'},1000).animate({'opacity':'0'},1000,function(){
							obj.children().css('display','none').eq(4).css('display','block');
							$('.bill-carousel2 .playOff').text('演示完成');
							setTimeout(function(){
								obj.children().eq(4).animate({'display':'none'},1000,function(){
									n=0;
									element.css('left',0);
									obj.css('left',0);
									obj.children().css('display','none').eq(0).css('display','block');
									$('.bill-carousel2 .playOff').removeAttr('disabled').html("<i class='icon-play'></i> 开始演示");
								});
							},2000)
						});
					});
				}).animate({'opacity':'0'},1000);
			};
		}
	}
})
