<%@ page import="com.kfluous.webload.domain.Student" %>
<%@ page import="com.kfluous.webload.service.FileService" %>
<%@ page import="com.kfluous.webload.service.Impl.FileServiceImpl" %>
<%@ page import="com.kfluous.webload.domain.Project" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kfluous
  Date: 2018/4/10
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <title>$Title$</title>

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
                  <%
                      Student student =(Student) request.getAttribute("user");
                      if(student==null){
                  %>
                  <li><a href="login.jsp" >Sign In</a></li>
                  <%
                  }else{
                  %>
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                         role="button" aria-haspopup="true" aria-expanded="false">
                          ${user.sid}已登入
                          <%
                              }
                          %>
                          <span class="caret"></span>
                      </a>
                      <ul class="dropdown-menu">
                          <li><a href="#">Action</a></li>
                          <li><a href="#">Another action</a></li>
                          <li><a href="#">Something else here</a></li>
                          <li role="separator" class="divider"></li>
                          <li class="dropdown-header">Nav header</li>
                          <li><a href="#">Separated link</a></li>
                          <li><a href="#">One more separated link</a></li>
                      </ul>
                  </li>
              </ul>
          </div><!--/.nav-collapse -->
      </div>
  </nav>
    <!-- nav    -->


  <!-- Main Page Context -->
  <div class="container theme-showcase" role="main" >
      <div class="col-xs-10">
          <div class="page-header">
              <h2>课程作业1</h2><span>更新于1970-1-1</span>
          </div>

          <div class="jumbotron">
              <h3>作业要求</h3>
              <p>这是作业规定的要求 1.... 2... 3....</p>
          </div>

          <div class="col-lg-6">
              <form id="upload" enctype="multipart/form-data" action="upload" method="post">
                  <div class="col-4 form-group">
                      <input type="file" class="filestyle" multiple="multiple" data-buttonName="btn-primary" data-buttonText="Find file" name="filename">
                  </div>

                  <div class="progress progress-striped active" style="display: none">
                      <div id="progressBar" class="progress-bar progress-bar-info"
                           role="progressbar" aria-valuemin="0" aria-valuenow="0"
                           aria-valuemax="100" style="width: 0%"></div>
                  </div>

                  <div class="form-group">
                      <button type="submit" class="btn btn-primary ">
                          <span ></span> Send
                      </button>
                  </div>
                  <div class="col-6">
                      <div class="progress">
                          <div class="progress-bar" role="progressbar" aria-valuenow="0"
                               aria-valuemin="0" aria-valuemax="100" style="width: 10%;">
                              <span class="sr-only">40% 完成</span>
                          </div>
                      </div>
                  </div>
              </form>
          </div>
      </div>
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
