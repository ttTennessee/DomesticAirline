<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qinzheng.airline.pojo.AddressList" %>
<%@ page import="com.qinzheng.airline.pojo.Address" %>
<%
    for (Address addressList : ((AddressList) session.getAttribute("add")).getList()) {
        response.getWriter().print("<tr>");
        response.getWriter().print("<td>"+ addressList.getCnCityName()+"</td>");
        response.getWriter().print("<td>"+ addressList.getEnCityName()+"</td>");
        response.getWriter().print("<td>"+ addressList.getAbbreviation()+"</td>");
        response.getWriter().print("</tr>");
    }
%>