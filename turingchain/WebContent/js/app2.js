angular
		.module(
				'myApp2',
				[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'myFilters',
						'ngCookies', 'controllers',
						'BlockChainAdminController', 'HomeController',
						'myServices', 'myDirectives', 'ngMessages',
						'BillService' ])

		.config(function($routeProvider) {
			$routeProvider.when('/login', {
				templateUrl : 'tpls/login.html',
			// controller:'UserController'
			}).when('/register', {
				templateUrl : 'tpls/register.html',
			// controller:'UserController'
			}).when('/principle', {
				templateUrl : 'tpls/principle.html',
				controller : ''
			}).when('/home', {
				templateUrl : 'tpls/home2.html',
				controller : 'newHomeController'
			}).when('/contract', {
				templateUrl : 'bcPages/contract.html',
				controller : 'EditorCtrl'
			}).when('/api', {
				templateUrl : 'bcPages/api.html',
				controller : 'ApiCtrl'
			}).when('/sdk', {
				templateUrl : 'bcPages/sdk.html',
			// controller:
			}).when('/newNodeApply', {
				templateUrl : 'tpls/newNodeApply.html',
				controller : 'newNodeApplyController'
			}).when('/newNodeApplyRecord', {
				templateUrl : 'tpls/newNodeApplyRecord.html',
				controller : 'newNodeApplyRecordController'
			}).when('/transaction/:id', {
				templateUrl : 'tpls/index_transaction.html',
				controller : 'IndexTransactionInfoController'
			}).when('/industryCase', {
				templateUrl : 'tpls/industryCase.html',

			}).when('/TuringThingTrace', {
				templateUrl : 'tpls/TuringThingTrace.html'
			}).when('/electronBill', {
				templateUrl : 'tpls/electronBill.html'
			}).otherwise({
				redirectTo : '/home',
				templateUrl : 'tpls/home2.html',
				controller : 'newHomeController'
			})
		})
		.run(
				[
						'$rootScope',
						'$location',
						'$timeout',
						'$window',
						function($rootScope,$location,$timeout,$window) {

							var wow = new WOW({
								boxClass : 'wow',
								animateClass : 'animated',
								offset : 0,
								mobile : false,
								live : true
							});
							wow.init();
							if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
								$('.index-header').removeClass('color-141414');
							}
							$(window).on('scroll',function(){
								if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
									
									if($('body').scrollTop()>100){
										$('.index-header').addClass('color-141414');
										 
									}else{
										$('.index-header').removeClass('color-141414');
									}
								};
							})
							if(($location.url()=='/login')||($location.url()=='/register')){
								$('.index-header').addClass('color-141414');
							};
								
							/*if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
								if($('html,body').scrollTop()>100){
									$('.index-header').addClass('color-141414')
									console.log($location.url());
								}else{
									$('.index-header').removeClass('color-141414')
								}
							}*/

							$rootScope.$on('$routeChangeStart', function(next,
									current) {
								$('html,body').scrollTop(0);
								if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
									$('.index-header').removeClass('color-141414');
								}
								$(window).on('scroll',function(){
									if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
										
										if($('body').scrollTop()>100){
											$('.index-header').addClass('color-141414');
											 
										}else{
											$('.index-header').removeClass('color-141414');
										}
									};
								})
								if(($location.url()=='/login')||($location.url()=='/register')){
									$('.index-header').addClass('color-141414');
								};
								var wow = new WOW({
									boxClass : 'wow',
									animateClass : 'animated',
									offset : 0,
									mobile : false,
									live : true
								});
								wow.init();

							});
							/*
							 * var starchart = new
							 * StarChart(document.getElementById('div1'), PIXI,
							 * 70, 70, 2); starchart.run();
							 */
							$rootScope.$on('$routeChangeSuccess', function(
									next, current) {
								$('html,body').scrollTop(0);
								if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
									$('.index-header').removeClass('color-141414');
								}
								$(window).on('scroll',function(){
									if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
										
										if($('body').scrollTop()>100){
											$('.index-header').addClass('color-141414');
											 
										}else{
											$('.index-header').removeClass('color-141414');
										}
									};
								})
								if(($location.url()=='/login')||($location.url()=='/register')){
									$('.index-header').addClass('color-141414');
								};
								/*if(($location.url()=='/home')||($location.url()=='/industryCase')||($location.url()=='/TuringThingTrace')||($location.url()=='/electronBill')){
									$rootScope.$apply(function(){
										if($('html,body').scrollTop()>100){
											$('.index-header').addClass('color-141414')
										}else{
											$('.index-header').removeClass('color-141414')
										}
									})
									
								}*/
								
								if ($location.url() == '/industryCase') {
									$timeout(function(){
										
										var starchart = new StarChart(document.getElementById('indusStar'), PIXI, 70, 70, 2);
										starchart.run();
									},1000);
								}

							})
						} ])
		.controller('EditorCtrl', function($scope) {

			var editor = ace.edit("editor");
			editor.setTheme("ace/theme/monokai");
			editor.getSession().setMode("ace/mode/javascript");
			document.getElementById('editor').style.fontSize = '16px';
			// editor.setHighlightActiveLine(false);
		})
		.controller(
				'testController',
				[
						'$scope',
						'$rootScope',
						'$http',
						'$location',
						'$interval',
						'getTransferByIdService',
						'$window',
						'$timeout',
						'$q',
						function($scope, $rootScope, $http, $location,
								$interval, getTransferByIdService, $window,
								$timeout, $q) {
							$scope.testApi = function() {
								$('.data-service-top')
										.slideDown(
												1000,
												function() {
													$(
															'#div2 .data-service-return pre')
															.slideUp()
													$http({
														method : 'POST',
														url : 'testApi.do',
														data : $scope.testBill
													})
															.success(
																	function(
																			data) {
																		console
																				.log(data);
																		$scope.txid = data;
																		$(
																				'#div2 .data-service-msg')
																				.slideDown();
																	});
												});

							}
							$scope.mykeyup = function(e) {
								var keycode = window.event ? e.keyCode
										: e.which;
								if (keycode == 13) {
									$scope.testApi();
								}
							}

							$scope.turnTran = function() {
								var input = $scope.txid;

								$http.get(
										'getTransactionByidRest/' + input
												+ '.do').success(
										function(data) {
											/* $location.path('/transaction'); */
										});
							};
							$scope.getBytxid = function() {
								$('#div2 .data-service-msg').slideUp();
								var stop = $interval(
										function() {
											getTransferByIdService
													.getTransfer($scope.txid)
													.then(
															function(data) {
																console
																		.log(data);
																$scope.txidInfo = "正在投票中";
																$(
																		'#div2 .data-service-return pre')
																		.slideDown()
																if (data.id) {
																	$scope.txidInfo = angular
																			.toJson(data.transaction.data.payload);
																	$interval
																			.cancel(stop);
																}
																;
															});
										}, 1000);
							}

						} ])
		.controller(
				'newHomeController',
				[
						'$scope',
						'$rootScope',
						'$http',
						'$location',
						'$window',
						'$interval',
						'$anchorScroll',
						'$cookies',
						'$cookieStore',
						'$timeout',
						function($scope, $rootScope, $http, $location, $window,
								$interval, $anchorScroll, $cookies,
								$cookieStore, $timeout) {

							$rootScope.user = $cookieStore.get('User');
							$rootScope.type = $cookieStore.get('Type');
							/* console.log($rootScope.type); */

							$scope.indexdown = function() {
								$('html,body').animate({
									'scrollTop' : '2000px'
								}, 'fast');
							}
							$('body').scrollspy({
								target : '#header'
							})

							$scope.isActive = false;
							$scope.div1 = function() {
								$location.hash('div2');
								$anchorScroll();
							};
							$scope.div2 = function() {
								$location.hash('div3');
								$anchorScroll();
							};
							/*
							 * $scope.div3 = function(){ $location.hash('div3');
							 * $anchorScroll(); };
							 */
							$scope.div4 = function() {
								$location.hash('div4');
								$anchorScroll();
							};
							$scope.div5 = function() {
								$location.hash('div5');
								$anchorScroll();
							};
							$scope.div6 = function() {
								$location.hash('div6');
								$anchorScroll();
							};
							$scope.div7 = function() {
								$location.hash('div7');
								$anchorScroll();
							};
							$scope.div8 = function() {
								$location.hash('div8');
								$anchorScroll();
							};
							$scope.div9 = function() {
								$location.hash('div9');
								$anchorScroll();
							};
							$scope.div10 = function() {
								$location.hash('div10');
								$anchorScroll();
							};
							var userName = $cookieStore.get("userName");
							if (userName) {
								$rootScope.userName = userName;// 用户名
							}

							var noderName = $cookieStore.get("noderName");
							if (noderName) {
								$rootScope.noderName = noderName;// 节点用户名
								$rootScope.noderType = $cookieStore
										.get("noderType");// 节点用户类型 销售 3 生产商 0
								// 原材料 1 物流 2
							}

							var bcAdmName = $cookieStore.get("bcAdmName");
							$rootScope.bcAdmName = bcAdmName;// 区块链用户名
							
							
							
							
							
							
						} ])

		.controller(
				'rotateImgController',
				[
						'$scope',
						'$rootScope',
						'$http',
						'$location',
						'$window',
						'$interval',
						'$anchorScroll',
						function($scope) {
							var r = r || 0;
							var element = document.getElementById("rotateImg");

							$scope.mouseOver = function() {
								r = r || 0;
								if ($(window).width() > 992) {
									element.style.MozTransform = " scale(1.30,1.30)";
									element.style.webkitTransform = " scale(1.30,1.30)";
									element.style.msTransform = " scale(1.30,1.30)";
									element.style.OTransform = " scale(1.30,1.30)";
									element.style.transform = " scale(1.30,1.30)";
								}
							}

							$scope.mouseUp = function() {
								r = r + 72;
								if ($(window).width() > 992) {
									element.style.MozTransform = "rotate(" + r
											+ "deg)" + " scale(1.30,1.30)";
									element.style.webkitTransform = "rotate("
											+ r + "deg)" + " scale(1.30,1.30)";
									element.style.msTransform = "rotate(" + r
											+ "deg)" + " scale(1.30,1.30)";
									element.style.OTransform = "rotate(" + r
											+ "deg)" + " scale(1.30,1.30)";
									element.style.transform = "rotate(" + r
											+ "deg)" + " scale(1.30,1.30)";
								} else {
									element.style.MozTransform = "rotate(" + r
											+ "deg)";
									element.style.webkitTransform = "rotate("
											+ r + "deg)";
									element.style.msTransform = "rotate(" + r
											+ "deg)";
									element.style.OTransform = "rotate(" + r
											+ "deg)";
									element.style.transform = "rotate(" + r
											+ "deg)";
								}
								console.log("==>" + r + "\n");
							}

							$scope.mouseLeave = function() {
								element.style.MozTransform = " scale(1.0,1.0)";
								element.style.webkitTransform = " scale(1.0,1.0)";
								element.style.msTransform = " scale(1.0,1.0)";
								element.style.OTransform = " scale(1.0,1.0)";
								element.style.transform = " scale(1.0,1.0)";
								r = r || 0;
							}

						} ])
		.controller(
				'IndexTransactionInfoController',
				[
						'$scope',
						'$rootScope',
						'$http',
						'$location',
						'$routeParams',
						function($scope, $rootScope, $http, $location,
								$routeParams) {
							function unUnicode(str) {
								return unescape(str.replace(/\\u/g, "%u"));
							}
							;
							var id = $routeParams.id;
							$http
									.get('getTransactionByidRest/' + id + '.do')
									.success(
											function(data) {
												$scope.blocknumnber = 11111;
												$scope.txid = id;
												$scope.content = data.transaction.data.payload.content;
											});
						} ])
		.controller(
				'ApiCtrl',
				function($scope, $location, $anchorScroll) {
					$scope.section1 = function() {
						$location.hash('section1');
						$anchorScroll();
					};
					$scope.section2 = function() {
						$location.hash('section2');
						$anchorScroll();
					};
					$scope.section3 = function() {
						$location.hash('section3');
						$anchorScroll();
					};
					$scope.section4 = function() {
						$location.hash('section4');
						$anchorScroll();
					};
					$scope.section5 = function() {
						$location.hash('section5');
						$anchorScroll();
					};
					$scope.section6 = function() {
						$location.hash('section6');
						$anchorScroll();
					};
					$scope.section7 = function() {
						$location.hash('section7');
						$anchorScroll();
					};
					$scope.section8 = function() {
						$location.hash('section8');
						$anchorScroll();
					};
					$scope.section9 = function() {
						$location.hash('section9');
						$anchorScroll();
					}
					$scope.section10 = function() {
						$location.hash('section10');
						$anchorScroll();
					}
					$(window).scroll(
							function() {
								$scope.scroll = $(window).scrollTop();
								$scope.$apply();
								if ($scope.scroll >= 0 && $scope.scroll < 285) {
									$('.apiWrap li').eq(0).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 285
										&& $scope.scroll < 590) {
									$('.apiWrap li').eq(1).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 590
										&& $scope.scroll < 895) {
									$('.apiWrap li').eq(2).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 895
										&& $scope.scroll < 1200) {
									$('.apiWrap li').eq(3).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 1200
										&& $scope.scroll < 1505) {
									$('.apiWrap li').eq(4).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 1505
										&& $scope.scroll < 1810) {
									$('.apiWrap li').eq(5).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 1810
										&& $scope.scroll < 2137) {
									$('.apiWrap li').eq(6).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 2137
										&& $scope.scroll < 2465) {
									$('.apiWrap li').eq(7).addClass('active')
											.siblings().removeClass('active');
								} else if ($scope.scroll >= 2465
										&& $scope.scroll < 2665) {
									$('.apiWrap li').eq(8).addClass('active')
											.siblings().removeClass('active');
								} else {
									$('.apiWrap li').eq(9).addClass('active')
											.siblings().removeClass('active');
								}
								/*
								 * if($scope.scroll>=96){ $('.apiWrap
								 * ul').css('top','90px'); }else{ $('.apiWrap
								 * ul').css('top','180px'); }
								 */
							})
				})
		.controller(
				'LoginController',
				[
						'$scope',
						'$rootScope',
						'$location',
						'$window',
						'$cookies',
						'$cookieStore',
						'loginServices',
						function($scope, $rootScope, $location, $window,
								$cookies, $cookieStore, loginServices) {
							// 首页登陆控制器，四种登陆角色 开发者、节点用户、区块链管理员、超级管理员
							// 用来存放发送、接受的用户信息

							$scope.adminLogin = function() {
								loginServices.login('adminLogin',
										$scope.postUser).then(
										function(data) {
											console.log($scope.postUser);
											console.log(data);
											// if($scope.postUser.referrerKey!=data.referrerKey){
											// Showbo.Msg.alert("您的秘钥或密码有错！");
											// }
											// 将用户登陆信息放入Cookies中并设置时间
											$cookieStore.put("User", data, {
												'expires' : new Date(new Date()
														.getTime() + 5000)
											});
											$cookieStore.put("Type", 4, {
												'expires' : new Date(new Date()
														.getTime() + 5000)
											});

											$location.path('/home');
										});
							};
							$scope.bcaLogin = function() {
								loginServices.login('blockChainAdminLogin',
										$scope.postUser).then(
										function(data) {
											console.log($scope.postUser);
											console.log(data);
											// if($scope.postUser.referrerKey!=data.referrerKey){
											// Showbo.Msg.alert("您的秘钥或密码有错！");
											// }
											// 将用户登陆信息放入Cookies中并设置时间
											$cookieStore.put("User", data, {
												'expires' : new Date(new Date()
														.getTime() + 5000)
											});
											$cookieStore.put("Type", 3, {
												'expires' : new Date(new Date()
														.getTime() + 5000)
											});
											$location.path('/home');
										});
							};
							$scope.devLogin = function() {
								loginServices
										.login('xxxxx', $scope.postUser)
										.then(
												function(data) {
													console
															.log($scope.postUser);
													console.log(data);
													// if($scope.postUser.referrerKey!=data.referrerKey){
													// Showbo.Msg.alert("您的秘钥或密码有错！");
													// }
													// 将用户登陆信息放入Cookies中并设置时间
													$cookieStore
															.put(
																	"User",
																	data,
																	{
																		'expires' : new Date(
																				new Date()
																						.getTime() + 5000)
																	});
													$cookieStore
															.put(
																	"Type",
																	2,
																	{
																		'expires' : new Date(
																				new Date()
																						.getTime() + 5000)
																	});
													$location.path('/home');
												});
							};
							$scope.devRegiste=function () {
		loginServices.registe('dev/registe',$scope.postUser).then(function(data) {
			console.log(data);
		});
	}

							$scope.noderLogin = function() {
								loginServices
										.login('xxxxx', $scope.postUser)
										.then(
												function(data) {
													console
															.log($scope.postUser);
													console.log(data);
													// if($scope.postUser.referrerKey!=data.referrerKey){
													// Showbo.Msg.alert("您的秘钥或密码有错！");
													// }
													// 将用户登陆信息放入Cookies中并设置时间
													$cookieStore
															.put(
																	"User",
																	data,
																	{
																		'expires' : new Date(
																				new Date()
																						.getTime() + 5000)
																	});
													$cookieStore
															.put(
																	"Type",
																	1,
																	{
																		'expires' : new Date(
																				new Date()
																						.getTime() + 5000)
																	});
													$location.path('/home');
												});
							};

							$scope.logout = function() {
								$cookieStore.remove('User');
								$rootScope.user = {};
								$location.path('/home');
							}
						} ])