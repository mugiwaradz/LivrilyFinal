<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Liste des Clients </caption>
			<thead>
				<tr>
					<th>Nom</th>
					<th>prenom</th>
					<th>Num carte </th>
					<th>DateNaissance</th>
					<th>LieudeudeNaissance</th>
                    <th>Phone1</th>
                    <th>Email</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Clients}" var="client">
					<tr>
						<td>${client.getUtilisateur().getNom()}</td>
						<td>${client.getUtilisateur().getPrenom() }</td>
						<td>${client.getNumCarteCredit()}</td>
						 </>
						<td >${client.getUtilisateur().getDateNaissance() }</td>
						<td >${client.getUtilisateur().getLieudeudeNaissance()} </td>
						<td>${client.getUtilisateur().getPhone1()} </td>				
						<td>${client.getUtilisateur().getEmail()} </td>						
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