(function(){
	function toJSON(obj){
		if(Object.toJSON){
			return Object.toJSON(obj);
		}
		if(window.JSON){
			return window.JSON.stringify(obj);
		}
	}
	
	function callbackJava(content){
		return window.prompt('__jsi:'+toJSON({
			service: 'wifikey_get_content',
			method: 'onContent',
			param: content
		}));
	}
	
	var content = '<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>';
	//console.log('content: '+content);
	callbackJava(content);
})();
