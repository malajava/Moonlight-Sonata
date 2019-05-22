<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<style type="text/css">
			<!--
			body {
				margin-left: 0px;
				margin-top: 0px;
				margin-right: 0px;
				margin-bottom: 0px;
			}
			.STYLE3 {
				font-size: 12px;
				color: #435255;
			}
			.STYLE4 {font-size: 12px}
			.STYLE5 {font-size: 16px; font-weight: bold; }
			a:link {font-size:12px; text-decoration:none; color:#000000;}
			a:visited {font-size:12px; text-decoration:none; color:#000000;}
			a:hover{font-size:12px; text-decoration:none; color:#FF0000;}
			-->
		</style>
  </head>
  
  <body>
        <c:if test="${sessionScope.userType==1}">
		<table width="147" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="23">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9%">
								&nbsp;
							</td>
							
							<td width="8%">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">
						<table width="82%" border="0" align="center" cellpadding="0"cellspacing="0">
							<tr>
								<td height="38">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="33" height="28">
												<img src="<%=path %>/images/main_40.gif" width="28" height="28">
											</td>
											<td width="99">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="23" class="STYLE4" style="cursor:hand"
															onMouseOver="this.style.backgroundImage='url(<%=path %>/images/tab_bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<a href="<%=path %>/auser/userinfo/userinfo.jsp" target="rightF">编辑我的资料</a>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td width="33" height="28">
												<img src="<%=path %>/images/main_40.gif" width="28" height="28">
											</td>
											<td width="99">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="23" class="STYLE4" style="cursor:hand"
															onMouseOver="this.style.backgroundImage='url(<%=path %>/images/tab_bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<a href="<%=path %>/zhutiMe.action" target="rightF">我发布的帖子</a>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
					</table>
				</td>
			</tr>
		</table>
		</c:if>
		
	</body>
</html>
