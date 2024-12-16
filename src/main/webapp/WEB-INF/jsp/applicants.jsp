<%@ include file="base/TagLib.jsp"%>
<%@ include file="base/include.jsp"%>

<body>

	<div class="container rounded-4 shadow p-3 mb-3 bg-body">
	<div class="row">
        <div class="col-md-4 mx-auto">
            <div class="fw-light ">Search applicant by name</div>
            <div class="input-group">
                <input class="form-control border-end-0 border rounded-pill" type="search" placeholder="search" id="searchField">
                <span class="input-group-append">
                    <button class="btn btn-outline-primary bg-white border-0 border rounded-pill ms-n5" onclick="search()" type="button">
                        <i class="fa text-decoration-underline">Search</i>
                    </button>
                </span>
            </div>
        </div>
    </div>
	</div>
	<div class="container rounded-4 shadow p-3 mb-5 bg-body">

		<c:if test="${noResults != null}">
			<div class="alert alert-warning" role="alert">
				<strong>Sorry! </strong><s:message code="no.result.found" /> for <i>${noResults}</i>
			</div>
		</c:if>
		
		<div class="row">
			<c:forEach var="applicant" items="${applicants}">
				<div class="col-sm-4 mt-3">
					<div class="card shadow p-1 mb-2 bg-body">
						<img class="card-img-top" width="200" height="350"
							alt="image" src="${applicant.image}">
						<div class="card-body">
							<div class="card-title"><b>${applicant.applicantNo}</b> | ${applicant.fullName}</div>
							<!-- <p class="card-text">something is going here</p> -->
							<a href="<c:url value="/applicant/${applicant.applicantNo}"/>" class="btn btn-primary"> <i class="fa">See profile</i></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<script type="text/javascript">
	
		function search() {
			let searchText = $('#searchField').val()
			window.location.href ="${pageContext.request.contextPath}/applicant/"+searchText+"";
		}
	</script>
</body>