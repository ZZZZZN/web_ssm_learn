<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/6
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta charset="UTF-8">
    <script src="<%=basePath%>static/js/jQuery-2.1.4.min.js"></script>
    <title>Title</title>
</head>
<body>
<script>
    $(function () {
       $.ajax({
           type:"post",
           url:"<%=basePath%>index/userlist",
           success:function (rs) {
               var a=0;
           }
       })
    });
</script>
</body>
</html>
