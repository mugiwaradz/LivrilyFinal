<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Liste des articles </caption>
			<thead>
				<tr>
					<th>Nom</th>
					<th>prix</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produits}" var="produit">
					<tr>
						<td>${produit.getNomProduit()} -${produit.getReferance()}-</td>
						<td>${produit.getPrixDevante()} DA</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${produit.getProduit_ID()}">Commander</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>