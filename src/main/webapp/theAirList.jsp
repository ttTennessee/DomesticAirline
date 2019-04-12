<%@ page import="com.qinzheng.airline.pojo.AirlinesTime" import="com.qinzheng.airline.pojo.Airlines" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    for (AirlinesTime airlinesTime : ((Airlines) session.getAttribute("al")).getList()) {
        response.getWriter().println("<tr>");
        response.getWriter().print("<td>"+ airlinesTime.getCompany()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getAirlineCode()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getStartDrome()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getArriveDrome()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getStartTime()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getArriveTime()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getMode()+"</td>");
        response.getWriter().print("<td>"+ airlinesTime.getAirlineStop()+"</td>");
        response.getWriter().println("</tr>");
    }
%>