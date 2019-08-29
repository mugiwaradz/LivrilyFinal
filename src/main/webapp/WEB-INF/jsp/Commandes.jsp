<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Liste des Commandes</caption>
		<thead>
			<tr>
				<th>Numéro commande</th>
				<th>Client</th>
				<th>Date</th>
				<th>Status</th>
				<th>Total</th>
				<th>TVA</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.getCommande().getNumeroCommande()}</td>
					<td>${order.getCommande().getClinet_ID()}</td>
					<td>${order.getCommande().getDtaedeCommande()}</td>
					<td>${order.getCommande().getStatue()}</td>
					<td>${order.getCommande().getTotal()}</td>
					<td>${order.getCommande().getTva()}</td>
					<td><a type="button" class="btn btn-success"
						href="/Commandes?id_commande=${order.getCommande().getCommande_ID()}">Détail</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 		<div> -->
	<!-- 			<a class="button" href="/add-todo">Livrer </a> -->
	<!-- 		</div> -->
</div>
<%@ include file="common/footer.jspf"%>