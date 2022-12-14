<%@ page import="com.example.showvideoapp.models.Video" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Page Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial;
            margin: 0;
            background-color: black;
        }

        .header {
            padding-top: 1px;
            padding-bottom: 1px;
            padding-left: 10px;
            background: white;
            color: black;
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        }
        .videos-box{
            background-color: black;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 5px;
        }
        .video-box {
            background-color: white;
            width:350px;
            height: 400px;
            border: solid black;
            margin-top: 10px;
        }
        img{
            height: 300px;
            width: 300px;
            margin: auto;
            display: block;
            border: solid black;
            border-top: 0px;
        }
        .content {padding:20px;}
        p {
            font-size: 25px;
            padding-top: 10px;
            padding-bottom: 5px;
            text-decoration: none;
            font-weight: bold;
            border-top:solid black;
            text-align: center;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;

        }
        a{
            color:black;
            text-decoration: none;
        }
        .nextpage{
            position: absolute ;
            bottom: 0;
            left: 0;
            color: white;
            content: "\2192";
        }
        span {
            font-size: 70px;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>HamzaTube</h1>
</div>
<div class="videos-box">


    <%
        List<Video> videoList= (List<Video>) request.getAttribute("videos");
    %>
    <%
        for(Video video:videoList){
            request.setAttribute("video",video);
    %>
    <a href="${pageContext.request.contextPath}/video/<%=video.getId()%>">
        <div class="video-box">
            <img controls src="<%=video.getVideoCoverUrl()%>"></img>
            <p><%=video.getName()%></p>
        </div>
    </a>
    <%
        }
    %>

</div>
<a href="http://host.docker.internal:8082/api/video/upload">
    <div class="nextpage">

        <span>&#8592;</span>
        <p style="display:inline;position: relative; bottom: 10px; font-size: 20px;">
            Upload Video Service
        </p>
    </div>
</a>

</body>
</html>
