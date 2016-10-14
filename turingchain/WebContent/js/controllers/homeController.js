angular.module('HomeController',['myDirectives','myFilters'])
.controller('CarouselDemoCtrl', function ($scope) {   //林柯
    $scope.myInterval = 5000;
    $scope.noWrapSlides = false;
    var slides = $scope.slides = [];
    $scope.addSlide = function () {
        var newWidth = 60 + slides.length + 1;
        slides.push({
            image: './images/providerChartBasedBlockChain.JPG',
            text: '',
        });
        slides.push({
            image: './images/providerChartBasedBlockChain2.JPG',
            text: '',
        });
    };
    $scope.addSlide();
})
.controller('homeController',['$scope','$rootScope','$http','$location','$window','$interval','$cookies','$cookieStore',
      function($scope , $rootScope , $http , $location ,$window ,$interval,$cookies ,$cookieStore){
	//WEBSERVICE 方式获取首页block列表
//	$http.get('getListBlock.do')
//    .success(function(data){
//    	$scope.blocks = data;
////    	console.log(data);
//        });
//WEBSERVICE 方式获取首页Transaction列表
//	$http.get('getListTx.do')
//    .success(function(data){
//    	$scope.trans = data;
////    	console.log(data);
//        });
	$http.get('getListBlockRest.do')
    .success(function(data){
    	$scope.indexBlocks = data;
     });
	$http.get('getListTransRest.do')
    .success(function(data){
    	$scope.indexTrans = data;
     });
	//点击查询
	$interval(function(){
		$scope.showtableitems0();
		$scope.showtableitems1();
		
	},300000)
	$scope.showtableitems0=function(){
		var _PageWidth = $('#mytable1').outerWidth();
		var _LoadingLeft = _PageWidth > 215 ? (_PageWidth - 215) / 2 : 0;
		var $div=$('<div>正在查询请稍等。</div>');
		$div.css({'border-radius':'5px','box-shadow':'5px 5px 20px 5px rgba(255,255,255,.2)','width':'215px',"height":'61px','position':'absolute','top': '100px','left':_LoadingLeft+'px','curosr':'wait','color':'#fff','font-size':'20px','background':'url(images/5-130H2191323.gif) 10px center no-repeat','padding-left':'50px','line-height':'61px'});
		$('#mytable1').append($div);
		$http.get('getListBlockRest.do')
	     .success(function(data){
	       	$div.remove();
	        $scope.indexBlocks = data;
	     });
	};
	$scope.showtableitems1=function(){
		var _PageWidth = $('#mytable2').outerWidth();
		var _LoadingLeft = _PageWidth > 215 ? (_PageWidth - 215) / 2 : 0;
		var $div=$('<div>正在查询请稍等。</div>');
		$div.css({'border-radius':'5px','box-shadow':'5px 5px 40px 5px rgba(255,255,255,.2)','width':'215px',"height":'61px','position':'absolute','top': '100px','left':_LoadingLeft+'px','curosr':'wait','color':'#fff','font-size':'20px','background':'url(images/5-130H2191323.gif) 10px center no-repeat','padding-left':'50px','line-height':'61px'});
		$('#mytable2').append($div);
		$http.get('getListTransRest.do')
        .success(function(data){
        	$div.remove();
        	$scope.indexTrans = data;
        	console.log(data);
         });
	};
		
	
	
	
		if($rootScope.bcAdmName!=null && $rootScope.bcAdmName!=""){
			$scope.nodeDeploy="bcaPages/bcaIndex.jsp";
		}
		$scope.nodeDeployChina = function(){
			bcAdmName = $cookieStore.get("bcAdmName");
			if($rootScope.bcAdmName==null || $rootScope.bcAdmName==""){
				Showbo.Msg.alert("您未登陆或者未获查看权限！");
			}
		}
	
		$scope.load = function (){//林柯
			$(window).scrollTop="0px";
//			if($(window).height() < $(window).width()){
//				document.getElementsByName("homePic")[0].style.height=0.92 * $(window).height()-120 + "px";
//				document.getElementsByName("homePic")[1].style.height=0.92 * $(window).scrollHeight()-120 + "px";
//				document.getElementsByName("homePic")[2].style.height=0.92 * $(window).scrollHeight()-120 + "px";
//			}
//			
//			document.getElementsByName("home")[0].style.fontSize=0.014 * $(window).height() + "px";
//			document.getElementsByName("table")[0].style.paddingTop=0.0099 * $(window).height() + "px";
//			document.getElementsByName("table")[1].style.paddingTop=0.0099 * $(window).height() + "px";
//			document.getElementsByName("div")[0].style.paddingBottom=0.0099 * $(window).height() + "px";
//			
//			document.getElementsByName("title")[0].style.fontSize=0.0255623721881391 * $(window).height() + "px";
//			document.getElementsByName("title")[1].style.fontSize=0.0255623721881391 * $(window).height() + "px";
			
	    }
    
		$(document).ready(function(){
			$(window).resize(function() {
//				if($(window).height() < $(window).width()){
//					document.getElementsByName("homePic")[0].style.height=0.92 * $(window).height()-120 + "px";
//					document.getElementsByName("homePic")[1].style.height=0.92 * $(window).height()-120 + "px";
//					document.getElementsByName("homePic")[2].style.height=0.92 * $(window).height()-120 + "px";
//				}
//					
//				document.getElementsByName("home")[0].style.fontSize=0.014 * $(window).height() + "px";
//				document.getElementsByName("table")[0].style.paddingTop=0.0099 * $(window).height() + "px";
//				document.getElementsByName("table")[1].style.paddingTop=0.0099 * $(window).height() + "px";
//				document.getElementsByName("div")[0].style.paddingBottom=0.0099 * $(window).height() + "px";
//				
//				document.getElementsByName("title")[0].style.fontSize=0.0255623721881391 * $(window).height() + "px";
//				document.getElementsByName("title")[1].style.fontSize=0.0255623721881391 * $(window).height() + "px";
					
			});
		});
		
		$scope.queryBlock = function() {
			   
			var input = $scope.input;
			
			
			if(angular.element(document.querySelector('#input')).val().length != 64 || angular.element(document.querySelector('#input')).val().length != 64){
				$http.get('getBlockByHeightRest/'+ input +'.do')
		        .success(function(data){
		        	$rootScope.blockinfo = data
		    	   $location.path('/block');
		        });
			}else {
				$http.get('getTransactionByidRest/'+ input +'.do')
		        .success(function(data){
		        	if(data.transaction.data.payload == null){
		        		Showbo.Msg.alert("请输入正确的交易Id号!");	   
		                $location.path('/home');
	        	}else if(data.transaction.data.payload.content!=null){
		        		$rootScope.blockContent=data.transaction.data.payload;
		                $location.path('/blockContent');
		        	} else{
		        		$rootScope.transs = data
		        		console.log(data);
		        		$location.path('/transaction');
		        	}
		        });
			}
			
//			if(angular.element(document.querySelector('#input')).val().length != 64){
//				$http.get('getBlockByHeightRest/'+ input +'.do')
//		        .success(function(data){
//		        	$rootScope.blockinfo = data
//		    	   $location.path('/block');
//		        });
//			}else {
//				$http.get('getTransactionByidRest/'+ input +'.do')
//		        .success(function(data){
//		        	if(data.transaction.data.payload == null){
//		        		Showbo.Msg.alert("请输入正确的交易Id号!");	   
//		                $location.path('/home');
//		        	}else if(data.transaction.data.payload.where.original.nation == null || data.transaction.data.payload.who.original.company_id == null){
//		        		Showbo.Msg.alert("您输入的交易Id为 Create TransactionId！");	   
//		                $location.path('/home');
//		        	}else{
//		        		$rootScope.transs = data
//		        		console.log(data);
//		        		$location.path('/transaction');
//		        	}
//		        });
//			}
	    }
		//搜索框 enter按键 搜索
		$scope.myKeydown = function(e){
            var keycode = window.event?e.keyCode:e.which;
            if(keycode==13){
                $scope.queryBlock();
            }
        };
		
		
		
		$scope.queryBlockInfoRest=function(height){
			$http.get('getBlockByHeightRest/'+ height +'.do')
			.success(function(data){
				console.log(data);
	 			$rootScope.blockinfo = data;
	 			console.log('==========');
	 			console.log($rootScope.blockinfo);
	 			 $location.path('/block');
			 });
			};
		
		
		
			
//		$scope.queryTxInfo = function(Id) {
//			$http.get('getTxById/'+ Id +'.do')
//	        .success(function(data){
//	        	$rootScope.transs = data
//	    	   $location.path('/transaction');
//	        });
//		}
		$scope.queryTxInfoRest = function(Id) {
			console.log(Id)
			$http.get('getTransactionByidRest/'+ Id +'.do')
	        .success(function(data){
	        	$rootScope.transs = data
	        	console.log(data);
	    	   $location.path('/transaction');
	        });
		}
		
		
		
//		Restful 风格的开始================================================================================================
	
//		$http.get("getKeyPairRest.do").success(function(data){
//			console.log(data);
//		}).error(function(data,header,config,status){
//			console.log(data);
//		});
		
		//Rest方式获取首页 区块  和 交易
//		$http.get("getLastBlockRest.do").success(function(data){
//			console.log(data);
//		}).error(function(data,header,config,status){
//			console.log(data);
//		});
		
//**************************************************************wyc 8.2
//		$http.get("getListBlockRest.do").success(function(data){  
////			console.log('1111111111');
//			$scope.indexBlocks = data;
////			console.log(data);
//		}).error(function(data,header,config,status){
//			console.log(data);
//		});
//		
//		$http.get("getListTransRest.do").success(function(data){
////			console.log('222222222');
//			$scope.indexTrans = data;
////			console.log(data);
//		}).error(function(data,header,config,status){
//			console.log(data);
//		});
//		
		
		
		
		
	/*	var timer = $interval(function(){
			$http.get('getListBlock.do')
	        .success(function(data){
	        	$scope.blocks = data;
	        	console.log(data);
		        });
			
			$http.get('getListTx.do')
		    .success(function(data){
		    	$scope.trans = data;
		    	console.log(data);
		        });
			
		},60000,10);*/

		
//		$http({
//		      method: 'GET',
//		      url: 'http://114.55.147.2:8000/rest/key-pair/',
//		      headers: {
//		    	  authorization : "Basic " + btoa(username + ":" + password)
//		      }
//		    }).success(function(data111){
//				console.log('========================');
//				$scope.restBlocks=data111;
//				console.log($scope.restBlocks);
//			}).error(function(data111,header,config,status){
//				
//				console.log(data111);
//			});
	
		
  }])

  .controller('newNodeApplyController',['$scope','$rootScope','$http','$location','$window',
    function($scope , $rootScope , $http , $location,$window){
	
	$scope.addNewNodeApply = function(){
		$scope.newNodeApply.nodeIPRegion = $scope.selectedDistrict.name + $scope.selectedUnit.name
	     	+ $scope.selectedPosition.name;
		$scope.newNodeApply.userNameID=$rootScope.noderName;
		$scope.newNodeApply.state="未审核";
		$http.post('nodeApplyBlock.do',$scope.newNodeApply)
		.success(function(data){
			console.info(data.msg); 
   			Showbo.Msg.alert("新申请节点  " + $scope.newNodeApply.userNameID +" 信息已经发送!");
   			$location.path('/home');
		})
	};
	
	$http.get("json/city.json").success(function(data){
		var jsonString = angular.toJson(data);
		
		$scope.districts = angular.fromJson(jsonString);
		console.log($scope.districts);
	});

	$scope.currentDate = new Date();
 	$scope.open1 = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
 		$event.preventDefault();
 		$event.stopPropagation();
 		$scope.registerDateOpened = true;
 	} 
 	$scope.open2 = function($event){  	// 创建open方法 。 下面默认行为并将opened 设为true
 		$event.preventDefault();
 		$event.stopPropagation();
 		$scope.nodeCreaTimeOpened = true;
 	}
 	$scope.disabled = function(date , mode){ 
 		return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6));
 	}
 	$scope.dateOptions = {
 		formatYear : 'yy',
 		startingDay : 1
 	};

}])
  
