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
    
    <script type="text/javascript">
		 function down1(fujianPath,fujianYuashiMing)
	     {
	           var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
	           url=encodeURI(url); 
	           url=encodeURI(url); 
	           window.open(url,"_self");
	     }
	     
	     
	    function zhutiDel(id)
	    {
	        var url="<%=path %>/zhutiDel.action?id="+id;
	        window.location.href=url;
	    }
	    
	    function huifuDel(id)
	    {
	        var url="<%=path %>/huifuDel.action?id="+id;
	        window.location.href=url;
	    }
	    
	    function down1(fujianPath,fujianYuashiMing)
	    {
	           var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
	           url=encodeURI(url); 
	           url=encodeURI(url); 
	           window.open(url,"_self");
	    }
	    
	    
        function zhuti_zhiding_shezhi(id)
	    {
	           var url="<%=path %>/zhuti_zhiding_shezhi.action?id="+id;
	           window.location.href=url;
	    }
	    
	    function zhuti_zhiding_quxiao(id)
	    {
	           var url="<%=path %>/zhuti_zhiding_quxiao.action?id="+id;
	           window.location.href=url;
	    }
	    
	    
	    function zhuti_jinghua_shezhi(id)
	    {
	           var url="<%=path %>/zhuti_jinghua_shezhi.action?id="+id;
	           window.location.href=url;
	    }
	    function zhuti_jinghua_quxiao(id)
	    {
	           var url="<%=path %>/zhuti_jinghua_quxiao.action?id="+id;
	           window.location.href=url;
	    }
    </script>
    
  </head>
  
  <body style="margin-left: 5px;margin-top: 5px;">
	  <DIV style="width: 98%">
         <DIV class="mainbox threadlist">
             <SPAN class=headactions>&nbsp;</SPAN>
             <H1 style="font-size: 11px;">&nbsp;</H1>
             <TABLE cellSpacing=0 cellPadding=0>
				 <TR>
				    <TD class=postauthor>
				        <DIV class=avatar><IMG alt="" src="<%=path %>/${requestScope.zhuti.user.fujian}" width="100" height="130"></DIV>
				        <P><EM></EM></P>
				        <DL class=profile>
							<DT>账号</DT>
							<DD>${requestScope.zhuti.user.loginname }&nbsp;</DD>
							<DT>姓名</DT>
							<DD>${requestScope.zhuti.user.name }</DD>
							<DT>邮箱</DT>
							<DD>${requestScope.zhuti.user.email }&nbsp;</DD>
							<DT>住址</DT>
							<DD>${requestScope.zhuti.user.address }&nbsp;</DD>
						</DL>
				    </TD>
				    <TD class="postcontent opt_dblclick" valign="top">
				        <DIV class=postinfo>
				            <STRONG></STRONG> 发表于 ${requestScope.zhuti.shijian }&nbsp;<!-- 获取request变量，名字是zhuti，值是shijian  -->
				            <c:if test='${requestScope.zhuti.shifouding=="是"}'>
						       <img src="<%=path %>/img/ding.jpg">
							</c:if>
							<c:if test='${requestScope.zhuti.shifoujing=="是"}'>
							   <img src="<%=path %>/img/jing.jpg">
							</c:if>
				        </DIV>
				        <DIV class="postmessage defaultpost">
				            <H2 id=posttitle_86445228>${requestScope.zhuti.title } </H2>
				            <DIV class=t_msgfont><c:out value="${requestScope.zhuti.content}" escapeXml="false"></c:out></DIV>
				            <br/>
				            <c:if test="${requestScope.zhuti.fujian!='' }">
			                    ${requestScope.zhuti.fujianYuanshiming}
			                    <a href="#" onClick="down1('${requestScope.zhuti.fujian}','${requestScope.zhuti.fujianYuanshiming}')" style="font-size: 13px;color: red">下载</a>
			                </c:if>
				        </DIV>
				    </TD>
				  </TR>
				  <TR>
				    <TD class=postauthor></TD>
				    <TD style="BORDER-TOP-STYLE: none">
						<A href="#" style="color: red" onclick="zhuti_zhiding_shezhi(${zhuti.id})">设置置顶</A>&nbsp;&nbsp;&nbsp;
						<A href="#" style="color: red" onclick="zhuti_zhiding_quxiao(${zhuti.id})">取消置顶</A>&nbsp;&nbsp;&nbsp;
						<A href="#" style="color: red" onclick="zhuti_jinghua_shezhi(${zhuti.id})">设置精华</A>&nbsp;&nbsp;&nbsp;
						<A href="#" style="color: red" onclick="zhuti_jinghua_quxiao(${zhuti.id})">取消精华</A>&nbsp;&nbsp;&nbsp;
						<A href="#" style="color: red" onclick="zhutiDel(${zhuti.id})">删除</A>&nbsp;&nbsp;&nbsp;
					</TD>
				  </TR>
				  <TR>
				    <TD class=postauthor></TD>
				    <TD class=postcontent>
				        <DIV style="HEIGHT: 45px" class=postactions>
				            <SPAN style="MARGIN-TOP: 5px; FLOAT: right; MARGIN-RIGHT: 15px"><STRONG title=顶部 onclick=scroll(0,0)>TOP</STRONG> </SPAN>
				        </DIV>
					</TD>
				  </TR>
		     </TABLE>
         </DIV>
         <c:forEach items="${requestScope.zhuti.huifuList}" var="huifu" varStatus="ss">
         <DIV class="mainbox threadlist">
             <TABLE cellSpacing=0 summary=pid86445228 cellPadding=0>
				 <TR>
				    <TD class=postauthor>
				        <DIV class=avatar><IMG alt="" src="<%=path %>/${huifu.user.fujian}" width="100" height="130"></DIV>
				        <P><EM></EM></P>
				        <DL class=profile>
							<DT>账号</DT>
							<DD>${huifu.user.loginname }&nbsp;</DD>
							<DT>姓名</DT>
							<DD>${huifu.user.name }</DD>
							<DT>邮箱</DT>
							<DD>${huifu.user.email }&nbsp;</DD>
							<DT>住址</DT>
							<DD>${huifu.user.address }&nbsp;</DD>
						</DL>
				    </TD>
				    <TD class="postcontent opt_dblclick" valign="top">
				        <DIV class=postinfo><STRONG></STRONG> 发表于${huifu.shijian } &nbsp;</DIV>
				        <DIV class="postmessage defaultpost">
				            <H2 id=posttitle_86445228>${huifu.title }</H2>
				            <DIV class=t_msgfont><c:out value="${huifu.content}" escapeXml="false"></c:out></DIV>
				        </DIV>
				    </TD>
				  </TR>
				  <TR>
				    <TD class=postauthor></TD>
				    <TD class=postcontent>
				        <DIV style="HEIGHT: 45px" class=postactions>
				            <A href="#" style="color: red" onclick="huifuDel(${huifu.id })">删除</A>&nbsp;&nbsp;&nbsp;
				            <SPAN style="MARGIN-TOP: 5px; FLOAT: right; MARGIN-RIGHT: 15px"><STRONG title=顶部 onclick=scroll(0,0)>TOP</STRONG> </SPAN>
				        </DIV>
					</TD>
				  </TR>
		     </TABLE>
         </DIV>
         </c:forEach>
      </DIV>
  </body>
</html>
