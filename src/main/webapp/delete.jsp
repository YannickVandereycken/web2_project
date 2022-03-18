<%@ page import="domain.model.Film" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijderingsbevestiging</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<header>
    <div class="logotitle">
        <img src="images/YMDb_Logo.png" alt="IMDB">
        <h1>Verwijderingsbevestiging</h1>
    </div>
    <%@include file="nav.jspf" %>
</header>
<main class="container">
    <h2>Zoekresultaat</h2>
    <%
        if (request.getAttribute("result") == null) {
            Film f = (Film) request.getAttribute("result");
    %>
    <h3>Er is geen film de overeenkomt met je zoekopdracht.</h3>
    <%
        }
        if (request.getAttribute("result") != null) {
            Film f = (Film) request.getAttribute("result");
    %>
    <h3>De film die je zocht is:</h3>
    <p>
        <%= f.getTitel() %> met een lengte van
        <%= f.getSpeelduurHours()%> uit het jaar
        <%= f.getJaar()%> en een rating van
        <%= f.getRating()%>/10.
    </p>
    <%
        }
    %>
    <p><input type="submit" id="confirm" value="confirm" name="page"> <input type="submit" id="cancel" value="cancel" name="page"></p>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>
