<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<rapid:override name="title">
    Upload
</rapid:override>

<rapid:override name="css_js">
    <link rel="stylesheet" href="Resource/css/upload.css">
</rapid:override>

<rapid:override name="content">
    <div id="upload_div">
        <div id="upload_form_div">
            <form action="${action}" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${id}">
                <input type="hidden" name="type" value="1">
                <input type="file" name="file" id="file"><br>
                <input type="submit" value="upload" id="btn-upload">&nbsp; &nbsp;
                <span id="upload_message">${upload_status}</span>
            </form><br>

            <form action="${action}" method="post">
                <input type="hidden" name="id" value="${id}">
                <input type="hidden" name="type" value="2">
                <input class="form-control" id="extra" name="extra" title="extra" placeholder="${link}"/><br>
                <input type="submit" class="btn btn-default btn-primary" id="btn-submit" value="Submit">
            </form>
        </div>
    </div>
    </div>
</rapid:override>

<%@ include file="base.jsp"%>