.controller('newNodeApplyRecordController',['$scope','$rootScope','$http','$location',
    function($scope,$rootScope, $http, $location) {
	var userNameID=$rootScope.noderName;
	$http.get('listAllNewNodeApplyByKey/'+ userNameID +'.do')
    .success(function(data){
    	$scope.newNodeApplys = data;
    	console.log(data);
    });
}])

.controller('newNodeApplyRecordInfoController',['$scope','$rootScope','$http','$location','$routeParams','$filter','$window',
    function($scope,$rootScope, $http, $location,$routeParams,$filter,$window) {
	
	var userNameID=$routeParams.userNameID;
	var nodeID=$routeParams.nodeID;
	$http.get('getNodeApplyBlockInfoByKey2/'+ userNameID + '/' + nodeID +'.do')
	.success(function(data){
		$scope.newNodeApplyInfo = data;
		$scope.newNodeApplyInfo.registerDate=$filter('date')(data.registerDate,'yyyy-MM-dd');
		$scope.newNodeApplyInfo.nodeCreaTime=$filter('date')(data.nodeCreaTime,'yyyy-MM-dd');
		if(data.nodeType==1){
			$scope.newNodeApplyInfo.nodeType="主验证节点";
		}else if(data.nodeType==2){
			$scope.newNodeApplyInfo.nodeType="从辅助节点";
		}
		console.log("======>" + data);
	});
	
	$scope.close = function(){
		$(window).scrollTop="0px";
		$location.path('/newNodeApplyRecord');
	}
}])

