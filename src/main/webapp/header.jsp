<header>
    <div class="logotitle">
        <img src="images/YMDb_Logo.png" alt="IMDB">
        <h1>Filmbibliotheek</h1>
    </div>
    <nav>
        <ul>
            <li><a href="FilmServlet?page=index" ${param.current.equals("index")?"class='here'":""}>Home</a></li>
            <li><a href="FilmServlet?page=overview" ${param.current.equals("overview")?"class='here'":""}>Overzicht</a>
            </li>
            <li><a href="FilmServlet?page=add" ${param.current.equals("add")?"class='here'":""}>Voeg Toe</a></li>
            <li><a href="FilmServlet?page=search" ${param.current.equals("search")?"class='here'":""}>Zoek</a></li>
        </ul>
    </nav>
</header>