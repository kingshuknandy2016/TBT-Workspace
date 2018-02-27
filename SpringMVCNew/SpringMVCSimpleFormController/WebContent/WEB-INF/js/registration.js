

$(document).ready(function() {
	$(".embed-responsive-item").on("click", "p", function() {
		alert("Current Object: " + $(this));
		$(this).hide();
	});
});