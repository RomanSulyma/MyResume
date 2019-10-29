<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags"%>
<script src="/static/js/jquery-2.2.2.js"></script>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				This is not real social network!<br>
				And all information presented here is for reference only<br>
				Used technologies:<br>
				1)Spring IOC<br>
				2)Spring MVC<br>
				3)Spring DATA , Hibernate<br>
				4)Spring Security<br>
				5)Elastic Search<br>
			</div>
		</div>
	</div>
</div>

<jsp:include page="profiles.jsp" />
<script type="text/javascript">
	$(window).on('load',function(){
		$('#exampleModalCenter').modal('show');
	});
</script>

