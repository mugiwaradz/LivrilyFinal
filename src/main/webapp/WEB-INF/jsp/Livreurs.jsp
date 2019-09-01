<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<h2 align="center"> Liste des Livreurs</h2>
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
					    <td >${Livreur.isEst_disponible() }</td>
						<td >${Livreur.getMoyenLivraison() } </td>
						<td>${Livreur.getTypePermetConduire()} </td>				
										
						<td><a type="button" class="btn btn-dark"
							href="/PostLivraison?livreur_id=${Livreur.getLivreur_ID()} ">Ajouter</a> </td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>