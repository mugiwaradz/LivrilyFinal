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
		<h1 style="font-size: 7vw"><i> ${invoice.getFacture().getNumeroFacture()}</i> details</h1>
	</div>

	<div style="overflow: auto">
		<div class="menu">
		    <a style="color: white"" href="#"></a>
		</div>

		<div class="main">
			<br> <br> <br>

			<table class="table" border="2">
				<thead class="thead-light">

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

			<table border="2">

				<thead class="thead-light">
					<tr>

						<th>Line_ID</th>
						<th>Facture_ID</th>
						<th>ProduitID</th>
						<th>prix</th>
						<th>Quantité</th>
						<th>TotalLine</th>

					</tr>
					<c:forEach items="${invoice.getFacturelines()}" var="line">
						<tr>
							<td>${line.getFactureLine_ID()}</td>
							<td>${line.getFacture_ID()}</td>
							<td>${line.getProduitID()}</td>
							<td>${line.getPrix()}</td>
							<td>${line.getQuantityFacture()}</td>
							<td>${line.getTotalLine()}</td>

							<td></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div align="center">
				<a type="button" class="btn btn-danger" href="Factures">show
					less</a>
			</div>



		</div>
		<div class="right">
			<h2 style="color: white">About</h2>
    <p style="color: white">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
		</div>
	</div>

</body>


<%@ include file="common/footer.jspf"%>