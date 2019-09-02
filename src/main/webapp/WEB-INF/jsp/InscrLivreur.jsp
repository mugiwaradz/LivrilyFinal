<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" action="InscrLivreur">
		<div class="form-group">
			<label for="utilisateur_id">Utilisateur</label> <input type="text"
				class="form-control" name="utilisateur_id" value="<%= request.getParameter("utilisateur_id") %>" readonly>
			<label for="moyenLivraison">Moyen Livraison</label> <input type="text"
				class="form-control" name="moyenLivraison" placeholder="moyenLivraison">
				<label for="typePermetConduire">Type de Permis de conduire</label> <input type="text"
				class="form-control" name="typePermetConduire" placeholder="typePermetConduire">
		<label for="distanceMax">Disnance max</label> <input type="number"
				class="form-control" name="distanceMax" placeholder="distanceMax">
		
		</div>
		<button type="submit" class="btn btn-success">Finaliser Inscription</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>