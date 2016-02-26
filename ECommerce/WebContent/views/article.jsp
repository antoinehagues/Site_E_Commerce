<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="jumbotron">
	<div class="container">
		<h1>
			<s:property value="article.nom" />
		</h1>
		<span class="label label-default"><s:property value="article.ref" /></span>
		<img style="width:150px" src="<s:url value="/images/articles/Jellyfish.jpg"/>">
		<p><s:property value="article.description" /></p><br/><br/>
			<select name="anneeResultat" id="choices_anneeResultat">
				<s:iterator status="stat" begin="1" end="10">
					<option value="<s:property value="%{#stat.count}" />"><s:property value="%{#stat.index+1}" /></option>
	  			</s:iterator>
			</select>
		<div class="btn-group" role="group" aria-label="...">
			<button type="button" class="btn btn-info">
				Prix : <s:property value="article.prix" /> euros
			</button>
			<s:url namespace="/article" action="panier.action" var="addToPanier" >
				    <s:param name="id"><s:property value="article.id"/></s:param>
				</s:url>
	         <a class="btn btn-success" href="<s:action name="addToPanier" />" >Ajouter au panier</a>
		</div>
	</div>
</div>