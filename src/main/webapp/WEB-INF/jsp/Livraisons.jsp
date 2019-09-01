<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>Livraison_ID</th>
					<th>Commande_ID</th>
					<th>setLivreur_ID</th>
		        	<th>NumeroLivraison</th>
				    <th>VolumneTotal</th>
					<th> </th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shipments}" var="shipment">
                        <td>${shipment.getLivraison().getCommande_ID()}</td>
					    <td>${shipment.getLivraison().getLivraison_ID()}</td>
			        	<td>${shipment.getLivraison().getLivreur_ID()}</td>
					    <td>${shipment.getLivraison().getNumeroLivraison()}</td>
						<td>${shipment.getLivraison().getVolumneTotal()} </td>
						<td>  <a type="button" class="btn btn-success"
						href="/LivraisonDetail?id_livraison=${shipment.getLivraison().getCommande_ID()}">Détail</a></td>

						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${produit.getProduit_ID()}">Livrer</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<%@ include file="common/footer.jspf" %>