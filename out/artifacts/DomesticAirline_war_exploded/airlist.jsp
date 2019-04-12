<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>查询结果</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="static/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">航班列表</h3>

                        <div class="box-tools">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                                <div class="input-group-btn">
                                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <thead>
                                <th>航空公司</th>
                                <th>航班号</th>
                                <th>StartDrome</th>
                                <th>ArriveDrome</th>
                                <th>StartTime</th>
                                <th>ArriveTime</th>
                                <th>Mode</th>
                                <th>AirlineStop</th>
                            </thead>
                                <jsp:include page="theAirList.jsp"></jsp:include>
                                <%--<%

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

                                %>--%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery 3 -->
    <script src="static/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Slimscroll -->
    <script src="static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="static/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="static/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="static/dist/js/demo.js"></script>
</body>
</html>
