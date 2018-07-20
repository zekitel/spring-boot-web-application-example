<%--
  Created by IntelliJ IDEA.
  User: zeki.tel
  Date: 20.07.2018
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First Name:<form:input path="firstName"></form:input>
    Last Name:<form:input path="lastName"></form:input>
    Country:<form:select path="country">
    <form:options items="${student.countryOptions}"/>
    Operating Systems:
    Linux<form:checkbox path="operatingSystems" value="linux"/>
    Mac OS<form:checkbox path="operatingSystems" value="macOs"/>
    MS Windows<form:checkbox path="operatingSystems" value="MS Windows"/>


</form:select>
    Favorite Language:<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>


    <input type="submit" value="Submit">
</form:form>
</body>
</html>
