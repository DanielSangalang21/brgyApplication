<%@ include file="base/TagLib.jsp"%>
<%@ include file="base/include.jsp"%>

<link rel="stylesheet" href="../css/cropper.min.css">
<script src="../js/cropper.min.js"></script>
<style>
	.img{
		/* Ensure the size of the image fit the container perfectly */
		display: block;
 	 	/* This rule is very important, please don't ignore this */
  		max-width: 100%;
	}
	.preview {
		overflow: hidden;
		width: 160px;
		height: 160px;
		margin: 10px;
		border: 1px solid red;
	}
</style>
<body>

	<div class="container mt-3 py-2 shadow p-3 mb-5 bg-body">
	<form:form method="post" modelAttribute="applicant"
		enctype="multipart/form-data">
		
			<div class="alert alert-light fw-light fst-italic">
	    		<strong>Note! </strong>Fields with red asterisk (<span class="mand"></span> ) are mandatory.
	  		</div>
  		
  		
		<div class="row mb-1">
			<div class="col">
				<form:label class="form-label mand" path="firstname">First name:</form:label>
				<form:input class="form-control form-control-sm" path="firstname" />
				<form:errors path="firstname" cssClass="error"/>
			</div>
			
			<div class="col">
				<form:label class="form-label" path="middlename">Middle name:</form:label>
				<form:input class="form-control form-control-sm" path="middlename" />
				<form:errors path="middlename" cssClass="error"/>
			</div>
			<div class="col">
				<form:label class="form-label mand" path="lastname">Last name:</form:label>
				<form:input class="form-control form-control-sm" path="lastname" />
				<form:errors path="lastname" cssClass="error"/>
			</div>
			
			<div class="col">
				<form:label class="form-label" path="suffix">Suffix:</form:label>
				<form:input class="form-control form-control-sm" path="suffix" />
				<form:errors path="suffix" cssClass="error"/>
			</div>
		</div>
		
		<div class="row mb-1">
			<div class="col-sm-3">
				<form:label  class="form-label mand" path="birthDate">Birth Date:</form:label>
				<input class="datePicker form-control form-control-sm" width="50" id="birthDatePicker" readonly />
				<form:input path="birthDate" type="hidden" />
				<form:errors path="birthDate" cssClass="error"/>
			</div>
			
			<div class="col-sm-3">
				<form:label class="form-label" path="age">Age:</form:label>
				<form:input class="form-control form-control-sm" path="age"  readonly="true"/>
				<form:errors path="age" cssClass="error"/>
			</div>
		</div>

		<div class="row mb-1">
			<div class="col-3">
				<form:label class="form-label mand" path="sex">Sex:</form:label><br>
				<div class="form-check form-check-inline">
					<input type="radio" id="sMale" name="sexRadio" class="form-check-input" value="Male" />
					<div class="form-check-label">Male</div>
				</div>
				
				<div class="form-check form-check-inline">
					<input type="radio" id="sFemale" name="sexRadio" class="form-check-input" value="Female" />
					<div class="form-check-label">Female</div>
				</div>
				<form:input path="sex" type="hidden" />
				<br><form:errors path="sex" cssClass="error"/>
			</div>
			
			<div class="col-3">
				<form:label class="form-label mand" path="nationality">Nationality:</form:label>
				<form:input class="form-control form-control-sm" path="nationality" />
				<form:errors path="nationality" cssClass="error"/>
			</div>
		</div>
		
		<div class="row mb-1">
			<div class="col-3">
				<form:label path="civilStatus" class="form-label mand">Civil Status:</form:label>
				<form:select path="civilStatus" class="form-select form-select-sm">
				  <c:forEach items="${csList}" var="cs" >
				  	<option value="${cs.civilStatusDesc}">${cs.civilStatusDesc}</option>
				  </c:forEach>
				</form:select>
				<form:errors path="civilStatus" cssClass="error"/>
			</div>
			
			<div class="col-3">
				<form:label  class="form-label mand" path="religion">Religion:</form:label>
				<form:input class="form-control form-control-sm" path="religion"/>
				<form:errors path="religion" cssClass="error"/>
			</div>
		</div>
		
		<div class="row mb-1">
			<div class="col-3">
				<form:label class="form-label mand" path="addHouseNo">House No.:</form:label>
				<form:input class="form-control form-control-sm" path="addHouseNo" />
				<form:errors path="addHouseNo" cssClass="error"/>
			</div>
			<div class="col-3">
				<form:label  class="form-label mand" path="addStreet">Street address:</form:label>
				<form:input class="form-control form-control-sm" path="addStreet" />
				<form:errors path="addStreet" cssClass="error"/>
			</div>
		</div>
		
		<div class="row mb-1">
			<div class="col-4">
				<form:label class="form-label" path="addBarangay">Barangay:</form:label>
				<form:label class="form-control-plaintext lead" path="addBarangay">${barangayAdd}</form:label>
			</div>
			
			<div class="col-4">
				<form:label class="form-label" path="addCity">City:</form:label>
				<form:label class="form-control-plaintext lead" path="addCity">${cityAdd}</form:label>
			</div>
			
			<div class="col-4">
				<form:label class="form-label" path="addProvince">Province:</form:label>
				<form:label class="form-control-plaintext lead" path="addProvince">${provinceAdd}</form:label>
			</div>
		</div>
		
		<div class="row mb-1 justify-content-center">
				<form:label class="form-label mand" path="imageFile">Applicant image:</form:label>
				<div >
					<form:input path="imageFile" type="file" class="w-50 form-control imageInput" id="imageFile" name="imageFile"/>
					<form:input path="image" type="hidden"/>
					<form:input path="fullImagePath" type="hidden"/>
					<form:errors path="imageFile" cssClass="error"/>
					<img class="mt-2" alt="Applicant's Image" id="uploadedImg" src="${applicant.image}">
				</div>
		</div>
		
		
		<div class ="mt-4 text-center">
		
			<a type="button" class="btn btn-primary" onclick ="submit('applicant')">Register</a>
		</div>
		
	</form:form>
	
	<!-- image crop modal -->
	<div class="modal fade" id="imageModal">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header bg-dark text-light">
	        <h4 class="modal-title fw-light">Crop Image</h4>
	        <!-- <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button> -->
	      </div>
	
	      <!-- Modal body -->
			<div class="modal-body bg-light text-dark">
				<div class="img-container">
					<div class="row">
							<div class="col-md-8">
							<!--  default image where we will set the src via jquery-->
								<img id="imageHolder">
							</div>
							<div class="col-md-4">
								<div class="preview"></div>
							</div>
					</div>
				</div>
			</div>

					<!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
	        <button id="crop" type="button" class="btn btn-primary" >Crop</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	<!-- End of crop modal -->

