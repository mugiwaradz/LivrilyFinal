<%@ include file="common/header.jspf"%>
<%@ include file="common/naviguationadmine.jspf"%>
<style>
* {
	box-sizing: border-box;
}

.menu {
	float: left;
	width: 20%;
	text-align: center;
}

.menu a {
	background-color: white;
	padding: 8px;
	margin-top: 7px;
	display: block;
	width: 100%;
	color: black;
}

.main {
	float: left;
	width: 60%;
	padding: 0 20px;
}

.right {
	background-color: white;
	float: left;
	width: 20%;
	padding: 15px;
	margin-top: 7px;
	text-align: center;
}

@media only screen and (max-width:620px) {
	/* For mobile phones: */
	.menu, .main, .right {
		width: 100%;
	}
}
</style>
</head>
<body style="font-family: Arial; color: #000000;">


	<div
		style="background-color: #e5e5e5; padding: 15px; text-align: center;">
		<h1 style="font-size: 7vw">detail commande</h1>
	</div>

	<div style="overflow: auto">
		<div class="menu">
			<a style="color: white" " href="#"></a>

		</div>

		<div class="main">
			<br> <br> <br>

			<table class="table" border="2">
				<thead class="thead-light">

					<tr>
						<th>Num�ro commande</th>
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

			<table border="2">

				<thead class="thead-light">
					<tr>

						<th>Line_ID</th>
						<th>Produit_ID</th>
						<th>Prix</th>
						<th>Quantit�</th>
						<th>TotalLine</th>

					</tr>
				</thead>

				<c:forEach items="${order.getCommandelines()}" var="line">

					<tr>
						<td style="width: 2px; height: 20px">${line.getCommandeLine_ID()}</td>
						<td>${line.getProduit_ID()}</td>
						<td>${line.getPrix()}</td>
						<td>${line.getQuantityCommande()}</td>
						<td>${line.getTotalLine()}</td>


					</tr>
				</c:forEach>
				</tbody>
			</table>
			<br>
			<div align="center">
				<a type="button" class="btn btn-danger" href="Commandes">show
					less</a>
			</div>

		</div>
		<div class="right">
			<h2 style="color: white">About</h2>
			<p style="color: white">Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit.</p>
		</div>
	</div>
	</div>

</body>


<%@ include file="common/footer.jspf"%>