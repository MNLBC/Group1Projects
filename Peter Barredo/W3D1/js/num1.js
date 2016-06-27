function onLoad(){
		document.getElementById('replace').innerHTML = 'abc *ec *Eab';
		document.getElementById('switch').innerHTML = 'java--script';

		function validateEmailUsingRegex() {
		    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		    
		    var email = document.getElementById('email').value;
		    if(re.test(email)){
		    	alert("The email is VALID");
		    }else{
		    	alert("The email is NOT VALID");
		    }

		}

		function validateEmailUsingOther(){
			var email = document.getElementById('email').value;
			isValidEmail(email);			

		}

		function isValidEmail(email) {
		    // If no email or wrong value gets passed in (or nothing is passed in), immediately return false.
		    if(typeof email === 'undefined') return null;
		    if(typeof email !== 'string' || email.indexOf('@') === -1) {
		    	alert("No @ sign");
		    	return;
		    }

		    // Get email parts
		    var emailParts = email.split('@'),
		        emailName = emailParts[0],
		        emailDomain = emailParts[1],
		        emailDomainParts = emailDomain.split('.'),
		        validChars = 'abcdefghijklmnopqrstuvwxyz.0123456789_-';

		    

		    // There must be exactly 2 parts
		    if(emailParts.length !== 2) {
		        alert("Wrong number of @ signs");
		        return;
		    }

		    // Must be at least one char before @ and 3 chars after
		    if(emailName.length < 1 || emailDomain.length < 3) {
		        alert("Wrong number of characters before or after @ sign");
		        return;
		    }

		    // Domain must include but not start with .
		    if(emailDomain.indexOf('.') <= 0) {
		        alert("Domain must include but not start with .");
		        return;
		    }

		    // emailName must only include valid chars
		    for (var i = emailName.length - 1; i >= 0; i--) {
		        if(validChars.indexOf(emailName[i]) < 0) {
		            alert("Invalid character in name section");
		            return;
		        }
		    };

		    // emailDomain must only include valid chars
		    for (var i = emailDomain.length - 1; i >= 0; i--) {
		        if(validChars.indexOf(emailDomain[i]) < 0) {
		            alert("Invalid character in domain section");
		            return;
		        }
		    };

		    // Domain's last . should be 2 chars or more from the end
		    if(emailDomainParts[emailDomainParts.length - 1].length < 2) {
		        alert("Domain's last . should be 2 chars or more from the end");
		        return;   
		    }

		    alert("Email address is valid");
		    return;
		}


		function validateDateUsingRegex(){
			var re =  /^\d{2}([./-])\d{2}\1\d{4}$/;
		    
		    var date = document.getElementById('date').value;
		    if(re.test(date)){
		    	alert("The date is VALID");
		    }else{
		    	alert("The date is NOT VALID");
		    }
		}

		function validateDateUsingOther(){
		    var date = document.getElementById('date').value;
		    if(date.charAt(2) !== date.charAt(5)){
		    	alert("The date is NOT valid");
		    	return;
		    }
		    var parms = date.split(/[\.\-\/]/);
		    for(x in parms){
		    	var isnum = /^\d+$/.test(parms[x]);
		    	if(!isnum){
		    		alert("The date is not valid");
		    		return;
		    	}
		    }

		    if(parms[0].length !== 2 && parms[1].length !==2){
		    	alert("The date is not valid");
		    	return;
		    }
		    if(parms[2].length !== 4){
		    	alert("The date is not valid");
		    	return;
		    }

		    alert('The date is VALID');

		}




		function validateStringUsingOther(){

			var input = document.getElementById('string').value;

			if(!input || input.length === 0){
				alert('Textbox is empty');
			}else{
				alert('Textbox is NOT empty');
			}
		}

		function validateStringUsingRegex(){

			var input = document.getElementById('string').value;
			var reg = /^$|^.*@.*\..*$/
			if (reg.test(input)) {
				alert('Textbox is empty! Input any string');
			}
			
		}

		function replaceStringUsingRegex(){
			var test = document.getElementById('replace').innerHTML ;
			document.getElementById('replace').innerHTML = test.replace(/\*e/ig,'-');
		}
		function replaceStringUsingOther(){
			var test = document.getElementById('replace').innerHTML ;
				test = test.toLowerCase();
				testSplit = test.split("*e");

			document.getElementById('replace').innerHTML = testSplit.join('-');


		}

		function removeTrimUsingRegEx(){
			var val = document.getElementById('trim').value; 
			document.getElementById('trim').value = val.replace(/^\s+|\s+$/g,'');
		}

		function removeTrimUsingOther(){
			var val = document.getElementById('trim').value; 
			document.getElementById('trim').value = val.trim();
		}

		function switchUsingOther(){
			var val = document.getElementById('switch').innerHTML.split("--");
			val.push(val.shift());
			var valFinal = val.join("--");
			document.getElementById('switch').innerHTML = valFinal;

		}

		function switchUsingRegex(){
			var val = 'java--script',
				splitVal = val.split('--'),
				val = splitVal[1] + '--' + splitVal[0];
			document.getElementById('switch').innerHTML = val;
		}


		document.getElementById('regexValidateEmail').onclick = validateEmailUsingRegex;
		document.getElementById('otherValidateEmail').onclick = validateEmailUsingOther;
		

		document.getElementById('regexValidateDate').onclick = validateDateUsingRegex;
		document.getElementById('otherValidateDate').onclick = validateDateUsingOther;

		document.getElementById('otherValidateString').onclick = validateStringUsingOther;

		document.getElementById('regexReplaceString').onclick = replaceStringUsingRegex;
		document.getElementById('otherReplaceString').onclick = replaceStringUsingOther;

		document.getElementById('regexRemoveSpace').onclick = removeTrimUsingRegEx;
		document.getElementById('otherRemoveSpace').onclick = removeTrimUsingOther;

		document.getElementById('regexSwitch').onclick = switchUsingOther;
		document.getElementById('otherSwitch').onclick = switchUsingOther;
		

	}
