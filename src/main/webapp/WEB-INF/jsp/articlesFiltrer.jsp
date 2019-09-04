<%@ include file="common/header.jspf" %>
<body background="back.jpg">
<div style="background-color:#fffff;padding:30px;text-align:center;">
<header> <div> <a href="welcomeClient"> <img height="50" width="50" alt="" src="Livrily.png"></a> </div> 
 <h1 style="color: white;font-size:10vw"> 1 resultat
   <i>${produit.NomProduit()} </i></h1>
</header>

</div>


<div class="card mb-3">
<c:forEach items="${produits}" var="produit">

  <img width="300" height="500" class="card-img-top" src="${produits.getproduit().getImage()}"  alt="market">
  <div class="card-body">
    <h5 class="card-title">${produits.getproduit().NomProduit()} </h5>
    <p class="card-text">${produits.getproduit().PrixDevante()}  
    <p> </p>
    </c:forEach>
  </div>



<%@ include file="common/footer.jspf" %>