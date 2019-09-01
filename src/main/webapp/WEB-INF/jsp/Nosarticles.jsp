<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div style="background-color:#fffff;padding:30px;text-align:center;">

<div class="header">
  <a href="/" class="logo"><img width="50" height="50" alt="livrily" src="Livrily.png"> </a>
 
</div>

<div style="padding-left:20px">
  <h1>Liste des Articles</h1>
</div></div>


<div class="row" >

<br> <br>
<c:forEach items="${produits}" var="produit">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div style align="center" class="card-header">${produit.getNomCategore()}</div>
  <div class="card-body">
    <h5 style align="center" class="card-title">${produit.getNomProduit()}</h5>
    
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