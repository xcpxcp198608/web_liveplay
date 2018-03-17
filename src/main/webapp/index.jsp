<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>Login--LivePlay</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />  
  <meta name="apple-mobile-web-app-capable" content="yes" />  
  <meta name="format-detection" content="telephone=no" />
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <script type="application/javascript" language="JavaScript" src="Resource/js/jquery-3.2.1.min.js"></script>
  <script type="application/javascript" language="JavaScript" src="Resource/js/common.js"></script>
  <script type="application/javascript" language="JavaScript" src="Resource/js/login.js"></script>
  <link rel="shortcut icon" href="Resource/img/btv.ico">
  <link rel="stylesheet" type="text/css" href="Resource/css/index.css">
</head>
<body style="padding: 0; margin: 0">
  <div id="bg" style="background-image: url(Resource/img/bg.jpg);">
    <div id="login_div">
      <form class="form-horizontal" method="post" action="/liveplay/admin/login">
        <input  class="form-control" id="username" name="userName" placeholder="Username">
        <p id="error_username">&nbsp;</p>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        <p id="error_password">&nbsp;</p><br>
        <input type="submit" class="btn btn-default btn-primary" id="sign_in" value="Sign in" disabled>
      </form>
    </div>
  </div>
</body>
</html>
