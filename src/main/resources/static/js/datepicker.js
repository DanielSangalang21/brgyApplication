/*
 	PARAMETERS 
 	inputId = id of datepicker input
 	hiddenInput = id of binded input for model, will also have the value of date picker
 	*/
	function createDatePicker(inputId, hiddenInput) {
		let dPicker = $('#' + inputId + '').datepicker({
			dateFormat : 'yy-mm-dd',
			 changeMonth: true, 
    	     changeYear: true, 
    	     yearRange: "-150:+150",
			onSelect : function(dateText, inst) {
				$('#' + hiddenInput + '').val(dateText);
			},
		});

	}
	
	function createDatePickMinMax(inputId, hiddenInput, minDate, maxDate) {
			let dPicker = $('#' + inputId + '').datepicker({
				dateFormat : 'yy-mm-dd',
				 changeMonth: true, 
	    	     changeYear: true, 
	    	     yearRange: "-150:+150",
				onSelect : function(dateText, inst) {
					$('#' + hiddenInput + '').val(dateText);
				},
				minDate: minDate,
				maxDate: maxDate,
			});

		}
		
		
		function createDatePickMinMaxAge(inputId, hiddenInput , ageElement, minDate, maxDate) {
			let dPicker = $('#' + inputId + '').datepicker({
				dateFormat : 'yy-mm-dd',
				 changeMonth: true, 
	    	     changeYear: true, 
	    	     yearRange: "-150:+150",
				onSelect : function(date, inst) {
					$('#' + hiddenInput + '').val(date);
					if(ageElement != null){
						$('#' + ageElement + '').val(calculateAge(date));
					}
				},
				minDate: minDate,
				maxDate: maxDate,
			});

		}

		function calculateAge(birthDate){
			let age = new Date(new Date() - new Date(birthDate)).getFullYear() - 1970;
			return age;
		}