/**
 *  Hugo Vindas -- ATM test
 */


var opts = {
  lines: 13, // The number of lines to draw
  length: 10, // The length of each line
  width: 7, // The line thickness
  radius: 21, // The radius of the inner circle
  corners: 1, // Corner roundness (0..1)
  rotate: 0, // The rotation offset
  direction: 1, // 1: clockwise, -1: counterclockwise
  color: '#000', // #rgb or #rrggbb or array of colors
  speed: 1, // Rounds per second
  trail: 60, // Afterglow percentage
  shadow: false, // Whether to render a shadow
  hwaccel: false, // Whether to use hardware acceleration
  className: 'spinner', // The CSS class to assign to the spinner
  zIndex: 2e9, // The z-index (defaults to 2000000000)
  top: '50%', // Top position relative to parent
  left: '50%' // Left position relative to parent
};



var operationModel = {
		amount : ko.observable("").extend({ number: true,max: 999999,required: true }),
		error: ko.observable(""),
		doWithdraw: function(){
			if (operationModel.amount() != "") {
				var target = document.getElementById('spinnerDiv');
				var spinner = new Spinner(opts).spin(target);
				modalModel.title("Proccesing...");
				modalModel.listOfBills([]);
				$('#myModal').modal({
					backdrop: 'static',
					show:true
				});
				$.ajax({
					type : "POST",
					url : "withdraw",
					cache : false,
					data : {
						amount : operationModel.amount()
					},
					success : function(data, textStatus) {
						if (data.acknowledgment == true) {
							modalModel.message("You will get:");
							modalModel.listOfBills(data.denominationNotes);
							modalModel.title("Complete");
							spinner.stop();
						} else {
							modalModel.title("Complete");
							modalModel.message(data.message);
							spinner.stop();
						}
					},
					error : function(data, textStatus) {
						modalModel.title("Complete");
						modalModel.message(data.message);
						spinner.stop();
					}
				});
			}else{
				operationModel.error("Insert a valid amount");
			}
		}
}

var modalModel = {
		title : ko.observable(""),
		message: ko.observable(""),
		listOfBills : ko.observable([])
}


ko.applyBindings(modalModel, document.getElementById('modalBody'));
ko.applyBindings(operationModel, document.getElementById('wizard'));
