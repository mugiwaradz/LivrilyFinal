<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div style="background-color:#fffff;padding:30px;text-align:center;">
<h1> des promotions jusqua</h1>
<div class="header"> 
</div>

<div= align="center"">
<img width="150" height="150" alt="pomo" src="50.png"> </div>


<div class="row" >

<br> <br>
<c:forEach items="${Promotions}" var="Promotion">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div style align="center" class="card-header">${Promotion.getNomProduit()} </div>
  <div class="card-body">
    <h5 style align="center" class="card-title"> ${Promotion.getPrixDevante()} DA <br> ${Promotion.getPromotion()}%</h5>
    
    <p class="card-text">  <img alt="img" src="${Promotion.getImage()}" >  </p>
    
		
  </div>
</div>

</c:forEach>
</div>

</div>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>

<%@ include file="common/footer.jspf" %>