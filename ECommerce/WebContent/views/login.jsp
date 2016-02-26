<%@ taglib uri="/struts-tags" prefix="s" %>  
<div class="container" >
	<div class="row">
	<div class="col-md-4"></div>
  	<div class="col-md-4">
      <s:form class="form-signin" action="login">
      <s:hidden name="form" value="true"></s:hidden> 
        <h2 class="form-signin-heading">Veuillez vous connecter</h2>
        <s:textfield  name="pseudo" id="inputEmail" class="form-control " placeholder="Pseudo" required="" autofocus="" ></s:textfield>
   		<br/>
        <s:textfield name="motdepasse" type="password" width="100px" id="inputPassword" class="form-control col-md-12" placeholder="Mot De Passe" required=""></s:textfield>
        <div class="checkbox">
        </div>
        <s:submit class="btn btn-lg btn-primary btn-block" value="Connexion"></s:submit>
      </s:form>
      </div>
      <div class="col-md-4"></div>
	</div>
   </div><br/><br/>