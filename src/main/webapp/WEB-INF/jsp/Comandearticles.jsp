<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div style="background-color:#fffff;padding:30px;text-align:center;">
<h2> Liste des produits</h2>
</div>
<div align="right">
<div class="row" >

<br> <br>
<c:forEach items="${produits}" var="produit">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div style align="center" class="card-header">${produit.getNomCategore()}</div>
  <div class="card-body">
    <h5 style align="center" class="card-title">${produit.getNomProduit()}</h5>
    
    <p class="card-text">  <img alt="img" src="${produit.getImage()}" >  </p>
    <p style align="center" "card-text">	<a type="button" class="btn btn-warning" 
							href="Factures">Ajouter au panier</a> </p>
		
  </div>
</div>

</c:forEach>
</div>

</div>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>

<%@ include file="common/footer.jspf" %>