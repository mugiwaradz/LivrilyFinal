<%@ include file="common/header.jspf" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"> <img   width="42" height="42 alt="livrily" src="/Livrily.png" > </a>
  
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item">
        <a class="nav-link" href="ListeLivraisons">Livraisons</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Factures">Factures</a>
      </li>
       </ul>
       
  </div>

</nav>

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
		
<%@ include file="common/footer.jspf" %>