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
						<td colspan="4" class="optiontitle">权限管理</td>
					</tr>
					<c:forEach items="${role}" var="oneRole">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="4" class="optiontitle">${oneRole.ROLENAME}</td>
						</tr>
						<form action="updRights.do" method="post">
						<input type="hidden" name="roleid" value="${oneRole.ID}"/>
						<tr align="left"  bgcolor="#FFFFFF">
							<td colspan="3" >
							<c:forEach  items="${allRt}" var="oneRt" varStatus="vs">
									    <input type="checkbox"
									    <c:forEach  items="${oneRole.rights}" var="oneRt2" >
							          	    <c:if test="${oneRt2.right_id == oneRt.right_id}">
							          	           checked
							          	    </c:if>
							          	</c:forEach>
									     value="${oneRt.right_id}" name="right_id" />:${oneRt.rightName} &nbsp;|&nbsp;
				                    <c:if test="${vs.count %5 ==0 }">
				                       <br> 
				                    </c:if>
				    
				    	   </c:forEach></td>
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