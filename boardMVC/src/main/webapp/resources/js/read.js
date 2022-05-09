/**
 * read.jsp 스크립트
 */
$(function(){
	
	let operForm = $("#operForm");
	
	// list 버튼 클릭시 /board/list 로 이동
	$(".btn-info").click(function(){
		// operForm bno 태그 제거하기
		operForm.find("input[name='bno']").remove();
		
		// operForm action 수정
		operForm.attr("action", "/board/list");
		
		// operForm 보내기
		operForm.submit();
	})
		
	// modify 버튼 클릭시 operForm 이동
	$(".btn-default").click(function(){
		operForm.submit();
	})
	
	// 첨부파일 가져오기 - 무조건 실행
	$.getJSON({
		url:'getAttachList',
		data:{
			bno:bno
		},
		success:function(data){
			console.log(data);
		}	
	})
})