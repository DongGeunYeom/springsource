/**
 *  changePwd.jsp 스크립트
 */
$(function(){
	$(".btn-primary").click(function(e){
		e.preventDefault();
		
		let param = {
			userid:'meronot1',
			confirm_password:$("#confirm_password").val()
		};
		
		$.ajax({
			url:'meronot1',
			type:'put',
			contentType:'application/json',
			data:JSON.stringify(param),
			success:function(data){
				alert(data);
			},
			error:function(xhr,status,error){
				alert(xhr.responseTexT);
			}
			
		})
		
	})
	
})