<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
</head>
<body>
<h1>${user.login}</h1>
<h1>${user.email}</h1>
<form:form action="/logout" id="logout" method="post">

</form:form>
<button onclick="document.getElementById('logout').submit();">Logout</button>
</body>
</html>