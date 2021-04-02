<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Reimbursements</title>
</head>
<body>

<h2>All Reimbursements in the System</h2>
<c:forEach var="reimbursement" items="${REIMBURSEMENT_LIST}">
    <c:url var="updateLink" value="/reimbursements">
        <c:param name="reimbursement-command" value="LOAD_REIMBURSEMENT" />
        <c:param name="id" value="${reimbursement.id}" />
    </c:url>
    <c:url var="deleteLink" value="/users">
        <c:param name="reimbursement-command" value="DELETE_REIMBURSEMENT" />
        <c:param name="id" value="${reimbursement.id}" />
    </c:url>
    <p>
        ID #: ${reimbursement.id} |

        Type ID#: ${reimbursement.typeId}
    </p>
    <p>
<%--        <a href="${updateLink}">Update User</a> |--%>
        <a href="${deleteLink}" onclick="if (!(confirm('Confirm: Delete ${reimbursement.id} from the system?'))) return false">Delete Reimbursement</a>
    </p>
    <hr>
</c:forEach>
<h3><a href="${pageContext.request.contextPath}/">Back to Home Page</a></h3>
</body>
</html>
