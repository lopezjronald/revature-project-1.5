<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>

<h2>All Users in the System</h2>
<c:forEach var="user" items="${USER_LIST}">
    <c:url var="updateLink" value="/updateUser">
        <c:param name="id" value="${user.id}" />
    </c:url>
    <c:url var="deleteLink" value="/users">
        <c:param name="command" value="DELETE" />
        <c:param name="id" value="${user.id}" />
    </c:url>
    <p>
        ID #: ${user.id} |
        Username: ${user.username} |
        Password: ${user.password} |
        First Name: ${user.firstName} |
        Last Name: ${user.lastName} |
        Email: ${user.email} |
        Role #: ${user.roleId}
    </p>
    <p>
        <a href="${updateLink}">Update User</a> |
        <a href="${deleteLink}" onclick="if (!(confirm('Confirm: Delete ${user.username} from the system?'))) return false">Delete User</a>
    </p>
    <hr>
</c:forEach>
<h3><a href="${pageContext.request.contextPath}/">Back to Home Page</a></h3>
</body>
</html>
