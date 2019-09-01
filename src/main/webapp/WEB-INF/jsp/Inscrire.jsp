<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common/header.jspf"%>
    
<div style="background-color:#fffff;padding:30px;text-align:center;">

<div class="header">
  <a href="/" class="logo"><img width="50" height="50" alt="livrily" src="Livrily.png"> </a>
 
</div>

<div style="padding-left:20px">
  <h1>Inscrire</h1>
</div></div>
<form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="Nom">Nom</label>
      <input type="text" class="form-control" id="Nom" placeholder="votre nom">
    </div>
    <div class="form-group col-md-6">
      <label for="Prenom">Prenom</label>
      <input type="text" class="form-control" id="Prenom" placeholder="votre Prenom">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="date">Date de naissance</label>
      <input type="date" class="form-control" id="date" placeholder="votre date de naissance">
    </div>
    <div class="form-group col-md-6">
      <label for="lieu">Lieu de Niassance</label>
      <input type="text" class="form-control" id="lieu" placeholder="votre Lieu de Niassance">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="Phonne 1">Phonne 1</label>
      <input type="text" class="form-control" id="date" placeholder="Phonne 1">
    </div>
    <div class="form-group col-md-6">
      <label for="Phonne 2">Phonne 2</label>
      <input type="text" class="form-control" id="Phonne 2" placeholder="Phonne 2">
    </div>
  </div>
  <div class="form-group col-md-6">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" placeholder="votre email">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="Login">Login</label>
      <input type="text" class="form-control" id="Login">
    </div>
    <div class="form-group col-md-6">
      <label for="password">password</label>
      <input type="password" class="form-control" id="password">
    </div>
    </div>
  <button type="submit" class="btn btn-primary" >Sign in</button>
</form>
</body>
</html>