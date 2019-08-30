
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>


<div class="container">
	Welcome ${name}!! <a href="/articles">Click here</a> to manage your
	articles. <br> <br>
<p> <a  href="/Clients" class="text-primary">Click here to chaek lits clients</a><br> </p> <br>
<a href="/Livreurs">Click here to chaek lits Livreuers</a><br> <br>
<a href="/Fournisseurs">Click here to chaek lits Fournisseurs</a><br> <br>
<a href="/SignUp">Click here to login</a><br> <br>


<form class="form-inline my-2 my-lg-0 ">
    <button class="btn btn-warning"" type="button" margine"center">panier</button>
  </form>
        <span class="navbar-text">
          Bonjour <strong> ${name}  </strong>
          </span>








<%@ include file="common/footer.jspf"%>