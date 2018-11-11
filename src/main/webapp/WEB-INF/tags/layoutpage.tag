<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>

<!doctype html>
<html lang=tr>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
</head>
<body>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/popper.js/popper.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<jsp:doBody/>

</body>
</html>