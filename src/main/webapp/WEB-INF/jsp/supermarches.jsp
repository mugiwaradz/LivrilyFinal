<%@ include file="common/header.jspf" %>
<body background="back.jpg">
<div style="background-color:#fffff;padding:30px;text-align:center;">
<header> <div> <a href="welcomeClient"> <img height="50" width="50" alt="" src="Livrily.png"></a> </div> 
 <h1 style="color: white;font-size:10vw"> nos 
   Supermarchés</h1>
</header>

</div>


<div class="card mb-3">
<c:forEach items="${markets}" var="market">

  <img width="300" height="500" class="card-img-top" src="${market.getImage_supermarche()}"  alt="market">
  <div class="card-body">
    <h5 class="card-title">${market.getNomSupermarche()} </h5>
    <p class="card-text">${market.getTelephoneSupermarche()}   supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
    <p class="card-text"><small class="text-muted">${market.getEmailSupermarche()}</small></p>
    <
    </c:forEach>
  </div>



<%@ include file="common/footer.jspf" %>