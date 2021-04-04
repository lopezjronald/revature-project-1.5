<html>
<head>
    <title>Add User Form</title>
</head>
<body>
<h2>Add A User</h2>
<form action="${pageContext.request.contextPath}/updateUser" method="post">
    <input type="hidden" name="command" value="ADD">
    <input type="hidden" value="1" name="roleId"/>
    <input type="hidden" value="${user.id}" name="userId"/>

    <label>Username</label>
    <br><br>
    <input type="text" name="username" value="${user.username}" placeholder="username"/>
    <br><br>
    <label>Password</label>
    <br><br>
    <input type="password" name="password" value="${user.password}" placeholder="password"/>
    <br><br>
    <label>First Name</label>
    <br><br>
    <input type="text" name="firstName" value="${user.firstName}" placeholder="first name"/>
    <br><br>
    <label>Last Name</label>
    <br><br>
    <input type="text" name="lastName" value="${user.lastName}" placeholder="last name"/>
    <br><br>
    <label>Email</label>
    <br><br>
    <input type="email" name="email" value="${user.email}" placeholder="email"/>
    <br><br>
    <input type="submit" value="Update User"/>
</form>

<h3><a href="${pageContext.request.contextPath}/">Back to Home Page</a></h3>

</body>
</html>
