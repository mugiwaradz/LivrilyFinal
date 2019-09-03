<%@ include file="common/header.jspf" %>
<%@ include file="common/naviguationadmine.jspf"%>
	
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>Fournisseur_ID</th>
					<th>Nom</th>
					<th>prenom</th>
					<th>numeroGestire </th>
					<th>numeroFiscale</th>
					<th>taxid</th>
                    
                    <th></th>
                    <th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Fournisseurs}" var="Fournisseur">
					<tr>
					    <td>${Fournisseur.getFournisseur_ID()}</td>
						<td>${Fournisseur.getUtilisateur().getNom()}</td>
						<td>${Fournisseur.getUtilisateur().getPrenom() }</td>
						<td>${Fournisseur.getNumeroGestire() }</td>
						<td>${Fournisseur.getNumeroFiscale()} </td>				
						<td>${Fournisseur.getTaxid()} </td>						
						<td><a type="button" class="btn btn-danger"
							href="/update-todo?id=${produit.getProduit_ID()}">Supprimer</a> </td>
						<td><a type="button" class="btn btn-warning"
							href="/update-todo?id=${produit.getProduit_ID()}">modifier</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<%@ include file="common/footer.jspf" %>