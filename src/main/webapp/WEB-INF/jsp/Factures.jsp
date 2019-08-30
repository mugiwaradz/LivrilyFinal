<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>NumeroFacture</th>
					<th>Tarif</th>
					<th>Tva</th>
					<th>Total</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${invoices}" var="invoice">
					<tr>
						<td>${invoice.getFacture().getNumeroFacture()}</td>
						<td>${invoice.getFacture().getTarif()} DA</td>
						<td>${invoice.getFacture().getTva()}</td>
						<td>${invoice.getFacture().getTotal()}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${facture.getfacture_ID()}">imprimer</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>