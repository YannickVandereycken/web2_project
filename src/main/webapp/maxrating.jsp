<%@ page import="domain.model.Film" %><%--
  Created by IntelliJ IDEA.
  User: yannick
  Date: 05/03/2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film met de hoogste rating</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <li><a href="overview.jsp">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main class="container">
    <h2>De film met de hoogste rating is:</h2>
    <p id="result">
        <%= ((Film) request.getAttribute("maxr")).getTitel()%> met een lengte van
        <%= ((Film) request.getAttribute("maxr")).getSpeelduur()%> en een rating van
        <%= ((Film) request.getAttribute("maxr")).getRating()%>/10
    </p>
    <a href="overview.jsp">Terug naar het overzicht</a>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>
