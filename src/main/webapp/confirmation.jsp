<%@ page import="domain.model.Film" %>
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
<header>
    <div class="logotitle">
        <img src="images/YMDb_Logo.png" alt="IMDB">
        <h1>Filmbibliotheek</h1>
    </div>
    <%@include file="nav.jspf" %>
</header>
<main class="container">
    <h2>Verwijdering van deze film</h2>
    <p>Ben je zeker dat je de film ${param.titel} wilt verwijderen?</p>
    <form action="FilmServlet" method="post" novalidate>
        <input type="hidden" name="titel" value="${param.titel}">
        <p><input type="submit" id="confirm" value="Bevestig" name="page">
            <input type="submit" id="cancel" value="Annuleer" name="page"></p>
    </form>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>
