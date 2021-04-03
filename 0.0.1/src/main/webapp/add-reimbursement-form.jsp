<html>
<head>
    <title>Add a Reimbursement</title>
</head>
<body>
<h2>Add A Reimbursement</h2>
<form action="${pageContext.request.contextPath}/reimbursements" method="get">
    <input type="hidden" name="command" value="ADD">
    <input type="hidden" value="1" name="typeId"/>
    <input type="hidden" value="1" name="statusId"/>
    <input type="hidden" value="1" name="resolverId"/>
    <input type="hidden" value="1" name="authorId"/>

    <label>Amount</label>
    <br><br>
    <input name="amount" step="0.01" value="0.00" type="number" placeholder="amount"/>
    <br><br>
    <label>Description</label>
    <br><br>
    <input type="text" name="description" placeholder="description"/>
    <br><br>
    <input type="submit" value="Save Reimbursement"/>
</form>

<h3><a href="${pageContext.request.contextPath}/">Back to Home Page</a></h3>

</body>
</html>
