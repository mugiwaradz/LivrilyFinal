<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<h1 align="center"> Commande details</h1>

<table class="table">
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
			
		<table class="table">
					
						<thead class="thead-light">
					<tr>
					
					 <th>CommandeLine_ID </th>
				     <th>Produit_ID </th>
				     <th>Prix </th>
				     <th>QuantityCommande </th>
				     <th> TotalLine</th>
				     
					</tr>
					</thead>
				
				<c:forEach items="${order.getCommandelines()}" var="line"> 
					
				<tr>
				    <td>${line.getCommandeLine_ID()}</td>
				    <td>${line.getProduit_ID()}</td>
				    <td>${line.getPrix()}</td>
				    <td>${line.getQuantityCommande()}</td>
				    <td>${line.getTotalLine()}</td>
				    
	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div align="center">	<a type="button" class="btn btn-danger"
							href="Commandes">show less</a> 
	<!-- 		<div> -->
	<!-- 			<a class="button" href="/add-todo">Livrer </a> -->
	<!-- 		</div> -->
</div>
<%@ include file="common/footer.jspf"%>