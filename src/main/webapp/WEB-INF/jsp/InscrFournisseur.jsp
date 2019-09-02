<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" action="InscrFournisseur">
		<div class="form-group">
			<label for="utilisateur_id">Utilisateur</label> <input type="number"
				class="form-control" name="utilisateur_id" value="<%= request.getParameter("utilisateur_id") %>" readonly>
			<label for="numeroRegistre">numero Registre</label> <input type="number"
				class="form-control" name="numeroRegistre" placeholder="numeroRegistre">
				<label for=numeroFiscale>numero Fiscale</label> <input type="number"
				class="form-control" name="numeroFiscale" placeholder="numeroFiscale">
		<label for="taxId">tax ID</label> <input type="text"
				class="form-control" name="taxId" placeholder="taxId">
		
		</div>
		<button type="submit" class="btn btn-success">Finaliser Inscription</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>