<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overzicht</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="overview"/>
</jsp:include>
<main class="container">
    <h2>Overzicht</h2>
    <c:choose>
        <c:when test="${not empty filmlist}">
            <table>
                <thead>
                <tr>
                    <th>Titel</th>
                    <th>Speelduur</th>
                    <th>Jaar</th>
                    <th>Rating</th>
                    <th>Wijzig</th>
                    <th>Verwijder</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="f" items="${filmlist}">
                    <tr>
                        <td>${f.titel}</td>
                        <td>${f.speelduurHours}</td>
                        <td>${f.jaar}</td>
                        <td>${f.rating}</td>
                        <td><a href="FilmServlet?page=update&id=${f.id}" id="update${f.id}">Wijzig</a></td>
                        <td><a href="FilmServlet?page=confirmation&id=${f.id}" id="remove${f.id}">Verwijder</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Er zijn geen films </p>
        </c:otherwise>
    </c:choose>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>