<html>
<head>
    <title>Add User Form</title>
</head>
<body>
<h2>Add A User</h2>
<form action="${pageContext.request.contextPath}/users" method="get">
    <input type="hidden" name="command" value="UPDATE">
    <input type="hidden" value="1" name="roleId"/>
    <label>Username</label>
    <br><br>
    <input type="text" name="username" placeholder="username"/>
    <br><br>
    <label>Password</label>
    <br><br>
    <input type="text" name="password" placeholder="password"/>
    <br><br>
    <label>First Name</label>
    <br><br>
    <input type="text" name="firstName" placeholder="first name"/>
    <br><br>
    <label>Last Name</label>
    <br><br>
    <input type="text" name="lastName" placeholder="last name"/>
    <br><br>
    <label>Email</label>
    <br><br>
    <input type="text" name="email" placeholder="email"/>
    <br><br>
    <input type="submit" value="Save New User"/>
</form>

<h3><a href="${pageContext.request.contextPath}/">Back to Home Page</a></h3>

</body>
</html>
