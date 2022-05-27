<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wijzig</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="add"/>
</jsp:include>
<main class="container">
    <article id="form" class="container">
        <h2>Wijzig de volgende film</h2>
        <c:forEach var="e" items="${errors}">
            <p class="error">${e}</p>
        </c:forEach>
        <form action="FilmServlet" method="post" novalidate>
            <p><label for="titel" ${titelError?"class='error'":""}>Titel</label><input type="text" id="titel" name="titel" value="${titelPrevious}" required autofocus></p>
            <p><label for="tijd" ${tijdError?"class='error'":""}>Speelduur (min.)</label><input type="number" id="tijd" name="tijd" value="${tijdPrevious}" required></p>
            <p><label for="jaar" ${jaarError?"class='error'":""}>Releasejaar</label><input type="number" id="jaar" name="jaar" value="${jaarPrevious}" required></p>
            <p><label for="rating" ${ratingError?"class='error'":""}>Rating/10.0</label><input type="number" id="rating" max="10" min="0" name="rating" value="${ratingPrevious}" required></p>
            <input type="hidden" name="id" value="${id}">
            <input type="hidden" name="page" value="updateFilm">
            <p><input type="submit" id="verstuur" value="Indienen"></p>
        </form>
    </article>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
