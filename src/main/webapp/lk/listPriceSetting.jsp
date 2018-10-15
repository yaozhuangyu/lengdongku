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
				  $.get("delcab.do?cab_id="+$(this).prop("lang"),function(rtnMsg){
					  alert(rtnMsg);
					  //删除当前行
					  if("删除成功"==rtnMsg){
						        //td        //tr
						  $(btn).parent().parent().remove();
					  }
				  });
			  }
		   }else  if( $(this).html()=="【编辑】" ){
				 $.get("onecab.do?cab_id="+$(this).prop("lang"),function(json){
					 if(json){
						 console.log(json);
						 $("#dlg2 input[name='SERIALNO']").val(json.serialno);
						 $("#dlg2 input[name='LOCATION']").val(json.location);
						 $("#dlg2 input[name='CABINATENAME']").val(json.cabinatename);
						 $("#dlg2 input[name='CAPACITY']").val(json.capacity);
						 $("#dlg2 input[name='STATE']").val(json.state);
						 $("#dlg2 input[name='ID']").val(json.id);
						 $("#dlg2").window("open");
					 }else{
						 alert("被编辑的东西不存在.");
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
					<!-- <div id="cusid" style="padding-top: 10px;padding-bottom: 10px;padding-left: 30px;">
						<form action="likeCusName.do" method="post">
							顾客：<input type="text" name="cusname"/>&nbsp;&nbsp;<input type="submit" value="查询"/>
						</form>
					</div> -->
					<tr align="left" bgcolor="#F2FDFF">
					</tr>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">区位</td>
						<td align="center" bgcolor="#ebf0f7">卡位</td>
						<td align="center" bgcolor="#ebf0f7">仓库</td>
						<td align="center" bgcolor="#ebf0f7">顾客</td>
						<td align="center" bgcolor="#ebf0f7">货物</td>
						<td align="center" bgcolor="#ebf0f7">单位</td>
						<td align="center" bgcolor="#ebf0f7">单位数</td>
						<td align="center" bgcolor="#ebf0f7">弃用</td>
						<td align="center" bgcolor="#ebf0f7">是否已支付</td>
						<td align="center" bgcolor="#ebf0f7">目标类型</td>
						<td align="center" bgcolor="#ebf0f7">备注</td>
						<td align="center" bgcolor="#ebf0f7">操作 </td>
					</tr>
					<c:forEach items="${lsps}" var="oneps">
						<tr align="center" bgcolor="#FFFFFF">
						<c:forEach items="${oneps.areainfo}" var="onearea">
							<td align="center">${onearea.AREANAME}</td>
						</c:forEach>
						<c:forEach items="${oneps.locationsetting}" var="onelocation">
							<td align="center">${onelocation.CARDNAME}</td>
						</c:forEach>
						<c:forEach items="${oneps.cabinatsetting}" var="onecab">
							<td align="center">${onecab.CABINATENAME}</td>
						</c:forEach>
						<c:forEach items="${oneps.customer}" var="onecus">
							<td align="center">${onecus.CUSTOMERNAME}</td>
						</c:forEach>
						<c:forEach items="${oneps.fruitcategory}" var="onefruit">
							<td align="center">${onefruit.CATENAME}</td>
						</c:forEach>

							<td align="center">${oneps.UNIT}</td>
							<td align="center">${oneps.UNITNUM}</td>
							<td align="center">${oneps.DISCARD}</td>
							<c:if test="${oneps.ISPAY==0}">
								<td align="center">不作为结算单价</td>
							</c:if>
							<c:if test="${oneps.ISPAY==1}">
								<td align="center">作为结算单价</td>
							</c:if>
							<c:choose>
						         <c:when test="${oneps.FLAG==0}">
						             	  <td align="center">全局</td>
						         </c:when>
						         <c:when test="${oneps.FLAG==1}">
						             	  <td align="center">区位</td>
						         </c:when>
						         <c:when test="${oneps.FLAG==2}">
						             	  <td align="center">区位 卡位</td>
						         </c:when>
						         <c:when test="${oneps.FLAG==3}">
						             	  <td align="center">区位 卡位 柜号</td>
						         </c:when>
						         <c:when test="${oneps.FLAG==4}">
						             	  <td align="center">特定水果</td>
						         </c:when>
						         <c:otherwise>
					                      <td align="center">特定档主</td>
						         </c:otherwise>
						     </c:choose>  
							<td align="center">${oneps.REMARK}</td>
							
							<td align="center">
									  <span class="btnAll" lang="${oneps.ID}">【编辑】</span>
								    | <span class="btnAll" lang="${oneps.ID}">【删除】</span>
						 
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
	   <form action="addcab.do">
	    <table>
	       <tr><td>编号</td><td><input name="SERIALNO"/></td></tr>
	       <tr><td>位置</td><td><input name="LOCATION"/></td></tr>
	       <tr><td>名称</td><td><input name="CABINATENAME"/></td></tr>
	       <tr><td>容量</td><td><input name="CAPACITY"/></td></tr>
	       <tr><td>状态</td><td><input name="STATE"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="添加"/>  </td></tr>
	    </table>
	    </form>
	</div>
    <div id="dlg2" class="easyui-dialog" title="编辑仓库信息" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="updtcab.do">
	    <table>
	       <tr><td>编号</td><td><input name="SERIALNO"/><input name="ID" type="hidden"  /></td></tr>
	       <tr><td>位置</td><td><input name="LOCATION"/></td></tr>
	       <tr><td>名称</td><td><input name="CABINATENAME"/></td></tr>
	       <tr><td>容量</td><td><input name="CAPACITY"/></td></tr>
	       <tr><td>状态</td><td><input name="STATE"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="修改"/>  </td></tr>
	    </table>
	    </form>
	</div>
	
	
	
</body>
</html>