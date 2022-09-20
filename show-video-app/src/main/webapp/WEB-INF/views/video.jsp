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
            border-bottom: solid rgb(194, 192, 192);
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            margin-bottom: 30px;
        }
        .video-box{
            background-color: white;
            width: 700px;
            margin: auto;
            height: 600px;
            border: solid #2f2d2d;
            margin-bottom: 10px;
        }
        video {
            width: 700px;
            height: 500px;
            display: block;
            margin: 0 auto;
            border: solid black;
        }
        p {
            background-color: white;
            font-size: 35px;
            font-weight: bold;
            text-align: center;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>HamzaTube</h1>
</div>
<%
    Video video=(Video) request.getAttribute("video");
%>

<div class="video-box">
    <video controls src="<%=video.getUrl()%>"></video>
    <p><%=video.getName()%></p>
</div>

</body>
</html>

