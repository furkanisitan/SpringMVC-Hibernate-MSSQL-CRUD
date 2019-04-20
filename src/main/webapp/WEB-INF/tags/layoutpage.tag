<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>

<!doctype html>
<html lang=tr>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
</head>
<body>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.4.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/popper.js/1.15.0/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<jsp:doBody/>

</body>
</html>