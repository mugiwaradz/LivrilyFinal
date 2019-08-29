<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Liste des Livraisons </caption>
			<thead>
				<tr>
					<th>NumeroLivraison</th>
					<th>Livreur id</th>
					<th>VolumneTotal</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shipments}" var="shipment">
					<tr>
						<td>${shipment.getLivraison().getNumeroLivraison()}</td>
						<td>${shipment.getLivraison().getLivreur_ID()}-</td>
						<td>${shipment.getLivraison().getVolumneTotal()} </td>

						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${produit.getProduit_ID()}">Livrer</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>