<%@ page import="domain.model.Film" %>
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
<header>
    <div class="logotitle">
        <img src="images/YMDb_Logo.png" alt="IMDB">
        <h1>Filmbibliotheek</h1>
    </div>
    <%@include file="nav.jspf" %>
</header>
<main id="home" class="container">
    <h2>Mijn persoonlijke filmbibliotheek</h2>
    <p>Hier houd ik alle film bij die ik onlangs gezien heb.</p>
    <p>Ik zet ze in mijn database met titel, speelduur, datum van kijken en rating.</p>
    <h3>De film met de hoogste rating is:</h3>
    <p id="maxrating">
        <%= ((Film) request.getAttribute("maxr")).getTitel()%> met een lengte van
        <%= ((Film) request.getAttribute("maxr")).getSpeelduurHours()%> en een rating van
        <%= ((Film) request.getAttribute("maxr")).getRating()%>/10.
    </p>
    <h3>De film met de langste speelduur is:</h3>
    <p id="maxspeelduur">
        <%= ((Film) request.getAttribute("maxs")).getTitel()%> met een lengte van
        <%= ((Film) request.getAttribute("maxs")).getSpeelduurHours()%> en een rating van
        <%= ((Film) request.getAttribute("maxs")).getRating()%>/10.
    </p>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>