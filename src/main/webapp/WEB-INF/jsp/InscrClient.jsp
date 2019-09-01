<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" action="InscrClient">
		<div class="form-group">
			<label for="utilisateur_id">Utilisateur</label> <input type="text"
				class="form-control" name="utilisateur_id" value="<%= request.getParameter("utilisateur_id") %>" readonly>
			<label for="numCartCredit">Carte Credit</label> <input type="text"
				class="form-control" name="numCartCredit" placeholder="numCartCredit">
		</div>
		<button type="submit" class="btn btn-success">Finaliser Inscription</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>