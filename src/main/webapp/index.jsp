<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Filmbibliotheek</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<header>
    <div  class="logotitle">
        <img src="images/YMDb_Logo.png" alt="IMDB">
        <h1>Filmbibliotheek</h1>
    </div>
    <nav>
        <ul>
            <li><a href="index.jsp" class="here">Home</a></li>
            <li><a href="add.jsp">Voeg Toe</a></li>
            <li><a href="FilmServlet">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main id="home" class="container">
    <h2>Mijn persoonlijke filmbibliotheek</h2>
    <p>Hier houd ik alle film bij die ik onlangs gezien heb.</p>
    <p>Ik zet ze in mijn database met titel, speelduur, datum van kijken en rating.</p>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>