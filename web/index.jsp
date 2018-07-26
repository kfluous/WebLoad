
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kfluous
  Date: 2018/4/10
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" import="java.util.*" contentType="text/html;" pageEncoding="UTF-8"%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title>$Title$</title>

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
                  <li class="active"><a href="#">待提交</a></li>
                  <li><s:a action="achieve">历史提交</s:a></li>
              </ul>
              <ul class="nav navbar-nav pull-right">
                  <s:if test="#session.user == null">
                  <li><a href="login.jsp" >登录</a></li>
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
                          <s:if test="#session.user.admin == 2">
                              <li><s:a action="achieveAll">管理</s:a> </li>
                          </s:if>
                          <li role="separator" class="divider"></li>
                          <li class="dropdown-header">用户操作</li>
                          <li><a data-toggle="modal" data-target="#myModal">修改密码</a></li>
                          <li><a href="logout.action">注销</a></li>
                      </ul>
                  </li>
              </ul>
          </div><!--/.nav-collapse -->
      </div>
  </nav>
    <!-- nav    -->



  <!-- Main Page Context -->
  <div class="container theme-showcase" role="main" >
      <s:iterator value="#toAchieve">
      <div class="col-xs-10">
          <div class="page-header">
              <h2>${projectname}</h2><span>更新于${date}</span>
          </div>
          <div class="jumbotron">
              <h3>作业要求</h3>
              <p>${request}</p>
          </div>

          <div class="col-lg-6">
              <form id="upload" enctype="multipart/form-data" action="upload?project_id=${id}" method="post">
                  <div class="col-4 form-group">
                      <input type="file" class="filestyle" multiple="multiple" data-buttonName="btn-primary" data-buttonText="Find file" name="filename">
                  </div>

                  <%--<div class="progress progress-striped active" style="display: none">--%>
                      <%--<div id="progressBar" class="progress-bar progress-bar-info"--%>
                           <%--role="progressbar" aria-valuemin="0" aria-valuenow="0"--%>
                           <%--aria-valuemax="100" style="width: 0%"></div>--%>
                  <%--</div>--%>

                  <div class="form-group">
                      <button type="submit" class="btn btn-primary ">
                          <span ></span> Send
                      </button>
                  </div>
                  <%--<div class="col-6">--%>
                      <%--<div class="progress">--%>
                          <%--<div class="progress-bar" role="progressbar" aria-valuenow="0"--%>
                               <%--aria-valuemin="0" aria-valuemax="100" style="width: 10%;">--%>
                              <%--<span class="sr-only">40% 完成</span>--%>
                          <%--</div>--%>
                      <%--</div>--%>
                  <%--</div>--%>
              </form>
          </div>
      </div>
          </s:iterator>
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

              <form action="change_pwd">
              <div class="modal-body">
                  <p>设置你的新密码</p>
                  <label for="updatepassword">密码</label><input type="password" class="form-control" id="updatepassword" name="updatepassword" required="" />
                  <label for="updatepassword">确认密码</label><input type="password" class="form-control" id="updatepassword2" name="updatepassword2" required="" />
              </div>

              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                  </button>
                  <button type="submit" class="btn btn-primary" onclick="jungle(updatepassword,password2)" >
                      提交
                  </button>
              </div>
              </form>
          </div><!-- /.modal-content -->
      </div><!-- /.modal -->
  </div>
  <script type="text/javascript">
      $('#filename').filestyle({
          buttonText : 'Multiple',
          buttonName : 'btn-danger'
      });
  </script>

  <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>
</body>
</html>
