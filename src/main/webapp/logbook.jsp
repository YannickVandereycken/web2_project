<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logboek</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="icon" href="images/YMDb_Logo_Square.png" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value=""/>
</jsp:include>
<main class="container">
    <h2>Logboek</h2>
    <form action="FilmServlet" method="get" novalidate>
        <input type="hidden" name="page" value="reset">
        <p><input type="submit" value="Reset Logbook"></p>
    </form>
    <c:forEach var="l" items="${logbook}">
        <p>${l}</p>
    </c:forEach>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>