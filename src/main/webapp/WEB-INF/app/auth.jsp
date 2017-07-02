<%@ page import="cz.endhalf.Person" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authenticated</title>
    <% Person usr = (Person)request.getAttribute("user"); %>

</head>
<body>
<div>
    <h2>Welcome, <%= usr.getUsername() %> </h2>
</div>

</body>
</html>