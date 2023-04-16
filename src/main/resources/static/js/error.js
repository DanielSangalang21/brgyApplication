function markErrorfields(errors){
	let classNm = 'is-invalid';	
	for (let i=0 ; i< errors.length; i++){
		if(errors[i].toLowerCase().includes('date')){
			$('#'+errors[i]+'Picker').addClass(classNm);			
		}
		else{
			let fname = '#'+errors[i];
			if( $(fname).length == 0 ){
				$("[id^="+ errors[i] +"]").addClass(classNm)
			}
			$(fname).addClass(classNm);
		}
	}
}