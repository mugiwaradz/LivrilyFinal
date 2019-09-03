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
		<h1 style="font-size: 7vw">Liste Des factures</h1>
	</div>

	<div style="overflow: auto">
		<div class="menu">
			<a style="color: white" " href="#"></a>

		</div>

		<div class="main">
			<br> <br> <br>



			<table class="table" border="2">
				<thead class="thead-light">

					<c:forEach items="${invoices}" var="invoice">
						<tr>
							<th>Facture_ID</th>
							<td>${invoice.getFacture().getFacture_ID()}</td>
						</tr>
						<tr>
							<th>Livraison ID</th>
							<td>${invoice.getFacture().getLivraison_ID()}</td>
						</tr>
						<tr>
							<th>Client_ID</th>
							<td>${invoice.getFacture().getClient_ID()}</td>
						</tr>

						<tr>
							<th>NumeroFacture</th>
							<td>${invoice.getFacture().getNumeroFacture()}</td>
						</tr>

						<tr>
							<th>Tarif</th>
							<td>${invoice.getFacture().getTarif()}DA</td>
						</tr>

						<tr>
							<th>Tva</th>
							<td>${invoice.getFacture().getTva()}</td>
						</tr>

						<tr>
							<th>Total</th>
							<td>${invoice.getFacture().getTotal()}</td>
						</tr>
			</table>
			<div align="center">
				<a type="button" class="btn btn-success"
					href="/FacturesDetail?id_facture=${invoice.getFacture().getFacture_ID()}">Détail
				</a> <a type="button" class="btn btn-primary"
					href="printFacture?id_facture=${invoice.getFacture().getFacture_ID()}">Imprimer</a>
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