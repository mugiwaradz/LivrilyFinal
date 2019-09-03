
<%@ include file="common/header.jspf"%>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 10;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}


</style>
</head>
<body background="back.JPG" style="font-family: Arial; color: #000000;">

<nav style="width: 100%" class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="welcomeADS"> <img   width="42" height="42 alt="livrily" src="/Livrily.png" > </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/articles">Articles <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Commandes">Commandes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Livraisons">Livraisons</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Factures">Factures</a>
      </li>
       </ul>
    

  </div>

</nav>
	<div
		style="background-color: #e5e5e5; padding: 15px; text-align: center;">
		<img width="50" height="50" src="/AF.png">
		<h1 style="font-size: 7vw">Admine du Filiale</h1>
	</div>

	<div style="overflow: auto">
		<div class="menu">

			<div>
				<img width="50" height="50" alt="" src="/scooter-livraison.png">
				<a href="/Livreurs">Liste des Livreurs</a>
			</div>
			<div>
				<img width="50" height="50" alt="" src="/admin-icon-png-19.jpg">
				<a href="/Fournisseurs">Liste des Fournisseurs</a>
			</div>
			<br>
			<div>
				<img width="50" height="50" alt="" src="/47950.png"> <a
					href="/Clients">Liste des Clients</a>
			</div>
			<br> <br>
			<br> <br>
		</div>

		<div class="main">
			<img alt="" src="dezitholk.png">
		

		</div>

		
	</div>

	










	<%@ include file="common/footer.jspf"%>