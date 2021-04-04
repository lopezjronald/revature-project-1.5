<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Reimbursements</title>
</head>
<body>

<h2>All Reimbursements in the System</h2>
<c:forEach var="reimbursement" items="${REIMBURSEMENT_LIST}">
    <c:url var="updateLink" value="/updateReimbursement">
        <c:param name="id" value="${reimbursement.id}" />
    </c:url>
    <c:url var="deleteLink" value="/reimbursements">
        <c:param name="command" value="DELETE" />
        <c:param name="id" value="${reimbursement.id}" />
    </c:url>
    <p>
        ID #: ${reimbursement.id} |
        Amount: $${reimbursement.amount} |
        Description: ${reimbursement.description} |
        Type ID#: ${reimbursement.typeId}
    </p>
    <p>
        <a href="${updateLink}">Update Reimbursement</a> |
        <a href="${deleteLink}" onclick="if (!(confirm('Confirm: Delete ${reimbursement.id} from the system?'))) return false">Delete Reimbursement</a>
    </p>
    <hr>
</c:forEach>
<h3><a href="${pageContext.request.contextPath}/">Back to Home Page</a></h3>
</body>
</html>
