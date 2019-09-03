<%@ include file="common/header.jspf" %>
<%@ include file="common/naviguationadmine.jspf"%>
	
	
	<h2 align="center"> Commande a livrer</h2>
	
	<div class="form-group col-md-6">
						<input type="number" class="form-control" path="commande_id"
							name="commande_id"
							value="<%=request.getParameter("commande_id")%>"
							readonly="readonly">
					</div>
					
	<h2 align="center"> Liste des Livreurs disponible</h2>
	
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>Livreur_ID</th>
					<th>Nom</th>
					<th>prenom</th>
				    <th>est_disponible</th>
                    <th>moyenLivraison</th>
                    <th>typePermetConduire</th>
                    <th></th>
                    <th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Livreurs}" var="Livreur">
					<tr>
					    <td>${Livreur.getLivreur_ID()}</td>
						<td>${Livreur.getUtilisateur().getNom()}</td>
						<td>${Livreur.getUtilisateur().getPrenom() }</td>
					    <td>${Livreur.isEst_disponible() }</td>
						<td>${Livreur.getMoyenLivraison() } </td>
						<td>${Livreur.getTypePermetConduire()} </td>			
						<td><a type="button" class="btn btn-dark" 
							href="/Livraisons?livreur_id=${Livreur.getLivreur_ID()}&id_commande=<%=request.getParameter("commande_id")%>">Expédier</a> </td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<%@ include file="common/footer.jspf" %>