
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>
 <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body style="font-family:Arial;color:#000000;">

<div style="background-color:#e5e5e5;padding:15px;text-align:center;">
<img width="50" height="50" src="/admin-icon-png-9.jpg">  <h1>Espace d'Admine du supermarché</h1>
</div>

<div style="overflow:auto">
  <div class="menu">
<div> <img width="50" height="50" alt="" src="/scooter-livraison.png"> <a href="/Livreurs">Liste des Livreurs</a> </div><br> <br>
<a href="/Fournisseurs">Liste des Fournisseurs</a><br> <br>
<a href="/add-Supermarche">Click here to add new supermarchÃ©</a><br> <br>
  </div>

  <div class="main">
    <h2>
        <span class="navbar-text">
          Bonjour <strong> ${name}  </strong>
          </span>

</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
  </div>

  <div class="right">
    <h2>About</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit
    Lorem ipsum dolor sit amet, consectetuer adipiscing 
    <img alt="livrily" src="Livrily.png">
    .</p>
  </div>
</div>

<footer class="container-fluid text-center">
  <p> <i>www.livrily.dz</i></p>
</footer>










<%@ include file="common/footer.jspf"%>