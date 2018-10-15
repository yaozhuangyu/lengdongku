<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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

<script type="text/javascript">
	//进入jq
	$(function() {

		//初始化jq-easyUI对话框
		$("#dlg").window({
			onBeforeClose : function() {
				setTimeout(function() {
					sending.style.visibility = "hidden";
				}, 200);
			}
		});
		
		$(".cabtype").click(function(){
			if($(this).prop("name") ==  "type0"){
				$(this).attr("src","../images/type1.png");
				$(this).attr("name","type1");
			 $(this).next().attr("name","cab_id");
				var i =$(this).next().prop("name"); 
				console.log(i);
			}
			else{
				$(this).attr("src","../images/type0.png");
				$(this).attr("name","type0");
				$(this).next().attr("name","cab_id0");
				var i =$(this).next().prop("name");
				console.log(i);
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
					<tr align="left" bgcolor="#F2FDFF">
						<td colspan="4" class="optiontitle">卡位管理</td>
					</tr>
					<c:forEach items="${listloc}" var="oneLoc">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="4" class="optiontitle">${oneLoc.CARDNAME}</td>
						</tr>
						<form action="updLoc.do" method="post">
						<input type="hidden" name="loc_id" value="${oneLoc.ID}"/>
						<tr align="left"  bgcolor="#FFFFFF">
							<td colspan="3" >
							      <c:forEach  items="${oneLoc.cabinatsetting}" var="oneCab" varStatus="vs" >
									  <%--   <input type="checkbox" 
							          	    <c:if test="${oneCab.STATE == 1}">
							          	           checked
							          	    </c:if>
									     value="${oneCab.ID}" name="cab_id" />:${oneCab.CABINATENAME} &nbsp;|&nbsp; --%>
									     ${oneCab.CABINATENAME}:
									     <c:if test="${oneCab.STATE == 0}">
									        <img src="../images/type0.png" width="18px" height="18px" name="type0" class="cabtype" />
									      <input name="cab_id0" value="${oneCab.ID}" type="hidden"/> 
									     </c:if>
									     <c:if test="${oneCab.STATE == 1}">
									         <img src="../images/type1.png" width="18px" height="18px" name="type1" class="cabtype"/>
									        <input name="cab_id" value="${oneCab.ID}" type="hidden"/>
									     </c:if>
				                    <c:if test="${vs.count %5 ==0 }">
				                       <br> 
				                    </c:if>
				                     </c:forEach>
				    
				    	   </td>
				    	   <td> <input type="submit" value="修改" /></td>
				    	   
						</tr>
						</form>
					</c:forEach>

				</table></td>
		</tr>

		<tr>
			<td align="center" style="color: red">${msg}</td>
		</tr>
	</table>



</body>
</html>