<%@ include file="common/header.jspf"%>
<%@ include file="common/naviguationadmine.jspf"%>
<style>
* {
  box-sizing: border-box;
}
.menu {
  float:left;
  width:20%;
  text-align:center;
}
.menu a {
  background-color:white;
  padding:8px;
  margin-top:7px;
  display:block;
  width:100%;
  color:black;
}
.main {
  float:left;
  width:60%;
  padding:0 20px;
}
.right {
  background-color:white;
  float:left;
  width:20%;
  padding:15px;
  margin-top:7px;
  text-align:center;
}

@media only screen and (max-width:620px) {
  /* For mobile phones: */
  .menu, .main, .right {
    width:100%;
  }
}
</style>
</head>
<body style="font-family:Arial;color:#000000;">




	<div
		style="background-color: #e5e5e5; padding: 15px; text-align: center;">
		<h1 style="font-size: 7vw">Liste Livruers</h1>
	</div>
	
	<div align="center">	<h1 style="font-size: 7vw" >commande a livrer</h1>
		
		<div class="form-group col-md-6">
						<input type="number" class="form-control" path="commande_id"
							name="commande_id"
							value="<%=request.getParameter("commande_id")%>"
							readonly="readonly">
					</div>
		
	</div>

<div style="overflow:auto">
  <div class="menu">
    <a style="color: white"" href="#"></a>
   
  </div>

  <div class="main">
<br>
<br>
<br>


	<c:forEach items="${Livreurs}" var="Livreur">
		<table class="table" border="2">
			<thead class="thead-light">

				<tr>
					<th>Livreur_ID</th>
			     <td>${Livreur.getLivreur_ID()}</td>
			    
				</tr>	
				<tr>
					<th>Nom</th>
			<td>${Livreur.getUtilisateur().getNom()}</td>
				</tr>
				<tr>	
					<th>prenom</th>
					<td>${Livreur.getUtilisateur().getPrenom() }</td>
				</tr>
				<tr>
				    <th>est_disponible</th>
				    <td>${Livreur.isEst_disponible() }</td>
				  </tr>
				  <tr>
                    <th>moyenLivraison</th>
                    <td>${Livreur.getMoyenLivraison() } </td>
                  </tr>
                  <tr>
                    <th>typePermetConduire</th>
                    <td>${Livreur.getTypePermetConduire()} </td>


				</tr>
		</table>
		<br>
		<div align="center">
			<form action="/Livraisons" method="post">
						
						    <input type="hidden" name="livreur_id" value="${Livreur.getLivreur_ID()}">
						    <input type="hidden" name="id_commande" value="<%=request.getParameter("commande_id")%>">
						    <c:if test="${Livreur.isEst_disponible()==true}" >
  
						    <button type="submit" class="btn btn-primary">Expédier</button>
						</c:if>
						</form>
						
<br>
	</c:forEach>
    
  </div>

  <div class="right">
    <h2 style="color: white">About</h2>
    <p style="color: white">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
  </div>
</div>


</body>


	<%@ include file="common/footer.jspf"%>