<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Resultaat</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value=""/>
</jsp:include>
<main class="container">
    <h2>Zoekresultaat</h2>
    <c:if test="${empty result}">
        <h3>Er is geen film de overeenkomt met je zoekopdracht.</h3>
    </c:if>
    <c:if test="${not empty result}">
        <h3>De film die je zocht is:</h3>
        <p>
                ${result.titel} met een lengte van
                ${result.speelduurHours} uit het jaar
                ${result.jaar} en een rating van
                ${result.rating}/10.
        </p>
    </c:if>
    <p><a href="FilmServlet?page=index">Home</a> indien je niet meer geïnteresseerd bent.</p>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
