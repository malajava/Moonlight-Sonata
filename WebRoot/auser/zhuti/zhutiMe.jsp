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
    
    <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    
    <script type="text/javascript">
         function zhutiDel(id)
         {
             if(confirm('您确定删除吗？'))   //confirm() 方法用于显示一个带有指定消息和 OK 及取消按钮的对话框。
             {
                 window.location.href="<%=path %>/zhutiDel.action?id="+id;
             }
         }
    </script>
    
  </head>
  
  <body style="margin-left: 5px;margin-top: 5px;">
	  <DIV>
         <DIV id=data_list class="mainbox threadlist">
             <SPAN class=headactions>&nbsp;</SPAN>
             <H1 style="font-size: 11px;">&nbsp;</H1>
             <TABLE cellSpacing=0 summary=forum_21 cellPadding=0>
				  <TR>
				    <TD class=folder>&nbsp;</TD>
				    <TD class=icon>&nbsp;</TD>
				    <TH style="font-size: 11px;">标题</TH>
				    <TD class=author>作者</TD>
				    <TD class=lastpost>发布时间</TD>
				    <TD class=lastpost>操作</TD>
				  </TR>
				  <c:forEach items="${requestScope.zhuti_list_all}" var="zhuti">
				  <TR class=test>
				    <TD class=folder>
				        <img src="/luntan/img/icon.gif">
				    </TD>
                    <TD class=icon width=20>&nbsp; </TD>
				    <TH style="font-size: 11px;">
				        <LABEL>&nbsp;</LABEL> 
				        ${zhuti.title}
				        <c:if test='${zhuti.shifouding=="是"}'>
						     <img src="<%=path %>/img/ding.jpg">
						</c:if>
						<c:if test='${zhuti.shifoujing=="是"}'>
						     <img src="<%=path %>/img/jing.jpg">
						</c:if>
				    </TH>
				    <TD class=author>
				        <CITE>${zhuti.user.loginname}</CITE>
				    </TD>
				    <TD class=lastpost>
				        <EM>${zhuti.shijian}</EM> 
				    </TD>
				    <TD class=lastpost>
				        <EM><a href="#" onclick="zhutiDel(${zhuti.id})">删除</a></EM> 
				    </TD>
				  </TR>
				  </c:forEach>
	         </TABLE>
         </DIV>
      </DIV>
  </body>
</html>
