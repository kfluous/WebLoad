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
                <li class="active"><a href="toAchieve.action">作业记录</a></li>
                <li><s:a action="add_project">发布新作业</s:a></li>
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
                        <li><a  data-toggle="modal" data-target="#myModal">修改密码</a></li>
                        <li><a href="logout.action">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>



<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        归档名称
                    </th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="achieveAll">
                <tr>
                    <td>
                        <a href="StuNoFIle.action?project_id=${id}"> ${projectname}</a>
                    </td>
                </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>

        <div class="col-md-3 column">
            <div class="panel-group" id="accordion1">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion1"
                               href="#collapseOne1">
                                尚未提交
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne1" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>学号</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="StuNoFIle" status="fileitem">
                                    <tr>
                                        <td><s:property value="%{#fileitem.getIndex()+1}"/></td>
                                        <td>${sid}</td>

                                    </tr>
                                </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-7 column">

            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne">
                                已提交
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>学号</th>
                                    <th>提交作业</th>
                                    <th>提交日期</th>
                                    <th>Options</th>
                                </tr>
                                </thead>
                                <tbody>
                                <s:iterator value="classfileList" status="fileitem">
                                    <tr>
                                        <td><s:property value="%{#fileitem.getIndex()+1}"/></td>
                                        <td>${auther}</td>
                                        <td>${fileName}</td>
                                        <td>${date}</td>
                                        <%--<td><s:a action="delete_file?fileId=%{fileId}" onclick="return confirm('确定要删除吗？')">删除</s:a>--%>

                                        </td>
                                    </tr>
                                </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改密码
                </h4>
            </div>
            <div class="modal-body">
                <p>设置你的新密码</p>
                <label for="password">密码</label><input type="password" class="form-control" id="password" name="password" required="" />
                <label for="password">密码</label><input type="password" class="form-control" id="password2" name="password" required="" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
