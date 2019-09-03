<%@ include file="common/header.jspf" %>
<%@ include file="common/naviguationadmine.jspf"%>
	
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>Nom</th>
					<th>prenom</th>
					<th>Num carte </th>
					<th>DateNaissance</th>
					<th>LieudeudeNaissance</th>
                    <th>Phone1</th>
                    <th>Email</th>
                    <th></th>
                    <th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Clients}" var="client">
					<tr>
						<td>${client.getUtilisateur().getNom()}</td>
						<td>${client.getUtilisateur().getPrenom() }</td>
						<td>${client.getNumCarteCredit()}</td>
						
						<td >${client.getUtilisateur().getDateNaissance() }</td>
						<td >${client.getUtilisateur().getLieudeudeNaissance()} </td>
						<td>${client.getUtilisateur().getPhone1()} </td>				
						<td>${client.getUtilisateur().getEmail()} </td>						
						<td><a type="button" class="btn btn-danger"
							href="/delete-user?id=${client.getUtilisateur().getUtilisateur_ID()}">Supprimer</a> </td>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<%@ include file="common/footer.jspf" %>