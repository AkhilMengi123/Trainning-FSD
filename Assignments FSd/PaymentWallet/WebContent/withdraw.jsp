<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrap/bootstrap.html" %>
</head>
<body>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">
<h2 style="text-align:center;color:blue">Create Wallet<hr></h2>
<br><hr>
<%@ include file="nav.html" %>
<br><br><br>
<form action="withdraw" class="was-validated">
     <div class="form-group">
      <label for="uname">Amount:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter Amount to Deposit" name="amount" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
   
     
    <button type="submit" class="btn btn-primary">Withdraw</button>
  </form>
</div>
<div class="col-sm-2"></div>
</div>
 
</body>
</html>