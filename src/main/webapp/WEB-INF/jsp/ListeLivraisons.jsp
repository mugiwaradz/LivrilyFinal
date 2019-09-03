<%@ include file="common/header.jspf" %>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="welcomeLivreur"> <img   width="42" height="42 alt="livrily" src="/Livrily.png" > </a>
  
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      
      <li class="nav-item">
        <a class="nav-link" href="ListeLivraisons">Livraisons</a>
      </li>
      
       </ul>
       
  </div>

</nav>
<h1 align="center" style="font-size: 7vw">Votre Livraison</h1>
	<table class="table">
  <thead class="thead-light">
				<tr>
					<th>Livraison_ID</th>
		        	<th>NumeroLivraison</th>
				    <th>VolumneTotal</th>
					<th>Est Livrer </th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shipments}" var="shipment">
					    <td>${shipment.getLivraison().getLivraison_ID()}</td>
					    <td>${shipment.getLivraison().getNumeroLivraison()}</td>
						<td>${shipment.getLivraison().getVolumneTotal()} </td>
						<td>${shipment.getLivraison().isEstLivre()} </td>
						
						<td>  <a type="button" class="btn btn-danger"
						href="/ValiderLivraison?id_livraison=${shipment.getLivraison().getLivraison_ID()}">valider</a></td>

						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</body>
<%@ include file="common/footer.jspf" %>