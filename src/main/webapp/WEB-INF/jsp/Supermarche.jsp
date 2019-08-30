<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" commandName="Supermarche">

		<fieldset class="form-group">
			<form:label path="NomSupermarche">Nom Supermarche</form:label>
			<form:input path="NomSupermarche" type="text" class="form-control"
				required="required" />
			<form:errors path="NomSupermarche" cssClass="text-warning" />
		</fieldset>

		 <fieldset class="form-group">
			<form:label path="Filiale_ID">Fililae id</form:label>
			<form:input path="Filiale_ID" type="text" class="form-control"
				required="required" />
			<form:errors path="Filiale_ID" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="TelephoneSupermarche">TelephoneSupermarche</form:label>
			<form:input path="TelephoneSupermarche" type="text" class="form-control"
				required="required" />
			<form:errors path="TelephoneSupermarche" cssClass="text-warning" />
		</fieldset>

		

        <fieldset class="form-group">
			<form:label path="EmailSupermarche">EmailSupermarche</form:label>
			<form:input path="EmailSupermarche" type="text" class="form-control"
				required="required" />
			<form:errors path="EmailSupermarche" cssClass="text-warning" />
		</fieldset>
		
		
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>