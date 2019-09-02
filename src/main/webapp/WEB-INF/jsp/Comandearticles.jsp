<%@ include file="common/header.jspf" %>
<body background="back.jpg">
<div style="background-color:#fffff;padding:30px;text-align:center;">
<header> <div> <a href="welcomeClient"> <img height="50" width="50" alt="" src="Livrily.png"></a> </div> 
<h1 style="color: white; font-family: Arial"; max > Liste des produits</h1>
 </header>
<center>
<section>

<div align="center" class="row" >

<br> <br>
<c:forEach items="${produits}" var="produit">
<div class="card text-white bg-dark mb-3" style="max-width: 13.5rem;">
  <div style align="center" class="card-header">${produit.getNomCategore()}</div>
  <div class="card-body">
    <h5 style align="center" class="card-title">${produit.getNomProduit()}</h5>
    
    <p class="card-text">  <img alt="img" src="${produit.getImage()}" >  </p>
    <p style align="center"><input type="number" name=quantite placeholder="quantité" > </p>
    <p style align="center" "card-text"><a href="Factures">	<img height="50" width="50" alt="" src="Livrily.png"></a>
    
					
		
  </div>
</div>

</c:forEach>
</div>

</div>
		
		</section>
		</center>
			<a class
			="button" href="/add-todo">Add a Todo</a>
		
</body>
  
<%@ include file="common/footer.jspf" %>