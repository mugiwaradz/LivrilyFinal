<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" commandName="Article">

		<fieldset class="form-group">
			<form:label path="NomProduit">NomProduit</form:label>
			<form:input path="NomProduit" type="text" class="form-control"
				required="required" />
			<form:errors path="NomProduit" cssClass="text-warning" />
		</fieldset>

		 <fieldset class="form-group">
			<form:label path="CategoreProduit_ID">categorie</form:label>
			<form:input path="CategoreProduit_ID" type="text" class="form-control"
				required="required" />
			<form:errors path="CategoreProduit_ID" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="PrixDachat">prix dachat</form:label>
			<form:input path="PrixDachat" type="text" class="form-control"
				required="required" />
			<form:errors path="PrixDachat" cssClass="text-warning" />
		</fieldset>

		

        <fieldset class="form-group">
			<form:label path="PrixDevante">prix de vante</form:label>
			<form:input path="PrixDevante" type="text" class="form-control"
				required="required" />
			<form:errors path="PrixDevante" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="Fournisseur_ID">fournisseur id</form:label>
			<form:input path="Fournisseur_ID" type="text" class="form-control"
				required="required" />
			<form:errors path="Fournisseur_ID" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="Referance">refferance</form:label>
			<form:input path="Referance" type="text" class="form-control"
				required="required" />
			<form:errors path="Referance" cssClass="text-warning" />
		</fieldset>

		

		<fieldset class="form-group">
			<form:label path="Image">image</form:label>
			<form:input path="Image" type="text" class="form-control"
				required="required" />
			<form:errors path="Image" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="quantite">Quantite</form:label>
			<form:input path="quantite" type="text" class="form-control"
				required="required" />
			<form:errors path="quantite" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>