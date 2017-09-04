var scrollInProgress = false;

function scroll() {
	console.log($('#msg_container')[0].scrollHeight
			- ($('#msg_container').height() * 2) + ' '
			+ $('#msg_container')[0].scrollTop);
	if (!scrollInProgress
			&& $('#msg_container')[0].scrollHeight
					- ($('#msg_container').height() * 2) < $('#msg_container')[0].scrollTop) {
		scrollInProgress = true;
		$('#msg_container').animate({
			scrollTop : $('#msg_container')[0].scrollHeight
		}, 800, function() {
			scrollInProgress = false;
		});
	}
}

function scrollWhenWrite() {
	if (!scrollInProgress) {
		scrollInProgress = true;
		$('#msg_container').animate({
			scrollTop : $('#msg_container')[0].scrollHeight
		}, 800, function() {
			scrollInProgress = false;
		});
	}
}