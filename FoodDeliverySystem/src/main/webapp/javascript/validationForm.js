/**
 *  *****All Form Validation*****
 */
 
 /*  Validation for hotelSignup.jsp */
 function passValidation(){
	
	var password= document.hotelSignupForm.password.value;
	var confirmPassword= document.hotelSignupForm.confirmPassword.value;
	
	console.log(password);
	console.log(confirmPassword);
	
	if(password == confirmPassword)
		{			
			document.getElementById("validatePassword").innerHTML='Password Matched'
		}
	else{
		document.getElementById("validatePassword").innerHTML='Password Mismatched';
		
	}	
}


/*  Validation for customerSignup.jsp */
function customerValidation() {
	
	var password= document.customerSignupForm.password.value;
	var confirmPassword= document.customerSignupForm.confirmPassword.value;
	console.log (password + " " + confirmPassword);
	
	if(password == confirmPassword)
		{
			return true;
		}
	else{
		alert("password mismatched...!");
		return false;
	}
}