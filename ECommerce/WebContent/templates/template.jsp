<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
  <head>
  	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../javascript/bootstrap.min.js"></script>
    <title><tiles:getAsString name="title"/></title>
  </head>
  
  <header>
  	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
  </header>
  <body>
  	<tiles:insertAttribute name="body" />
  </body>
  <footer>
  	<tiles:insertAttribute name="footer" />
  </footer>
</html>