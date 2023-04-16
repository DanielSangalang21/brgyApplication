<%@ include file="base/TagLib.jsp"%>
<%@ include file="base/include.jsp"%>
<body>

	<div class="container mt-3 py-2 border">
		<form:form method="post" modelAttribute="applicant">
			<div class="row mb-1">
				<div class="col">
					<form:label class="form-label" path="applicantNo">Applicant No:</form:label>
					<form:input class="form-control form-control-sm" path="applicantNo" />
					<form:errors path="firstname" cssClass="error" />
				</div>
			</div>
			
			<div class ="mt-4 text-center">
				<form:button class="btn btn-primary">Request Clearance</form:button>
			</div>
		</form:form>
	</div>