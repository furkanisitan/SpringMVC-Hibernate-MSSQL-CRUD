<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd"/>

<c:choose>
    <c:when test="${empty customer}">
        <c:set var="title" value="Insert"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Update"/>
    </c:otherwise>
</c:choose>

<t:layoutpage>
    <jsp:attribute name="title">${title}</jsp:attribute>

    <jsp:body>

        <div class="container mt-5">

            <form id="customerForm">
                <input type="text" id="id" value="${customer.id}" hidden>

                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="fullname">Fullname</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" id="fullname" name="fullname"
                               required value="${customer.fullname}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="salary">Salary</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="number" id="salary" name="salary"
                               required value="${customer.salary}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="email">Email</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="email" id="email" name="email"
                               required value="${customer.email}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="phoneNumber">Phone</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" id="phoneNumber" name="phoneNumber" required
                               placeholder="xxx-xxx-xxxx" pattern='\d{3}-\d{3}-\d{4}' value="${customer.phoneNumber}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="dob">Date of Birth</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="date" id="dob" name="dob" value="${customer.dateOfBirth}"
                               required min="1900-01-01" max="${currentDate}">
                    </div>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary">${title}</button>
                    <a href="/" class="btn btn-warning">Home Page</a>
                </div>

            </form>

        </div>
        <script>

            $(function () {
                $("#customerForm").submit(function (e) {
                    e.preventDefault(e);

                    $.ajax({
                        type: "post",
                        url: "${pageContext.request.contextPath}/createorupdate",
                        data: {
                            "id": $('#id').val(),
                            "salary": $('#salary').val(),
                            "fullname": $('#fullname').val(),
                            "email": $('#email').val(),
                            "phoneNumber": $('#phoneNumber').val(),
                            "dob": $('#dob').val()
                        },
                        success: function (res) {
                            res = JSON.parse(res);
                            if (res.msg === "OK") {
                                alert("The operation was performed successfully.");
                                if (res.method === "CREATE")
                                    resetData();
                            } else
                                alert("An error occurred during the operation.");
                        },
                        error: function (err) {
                            alert("Error! :\n" + err.message);
                        }
                    });
                });
            });

            function resetData() {
                $('#id').val('');
                $('#salary').val('');
                $('#fullname').val('');
                $('#email').val('');
                $('#phoneNumber').val('');
                $('#dob').val('');
            }
        </script>

    </jsp:body>

</t:layoutpage>