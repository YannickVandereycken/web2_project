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
</head>
<body>
<header>
    <h1 class="logotitle">Filmbibliotheek</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="add.jsp">Voeg Toe</a></li>
            <li><a href="FilmServlet" class="here">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main class="container">
    <h1>Overzicht</h1>
    <table>
        <thead>
        <tr>
            <th>Titel</th>
            <th>Speelduur</th>
            <th>Rating</th>
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
            <td><%= f.getRating()%></td>
            <td><a href="#">Wijzig</a></td>
            <td><a href="#">Verwijder</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <h2>De film met de hoogste rating is:</h2>
    <p id="maxrating">
        <%= ((Film) request.getAttribute("maxr")).getTitel()%> met een lengte van
        <%= ((Film) request.getAttribute("maxr")).getSpeelduurHours()%> en een rating van
        <%= ((Film) request.getAttribute("maxr")).getRating()%>/10
    </p>
    <h2>De film met de langste Speelduur is:</h2>
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