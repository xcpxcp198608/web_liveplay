<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Channel</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>



    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>

    <link rel="shortcut icon" href="img/btv.ico">
    <script type="application/javascript" language="JavaScript" src="Resource/js/channel/show.js"></script>
    <link rel="stylesheet" type="text/css" href="Resource/css/channel/show.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">LivePlay</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" id="btToggler">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" name="nav" value="sports">Sports
                    <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="usa">USA</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="usa local news">USA Local</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="china">China</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="latino">Latino</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="korea">Korea</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="japan">Japan</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="europe">Europe</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="nav" value="asia">Asia</a>
            </li>
        </ul>
    </div>
</nav>

<div class="row" style="padding: 10px; margin-top: 60px" id="dChannel"></div>


<div style="position: absolute; left:48%; top:49%; z-index: 100; color: gray"
     class="text-center" id="dLoading">
    loading...
</div>


<script type="text/javascript">

    $(function () {
        show.listChannel.execute('sports');
        $('a[name=nav]').click(function () {
            $('#btToggler').click();
            var category = $(this).attr('value');
            show.listChannel.execute(category);
        });



    });
</script>


<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

