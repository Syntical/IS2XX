<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/test.css" />
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Roforbundet</h1>
<p>Herein you will have an example of a servlet handling a query to your mariaDb and display the results in your web browser
    using payara.
    This is pretty difficult right?
</p>
<div>
    <h3>Legge til en ny person</h3>
    <p>
        <button class="button buttonAdd"><a href="AddBruker.jsp">Legg til ny person</a></button>
    </p>
</div>

<div>
    <h3>Eller vis alle medlemmene</h3>
    <p>
    <button class="button buttonHent"><a href="ReceiveUserNameFromDb">Eller vis alle medlemmene</a></button>
    </p>
</div>


</body>
</html>
