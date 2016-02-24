<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
  <head>
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