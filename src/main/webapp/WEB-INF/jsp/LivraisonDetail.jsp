<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<h1 align="center"> ${shipment.getLivraison().getNumeroLivraison()} details</h1>

<table class="table">
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
			
		<table class="table">
					
						<thead class="thead-light">
					<tr>
					
					 <th>Livraison_Line_ID </th>
				     <th>Produit_ID </th>
				     <th>Quantitylivre </th>
				     <th>Volume </th>
				     
					</tr>
					</thead>
				
				<c:forEach items="${shipment.getLivraisonlines()}" var="line"> 
					
				<tr>
				    <td>${line.getLivraison_Line_ID()}</td>
				    <td>${line.getProduit_ID()}</td>
				    <td>${line.getQuantitylivre()}</td>
				    <td>${line.getVolume()}</td>
				    
	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div align="center">	<a type="button" class="btn btn-danger"
							href="Livraisons">show less</a> 
	<!-- 		<div> -->
	<!-- 			<a class="button" href="/add-todo">Livrer </a> -->
	<!-- 		</div> -->
</div>
<%@ include file="common/footer.jspf"%>