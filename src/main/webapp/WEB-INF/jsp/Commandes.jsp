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
		<h1 style="font-size: 7vw">Liste Commandes</h1>
	</div>

<div style="overflow:auto">
  <div class="menu">
    <a style="color: white"" href="#"></a>
   
  </div>

  <div class="main">
<br>
<br>
<br>


	<c:forEach items="${orders}" var="order">
		<table class="table" border="2">
			<thead class="thead-light">

				<tr>
					<th>Numéro commande</th>
					<td>${order.getCommande().getNumeroCommande()}</td>
				</tr>
				<tr>
					<th>Client</th>
					<td>${order.getCommande().getClinet_ID()}</td>
				</tr>
				<tr>
					<th>Date</th>
					<td>${order.getCommande().getDtaedeCommande()}</td>
				</tr>
				<tr>
					<th>Status</th>
					<td>${order.getCommande().getStatue()}</td>
				</tr>
				<tr>
					<th>Total</th>
					<td>${order.getCommande().getTotal()}</td>
				</tr>
				<tr>
					<th>TVA</th>
					<td>${order.getCommande().getTva()}</td>
				</tr>
		</table>
		<br>
		<div align="center">
			<a type="button" class="btn btn-success"
				href="/CommandeDetail?id_commande=${order.getCommande().getCommande_ID()}">Détail</a>
		</div>
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