<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voeg Toe</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
</head>
<body>
<header>
    <h1 class="logotitle">Filmbibliotheek</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="add.jsp" class="here">Voeg Toe</a></li>
            <li><a href="FilmServlet">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main>
    <article id="form" class="container">
        <h2>Voeg je favoriete films toe</h2>
        <form action="#">
            <p><label for="titel">Titel*</label><input type="text" id="titel" required autofocus></p>
            <p><label for="time">Speelduur (min.)*</label><input type="number" id="time" required></p>
            <p><label for="rating">Rating*</label><input type="number" id="rating" max="10" min="0" required></p>
            <p><input type="submit" id="verstuur" value="Indienen"></p>
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
