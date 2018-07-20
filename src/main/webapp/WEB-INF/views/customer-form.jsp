<%--
  Created by IntelliJ IDEA.
  User: zeki.tel
  Date: 20.07.2018
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error{color: #ff265e
        }
    </style>
</head>
<body>

    <form:form action="processForm" modelAttribute="customer">
        FirstName: <form:input path="firstName"/>
        LastName(*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        FreePasses: <form:input path="freePasses" type="number"/>
        <form:errors path="freePasses" cssClass="error"/>


        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>
