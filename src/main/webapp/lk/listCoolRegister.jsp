<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/four.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="../css/jqe/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../css/jqe/themes/icon.css" />

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" >

   //进入jq
   $(function(){
	   
	   //初始化jq-easyUI对话框
	   $("#dlg,dlg2").window({onBeforeClose:function(){
		   setTimeout(function(){
			   sending.style.visibility="hidden";
		   },200);
	   }});
	   
	   //监听
	   $(".btnAll").click(function(){
		   
		   if( $(this).html()=="【新增】" ){
			   $("#dlg").window("open");
		   }else  if( $(this).html()=="【删除】" ){
			  //ajax
			  var btn = $(this);
			  if(confirm("确认删除?")){
				  $.get("delCool.do?cool_id="+$(this).prop("lang"),function(rtnMsg){
					  alert(rtnMsg);
					  //删除当前行
					  if("删除成功"==rtnMsg){
						        //td        //tr
						  $(btn).parent().parent().remove();
					  }
				  });
			  }
		   }else  if( $(this).html()=="【编辑】" ){
				 $.get("oneCool.do?cool_id="+$(this).prop("lang"),function(json){
					 if(json){
						 console.log(json);
						 $("#dlg2 input[name='CABINETNO']").val(json.cabinetno);
						 $("#dlg2 input[name='CUSTOMERNAME']").val(json.customername);
						 $("#dlg2 input[name='FRUITCATEGERY']").val(json.fruitcategery);
						 $("#dlg2 input[name='BEGINTIME']").val(json.begintime);
						 $("#dlg2 input[name='ENDTIME']").val(json.endtime);
						 $("#dlg2 input[name='TEMPRATURE']").val(json.temprature);
						 $("#dlg2 input[name='CABINETLOC']").val(json.cabinetloc);
						 $("#dlg2 input[name='OPERATER']").val(json.operater);
						 $("#dlg2 input[name='MOBILE']").val(json.mobile);
						 $("#dlg2 input[name='REMARK']").val(json.remark);
						 $("#dlg2 input[name='REGISTERTIME']").val(json.registertime);
						 $("#dlg2 input[name='COOLTYPE']").val(json.cooltype);
						 $("#dlg2 input[name='MONEY']").val(json.money);
						 $("#dlg2 input[name='STATE']").val(json.state);
						 $("#dlg2 input[name='PAYTYPE']").val(json.paytype);
						 $("#dlg2 input[name='STOPTIME']").val(json.stoptime);
						 $("#dlg2 input[name='PAYDATETIME']").val(json.paydatetime);
						 $("#dlg2 input[name='AREANUM']").val(json.areanum);
						 $("#dlg2 input[name='CARDNUM']").val(json.cardnum);
						 $("#dlg2 input[name='ID']").val(json.id);
						 $("#dlg2").window("open");
					 }else{
						 alert("被编辑的停车场不存在.");
					 }
				 });	
	      }
		   
	   });

   });

