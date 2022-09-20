<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }
        form {
            background-color: white;
            margin:10% auto auto auto;
            border: 1px solid white;
            border-radius: 1.5%;
            width: 35%;
        }
        .input {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: none;
            box-sizing: border-box;
            background-color: white;
            border-bottom: solid black;

            color: black;
            font-size: large;
            font-weight: bold;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;

        }
        .input:enabled{
            border: none;
            box-sizing: border-box;
            background-color: white;
            border-bottom: solid black;
        }
        .input:focus{
            border: none;
            background-color: white;
            border-bottom: solid black;
        }
        .input:active{
            border: none;
            background-color: white;
            border-bottom: solid black;
        }
        .input:-webkit-autofill,
        .input:-webkit-autofill:hover,
        .input:-webkit-autofill:focus,
        .input:-webkit-autofill:active{
            -webkit-box-shadow: 0 0 0 30px white inset !important;
        }
        .input::selection {
            color: black;
            background: gray;
        }
        button {
            background-color: black;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }

        button:hover {
            opacity: 0.8;
        }
        .container {
            padding: 20px;
        }
        span.psw {
            float: right;
            padding-top: 16px;
        }
        ::placeholder{
            color: black;
            font-size: large;
            font-weight: bold;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }
        .input::selection{
            border: none;
            border-bottom: solid black;
        }
        .logo{
            text-align: center;
            font-size: 36px;
            font-weight: bold;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        }
        ::-webkit-file-upload-button{
            visibility: hidden;;
        }

        .inputfile {
            border: solid black;
            cursor: pointer;
            text-align: center;
        }
        .nextpage{
            position: absolute ;
            bottom: 0;
            right: 0;
            color: white;
            content: "\2192";
        }
        span {
            font-size: 70px;
        }
    </style>
</head>
<body>
<form  action="${pageContext.request.contextPath}/video/upload" method="post" enctype="multipart/form-data">
    <div class="container">
        <p class="logo">HamzaTube</p>
        <input class="input"type="text" placeholder="Video Name" name="name" required>
        <input id="videoCover"  type="file"  name="videoCover" required style=" display:none;">
        <label for="videoCover" class="input inputfile">Video Cover</label>
        <input  id="video" type="file"  name="video" required style=" display:none;">
        <label class="input inputfile" for="video">Video</label>
        <button type="submit">Upload</button>
    </div>
</form>
<a href="http://localhost:8083/api/video">
    <div class="nextpage">
        <p style="display:inline;position: relative; bottom: 10px; font-size: 20px;">
            Show Video Service
        </p>
        <span > &#8594;</span>
    </div>
</a>
</body>
</html>
