<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container">
	<div class="row">
		<s:iterator value="articles">
	        <div class="col-lg-4">
	          <h2><s:property value="nom"/></h2>
	          <img style="width:150px" src="<s:url value="/images/articles/Jellyfish.jpg"/>">
	          <p><s:property value="description"/></p>
	          <p><s:property value="prix"/> euros</p>
	          <p><s:property value="ref"/></p>
				<s:url namespace="/article" action="article.action" var="detail" >
				    <s:param name="id"><s:property value="id"/></s:param>
				</s:url>
	          <a class="btn btn-primary" href="<s:property value="#detail" />" >View details</a>
	        </div>
		</s:iterator>
	</div>
	<br/><br/><br/><br/>
</div>