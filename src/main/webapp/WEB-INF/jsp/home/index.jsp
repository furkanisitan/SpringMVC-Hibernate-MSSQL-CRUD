<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layoutpage>
    <jsp:attribute name="title">Index</jsp:attribute>

    <jsp:body>
        <div class="container mt-5">

            <div class="card">
                <div class="card-header bg-white font-weight-bold">
                    <div class="d-flex justify-content-between">
                        Customers
                        <a href="home/create" class="btn btn-sm btn-success">Insert</a>
                    </div>
                </div>

                <div class="card-body">

                    <table class="table table-hover table-responsive-md">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Fullname</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Date of Birth</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="customer" items="${customers}">
                            <tr id="${customer.id}">
                                <td>${customer.id}</td>
                                <td>${customer.fullname}</td>
                                <td>${customer.salary}</td>
                                <td>${customer.email}</td>
                                <td>${customer.phoneNumber}</td>
                                <td class="d-flex justify-content-between align-items-center">${customer.dateOfBirth}
                                    <span>
                                        <button onclick="ajaxpost(${customer.id})" class="btn btn-danger">Delete</button>
                                        <a href="home/update?id=${customer.id}" class="btn btn-primary">Edit</a>
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            function ajaxpost(id) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/delete",
                    data: {"id": id},
                    success: function (res) {
                        res = JSON.parse(res);
                        if (res.msg === "OK") {
                            $('#' + id).remove();
                        } else
                            alert("An error occurred during the operation.");
                    },
                    error: function (err) {
                        alert("Error! :\n" + err.message);
                    }
                });
            }
        </script>

    </jsp:body>

</t:layoutpage>