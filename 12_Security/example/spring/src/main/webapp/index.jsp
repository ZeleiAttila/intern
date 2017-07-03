<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<tiles:insertDefinition name="defaultLayout">

	<tiles:putAttribute name="body">
<script>

jQuery(document).ready(function() {


	jQuery.ajax
({ 
  type: "GET",
  url: "http://localhost:8080/gamification-app-neuron-demo/survey.xhtml?id=1",
  crossDomain: true,
  async: false,
  beforeSend: function(xhr){xhr.setRequestHeader('Authorization','Basic emVsZWlhOnpzb2ZpY2ljYQ==');},
  

  data: '',
  
  success: function (v){
	
  }
}) .done(function( data ) {
    if ( console && console.log ) {
//         console.log( "Sample of data:", data.slice( 0, 100 ) );
        jQuery('#content').html('<iframe width="300px" height="600px" src="http://localhost:8080/gamification-app-neuron-demo/survey.xhtml?id=1"></iframe> </div>'); 
      }
    });
});
</script>
		<div id="content">
<!-- 		<iframe width="300px" height="600px" src="http://localhost:8080/gamification-app-neuron-demo/survey.xhtml?id=1" ></iframe> -->
		</div>  

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>