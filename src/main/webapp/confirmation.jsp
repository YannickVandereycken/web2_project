<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Bevestiging</title>
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
    <article class="container">
        <h2>Verwijdering van deze film</h2>
        <p>Ben je zeker dat je de film ${db.vindId(param.id).titel} wilt verwijderen?</p>
        <form action="FilmServlet" method="post" novalidate>
            <input type="hidden" name="id" value="${param.id}">
            <p><input type="submit" id="confirm" value="Bevestig" name="page" class="confirm"></p>
            <p><input type="submit" id="cancel" value="Annuleer" name="page" class="cancel"></p>
        </form>
    </article>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
