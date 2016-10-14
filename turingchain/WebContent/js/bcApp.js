angular.module('myBcApp',['ngRoute','ngAnimate','ui.bootstrap'])

.config(function($routeProvider){
	$routeProvider.
    when('/guide', {
      templateUrl: 'bcPages/guide.html',
//      controller: 
    })
    .when('/userInfo',{
    	       templateUrl:'tpls/userInfo.html',
    	       reloadOnSearch: true,
    	       controller:'UserInfoController'
    }).
    when('/sdk', {
        templateUrl: 'bcPages/sdk.html',
//        controller: 
      }).
    when('/contract', {
    	templateUrl: 'bcPages/contract.html',
    	controller:'EditorCtrl'
    }).
    otherwise({
      redirectTo: '/contract'
    })
})

.controller('EditorCtrl',function($scope){
    
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/javascript");
    document.getElementById('editor').style.fontSize='16px';
    //editor.setHighlightActiveLine(false);
})