<%--
  Created by IntelliJ IDEA.
  User: zeki.tel
  Date: 20.07.2018
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The student is confirmation  : ${student.firstName} ${student.lastName}
Country: ${student.country}
Language: ${student.favoriteLanguage}
OperatingSystems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>

</ul>

</body>
</html>
