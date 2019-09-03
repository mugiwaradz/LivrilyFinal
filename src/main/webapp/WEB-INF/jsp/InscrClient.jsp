<%@ include file="common/header.jspf"%>
<body background="back.jpg">
	<div class="container">

		<div
			style="background-color: #fffff; padding: 30px; text-align: center;">

			<div class="header">
				<a href="/" class="logo"><img width="50" height="50"
					alt="livrily" src="Livrily.png"> </a>
				<h1 style="color: white;">
					<strong>Inscrivez-vous</strong>
				</h1>

			</div>

			<form method="post" action="InscrClient">
				<div class="form-row">
					<div class="form-group col-md-6">
						<input type="number" class="form-control" path="utilisateur_id"
							name="utilisateur_id"
							value="<%=request.getParameter("utilisateur_id")%>"
							readonly="readonly">
					</div>
					<div class="form-group col-md-6">
						<input type="number" class="form-control" path="Carte Credit"
							name="numCartCredit" placeholder="votre numCartCredit">
					</div>
				</div>
				<div align="center">  
				<button class=" btn btn-primary" onclick="getLocation()">Your position</button> </div> <br> <br>
				<button type="submit" class="btn btn-success">Finaliser Inscription</button>
			</form>
		</div>
		

<p id="demo"></p>

<script >
var x = document.getElementById("demo");

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else { 0
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}

function showPosition(position) {	
   x.innerHTML = " 	<div class=\"form-group col-md-6\">	<input type=\"number\" class=\"form-control\" path=\"Latitude\"	name=\"latitude\" value=\"" + position.coords.latitude  + "\"> </div> " 
   +  " 	<div class=\"form-group col-md-6\">	<input type=\"number\" class=\"form-control\" path=\"Longitude\"	name=\"longitude\" value=\"" + position.coords.longitude  + "\"> </div> "
    
}
</script>
		
		<%@ include file="common/footer.jspf"%>