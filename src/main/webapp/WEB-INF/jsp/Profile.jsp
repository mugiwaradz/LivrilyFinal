
<%@ include file="common/header.jspf"%>
<body background="back.jpg">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<div
		style="background-color: #fffff; padding: 30px; text-align: center;">

		<div class="header">
			<a href="/" class="logo"><img width="50" height="50"
				alt="livrily" src="Livrily.png"> </a>
			<h1 style="color: white;">
				<strong>Mon profile</strong>
			</h1>

		</div>

		<form method="post" action="#">
			
				<div class="form-group col-md-4">
					<input type="text" class="form-control" path="Nom" name="Nom"
						placeholder="${Clients.getUtilisateur().getNom()}">
				</div>
				<div class="form-group col-md-4">
					<input type="text" class="form-control" path="Prenom" name="Prenom"
						placeholder="${Clients.getUtilisateur().getPrenom() }">
				</div>
			
				<div class="form-group col-md-4">
					<input type="text" pattern="MM/DD/YYYY" class="form-control"
						path="DateNaissance" name="DateNaissance"
						placeholder="${Clients.getUtilisateur().getDateNaissance()}">
				</div>
				<div class="form-group col-md-4">
					<input type="text" pattern="MM/DD/YYYY" class="form-control"
						path="DateNaissance" name="DateNaissance"
						placeholder="${Clients.getUtilisateur().getLieudeudeNaissance()}">
				</div>
			
			
				<div class="form-group col-md-4">
					<input type="password" class="form-control" path="Pasword"
						name="Pasword" placeholder="nouveau password">
				</div>
			</div>

			<div align="center">
			</div>
		</form>
</body>
</html>
</body>
</html>