<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Film" %>
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
            <td>${f.speelduur}</td>
            <td>${f.jaar}</td>
            <td>${f.rating}</td>
            <td><a href="#">Wijzig</a></td>
            <td><a href="FilmServlet?page=confirmation&titel=${f.titel}" id="remove${f.titel}">Verwijder</a></td>
        </tr>
        </c:forEach>
        <!-- URL = URL.replaceAll("%20", ""); -->
        </tbody>
    </table>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>