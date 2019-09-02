


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
}

h3, h4 {
	margin: 10px 0 30px 0;
	letter-spacing: 10px;
	font-size: 20px;
	color: #111;
}

.container {
	padding: 80px 120px;
}

.person {
	border: 10px solid transparent;
	margin-bottom: 25px;
	width: 80%;
	height: 80%;
	opacity: 0.7;
}

.person:hover {
	border-color: #f1f1f1;
}

.carousel-inner img {
	-webkit-filter: grayscale(90%);
	filter: grayscale(90%); /* make all photos black and white */
	width: 100%; /* Set width to 100% */
	margin: auto;
}

.carousel-caption h3 {
	color: #fff !important;
}

@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
		/* Hide the carousel text when the screen is less than 600 pixels wide */
	}
}

.bg-1 {
	background: #2d2d30;
	color: #bdbdbd;
}

.bg-1 h3 {
	color: #fff;
}

.bg-1 p {
	font-style: italic;
}

.list-group-item:first-child {
	border-top-right-radius: 0;
	border-top-left-radius: 0;
}

.list-group-item:last-child {
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.thumbnail {
	padding: 0 0 15px 0;
	border: none;
	border-radius: 0;
}

.thumbnail p {
	margin-top: 15px;
	color: #555;
}

.btn {
	padding: 10px 20px;
	background-color: #333;
	color: #f1f1f1;
	border-radius: 0;
	transition: .2s;
}

.btn:hover, .btn:focus {
	border: 1px solid #333;
	background-color: #fff;
	color: #000;
}

.modal-header, h4, .close {
	background-color: #333;
	color: #fff !important;
	text-align: center;
	font-size: 30px;
}

.modal-header, .modal-body {
	padding: 40px 50px;
}

.nav-tabs li a {
	color: #777;
}

#googleMap {
	width: 100%;
	height: 400px;
	-webkit-filter: grayscale(100%);
	filter: grayscale(100%);
}

.navbar {
	font-family: Montserrat, sans-serif;
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	font-size: 11px !important;
	letter-spacing: 4px;
	opacity: 0.9;
}

.navbar li a, .navbar .navbar-brand {
	color: #d5d5d5 !important;
}

.navbar-nav li a:hover {
	color: #fff !important;
}

.navbar-nav li.active a {
	color: #fff !important;
	background-color: #29292c !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
}

.open .dropdown-toggle {
	color: #fff;
	background-color: #555 !important;
}

.dropdown-menu li a {
	color: #000 !important;
}

.dropdown-menu li a:hover {
	background-color: red !important;
}

footer {
	background-color: #2d2d30;
	color: #f5f5f5;
	padding: 32px;
}

footer a {
	color: #f5f5f5;
}

footer a:hover {
	color: #777;
	text-decoration: none;
}

.form-control {
	border-radius: 0;
}

textarea {
	resize: none;
}
</style>

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="50">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/"><img alt="livrily"
					src="Livrily.png" width="40"height="30"> </a>
					 
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Inscrire">INSCRIRE</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">LOGIN <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li id="login">
								<form class="px-4 py-3" action="login" method="post">
									<div class="form-group">
										<div align="center">
											<label for="login" style="font-family: Arial;">LOGIN</label>
										</div>
										<input type="text" class="form-control" name="login"
											placeholder="login">
									</div>
									<div class="form-group">
										<div align="center">
											<label for="password" style="font-family: Arial;">PASWORD</label>
										</div>
										<input type="password" class="form-control" name="password"
											placeholder="Password">
									</div>
									<div class="form-check">

										<div align="center">
											<button type="submit" class="btn btn-primary">Sign
												in</button>
										</div>
								</form>
							</li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">CONSULTER <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Nosarticles">nos Articles</a></li>
							<li><a href="Nospromotions">Promotions</a></li>
							<li><a href="#">Supermarche</a></li>
						</ul></li>
					<li><form  class="form-inline my-2 my-lg-0" mr-auto action="getarticle" method="get">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Rechercher " aria-label="Search">
							<button class="btn primary btn-sm" type="submit">RECHERCHER</button>
						</form></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="1.jpg" alt="shope" width="1200" height="700">
				<div class="carousel-caption">
					<h2>Livraison a domicile</h2>
					<p>Livraison a domicile</p>
				</div>
			</div>

			<div class="item">
				<img src="2.jpg" alt="shope" width="1200" height="700">
				<div class="carousel-caption">
					<h2>Pofiter de nos articles</h2>
					<p>Livirily vos offre plusiurs catégorie des produits pour
						bien enrichire votre veux.</p>
				</div>
			</div>

			<div class="item">
				<img src="3.jpg" alt="livraison" width="1200" height="700">
				<div class="carousel-caption">
					<h2>Prerparer votre Panier</h2>
					<p>tu peut maintent prand une panier et faire un shopping dans
						nos supermarché.!</p>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>


	<footer class="text-center">
		<div>
			<a href="https://www.instagram.com/zshockisme/"> <img width="80"
				height="80" alt="img" src="fb.png">
			</a>
		</div>
		<ul class="list-unstyled mb-0">
			<li><i class="fas fa-map-marker-alt fa-2x"></i>
				<p>contact@https://www.instagram.com/livrily</p></li>
			<li><i class="fas fa-phone mt-4 fa-2x"></i>
				<p>+ 213 672 28 83 29</p></li>
			<li><i class="fas fa-envelope mt-4 fa-2x"></i>
				<p>Constantine, elkhroub 25100, ALG</p></li>
		</ul>
	</footer>

	<script>

  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>




	<%@ include file="common/footer.jspf"%>