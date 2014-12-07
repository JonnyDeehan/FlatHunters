<html>
<head>
<%@ page import="src.Session" %>
<title>Login Page</title>
</head>
<body>
<!--  NAVIGATION BAR -->
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
  
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="search">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="search?full=true">Search</a></li>
      </ul>
      <!-- 
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      -->
      
      <% if(Session.hasSession()){ %>
    	<ul class="nav navbar-nav navbar-right">
          <li><a href="profile">My Account</a></li>
        </ul>
      <%
      }
      else{
      %>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login?caller=0&type=login">Login</a></li>
		<li><a href="login?caller=0&type=register">Register</a></li>
      </ul>
      <%} %>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<!--  PAGE CODE  -->
<h1>Login Page</h1><br />
<br />

<form action="login" method="GET">
<input type="hidden" name="caller" value="1">

<h3>Email:<br /></h3>
<input type="text" name="email" />

<h3>Password:<br /></h3>
<input type="password" name="password" />
<br />
<br />
<input type="submit" value="Login" />

</form>
</body>
</html>