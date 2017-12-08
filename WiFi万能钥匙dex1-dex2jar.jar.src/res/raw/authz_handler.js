(function(){
	if (!window.wifikey_authz) window.wifikey_authz = {};
	
	wifikey_authz.oneClick = function(elementId, delay){
		console.log('one click : '+elementId+', '+delay);		
		setTimeout(function(){
			var button = findElement(elementId);
			mockClick(button);
		}, delay);
	};
	
	wifikey_authz.fillPhoneNum = function(num, elementId){
		console.log('fill phone num : '+num+', '+elementId);
		var field = findElement(elementId)||getInputField(0);
		if(field!=null) field.value = num;
	};
	
	wifikey_authz.fillAuthzCode = function(code, elementId){
		console.log('fill authz code: '+code+', '+elementId);
		var field = findElement(elementId)||getInputField(1);
		if(field!=null) field.value = code;
	};
	
	wifikey_authz.getAuthzCode = function(elementId){
		console.log('getCode: '+elementId);
		var button = findElement(elementId)||getButton(0); 
		mockClick(button);
	};
	
	wifikey_authz.login = function(elementId){
		console.log('login: '+elementId);
		var button = findElement(elementId)||getButton(1); 
		mockClick(button);
	};
	
	var mockClick = function(element){
		if(!element){
			console.log('click target is null');
		}
		else if(element.click) {
			element.click();
		}else{
			console.log('mock click by fire mouse event');
			var theEvent = document.createEvent("MouseEvent");
			theEvent.initMouseEvent("click", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
			element.dispatchEvent(theEvent);
		}
	};
	
	var findElement = function(elementId){
		return document.querySelector('#'+elementId)||document.querySelector(elementId);
	};
	
	var getInputField = function(index){
		var inputs = document.querySelectorAll('input[type="text"],input[type="password"]');
		console.log('find text input  : '+inputs.length);
		for(var i=0; i<inputs.length; i++){
			if(i==index){
				return inputs[i];
			}
		}
		return null;
	};
	
	var getButton = function(index){
		var inputs = document.querySelectorAll('input[type="button"],input[type="submit"],button');
		console.log('find button  : '+inputs.length);
		for(var i=0; i<inputs.length; i++){
			if(i==index){
				return inputs[i];
			}
		}
		return null;
	};
	
})();