
dojo.addOnLoad( function() {  
	showUsername(dojo.byId('loginedUsername').value);  
	onEnterTeigerEvent('loginUsername',function(){dojo.byId('loginPassword').focus();});
	onEnterTeigerEvent('loginPassword',function(){dojo.byId('loginBtn').click();});
	
});  

function onEnterTeigerEvent(id,func){
	 dojo.connect(dojo.byId(id),'onkeydown',null, function(event){  
	        if (event.keyCode==13) {  
	        	func.call();  
	        }  
	 }); 
}

function showUsername(show) {
	if(show){
		dojo.byId('nologinDiv').style.display = 'none';
		dojo.byId('loginedDiv').style.display = 'block';
	}else{
		dojo.byId('nologinDiv').style.display = 'block';
		dojo.byId('loginedDiv').style.display = 'none';
	}
}

function showLoginWindow() {
	if(!dojo.byId('hiddenLayer')){
		dojo.create('div', {id: 'hiddenLayer'}, dojo.body());
	}
	dojo.byId('hiddenLayer').style.display = 'block';
	dojo.byId('loginDiv').style.display = 'block';
	
	dojo.removeClass(dojo.byId('loginPassword'), 'error');
	dojo.byId('loginUsername').value = '';
	dojo.byId('loginPassword').value = '';
	dojo.byId('loginErrorDiv').style.display = 'none';
	dojo.byId('loginErrorMsg').innerHTML = '';
	
	dojo.byId('loginUsername').focus();
}

function closeLoginWindow() {
	dojo.byId('hiddenLayer').style.display = 'none';
	dojo.byId('loginDiv').style.display = 'none';
}

//login-----------------

function doLogin() {
	var loginBtn = dojo.byId('loginBtn');
	dojo.addClass(loginBtn, 'btn-disable');
	dojo.attr(loginBtn, 'disabled', true);
	
	dojo.xhrPost({
		form: dojo.byId('loginForm'),
		preventCache: true,
		sync: true,
		handleAs: 'json',
		load: function(response){
			if(response.loginStatus){
				closeLoginWindow();
				dojo.byId('sayHiTo').innerHTML = response.username;
				showUsername(true);
			}else{
				dojo.addClass(dojo.byId('loginPassword'), 'error');
				dojo.byId('loginErrorDiv').style.display = 'block';
				dojo.byId('loginErrorMsg').innerHTML = 'Can\'t find your Username/Password combination';
			}
		},
		error: function(error){
			alert(error);
		}
	});
	
	dojo.removeClass(loginBtn, 'btn-disable');
	dojo.attr(loginBtn, 'disabled', false);
	loginBtn.blur();
}


function doLogout() {
	dojo.xhrGet({
	    url: 'logout.json',
	    handleAs: 'json',
	    load: function(response){
	    	if(response.logoutStatus){
	    		alert('Logout successfully');
	    		showUsername(false);
	    	}
	    },
	    error: function(error){
	    	alert(error);
	    }
	  })
}
