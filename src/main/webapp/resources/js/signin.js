/**
 * Hugo Vindas -- ATM test
 */

var signInModel = {
	pin : ko.observable("").extend({ number: true, max: 9999,required: true }),
	error : ko.observable(""),
	doLogin : function() {
		if (signInModel.pin() != "") {
			$.ajax({
				type : "POST",
				url : "login",
				cache : false,
				data : {
					pin : signInModel.pin()
				},
				success : function(data, textStatus) {
					if (data == "") {
						location.href = '/atm/home';
					} else {
						signInModel.error(data);
					}
				},
				error : function(data, textStatus) {
					signInModel.error(data);
				}
			});
		}else{
			signInModel.error("Insert a valid Pin");
		}
	}
}

ko.applyBindings(signInModel, document.getElementById('loginForm'));