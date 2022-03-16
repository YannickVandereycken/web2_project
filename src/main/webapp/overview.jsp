<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Film" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overzicht</title>
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
            <li><a href="add.jsp">Voeg Toe</a></li>
            <li><a href="FilmServlet" class="here">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main class="container">
    <h2>Overzicht</h2>
    <table>
        <thead>
        <tr>
            <th>Titel</th>
            <th>Speelduur</th>
            <th>Rating</th>
            <th>Jaar</th>
            <th>Wijzig</th>
            <th>Verwijder</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Film> filmlist = (ArrayList<Film>) request.getAttribute("filmlist");
            for (Film f : filmlist) {
        %>
        <tr>
            <td><%= f.getTitel()%></td>
            <td><%= f.getSpeelduurHours()%></td>
            <td><%= f.getJaar()%></td>
            <td><%= f.getRating()%></td>
            <td><a href="#">Wijzig</a></td>
            <td><a href="#">Verwijder</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <h3>De film met de hoogste rating is:</h3>
    <p id="maxrating">
        <%= ((Film) request.getAttribute("maxr")).getTitel()%> met een lengte van
        <%= ((Film) request.getAttribute("maxr")).getSpeelduurHours()%> en een rating van
        <%= ((Film) request.getAttribute("maxr")).getRating()%>/10
    </p>
    <h3>De film met de langste Speelduur is:</h3>
    <p id="maxspeelduur">
        <%= ((Film) request.getAttribute("maxs")).getTitel()%> met een lengte van
        <%= ((Film) request.getAttribute("maxs")).getSpeelduurHours()%> en een rating van
        <%= ((Film) request.getAttribute("maxs")).getRating()%>/10
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