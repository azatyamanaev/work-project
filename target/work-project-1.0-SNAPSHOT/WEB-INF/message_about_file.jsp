<%--
  Created by IntelliJ IDEA.
  User: monitor
  Date: 29.03.2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        #message {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #message td, #message th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #message tr:nth-child(even){background-color: #f2f2f2;}

        #message tr:hover {background-color: #ddd;}

        #message th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>

<table id="message">
    <tr>
        <th>Dear User</th>
    </tr>
    <tr>
        <td>You can find your uploaded file through this link
            <a href="http://localhost:8080/files/file-name:">http://localhost:8080/files</a></td>
    </tr>
</table>

</body>
</html>
