<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voeg Toe</title>
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
            <li><a href="index.jsp">Home</a></li>
            <li><a href="add.jsp" class="here">Voeg Toe</a></li>
            <li><a href="FilmServlet">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main>
    <article id="form" class="container">
        <h2>Voeg je favoriete films toe</h2>
        <%
            String message="";
            if(request.getAttribute("empty")!=null) message=(String)request.getAttribute("empty");
        %>
        <p class="error"><%= message %></p>
        <form action="FilmServlet" method="post" novalidate>
            <p><label for="titel">Titel*</label><input type="text" id="titel" name="titel" required autofocus></p>
            <p><label for="time">Speelduur (min.)*</label><input type="number" id="time" name="tijd" required></p>
            <p><label for="jaar">Releasejaar*</label><input type="number" id="jaar" name="jaar" required></p>
            <p><label for="rating">Rating*</label><input type="number" id="rating" max="10" min="0" name="rating" required></p>
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
