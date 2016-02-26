<%@ taglib uri="/struts-tags" prefix="s" %>  
  
<s:form action="create">  
	<s:textfield name="name" label="Nom"></s:textfield>  
	<s:textfield name="ref" label="Reference"></s:textfield>  
	<s:textfield name="prix" label="Prix"></s:textfield>  
	<s:textarea name="description" label="Description" cols="30" rows="8"/>
	<s:hidden name="form" value="true"></s:hidden>  
	<s:submit value="Create"></s:submit>  
</s:form>  

<style>
.label{
	color: black;
}
</style>