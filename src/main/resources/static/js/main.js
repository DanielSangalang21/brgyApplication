function confirmSubmit(form){
	$('#'+form).submit();
}

function confVal(formId){
		let stringConf="";
		$('#'+formId+' input, #'+formId+' select').each(
			    function(index){  
			        let input = $(this);
			        
			        let type = input.attr('type');
			        let inputId = input.attr('id');
			        let name = input.attr('name');
			      	//if input is datepicker ignore coz we have hidden input for that
			      	if(inputId.toLowerCase().includes('picker')){
				      	//continue
				      	return;
				     }
				     //ignore sex radio buttons
			      	if(name.toLowerCase().includes('sexradio')){
				      	return;
				     }

				  	
			        let label = $('label[for="' + inputId + '"]').text();
			      	//only file name if file type
			      	if(type == 'file'){
				      	let value = input.val();
				      	let filename = value.substring(value.lastIndexOf("\\")+1)
			      		stringConf+=label+filename+'|';
			      		return;
				    }
			        stringConf+=label+input.val()+'|';
			        //alert('Type: ' + input.attr('type') + 'Name: ' + input.attr('name') + 'Value: ' + input.val());
			    }
		);
		return stringConf;
	}

	function formConfVal(confVal){
		let values = confVal.split("|");
		let modalBody = $('#modalBody');
		modalBody.empty();
		for (let i=0; i < values.length; i++){
			if (values[i]){
				let label = values[i].substring(0,values[i].indexOf(':')+1);
				let value = values[i].substring(values[i].indexOf(':')+1);
				let innerHT = "<span class='lead'>"+ label +" "+ value +"</span><br>";
				modalBody.append(innerHT);
			}
		}
	}
	
	function showAlert(type, strongMess, message){
		let ancestor = $("#alertDiv");
		let st = (strongMess) ? strongMess : "";
		ancestor.append("<div class='alert alert-"+type+" alert-dismissible fade show modded-alert' role='alert'>"+
				"<strong>"+ st +"</strong>"+message +
				"<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>");
 	}

 	function clearModAlerts(){
 		//clear alerts modded-alert is the class name
		$( ".modded-alert" ).remove();
 	 }