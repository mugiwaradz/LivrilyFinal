<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<h2 align="center"> Liste des Produits</h2>
<table class="table">
  <thead class="thead-light">
    <tr>
                    <th>Produit_ID</th>
					<th>Nom</th>
					<th>Referance</th>
					<th>Categorie </th>
					<th>Prix de vante</th>
					<th>prix d'achat</th>
					<th>fournisseur_id</th>
					<th>Image</th>
					<th>promotion</th>
					<th>Quantite</th>

					<th></th>
					<th></th>

    </tr>
  </thead>
  <tbody>
    
    <tr>
    					<c:forEach items="${produits}" var="produit">
                        <td>${produit.getProduit_ID()} </td>
						<td>${produit.getNomProduit()} </td>
						<td>${produit.getReferance()}</td>
						<td>${produit.getNomCategore()} </td>
						<td>${produit.getPrixDevante()} DA</td>
						<td>${produit.getPrixDachat()} DA</td>
						<td>${produit.getFournisseur_ID()}</td>
						<td><img style height="40" width="40" alt="img" src="${produit.getImage()}">  </td>
						<td>${produit.getPromotion() } %</td>
						<td>${produit.getQuantite()} </td>

						
						<td><a type="button" class="btn btn-danger"
							href="/delete-article?id=${produit.getProduit_ID()}">Supprimer</a> </td>
						<td><a type="button" class="btn btn-warning"
							href="/update-todo?id=${produit.getProduit_ID()}">modifier</a> </td>
						
					</tr>
				</c:forEach>
    </tr>
  </tbody>
</table>
	<div align="center"><a type="button" class="btn btn-success"
							href="/add-Article">Ajouter un nouveau produit</a> </div>

		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>