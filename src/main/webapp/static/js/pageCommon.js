/**
 * @author sunyu
 * 初始化设置时间公共js
 *
 */

//
var date = new Date();
var nowMs = date.getTime();
var sevenDays = nowMs - 5184e5;//前第六天
var startTime0 = $.formatDate("yyyy-MM-dd",sevenDays);
var endTime0 =  $.formatDate("yyyy-MM-dd",nowMs);
//设置默认时间
var $startTime = $("#startTime");
var $endTime = $("#endTime");
$startTime.val(startTime0);
$endTime.val(endTime0);
function setDefaultTime(){

}
//时间选项添加事件监听
$("#quickSelect").on('change',function(){
    var value = $(this).val();
    if(value==1){
        //昨天
        var yesterday = nowMs-864e5;
        var startTime = $.formatDate("yyyy-MM-dd",yesterday);
        $startTime.val(startTime);
        $endTime.val(startTime);
    }else if(value==2){
        //近七天
        var sevenDays = nowMs - 5184e5;//前第六天
        var startTime = $.formatDate("yyyy-MM-dd",sevenDays);
        var endTime =  $.formatDate("yyyy-MM-dd",nowMs);
        $startTime.val(startTime);
        $endTime.val(endTime);
    }else  if(value ==3){
        var startTime = $.boco.getFirstDayOfCurrentWeek(nowMs);
        startTime = $.formatDate("yyyy-MM-dd",startTime);
        var endTime =  $.formatDate("yyyy-MM-dd",nowMs);
        $startTime.val(startTime);
        $endTime.val(endTime);
        //本周
    }else if(value ==4){
        //上周
        var startTime = $.boco.getFistDayOfLastWeek(nowMs);
        var endTime = startTime + 5184e5;
        startTime = $.formatDate("yyyy-MM-dd",startTime);
        endTime =  $.formatDate("yyyy-MM-dd",endTime);
        $startTime.val(startTime);
        $endTime.val(endTime);
    }else if(value == 5){
        //本月
        var startTime = $.boco.getFirstDayOfCurrentMonth(nowMs);
        startTime = $.formatDate("yyyy-MM-dd",startTime);
        var endTime =  $.formatDate("yyyy-MM-dd",nowMs);
        $startTime.val(startTime);
        $endTime.val(endTime);
    }else if(value == 6){
        //上月
        var startTime = $.boco.getFistDayOfLastMonth(nowMs);
        startTime = $.formatDate("yyyy-MM-dd",startTime);
        var endTime = $.boco.getFirstDayOfCurrentMonth(nowMs);
        endTime = $.formatDate("yyyy-MM-dd",(endTime-864e5));

        $startTime.val(startTime);
        $endTime.val(endTime);
    }
})
