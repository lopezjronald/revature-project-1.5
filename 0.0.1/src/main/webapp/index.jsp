<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Servlet CRUD Operations</title>
</head>
<body>
<c:url var="UserJsonLink" value="/users">
    <c:param name="command" value="LIST-JSON" />
</c:url>
<c:url var="ReimbursementJsonLink" value="/reimbursements">
    <c:param name="command" value="LIST_REIMBURSEMENT_JSON" />
</c:url>

<h3>
    <p><a href="${pageContext.request.contextPath}/users">Display All Users</a></p>
    <p><a href="add-user-form.jsp">Add A User</a></p>
    <p><a href="${UserJsonLink}">Users Json List</a></p>
    <br>
    <p><a href="${pageContext.request.contextPath}/reimbursements">Display All Reimbursements</a></p>
    <p><a href="add-reimbursement-form.jsp">Add a Reimbursement</a></p>
    <p><a href="${ReimbursementJsonLink}">Reimbursements Json List</a></p>

</h3>


</body>
</html>
