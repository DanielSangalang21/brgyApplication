<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="TagLib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${pageTitle}</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css">
<script src="../js/datepicker.js"></script>
<script src="../js/main.js"></script>

<script src="../bootstrap5/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="../bootstrap5/css/bootstrap.css">
<link rel="stylesheet" href="../css/error.css">
<script src="../js/error.js"></script>


</head>
<body>
	<!-- navigation bar -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
		<a class="navbar-brand" href="#">Logo</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
     	 	<span class="navbar-toggler-icon"></span>
   		</button>
   		 <div class="collapse navbar-collapse" id="collapsibleNavbar">
   		 	<ul class="navbar-nav">
   		 		 <li class="nav-item dropdown">
          			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Applicant</a>
          			<ul class="dropdown-menu">
            			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/applicant/register">Register</a></li>
            			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/applicant/all">Applicants List</a></li>
            		</ul>
          		</li>
   		 	  	<li class="nav-item dropdown">
	   		 	  	<li class="nav-item dropdown">
	          			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Barangay Clearance</a>
	          			<ul class="dropdown-menu">
	            			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/brgyClearance/request">Request</a></li>
	            		</ul>
	          		</li>
		       	</li>
   		 	</ul>
   		 </div>
		</div>
	</nav>

	<div class="container mt-3 py-1">
		<span class="h1 display-5">${pageTitle}</span>	
	</div>

	<div class="container mt-2" id="alertDiv">
		<c:if test="${errors != null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong><s:message code="all.error.strong"/></strong> <s:message code="all.error.message"/>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<c:if test="${successMessage != null}">
			<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong><s:message code="success"/></strong> <s:message code="${successMessage}"/>
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
	</div>

	<!-- confirmation Modal -->
	<div class="modal fade" id="formModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header bg-dark text-light">
	        <h4 class="modal-title fw-light">Confirm ${pageTitle}</h4>
	        <!-- <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button> -->
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body bg-light text-dark">
	       		<div class="container" id="modalBody">
	       			
	       		</div>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	        <button id="confirmBtn" type="button" class="btn btn-primary" >Confirm</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	<!-- End confirmation modal -->
</body>

<script type="text/javascript">
	$(function(){
		if(${errors != null}){
			let temp = '${errors}'
			let arrErr = temp.split('_');
			markErrorfields(arrErr);
		}
	})
	
</script>
</html>

<!-- JQUERY -->

<!-- JQUERY -->

