<%@ include file="common/header.jspf"%>
<%@ include file="common/header.jspf"%>
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
<body background="back.JPG" style="font-family: Arial; color: #000000;">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"> <img   width="42" height="42 alt="livrily" src="/Livrily.png" > </a>
  
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      
      <li class="nav-item">
        <a class="nav-link" href="ListeLivraisons">Livraisons</a>
      </li>
      
      
       </ul>
       
  </div>
</nav>




	<div
		style="background-color: #e5e5e5; padding: 15px; text-align: center;">
		<img width="50" height="50" src="/L.png">
		<h1 style="font-size: 7vw">Livruer</h1>
	</div>

	

		<div class="main">
			<img alt="" src="dezitholk.png">
		<br>
		<br>
		<br>
		
<div align="center"> <h1> Click here</h1> <button class=" btn btn-success" onclick="getLocation()">Show my position</button> </div>

<p id="demo"></p>

<script >
var x = document.getElementById("demo");

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else { 
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}

function showPosition(position) {
   x.innerHTML = " <h1>Latitude:</h1> " + position.coords.latitude + 
  "<br> <h1>Longitude:</h1> " + position.coords.longitude;
}
</script>

		</div>

		
	</div>

	










	<%@ include file="common/footer.jspf"%>









<%@ include file="common/footer.jspf"%>