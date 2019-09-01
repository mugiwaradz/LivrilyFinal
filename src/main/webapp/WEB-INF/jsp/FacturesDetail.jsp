<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<h1 align="center">"${invoice.getFacture().getNumeroFacture()}"details</h1>
	<table class="table">
  <thead class="thead-light">
  
             <tr>	
				<th>NumeroFacture</th>
				<td>${invoice.getFacture().getNumeroFacture()}</td>
			</tr>   
			<tr>	
				<th>Tarif</th>
				<td>${invoice.getFacture().getTarif()} DA</td>
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
	
	<table class="table">
					
				<thead class="thead-light">
				<tr>
					
					 <th>FactureLine_ID </th>
				     <th>Facture_ID </th>
			         <th>ProduitID </th>
				     <th>prix </th>
				     <th>QuantityFacture </th>
				     <th>TotalLine </th>
				     
					</tr>
				<c:forEach items="${invoice.getFacturelines()}" var="line">
					<tr>
						<td>${line.getFactureLine_ID()}</td>
						<td>${line.getFacture_ID()}</td>
						<td>${line.getProduitID()} </td>
						<td>${line.getPrix()}</td>
			         	<td>${line.getQuantityFacture()}</td>
			        	<td>${line.getTotalLine()}</td>
			         	
						<td></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	<div align="center">	<a type="button" class="btn btn-danger"
							href="Factures">show less</a> 
		</div>
		
	</br>
		<div align="center">	
		
<%@ include file="common/footer.jspf" %>