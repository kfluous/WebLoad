<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kfluous
  Date: 2018/4/22
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title>Admin</title>

    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

    <style type="text/css">
        body{
            margin-top: 60px;
        }

        .form-control1 {
            display: block;
            width: 100%;
            height: 150px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.42857143;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        }
    </style>
</head>
<body>
<s:if test="#session.user ==null">
    <jsp:forward page="index.jsp"></jsp:forward>
</s:if>
<s:elseif test="#session.user.admin != 2">
    <s:action name="toAchieve" executeResult="true"></s:action>
</s:elseif>
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
                <li ><a href="toAchieve.action">作业记录</a></li>
                <li class="active"><s:a action="add_project">发布新作业</s:a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <s:if test="#session.user == null">
                    <li><a href="login.jsp" >Sign In</a></li>
                </s:if>
                <s:else>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true" aria-expanded="false">
                            ${session.user.sid}已登入
                        </s:else>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <s:if test="#session.user.admin=2">
                            <li><s:a action="toAchieve">提交作业</s:a> </li>
                        </s:if>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">用户操作</li>
                        <li><a href="logout.action">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-8 column">
            <s:form role="form" method="post" action="newWork">
                <div class="form-group">
                    <label for="projectname">作业标题</label><input type="text" class="form-control" id="projectname" />
                </div>
                <div class="form-group">
                    <label for="request">作业要求</label><input type="text" class="form-control1" id="request" />
                </div>

                <button type="submit" class="btn btn-default">发布作业</button>
            </s:form>
        </div>
    </div>
</div>


</body>
</html>
