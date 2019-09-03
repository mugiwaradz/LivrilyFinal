<%@ include file="common/header.jspf" %>
<div style="background-color:#fffff;padding:30px;text-align:center;">
<body background="back.jpg">
<div style="background-color:#fffff;padding:30px;text-align:center;">
<header> <div> <a href="/"> <img height="50" width="50" alt="" src="Livrily.png"></a> </div> 
<h1 style="color: black;font-size:10vw; font-family: Arial"; > Liste des produits</h1>
 </header>
<center>
<section>

<div class="row">

<br> <br>
<c:forEach items="${produits}" var="produit">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div style align="center" class="card-header">${produit.getNomCategore()} </div>
  <div class="card-body">
    <h5 style align="center" class="card-title">${produit.getNomProduit()}</h5><h4 align="center">${produit.getPrixDevante()} DA</h4> 
    
    <p class="card-text">  <img alt="img" src="${produit.getImage()}" >  </p>
    
		
  </div>
</div>

</c:forEach>
</div>

</div>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>

<%@ include file="common/footer.jspf" %>