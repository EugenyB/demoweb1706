<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 17.06.2022
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artists</title>
    <link rel="stylesheet" type="text/css" href="style.css" >
</head>
<body>
    <h1>All artists</h1>
    <jsp:useBean id="ab" type="com.example.demoweb1706.ArtistBean" scope="request"/>
    <table>
        <c:forEach items="${ab.artists}" var="a">
        <tr>
            <td>${a.id}</td>
            <td>${a.name}</td>
        </tr>
        </c:forEach>
    </table>
    <h2>Current: ${ab.current.name}</h2>
</body>
</html>
