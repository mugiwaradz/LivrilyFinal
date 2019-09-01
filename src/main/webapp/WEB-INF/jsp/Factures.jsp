<%@ include file="common/header.jspf" %>
<%@ include file="common/naviguationadmine.jspf"%>

<h2 align="center">Liste des factures</h2>
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>Facture_ID</th>
			
					<th>Livraison ID</th>
					<th>Client_ID</th>
				    <th>NumeroFacture</th>
					<th>Tarif</th>
					<th>Tva</th>
					<th>Total</th>
					<th></th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${invoices}" var="invoice">
					<tr>									
					   <td>${invoice.getFacture().getFacture_ID()}</td>
							
						<td>${invoice.getFacture().getLivraison_ID()}</td>
						<td>${invoice.getFacture().getClient_ID()}</td>
						<td>${invoice.getFacture().getNumeroFacture()}</td>
						<td>${invoice.getFacture().getTarif()} DA</td>
						<td>${invoice.getFacture().getTva()}</td>
						<td>${invoice.getFacture().getTotal()}</td>
						<td><a type="button" class="btn btn-success"
						href="/FacturesDetail?id_facture=${invoice.getFacture().getFacture_ID()}">Détail </a></td>
						 <td><a type="button" class="btn btn-primary"
							href="printFacture?id_facture=${invoice.getFacture().getFacture_ID()}">Imprimer</a> </td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<%@ include file="common/footer.jspf" %>