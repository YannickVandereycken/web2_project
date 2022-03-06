<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Filmbibliotheek</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
</head>
<body>
<header>
    <h1 class="logotitle">Filmbibliotheek</h1>
    <nav>
        <ul>
            <li><a href="index.jsp" class="here">Home</a></li>
            <li><a href="add.jsp">Voeg Toe</a></li>
            <li><a href="FilmServlet">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main id="home" class="container">
    <h1>Mijn persoonlijke filmbibliotheek</h1>
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