<%--
  Created by IntelliJ IDEA.
  User: kfluous
  Date: 2018/4/20
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Login</title>
    <style type="text/css">
        body{
            margin-top: 60px;
        }
    </style>
</head>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Web作业提交</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav">
                <li class="active">Sign In</li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- nav    -->
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="col-lg-4">
            <form role="form" name="login" action="login.action">
                <div class="form-group">
                    <label for="username">学号</label><input type="text" class="form-control" id="username" name="username" required=""/>
                </div>
                <div class="form-group">
                    <label for="password">密码</label><input type="password" class="form-control" id="password" name="password" required="" data-toggle="tooltip" data-placement="right" title="default password=学号"/>
                </div>
                <%--<div class="checkbox">--%>
                    <%--<label><input type="checkbox"/>自动登陆</label>--%>
                <%--</div> --%>
                <button type="submit" class="btn btn-default">登录</button>
            </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
</body>
</html>
