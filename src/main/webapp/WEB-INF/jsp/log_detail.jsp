<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<rapid:override name="title">
    Detail
</rapid:override>

<rapid:override name="css_js">
    <link rel="stylesheet" href="Resource/css/log.css">
</rapid:override>

<rapid:override name="content">
    <table border="1px solid #800080" cellpadding="0px" cellspacing="0px" width="100%" >
        <thead>
        <tr bgcolor="purple" style="height: 35px; color: white; width: 100%">
            <th style="text-align: center" width="10%">ID</th>
            <th style="text-align: center" width="20%">CHANNEL_NAME</th>
            <th style="text-align: center"  width="15%">USERNAME</th>
            <th style="text-align: center"  width="15%">MAC</th>
            <th style="text-align: center" width="20%">START_TIME</th>
            <th style="text-align: center" width="20%">END_TIME</th>
            <th style="text-align: center" width="20%">DURATION</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${logChannelViewInfoList}" var="logChannelViewInfo" varStatus="status">
            <tr style="height: 30px; color: #646665; font-size: 18px; width: 100%" id="tr1">
                <td align="center">${status.index + 1}</td>
                <td align="center">${logChannelViewInfo.channelName}</td>
                <td align="center">${logChannelViewInfo.username}</td>
                <td align="center">${logChannelViewInfo.mac}</td>
                <td align="center">${logChannelViewInfo.startTime}</td>
                <td align="center">${logChannelViewInfo.endTime}</td>
                <td align="center">${logChannelViewInfo.viewStrTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</rapid:override>

<%@ include file="base.jsp"%>