.controller('BlockInfoController',['$scope','$rootScope','$http','$location',
    function($scope,$rootScope, $http, $location) {
		
		$scope.blockinfo=$rootScope.blockinfo;
		var height=$scope.blockinfo.block_number;
		
		$scope.blockContent=function(hash){
			console.log(height);
			console.log(hash);
			$http.get("getBlockContent/"+height+"/"+hash+".do").success(function(data){
				$rootScope.blockContent=data;
				console.log($rootScope.blockContent);
				$location.path("/blockContent");
''			});
			
		};
		
		
//		$scope.blockNumber = $rootScope.block.blockNumber.value;
//		$scope.hashId = $rootScope.block.id.value;
//		$scope.votes = $rootScope.block.votes.value.vote;
//		$scope.nodePubKey = $rootScope.block.block.value.nodePubkey.value;
//		$scope.transactions = $rootScope.block.block.value.transactions.value.transaction;
//		$scope.timestamp = $rootScope.block.block.value.timestamp.value + "000";
		
//		$scope.blockNumber = $rootScope.block.block_number;
//		$scope.hashId = $rootScope.block_id;
//		$scope.votes = $rootScope.block.votes.value.vote;
//		$scope.nodePubKey = $rootScope.block.block.value.nodePubkey.value;
//		$scope.transactions = $rootScope.block.block.value.transactions.value.transaction;
//		$scope.timestamp = $rootScope.block.block.value.timestamp.value + "000";
		
}]).controller('BlockContentController',['$scope','$rootScope','$http','$location',
                                         function($scope,$rootScope, $http, $location){
	//获得blockContent的json
	var json=$rootScope.blockContent;
//	var str=JSON.stringify($rootScope.blockContent);
	var str1=syntaxHighlight($rootScope.blockContent)
//	$scope.blockContent=str;
	$scope.blockContent1=str1;
//	console.log(str1);
}]).controller('TransactionInfoController',['$scope','$rootScope','$http','$location',
	function($scope,$rootScope, $http, $location) {
	function unUnicode(str){
		return unescape(str.replace(/\\u/g, "%u"));
	};
//	console.log($rootScope.transs);
	var listTransfer =$rootScope.transs.transaction;
	console.log(listTransfer);
//	for(var p in listTransfer){//遍历json对象的每个key/value对,p为key
		$scope.originaler=unUnicode(listTransfer.data.payload.bill.Bill_operator_name);
		$scope.receiver=unUnicode(listTransfer.data.payload.bill.Bill_receiver_name);
		$scope.discountinger=unUnicode(listTransfer.data.payload.bill.Guarantee_organization_name);
		$scope.billNumber=listTransfer.data.payload.bill.Bill_id;
		$scope.moneySum=listTransfer.data.payload.bill.Bill_amount_money;
		$scope.expireDate=listTransfer.data.payload.bill.Bill_outdate;
//	}
//	$scope.receiver =unUnicode($rootScope.transs.transaction.data.payload.bill.Bill_operator_name);
//	$scope.discountinger=unUnicode($rootScope.transs.transaction.data.payload.bill.Guarantee_organization_name);
//	$scope.billNumber=unUnicode($rootScope.transs.transaction.data.payload.bill.Bill_id);
//	$scope.moneySum=unUnicode($rootScope.transs.transaction.data.payload.bill.Bill_amount_money);
//	$scope.expireDate=unUnicode($rootScope.transs.transaction.data.payload.bill.Bill_outdate);
	//unicode 转汉字

	//unicode解码
	
		//首页测试模块进入图灵浏览器
}]).controller('IndexTransactionInfoController',['$scope','$rootScope','$http','$location','$routeParams',
                                     function($scope,$rootScope, $http, $location ,$routeParams) {
	function unUnicode(str){
		return unescape(str.replace(/\\u/g, "%u"));
	};
	var id = $routeParams.id;
	$http.get('getTransactionByidRest/'+ id +'.do').success(function(data){
		$scope.billNumber=data.transaction.data.payload.bill.Bill_amount_money;
	});
}])	
.controller('MoreBlockInfoController', ['$scope','$http','$location','$rootScope','$routeParams',function($scope,$http,$location,$rootScope,$routeParams) {
	console.log(currentPage);
	$scope.currentPage=$routeParams.currentPage;        //默认显示第一页
	$scope.listNumPerPage=20;    //默认每页显示10个
	
		var currentPage = $scope.currentPage; 
		var listNumPerPage = $scope.listNumPerPage; 
		$http.get('queryBlocksRest/' + currentPage + '/' + listNumPerPage + '.do')
			.success(function(data) {
				//将page对象放进scope
				$scope.page = data;
				//所有的页面数
				var totalPage=new Array();
				for(var i=1;i<=data.totalPages;i++){
					totalPage.push(i);
				}
				console.log(totalPage);
				//前台遍历select
				$rootScope.totalPagesAll=totalPage;
			});

		$scope.change=function(page){
			
		}
		
		$scope.queryBlockInfoRest=function(height){
			$http.get('getBlockByHeightRest/'+ height +'.do')
			.success(function(data){
				console.log(data);
	 			$rootScope.blockinfo = data;
	 			console.log('==========');
	 			console.log($rootScope.blockinfo);
	 			 $location.path('/block');
			 });
			};
}]).controller('traceController',['$scope','$http','$location',function($scope,$http,$location){

	$scope.trace=function(){
		var tid = $scope.tid;
		console.log(tid);
		//if(angular.element(document.querySelector('#tid')).val().length == 64){
		$http.get('getAllTrace/'+tid+'.do')
		.success(function(data){
			console.log(data);
			$scope.allTraces=data;
			$location.path('/trace');
		});
	};
	
}]);


function syntaxHighlight(json) {
if (typeof json != 'string') {
json = JSON.stringify(json, undefined, 2);
}
json = json.replace(/&/g, '&').replace(/</g, '<').replace(/>/g, '>');
return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
var cls = 'number';
if (/^"/.test(match)) {
if (/:$/.test(match)) {
cls = 'key';
} else {
cls = 'string';
}
} else if (/true|false/.test(match)) {
cls = 'boolean';
} else if (/null/.test(match)) {
cls = 'null';
}
return match ;
});
}
