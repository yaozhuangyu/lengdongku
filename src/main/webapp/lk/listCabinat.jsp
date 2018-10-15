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
						 alert("被编辑的停车场不存在.");
					 }
				 });	
	      }
		   
	   });
	   
	   $("#lsArea").change(function() {
			//location.href = "lsLoc.do?loc_id=" + $(this).val();
			if($(this).val() == 0){
				location.href = "lscab.do?loc_id=0" ;
			}
			$("#lsLoc").html("");
			$.get("lsLocByID.do?area_id=" + $(this).val(),function(object){
				console.log(object);
				var tr="<option value='0'>请选择</option>";
				$.each(object,function(i,v){
					tr+="<option value='"+v.id+"'>"+v.cardname+"</option>"
				})
				$(tr).appendTo($("#lsLoc"));
				$("#lsLoc").show();
			})
		});
	   
	   $("#lsLoc").change(function(){
		   location.href = "lscab.do?loc_id="+$(this).val();
	   })
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
					<tr align="left" bgcolor="#F2FDFF">
						<td colspan="6" class="optiontitle">地区
						<select id="lsArea">
						        <option>请选择</option>
								<option value="0">全部</option>
								<c:forEach items="${allArea}" var="onearea">
									<option value="${onearea.ID}">${onearea.AREANAME}</option>
								</c:forEach>
						</select>
						<select id="lsLoc" style="display: none;">
						   
						</select>
						</td>
					</tr>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">编号</td>
						<td align="center" bgcolor="#ebf0f7">位置</td>
						<td align="center" bgcolor="#ebf0f7">名称</td>
						<td align="center" bgcolor="#ebf0f7">容量</td>
						<td align="center" bgcolor="#ebf0f7">状态</td>
						<td align="center" bgcolor="#ebf0f7">操作 <span class="btnAll">【新增】</span>
						</td>
					</tr>
					<c:forEach items="${allcab}" var="onecab">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${onecab.SERIALNO}</td>
							<td align="center">${onecab.LOCATION}</td>
							<td align="center">${onecab.CABINATENAME}</td>
							<td align="center">${onecab.CAPACITY}</td>
							
							<c:if test="${onecab.STATE==0}">
								<td align="center">未满</td>
							</c:if>
							<c:if test="${onecab.STATE==1}">
								<td align="center">已满</td>
							</c:if>
							
							<td align="center">
									  <span class="btnAll" lang="${onecab.ID}">【编辑】</span>
								    | <span class="btnAll" lang="${onecab.ID}">【删除】</span>
						 
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