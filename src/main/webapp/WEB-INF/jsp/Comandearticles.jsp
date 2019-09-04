<%@ include file="common/header.jspf"%>
<body background="back.jpg">
	<div
		style="background-color: #fffff; padding: 30px; text-align: center;">
		<header>
			<div>
				<a href="welcomeClient"> <img height="50" width="50" alt=""
					src="Livrily.png"></a>
			</div>
			<h1 style="color: black; font-size: 10vw; font-family: Arial" ; max>
				Liste des produits</h1>
		</header>
		<center>
			<section>

				<div align="center" class="row">

					<br> <br>
					<c:forEach items="${produits}" var="produit">
						<div class="card text-white bg-dark mb-3"
							style="max-width: 16rem;">
							<div style align="center" class="card-header">${produit.getNomCategore()}</div>
							<div class="card-body">
								<h5 style align="center" class="card-title">${produit.getNomProduit()}
									${produit.getPrixDevante()} DA</h5>
								<form class="px-4 py-3" action="add-panier" method="post">
									<input type="hidden" class="form-control" path="product_id"
										name="product_id" value="${produit.getProduit_ID()}">
									<input type="hidden" class="form-control" path="client_id"
										name="client_id" value="<%=request.getParameter("client_id")%>">
									<p class="card-text">
										<img alt="img" src="${produit.getImage()}">
									</p>
									<div class="form-group col-md-6">
										<input type="number" class="form-control" path="qty"
											name="qty" placeholder="quantite" value = "1">
									</div>
									</p>
									<button type="submit" class="btn btn-danger">add to panier</button>
								</form>
							</div>
						</div>
					</c:forEach>
				</div>
	</div>

	<div>
		<form method="post" action = "Commander">
			<button type="submit" class="btn btn-danger">Confirmer votre Commande</button>
		</form>

	</div>
	</section>
	</center>


</body>

<%@ include file="common/footer.jspf"%>