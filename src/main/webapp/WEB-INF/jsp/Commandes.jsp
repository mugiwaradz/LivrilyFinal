<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<h2 align="center"> liste des Commandes</h2>
<table class="table">
  <thead class="thead-light">
		
			<tr>
				<th>Num�ro commande</th>
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
						href="/CommandeDetail?id_commande=${order.getCommande().getCommande_ID()}">D�tail</a> <a type="button" class="btn btn-success"
						href="/Livreurs?id_commande=${order.getCommande().getCommande_ID()}">Liste Livreurs Disponibles</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 		<div> -->
	<!-- 			<a class="button" href="/add-todo">Livrer </a> -->
	<!-- 		</div> -->
</div>
<%@ include file="common/footer.jspf"%>