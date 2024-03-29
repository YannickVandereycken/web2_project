<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Filmbibliotheek</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="index"/>
</jsp:include>
<main class="container">
    <h2>Mijn persoonlijke filmbibliotheek</h2>
    <p>Hier kan je alle films bijhouden die je onlangs gezien hebt.</p>
    <p>Een filmdatabase voor de echte filmfanaten.</p>
    <p>Ze worden bijgehouden met hun titel, speelduur, releasejaar en rating op 10.</p>
    <c:choose>
        <c:when test="${not empty filmlist}">
            <h3>De film met de hoogste rating is:</h3>
            <p id="maxrating">
                    ${maxr.titel} met een lengte van
                    ${maxr.speelduurHours} en een rating van
                    ${maxr.rating}/10.
            </p>
            <h3>De film met de langste speelduur is:</h3>
            <p id="maxspeelduur">
                    ${maxs.titel} met een lengte van
                    ${maxs.speelduurHours} en een rating van
                    ${maxs.rating}/10.
            </p>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <form action="FilmServlet" method="get" novalidate>
        <input type="hidden" name="page" value="goLogbook">
        <p><input type="submit" value="Logbook"></p>
    </form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>