<%@ page import="cz.endhalf.Person" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authenticated</title>
</head>
<body>
<div>
    <h2>Welcome, ${user.username} </h2>
</div>

</body>
</html>

<!--
    <% Person usr = (Person)request.getAttribute("user"); %>
        <%= usr.getUsername() %>
    -->