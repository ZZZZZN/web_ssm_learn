
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="<%=basePath%>static/js/jQuery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/upload.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/webuploader.js"></script>
    <link type="text/css" href="<%=basePath%>static/bootstrap/css/bootstrap-theme.min.css">
    <link type="text/css" href="<%=basePath%>static/bootstrap/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<body>
<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
</div>

</body>

</body>
</html>
