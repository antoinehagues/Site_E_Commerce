<%@ taglib uri="/struts-tags" prefix="s" %>  
  
<s:form action="create">  
	<s:textfield name="name" label="Nom"></s:textfield>  
	<s:hidden name="form" value="true"></s:hidden>  
	<s:submit value="Create"></s:submit>  
</s:form>  
