
    <%@ include file="common/header.jspf"%>
  <body  background="back.jpg" >  
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="background-color:#fffff;padding:30px;text-align:center;">

<div class="header">
  <a href="/" class="logo"><img width="50" height="50" alt="livrily" src="Livrily.png"> </a>
   <h1 style="color: white;"> <strong>Inscrivez-vous</strong></h1>
 
</div>

<form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <input type="text" class="form-control" id="Nom" placeholder="votre nom">
    </div>
    <div class="form-group col-md-6">
      <input type="text" class="form-control" id="Prenom" placeholder="votre Prenom">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <input type="date" class="form-control" id="date" placeholder="votre date de naissance">
    </div>
    <div class="form-group col-md-6">
      <input type="text" class="form-control" id="lieu" placeholder="votre Lieu de Niassance">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <input type="text" class="form-control" id="date" placeholder="Phonne 1">
    </div>
    <div class="form-group col-md-6">
      <input type="text" class="form-control" id="Phonne 2" placeholder="Phonne 2">
    </div>
  </div>
  <div class="form-row">
  <div class="form-group col-md-6">
    <input type="email" class="form-control" id="email" placeholder="votre email">
  </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <input type="text" class="form-control" id="Login">
    </div>
    <div class="form-group col-md-6">
      <input type="password" class="form-control" id="password">
    </div>
    </div>
 <div align="center"><button type="submit" class="btn btn-primary" >Sign in</button></div> 
</form>
</body>
</html>
</body>
</html>