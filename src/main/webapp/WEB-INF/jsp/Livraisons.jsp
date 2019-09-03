<%@ include file="common/header.jspf"%>
<%@ include file="common/naviguationadmine.jspf"%>
<style>
* {
  box-sizing: border-box;
}
.menu {
  float:left;
  width:20%;
  text-align:center;
}
.menu a {
  background-color:white;
  padding:8px;
  margin-top:7px;
  display:block;
  width:100%;
  color:black;
}
.main {
  float:left;
  width:60%;
  padding:0 20px;
}
.right {
  background-color:white;
  float:left;
  width:20%;
  padding:15px;
  margin-top:7px;
  text-align:center;
}

@media only screen and (max-width:620px) {
  /* For mobile phones: */
  .menu, .main, .right {
    width:100%;
  }
}
</style>
</head>
<body style="font-family:Arial;color:#000000;">


	<div
		style="background-color: #e5e5e5; padding: 15px; text-align: center;">
		<h1 style="font-size: 7vw">Liste Livraisons</h1>
	</div>

<div style="overflow:auto">
  <div class="menu">
     <a style="color: white"" href="#"></a>

  </div>

  <div class="main">
<br>
<br>
<br>




	<tbody>
	<c:forEach items="${shipments}" var="shipment">
		<table class="table" border="2">
			<thead class="thead-light">
				<tr>
					<th>Commande_ID</th>
					<td>${shipment.getLivraison().getCommande_ID()}</td>
				</tr>
				<tr>
					<th>Livraison_ID</th>
					<td>${shipment.getLivraison().getLivraison_ID()}</td>
				</tr>
				<tr>
					<th>Livreur_ID</th>
					<td>${shipment.getLivraison().getLivreur_ID()}</td>
				</tr>

				<tr>
					<th>NumeroLivraison</th>
					<td>${shipment.getLivraison().getNumeroLivraison()}</td>
				</tr>

				<tr>
					<th>VolumneTotal</th>
					<td>${shipment.getLivraison().getVolumneTotal()}</td>
				</tr>
		</table>

	<div align="center">	<a type="button" class="btn btn-success"
			href="/LivraisonDetail?id_livraison=${shipment.getLivraison().getLivraison_ID()}">Détail</a> </div>
		<br>
	</c:forEach>
    
  </div>



  <div class="right">
    <h2 style="color: white">About</h2>
    <p style="color: white">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
  </div>
</div>


</body>


	<%@ include file="common/footer.jspf"%>