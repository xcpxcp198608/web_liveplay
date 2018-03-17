<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<rapid:override name="title">
    Images
</rapid:override>

<rapid:override name="css_js">
    <link rel="stylesheet" href="Resource/css/images.css">
    <script src="Resource/js/images.js"></script>
</rapid:override>

<rapid:override name="content">
    <input type="button" class="btn btn-default btn-primary" id="btn-add" value="Add +">
    <ul id="ul_images">
        <c:forEach items="${imageInfoList}" var="imageInfo">
        <li>
            <div style="position: relative">
                <img src="${imageInfo.url}" class="preview">
                <div class="operate_div">
                    <input type="hidden" value="${imageInfo.id}">
                    <a class="delete"><img class="o_img" src="Resource/img/delete.png"></a>
                    <a class="edit" href="/liveplay/images/up?id=${imageInfo.id}">
                        <img class="o_img" src="Resource/img/edit.png">
                    </a>
                </div>
            </div>
        </li>
        </c:forEach>
    </ul>
</rapid:override>

<%@ include file="base.jsp"%>