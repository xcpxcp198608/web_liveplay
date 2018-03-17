<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<rapid:override name="title">
    Log
</rapid:override>

<rapid:override name="css_js">
    <script src="Resource/js/log.js"></script>
</rapid:override>

<rapid:override name="content">
    <table border="1px solid #800080" cellpadding="0px" cellspacing="0px" width="100%" id="tb">
        <thead>
        <tr bgcolor="purple" style="height: 35px; color: white; width: 100%">
            <th style="text-align: center" width="10%">ID</th>
            <th style="text-align: center" width="30%">CHANNEL_NAME</th>
            <th style="text-align: center"  width="20%">VIEW COUNT</th>
            <th style="text-align: center" width="30%">TIME</th>
            <th style="text-align: center" width="10%">DETAIL</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${viewLogInfoList}" var="viewLogInfo" varStatus="status">
            <tr style="height: 30px; color: #646665; font-size: 18px; width: 100%" id="tr1">
                <td align="center">${status.index + 1}</td>
                <td align="center">${viewLogInfo.channelName}</td>
                <td align="center">${viewLogInfo.count}</td>
                <td align="center">${viewLogInfo.duration}</td>
                <td align="center">
                    <input type="button" value="more" height="16px" style="font-size: 10px">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</rapid:override>

<%@ include file="base.jsp"%>