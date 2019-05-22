<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
   String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<LINK rel=stylesheet type=text/css href="<%=path %>/css/sportsforum_1.css">
    <LINK rel=stylesheet type=text/css href="<%=path %>/css/allbbs_append.css">

    <STYLE type=text/css>
        .secondaryHeader {BACKGROUND: url(http://i2.sinaimg.cn/dy/images/header/2008/standardl2nav_bg.gif111) #fff repeat-x; HEIGHT: 33px; COLOR: #000; FONT-SIZE: 12px; OVERFLOW: hidden; FONT-WEIGHT: 100}
		.secondaryHeader A {COLOR: #000; TEXT-DECORATION: none}
		.secondaryHeader A:visited {COLOR: #000; TEXT-DECORATION: none}
		.secondaryHeader A:hover {COLOR: #c00; TEXT-DECORATION: underline}
		.secondaryHeader A:active {COLOR: #c00; TEXT-DECORATION: underline}
		.sHBorder {BORDER-BOTTOM: #e3e3e3 1px solid; BORDER-LEFT: #e3e3e3 1px solid; PADDING-BOTTOM: 0px; PADDING-LEFT: 12px; PADDING-RIGHT: 10px; ZOOM: 1; OVERFLOW: hidden; BORDER-TOP: #e3e3e3 1px solid; BORDER-RIGHT: #e3e3e3 1px solid; PADDING-TOP: 0px}
		.sHLogo {LINE-HEIGHT: 31px; FLOAT: left; HEIGHT: 31px; OVERFLOW: hidden}
		.sHLogo SPAN {DISPLAY: block; FONT-FAMILY: Arial; FLOAT: left; HEIGHT: 31px; FONT-SIZE: 27px; VERTICAL-ALIGN: middle}
		.sHLogo SPAN A {DISPLAY: block; FONT-FAMILY: Arial; FLOAT: left; HEIGHT: 31px; FONT-SIZE: 27px; VERTICAL-ALIGN: middle}
		.sHLogo SPAN A:link {DISPLAY: block; FONT-FAMILY: Arial; FLOAT: left; HEIGHT: 31px; FONT-SIZE: 27px; VERTICAL-ALIGN: middle}
		.sHLogo SPAN A:visited {DISPLAY: block; FONT-FAMILY: Arial; FLOAT: left; HEIGHT: 31px; FONT-SIZE: 27px; VERTICAL-ALIGN: middle}
		.sHLogo SPAN A:hover {DISPLAY: block; FONT-FAMILY: Arial; FLOAT: left; HEIGHT: 31px; FONT-SIZE: 27px; VERTICAL-ALIGN: middle}
		.sHLogo SPAN {VERTICAL-ALIGN: middle}
		.sHLogo SPAN A IMG {VERTICAL-ALIGN: middle}
		.sHLogo SPAN A:link IMG {VERTICAL-ALIGN: middle}
		.sHLogo SPAN A:visited IMG {VERTICAL-ALIGN: middle}
		.sHLogo SPAN A:hover IMG {VERTICAL-ALIGN: middle}
		.sHLinks {LINE-HEIGHT: 31px; FLOAT: right}

		.nav-t {BORDER-BOTTOM: #c7d4de 0px solid; BORDER-LEFT: #c7d4de 1px solid; BACKGROUND: url(http://www.sinaimg.cn/book/deco/2010/t_b_bg_01.png111) repeat-x; HEIGHT: 40px; BORDER-TOP: #c7d4de 0px solid; BORDER-RIGHT: #c7d4de 1px solid}
		.nav-t UL {FLOAT: left}
		.nav-t UL LI {TEXT-ALIGN: center; PADDING-BOTTOM: 0px; LINE-HEIGHT: 36px; MARGIN: 4px 0px 0px 1px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; DISPLAY: inline; FLOAT: left; PADDING-TOP: 0px; _padding: 0 4px}
		.nav-t UL LI.selected {PADDING-BOTTOM: 0px; LINE-HEIGHT: 36px; PADDING-LEFT: 0px; WIDTH: 47px; PADDING-RIGHT: 0px; BACKGROUND: url(http://www.sinaimg.cn/book/deco/2010/news/backgruand2/sports.png111) no-repeat; HEIGHT: 36px; PADDING-TOP: 0px}
		.nav-t UL LI.selected A {COLOR: #fff}
		.nav-t UL LI.selected {COLOR: #fff}
		.nav-t UL LI.selected A:visited {COLOR: #fff}
		.nav-t A.nav-map {TEXT-INDENT: -10000px; MARGIN: 9px 5px 0px 0px; OUTLINE-STYLE: none; WIDTH: 63px; DISPLAY: inline; BACKGROUND: url(http://www.sinaimg.cn/book/deco/2010/news/backgruand2/sports.png111) -150px -150px; FLOAT: right; HEIGHT: 21px}
		.nav-t2 {BACKGROUND: url(http://www.sinaimg.cn/book/club/sports_banner_bg.png111) repeat-x 0px 0px; HEIGHT: 103px}
		.nav-t2-in {BACKGROUND: url(/luntan/img/123456.jpg) no-repeat; HEIGHT: 103px}
		.nav-t2-in H1 {WIDTH: 235px; FLOAT: left; HEIGHT: 103px}
		.nav-t2-in H1 A {TEXT-INDENT: -10000px; OUTLINE-STYLE: none; DISPLAY: block; HEIGHT: 103px}
		.nav-banner {MARGIN: 0px; DISPLAY: inline; FLOAT: right}
		.nav-banner IMG {DISPLAY: block}
		.nav-t3 {BORDER-BOTTOM: #d7d7d7 0px solid; BORDER-LEFT: #d7d7d7 1px solid; PADDING-BOTTOM: 0px; PADDING-LEFT: 5px; PADDING-RIGHT: 2px; BACKGROUND: url(http://www.sinaimg.cn/book/deco/2010/t_b_bg_01.png111) 0px -50px; HEIGHT: 34px; BORDER-TOP: #d7d7d7 0px solid; BORDER-RIGHT: #d7d7d7 1px solid; PADDING-TOP: 0px}
		.nav-t3l {LINE-HEIGHT: 34px; FLOAT: left; COLOR: #000000}
		.nav-t3l A {PADDING-BOTTOM: 0px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; PADDING-TOP: 0px}
		.nav-t3r {PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FLOAT: right; PADDING-TOP: 5px}
		.nav-t3r SELECT {COLOR: #999}
		.ipt-01 {BORDER-BOTTOM: #ccc 1px solid; BORDER-LEFT: #ccc 1px solid; PADDING-BOTTOM: 1px; LINE-HEIGHT: 16px; PADDING-LEFT: 1px; WIDTH: 200px; PADDING-RIGHT: 1px; BACKGROUND: #fff; HEIGHT: 16px; COLOR: #999; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid; PADDING-TOP: 1px}
		.ipt-sub {BORDER-BOTTOM-STYLE: none; PADDING-BOTTOM: 0px; BORDER-RIGHT-STYLE: none; TEXT-INDENT: -1000px; PADDING-LEFT: 0px; WIDTH: 78px; PADDING-RIGHT: 0px; BORDER-TOP-STYLE: none; BACKGROUND: url() 0px -150px; HEIGHT: 21px; BORDER-LEFT-STYLE: none; CURSOR: pointer; PADDING-TOP: 0px}
		#menu {ZOOM: 1; _overflow: hidden}
		.ipt-login {BORDER-BOTTOM-STYLE: none; PADDING-BOTTOM: 0px; BORDER-RIGHT-STYLE: none; TEXT-INDENT: -1000px; PADDING-LEFT: 0px; WIDTH: 39px; PADDING-RIGHT: 0px; BORDER-TOP-STYLE: none; BACKGROUND: url() -300px -150px; HEIGHT: 21px; BORDER-LEFT-STYLE: none; PADDING-TOP: 0px}
		#menu {ZOOM: 1; _overflow: hidden}
		.frameswitch {COLOR: #999}
		.ipt-11 {PADDING-BOTTOM: 2px; PADDING-LEFT: 2px; PADDING-RIGHT: 2px; PADDING-TOP: 2px}
    </STYLE>
    
    
    <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
    
    <script type="text/javascript">
		 function up()
	     {
	        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
            pop.setContent("title","文件上传");
            pop.build();
            pop.show();
	     }
	     
	     function edit()
	     {
	        if(document.form1.loginname.value=="")
	        {
	            alert("请输入账号");
	            return false;
	        }
	        if(document.form1.loginpw.value=="")
	        {
	            alert("请输入密码");
	            return false;
	        }
	        document.form1.submit();
	     }
    </script>
    
  </head>
  
  <body style="margin-left: 5px;margin-top: 5px;">
	  <DIV>
         <DIV id=nav></DIV>
         <DIV id=quickpost class=box>
             <SPAN class=headactions>&nbsp;</SPAN> <H4 style="font-size: 11px;">&nbsp;</H4>
             <DIV class=postform style="height: 300px;">
                 <DIV style="MARGIN-TOP: 5px; MARGIN-LEFT: 44px" id=fastlogin></DIV>
                     <form action="<%=path %>/userEdit.action" name="form1" method="post">
	                     <table align="left" border="0" cellpadding="2" cellspacing="2">
							<tr align='center'>
								<td style="width: 60px;" align="right">
									账号：										    
								</td>
								<td align="left">
									<input type="text" name="loginname" value="${sessionScope.user.loginname }" readonly="readonly" style="width: 300px;"/><font style="font-size: 11px;">(账号只读)</font>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									密码：										    
								</td>
								<td align="left">
									<input type="password" name="loginpw" value="${sessionScope.user.loginpw }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									姓名：										    
								</td>
								<td align="left">
									<input type="text" name="name" value="${sessionScope.user.name }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									性别：										    
								</td>
								<td align="left">
									<select name="sex" style="width: 120px;"><option value="男">男</option><option value="女">女</option></select>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									年龄：										    
								</td>
								<td align="left">
									<input type="text" name="age" value="${sessionScope.user.age }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									住址：										    
								</td>
								<td align="left">
									<input type="text" name="address" value="${sessionScope.user.address }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									电话：										    
								</td>
								<td align="left">
									<input type="text" name="tel" value="${sessionScope.user.tel }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									邮箱：										    
								</td>
								<td align="left">
									<input type="text" name="email" value="${sessionScope.user.email }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									QQ：										    
								</td>
								<td align="left">
									<input type="text" name="qq" value="${sessionScope.user.qq }" style="width: 300px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 60px;" align="right">
									头像：										    
								</td>
								<td align="left">
									<input type="text" name="fujian" id="fujian" style="width: 300px;" readonly="readonly" value="${sessionScope.user.fujian }"/>
	                                <input type="button" value="上传" onclick="up()" style="width: 60px;height: 20px;"/>
								</td>
							</tr>
							<tr align='center'>
							   <td style="width: 60px;" align="right"></td>
							   <td align="left">
							      <input type="hidden" name="id" value="${sessionScope.user.id }">
	                              <input type="button" value="修改" style="width: 90px;height: 22px;" onclick="edit();">
							   </td>
							</tr>
                         </table>
                     </form>
                 </DIV>
             </DIV>
         </DIV>
      </DIV>
  </body>
</html>
