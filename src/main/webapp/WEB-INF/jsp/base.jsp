<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title><rapid:block name="title"/>--LivePlay</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script type="application/javascript" language="JavaScript" src="Resource/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" language="JavaScript" src="Resource/js/common.js"></script>
    <script type="application/javascript" language="JavaScript" src="Resource/js/base.js"></script>
    <link rel="stylesheet" type="text/css" href="Resource/css/base.css">
    <link rel="shortcut icon" href="Resource/img/btv.ico">
    <rapid:block name="css_js" />

</head>

<body>
    <div id="navigation">
        <div id="nav_content">
            <a id="panel">Panel</a>
            <ul>
                <li><a href="/liveplay/images/">Images</a></li>
                <c:if test="${username eq 'wiatec'}">
                    <li><a href="/liveplay/report/">Reports</a></li>
                    <li><a href="/liveplay/log/view">Record</a></li>
                </c:if>
            </ul>
            <a id="sign_out" href="/liveplay/admin/logout">Sign out</a>
        </div>
    </div>

    <div id="content">
        <rapid:block name="content" />
    </div>

    <div id="footer">
        <p>Copyright © 2016-2017 WIATEC All Rights Reserved</p>
    </div>
    <div id="progress_div">
        <div ></div>
        <img src="Resource/img/loading.gif" alt="loading">
    </div>
    <div id="status_div">
        <div id="status_bg_div"></div>
        <div id="message_div">
            <p id="status_message"></p>
        </div>
    </div>

</body>
</html>
