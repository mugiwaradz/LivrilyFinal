<%@ include file="common/header.jspf" %>
<div class="container">
<div class="header">
<body background="back.jpg">
		<div align="center"><a href="/welcomeADF" class="logo"><img width="50" height="50" 
				alt="livrily" src="Livrily.png"> </a> </div>
			
<div align="center">
		<h1  style="font-size: 5vw;color: white" >Ajouter nouveau supermarché</h1>
	</div>
	<form:form method="post" commandName="Supermarche">

		<fieldset class="form-group">
			<form:label path="NomSupermarche"> Nom supermarché</form:label>
			<form:input path="NomSupermarche" type="text"  class="form-control"
				required="required"  />
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
		
		
	<div align="center">	<button type="submit" class="btn btn-success">Add</button> </div>
	</form:form>
</div>

</body>
<%@ include file="common/footer.jspf" %>