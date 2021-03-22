<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Result: ${numResult}
<table>
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <td><c:out value="${elem}"/>></td>
            <td><c:out value="${elem.id}"/>></td>
            <td><c:out value="${elem.username}"/>></td>
            <td><c:out value="${elem.password}"/>></td>
            <td><c:out value="${elem.role}"/>></td>
            <td><c:out value="${elem.email}"/>></td>
            <td><c:out value="${elem.phone}"/>></td>
            <td><c:out value="${elem.averageRating}"/>></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
