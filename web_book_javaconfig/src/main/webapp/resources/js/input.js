/**
 *  insert.jsp validation
 */
$(function(){
	//입력 버튼이 클릭되면 
	$(".btn-primary").click(function(e){
		//submit 기능중지
		e.preventDefault(); 
		
		// code, price 사용자 입력값 가져온 후 숫자로 들어왔는지 확인하기
		// 사용자의 입력값 확인 => 숫자 or 문자 : isNaN() // 정규식
		let code = $('#code');
		let price = $('#price');
		
		// Not a Number 
		if(!/^[0-9]{4}$/.test(code.val())){
			// 숫자가 아니라면 메세지 띄우고 돌아가기
			alert('코드를 확인해 주세요.');
			code.select(); // 코드 요소 안에 있는 값을 블록으로 선택
			return;
		}	
		if(!/^[0-9]+$/.test(price.val())){
			alert('가격을 확인해 주세요.');
			price.select(); 
			return;
		}	
		// 입력이 올바르게 되었다면 form submit 시키기
		$("form").submit();
	})	
})
