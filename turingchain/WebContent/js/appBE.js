angular.module('myAppBE',[
    'ngRoute','ngAnimate','ui.bootstrap', 'BlockChainAdminController','HomeController',
    'controllers', 'myFilters','ngCookies',
    'myServices', 'myDirectives','ngMessages' ])

   .config(function($routeProvider){
    $routeProvider.when('/home',{
	   templateUrl:'tpls/home.html',
	   controller:'homeController'
    })
    .when('/moreBlockInfo/:currentPage',{
    	templateUrl: 'tpls/moreBlockInfo.html',
    	controller: 'MoreBlockInfoController'
    })
    .when('/block',{
       templateUrl:'tpls/blockInfo.html',
       controller:'BlockInfoController'
    }).when('/transaction',{
        templateUrl:'tpls/bill_transaction.html',
        controller:'TransactionInfoController'
     })
     .when('/transaction/:id',{
        templateUrl:'tpls/bill_transaction.html',
        controller:'IndexTransactionInfoController'
     }).when('/blockContent',{
         templateUrl:'tpls/blockContent.html',
         controller:'BlockContentController'
      })
    .otherwise({
       redirectTo:'/home',
       controller:'BlockChianController'
    })
})