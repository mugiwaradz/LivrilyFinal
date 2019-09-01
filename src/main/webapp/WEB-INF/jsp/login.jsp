
<%@ include file="common/header.jspf"%>

<form method="post" >
  <div class="form-group">
    <label for="exampleInputEmail1">Login</label>
    <input type="login" class="form-control" id="login" name="login" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="logincheck" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>


<%@ include file="common/footer.jspf"%>