
function regSubmit() {
	//form1의 action에 있는 주소로 이동해서 처리
	document.getElementById('form1').submit();
}


function moveUpdate(seq) {
	location.href = '/starbucks-homepage1/admin_notice_update_form.jsp?seq=' + seq;
}


function updateSubmit() {
	document.getElementById('form1').submit();
}


function deleteNotice(seq) {
	if(!confirm('번호 ' + seq + '정말 삭제하시겠습니까?')) {
		return false;
	}
	location.href = '/starbucks-homepage1/admin_notice_delete.jsp?seq=' + seq;
}
