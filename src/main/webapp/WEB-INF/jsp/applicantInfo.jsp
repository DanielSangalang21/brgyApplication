<%@ include file="base/TagLib.jsp"%>
<%@ include file="base/include.jsp"%>
<head>
<style type="text/css">
	.sub_div {
        position: absolute;
        bottom: 0px;
     }
</style>
</head>
<body>
	<div class="container">
	
	<!-- <div class="shadow p-3 mb-5 bg-body rounded my-2 border rounded-3">
		<form action='#'>
			<div class="row mx-2 my-2">
				<div class="col-3">
					<label class="form-label">Search:</label> 
					<input type="text" class="form-control form-control-sm">
				</div>
			</div>
		</form>
	</div> -->

		<div class="container mt-3 shadow p-3 mb-5 bg-body">
			<div class="row mb-5">
					<div class="col-6">
						<div class="card">
						 	<img class="card-img-top img-fluid" width="500" height="600" src="${applicant.image}" alt="profile image">
						 	
						 </div>
						<%-- <img class="rounded-3 img-fluid  img-thumbnail" width="500" height="600" src="${applicant.image}" alt="profile image"> --%>
					</div>
					<div class="col-6">
						<div class=" rounded-3 px-3 py-3 text-center ">
							<a onclick="confirmSubmit('formSubmit')" class="btn btn-primary mt-1">Request Clearance</a>
							<a href="#" class="btn btn-warning mt-1">Modify</a>
							<a href="#" class="btn btn-danger mt-1">Delete Profile</a>
						</div>
						<div class="px-3 py-2 shadow p-3 bg-body">
							</label> <h4 class="display-6">${applicant.fullName}</h4>
							<div class="row mt-3">
								<label>Birthdate</label>
								<label class="lead">${applicant.birthDate}</label>
							</div>
							<div class="row mt-3">
								<label>Age</label>
								<label class="lead">${applicant.age}</label>
							</div>
							<div class="row mt-3">
								<label>Sex</label>
								<label class="lead">${applicant.sex}</label>
							</div>
							<div class="row mt-3">
								<label>Nationality</label>
								<label class="lead">${applicant.nationality}</label>
							</div>
							<div class="row mt-3">
								<label>Civil Status</label>
								<label class="lead">${applicant.civilStatus}</label>
							</div>
							<div class="row mt-3">
								<label>House No.</label>
								<label class="lead">${applicant.addHouseNo}</label>
							</div>
							<div class="row mt-3">
								<label>Street No.</label>
								<label class="lead">
								<c:choose>
									<c:when test="${applicant.addStreet != null || applicant.addStreet !=''}">
									 	${applicant.addStreet}
									</c:when>
									<c:otherwise>
										N/A
									</c:otherwise>
								</c:choose>
								
								
								</label>
							</div>
						</div>
						
						<form id=formSubmit method="post" action="<c:url value="/brgyClearance/request/${applicant.applicantNo}"/>" >
						
						</form>
					</div>
			</div>
		</div>
	</div>
</body>
</html>