</script>

 
</head>
<body>
	<!-- 包含等待框 -->
	<jsp:include page="../waittable.jsp" flush="true" />
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		
		<tr valign="top">
			<td bgcolor="#FFFFFF"><table width="96%" border="0"
					align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
					<div id="cxid" style="padding-top: 10px;padding-bottom: 10px;">
						<form action="likeCool.do" method="post">
							柜号或货主名：<input type="text" name="nameorid"/>&nbsp;&nbsp;<input type="submit" value="查询"/>
						</form>
					</div>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">柜号</td>
						<td align="center" bgcolor="#ebf0f7">货主</td>
						<td align="center" bgcolor="#ebf0f7">水果类别</td>
						<td align="center" bgcolor="#ebf0f7">打冷开始时间</td>
						<td align="center" bgcolor="#ebf0f7">打冷结束时间</td>
						<td align="center" bgcolor="#ebf0f7">设置温度</td>
						<td align="center" bgcolor="#ebf0f7">货柜位置</td>
						<td align="center" bgcolor="#ebf0f7">经办人</td>
						<td align="center" bgcolor="#ebf0f7">联系电话</td>
						<td align="center" bgcolor="#ebf0f7">备注</td>
						<td align="center" bgcolor="#ebf0f7">登记时间</td>
						<td align="center" bgcolor="#ebf0f7">打冷类别</td>
						<td align="center" bgcolor="#ebf0f7">金额</td>
						<td align="center" bgcolor="#ebf0f7">状态</td>
						<td align="center" bgcolor="#ebf0f7">支付类型</td>
						<td align="center" bgcolor="#ebf0f7">结束时间</td>
						<td align="center" bgcolor="#ebf0f7">支付时间</td>
						<td align="center" bgcolor="#ebf0f7">地区编号</td>
						<td align="center" bgcolor="#ebf0f7">卡位编号</td>
						<td align="center" bgcolor="#ebf0f7">操作 <span class="btnAll">【新增】</span>
						</td>
					</tr>
					<c:forEach items="${lsCr}" var="onecool">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${onecool.CABINETNO}</td>
							<td align="center">${onecool.CUSTOMERNAME}</td>
							<td align="center">${onecool.FRUITCATEGERY}</td>
							<td align="center"><fmt:formatDate value="${onecool.BEGINTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center"><fmt:formatDate value="${onecool.ENDTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center">${onecool.TEMPRATURE}</td>
							<td align="center">${onecool.CABINETLOC}</td>
							<td align="center">${onecool.OPERATER}</td>
							<td align="center">${onecool.MOBILE}</td>
							<td align="center">${onecool.REMARK}</td>
							<td align="center"><fmt:formatDate value="${onecool.REGISTERTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								
							<c:choose>
						         <c:when test="${onecool.COOLTYPE==0}">
						             	  <td align="center">付费打冷</td>
						         </c:when>
						         <c:when test="${onecool.COOLTYPE==1}">
						             	  <td align="center">预付打冷</td>
						         </c:when>
						         <c:when test="${onecool.COOLTYPE==2}">
						             	  <td align="center">后付打冷</td>
						         </c:when>
						         <c:otherwise>
					                      <td align="center">补时</td>
						         </c:otherwise>
						     </c:choose>  

							<td align="center">${onecool.MONEY}</td>
							<c:choose>
						         <c:when test="${onecool.STATE==0}">
						             	  <td align="center">登记</td>
						         </c:when>
						         <c:when test="${onecool.STATE==1}">
						             	  <td align="center">已安排打冷</td>
						         </c:when>
						         <c:when test="${onecool.STATE==2}">
						             	  <td align="center">中断</td>
						         </c:when>
						         <c:when test="${onecool.STATE==3}">
						             	  <td align="center">结束打冷</td>
						         </c:when>
						         <c:otherwise>
					                      <td align="center">作废</td>
						         </c:otherwise>
						     </c:choose>  
						     
						     <c:if test="${onecool.PAYTYPE==0}">
						     	<td align="center">未付款</td>
						     </c:if>
						     <c:if test="${onecool.PAYTYPE==1}">
						     	<td align="center">已付款</td>
						     </c:if>
							
							<td align="center"><fmt:formatDate value="${onecool.STOPTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center"><fmt:formatDate value="${onecool.PAYDATETIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center">${onecool.AREANUM}</td>
							<td align="center">${onecool.CARDNUM}</td>
							<td align="center">
									  <span class="btnAll" lang="${onecool.ID}">【编辑】</span>
								    | <span class="btnAll" lang="${onecool.ID}">【删除】</span>
						 
							</td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
		<tr>
			<td align="center" style="color: red">${msg}</td>
		</tr>
	</table>
	
	<div id="dlg" class="easyui-dialog" title="添加仓库" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="addCool.do">
	    <table>
	       <tr><td>柜号</td><td><input name="CABINETNO"/></td></tr>
	       <tr><td>货主</td><td><input name="CUSTOMERNAME"/></td></tr>
	       <tr><td>水果类别</td><td><input name="FRUITCATEGERY"/></td></tr>
	       <tr><td>打冷开始时间</td><td><input name="BEGINTIME" class="easyui-datetimebox" 
	       		data-options="required:true,showSeconds:false" style="width:150px"/></td></tr>
	       <tr><td>打冷结束时间</td><td><input name="ENDTIME" class="easyui-datetimebox" 
	       		data-options="required:true,showSeconds:false" style="width:150px"/></td></tr>
	       <tr><td>设置温度</td><td><input name="TEMPRATURE"/></td></tr>
	       <tr><td>货柜位置</td><td><input name="CABINETLOC"/></td></tr>
	       <tr><td>经办人</td><td><input name="OPERATER"/></td></tr>
	       <tr><td>联系电话</td><td><input name="MOBILE"/></td></tr>
	       <tr><td>备注</td><td><input name="REMARK"/></td></tr>
	       <tr><td>登记时间</td><td><input name="REGISTERTIME" class="easyui-datetimebox" 
	       		data-options="required:true,showSeconds:false" style="width:150px"/></td></tr>
	       <tr><td>打冷类别</td><td><select name="COOLTYPE" id="sltp" style="width:150px;"><option value="0">付费打冷</option><option value="1">预付打冷</option>
	       		<option value="2">后付打冷</option><option value="3">补时</option></select></td></tr>
	       <tr><td>金额</td><td><input name="MONEY"/></td></tr>
	       <tr><td>状态</td><td><select name="STATE" id="slst" style="width:150px;"><option value="0">登记</option><option value="1">已安排打冷</option>
	       		<option value="2">中断</option><option value="3">结束打冷</option><option value="4">作废</option></select></td></tr>
	       <tr><td>支付类型</td><td><select name="PAYTYPE" id="slpay" style="width:150px;"><option value="0">未付款</option>
	       		<option value="1">已付款</option></select></td></tr>
	       <tr><td>结束时间</td><td><input name="STOPTIME" class="easyui-datetimebox" 
	       		data-options="required:true,showSeconds:false" style="width:150px"/></td></tr>
	       <tr><td>支付时间</td><td><input name="PAYDATETIME" class="easyui-datetimebox" 
	       		data-options="required:true,showSeconds:false" style="width:150px"/></td></tr>
	       <tr><td>地区编号</td><td><input name="AREANUM"/></td></tr>
	       <tr><td>卡位编号</td><td><input name="CARDNUM"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="添加"/>  </td></tr>
	    </table>
	    </form>
	</div>
    <div id="dlg2" class="easyui-dialog" title="编辑停车场信息" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="updtCool.do">
	    <table>
	       <tr><td>柜号</td><td><input name="CABINETNO"/><input name="ID" type="hidden"/></td></tr>
	       <tr><td>货主</td><td><input name="CUSTOMERNAME"/></td></tr>
	       <tr><td>水果类别</td><td><input name="FRUITCATEGERY"/></td></tr>
	       <tr><td>打冷开始时间</td><td><input name="BEGINTIME" /></td></tr>
	       <tr><td>打冷结束时间</td><td><input name="ENDTIME" /></td></tr>
	       <tr><td>设置温度</td><td><input name="TEMPRATURE"/></td></tr>
	       <tr><td>货柜位置</td><td><input name="CABINETLOC"/></td></tr>
	       <tr><td>经办人</td><td><input name="OPERATER"/></td></tr>
	       <tr><td>联系电话</td><td><input name="MOBILE"/></td></tr>
	       <tr><td>备注</td><td><input name="REMARK"/></td></tr>
	       <tr><td>登记时间</td><td><input name="REGISTERTIME" /></td></tr>
	       <tr><td>打冷类别</td><td><input name="COOLTYPE"/></td></tr>
	       <tr><td>金额</td><td><input name="MONEY"/></td></tr>
	       <tr><td>状态</td><td><input name="STATE"/></td></tr>
	       <tr><td>支付类型</td><td><input name="PAYTYPE"/></td></tr>
	       <tr><td>结束时间</td><td><input name="STOPTIME"/></td></tr>
	       <tr><td>支付时间</td><td><input name="PAYDATETIME"/></td></tr>
	       <tr><td>地区编号</td><td><input name="AREANUM"/></td></tr>
	       <tr><td>卡位编号</td><td><input name="CARDNUM"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="修改"/>  </td></tr>
	    </table>
	    </form>
	</div>
	
	
	
</body>
</html>