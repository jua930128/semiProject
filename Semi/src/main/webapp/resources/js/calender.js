

$(document).ready(() => {

	var today = new Date();
	var tomorrow = new Date(today.setDate(today.getDate() + 1));
	var dDay = new Date(today.setDate(today.getDate() + 1));
	
	// 체크인 날짜지정(오늘날짜)
	document.getElementById('checkInDate').value = new Date().toISOString().substring(0, 10);
	
	// 체크아웃 날짜지정(체크인날짜 + 1)
	document.getElementById('checkOutDate').value = new Date(tomorrow).toISOString().substring(0, 10);

	// 이전날짜 비활성화
	var now_utc = Date.now()
	var timeOff = new Date().getTimezoneOffset()*60000;
	var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
	document.getElementById("checkInDate").setAttribute("min", today);
	document.getElementById("checkOutDate").setAttribute("min", today);
	
// 날짜 유효성 체크
function checkValidDate(value) {
	var result = true;
	try {
	    var date = value.split("-");
	    var y = parseInt(date[0], 10),
	        m = parseInt(date[1], 10),
	        d = parseInt(date[2], 10);
	    
	    var dateRegex = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
	    result = dateRegex.test(d+'-'+m+'-'+y);
	} catch (err) {
		result = false;
	}    
    return result;
}









});


    