</body>

<script type="text/javascript">

	var defProfPicSrc = '${defProfPic}'
		var defProfPicName = defProfPicSrc.split('\\').pop();

	$(function() {
		let cs = '${applicant.civilStatus}';
		if (typeof cs === 'string' && cs.trim().length != 0){
			$('#civilStatus').val('${applicant.civilStatus}');
		}
		const d = new Date();
		d.setFullYear(d.getFullYear()-120);
		
		createDatePickMinMaxAge('birthDatePicker', 'birthDate','age', d, new Date());

		 if(${applicant.birthDate != null}){
			$('#birthDatePicker').datepicker("setDate" , $('#birthDate').val());
			$('#age').val(${applicant.age});
		}

		 if(${applicant.image != null}){
			 
			 let src = "${fn:replace(applicant.image,'\\','\\\\')}"
			 $('#uploadedImg').attr("src",src);
		 }else{
			 $('#uploadedImg').attr("src",defProfPicSrc);
		 }
	});

	/* must be in yyyy-MM-dd format */
	/* convert date from string ('yyyy-MM-dd')  to valid Date*/
	function strToDate(dateStr){
		let strArr = dateStr.split("-");
		let converted = new Date(strArr[0],strArr[1],strArr[2]);
		return converted;
	}
	
	function submit(formId){
		//set value for sex since confval is dependent on input types, i ignored radio button so only one value will appear in confirmation
		if($("#sMale").is(":checked")){
			$('#sex').val($("#sMale").val())
		}else if ($("#sFemale").is(":checked")){
			$('#sex').val($("#sFemale").val())
		}

		let imageSrc = $('#uploadedImg').attr('src');
		if(imageSrc.split("\\").pop() === defProfPicName){
			showAlert("danger",null,"Must select an image first");
			return;
		}
		
		formConfVal(confVal(formId));
		$('#formModal').modal('toggle');
		$('#confirmBtn').attr('onclick', 'confirmSubmit('+JSON.stringify(formId)+')');
	}

    var bs_modal = $('#imageModal');
    var image = document.getElementById('imageHolder');
    var cropper,reader,file;

    $("body").on("change", "#imageFile", function(e) {
        var files = e.target.files;
        var done = function(url) {
            image.src = url;
            bs_modal.modal('show');
        };


        if (files && files.length > 0) {
            file = files[0];

            //clear errors from file input
            clearModAlerts();  $('#imageFile').removeClass('is-invalid');
            
             if (!validImageFile(file, $('#imageFile').val())){
            	 imageFile.value = null;
            	 $('#imageFile').addClass('is-invalid')
               return false;
            }
			
            if (URL) {
                done(URL.createObjectURL(file));
            } else if (FileReader) {
                reader = new FileReader();
                reader.onload = function(e) {
                    done(reader.result);
                };
                reader.readAsDataURL(file);
            }
        }
    });

    bs_modal.on('shown.bs.modal', function() {
        cropper = new Cropper(image, {
            aspectRatio: 1,
            viewMode: 0,
            preview: '.preview',
            responsive: true,
            cropBoxResizable: false,
            restore: false
        });
    }).on('hidden.bs.modal', function() {
        cropper.destroy();
        cropper = null;
        imageFile.value = null;
    });

    $("#crop").click(function() {
        canvas = cropper.getCroppedCanvas({
            width: 160,
            height: 160,
        });

        canvas.toBlob(function(blob) {
            url = URL.createObjectURL(blob);
            var reader = new FileReader();
            reader.readAsDataURL(blob);
            reader.onloadend = function() {
                var base64data = reader.result;
                var fullNm = fullFileName($("#firstname").val(), $("#middlename").val(), $("#lastname").val(), $("#suffix").val())
				//var fName = $("#firstname").val()+"_"+$("#lastname").val();
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    dataType: "json",
                    url: "uploadImg",
                    data: JSON.stringify({image: base64data , fullName: fullNm}),
                    success: function(data) { 
                        bs_modal.modal('hide');
                       // alert();
                        showAlert("success",null,"Image upload successful!");
                        //set image value to directory of uploaded image
                        $('#image').val(data.directory);
                        $('#fullImagePath').val(data.fullDirectory);
                        $('#uploadedImg').attr("src",data.directory);
                        //console.log(data);
                    }
                });
            };
        });
    });

    function fullFileName(fName, mName, lName, suffix){
        if((fName) && (lName)){
            let mNm = (mName) ? " "+mName+" " : " ";
            let suf = (suffix) ? " "+suffix : "";
        	  return fName + mNm + lName + suf;
         }else{
             return null;
         }
    }

 	function validImageFile(file, filename){
 		let fileExt = filename.split('.').pop();
		let arr =["img","png","jpeg","jpg"];
		console.log(file.size);
		if(!arr.includes(fileExt)){
			showAlert("danger",null,"Invalid file type");
			return false
		}else if(file.size > '${maxImageSize}' ){
			showAlert("danger",null,"Invalid file size");
			return false;
		}
		return true;
 	}

 	function clearFileInErr(){
 	 	
 	}

</script>

</html>