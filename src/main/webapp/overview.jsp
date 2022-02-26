<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            <li><a href="overview.jsp" class="here">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main class="container">
    <h1>Overzicht</h1>
    <table>
        <tr>
            <th>Titel</th>
            <th>Speelduur</th>
            <th>Rating</th>
            <th>Wijzig</th>
            <th>Verwijder</th>
        </tr>
        <tr>
            <td>Dune</td>
            <td>2h30</td>
            <td>9</td>
            <td><a href="#">Wijzig</a></td>
            <td><a href="#">Verwijder</a></td>
        </tr>
        <tr>
            <td>Inception</td>
            <td>2h20</td>
            <td>10</td>
            <td><a href="#">Wijzig</a></td>
            <td><a href="#">Verwijder</a></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="#">Wijzig</a></td>
            <td><a href="#">Verwijder</a></td>
        </tr>
    </table>
</main>
<footer>
    <div class="container">
        <h3>Copyright</h3>
        <p id="copyright"><i>© Yannick Vandereycken</i></p>
    </div>
</footer>
</body>
</html>
