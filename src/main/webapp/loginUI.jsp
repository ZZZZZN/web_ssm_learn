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

<span>用户名</span><input type="text" id="username" />
<span>密码</span><input type="text" id="password" />
<button id="submit" onclick="dosubmit()">提交</button>
<script>
        function dosubmit(){
            $.ajax({
                type:"post",
                url:"<%=basePath%>/login",
                data:{
                    "username":$("#username").val(),
                    "password":$("#password").val()
                },
                success:function (rs) {
                    if (rs.state==true){
                        alert("登录成功")
                    }
                    else {
                        alert(rs.Msg)
                    }
                }
            })
        }
</script>
</body>
</html>
