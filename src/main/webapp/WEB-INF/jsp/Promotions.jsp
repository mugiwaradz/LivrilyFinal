<%@ include file="common/header.jspf" %>
<div style="background-color:#fffff;padding:30px;text-align:center;">
<body background="back.jpg">
<div style="background-color:#fffff;padding:30px;text-align:center;">
<header> <div> <a href="welcomeClient"> <img height="50" width="50" alt="" src="Livrily.png"></a> </div> 

<h1 style="color: black;font-size:10vw; font-family: Arial"; max > Nos promotions</h1>
 </header>
<center>



<div class="row" >

<br> <br>
<c:forEach items="${Promotions}" var="Promotion">
<div class="card text-white bg-dark mb-3" style="max-width: 50rem;">
  <div style align="center" class="card-header">${Promotion.getNomProduit()} </div>
  <div class="card-body">
    <h5 style align="center" class="card-title"> ${Promotion.getPrixDevante()} DA <br> ${Promotion.getPromotion()}%</h5>
    
    <p class="card-text">  <img alt="img" src="${Promotion.getImage()}" >  </p>
    
		
  </div>
</div>

</c:forEach>
</div>

</div>
		

<%@ include file="common/footer.jspf" %>