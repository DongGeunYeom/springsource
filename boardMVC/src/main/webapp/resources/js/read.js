/**
 * list.jsp 스크립트
 */
$(function(){
	
	let operForm = $("#operForm");
	
	// list 버튼 클릭시 /board/list 로 이동
	$(".btn-info").click(function(){
		location.href = "/board/list";
	})
		
	// modify 버튼 클릭시 operForm 이동
	$(".btn-default").click(function(){
		operForm.submit();
	})
})