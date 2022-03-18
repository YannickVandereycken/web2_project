<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Zoek</title>
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
    <article id="form" class="container">
        <h2>Zoek in de filmbibliotheek</h2>
        <form action="FilmServlet" method="post" novalidate>
            <p><label for="titel">Titel</label><input type="text" id="titel" name="titel" required autofocus></p>
            <input type="hidden" name="page" value="searchFilm">
            <p><input type="submit" id="verstuur" value="indienen"></p>
        </form>
    </article>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>
