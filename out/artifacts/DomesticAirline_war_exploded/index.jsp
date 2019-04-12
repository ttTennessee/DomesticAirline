<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>航班查询</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="static/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
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
        <div class="col-md-12">
            <div class="box box-primary">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">航班查询API接口实现</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal" action="/DomesticAirline/airlineTimes" method="post">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="startCity" class="col-sm-2 control-label">出发城市</label>
                                <div class="col-sm-10">
                                    <div class="input-group lastCity">
                                        <div class="input-group-addon">
                                            <i class="fa fa-plane"></i>
                                        </div>
                                        <input type="text" class="form-control" id="startCity" placeholder="请输入起点" name="startCity">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastCity" class="col-sm-2 control-label">到达城市</label>

                                <div class="col-sm-10">
                                    <div class="input-group lastCity">
                                        <div class="input-group-addon">
                                            <i class="fa fa-plane"></i>
                                        </div>
                                        <input type="text" class="form-control" id="lastCity" placeholder="请输入终点" name="lastCity">
                                    </div>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">出发日期</label>
                                <div class="col-sm-10">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="datepicker" name="theDate" placeholder="不输入默认为今天">
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button formaction="/DomesticAirline/address" type="submit" class="btn btn-default">查看支持城市列表</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>



    <!-- jQuery 3 -->
    <script src="static/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="static/bower_components/fastclick/lib/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="static/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="static/dist/js/demo.js"></script>

    <!-- bootstrap datepicker -->
    <script src="static/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
    <script>
        //Date picker
        $('#datepicker').datepicker({
            autoclose: true
        })
    </script>
</body>
</html>
