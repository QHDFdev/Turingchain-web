$(document).off('click.bs.dropdown.data-api');
//自动展开
$('.nav .dropdown').mouseenter(function(){
 $(this).addClass('open');
});
//自动关闭
$('.nav .dropdown').mouseleave(function(){
 $(this).removeClass('open');
});
function orient() {
    //alert('gete');
    if (window.orientation == 0 || window.orientation == 180) {
        $("body").attr("class", "portrait");
        orientation = 'portrait';
        return false;
    }
    else if (window.orientation == 90 || window.orientation == -90) {
        $("body").attr("class", "landscape");
        orientation = 'landscape';

        return false;
    }
}


$(function(){
    orient();
});


$(window).bind( 'orientationchange', function(e){
    orient();
})
