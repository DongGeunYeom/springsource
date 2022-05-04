/**
 * read.jsp 댓글 스크립트
 */
// 모듈화(서버 쪽의 ajax 요청을 모아 둔 함수)
let replyService = (function(){
	
	function add(reply,callback){
		console.log('add 메소드 실행');
		
		$.ajax({
			url:'/replies/new',
			type:'post',
			contentType:'application/json',
			data:JSON.stringify(reply),
			success:function(result){
				if(callback){
					callback(result);
				}
			}
		})
		
	}// add 종료
	
	function getList(param, callback){
		
		let bno = param.bno;
		let page = param.page;
		$.getJSON({
			url:'/replies/pages/'+bno+'/'+page,
			success:function(result){
				if(callback){
					callback(result.replyCnt, result.list);
				}
			}
		})
	}// getList 종료
	
	function get(rno, callback){
		
		$.getJSON({
			url:'/replies/'+rno,
			success:function(result){
				if(callback){
					callback(result);
				}
			}
		})
	}// get종료
	
	function update(reply,callback){
		
		$.ajax({
			url:'/replies/'+reply.rno,
			type:'put',
			contentType:'application/json',
			data:JSON.stringify(reply),
			success:function(result){
				if(callback){
					callback(result);
				}
			}
		})
	} // update 종료
	
		function remove(rno,callback){
		
		$.ajax({
			url:'/replies/'+rno,
			type:'delete',
			success:function(result){
				if(callback){
					callback(result);
				}
			}
		})
	} // remove 종료
	
	function displayTime(timeValue){
		// ms ==> 변환
		// 댓글 단 날짜가 오늘이라면 시분초, 오늘이 아니라면 년월일
		let today = new Date();
		
		let gap = today.getTime() - timeValue;
		let dateObj = new Date(timeValue);
		
		if(gap<(1000*60*60*24)){
			let hh = dateObj.getHours();
			let mi = dateObj.getMinutes();
			let ss = dateObj.getSeconds();
			
			return [(hh>9?'':'0')+hh,':',(mi>9?'':'0')+mi,':',(ss>9?'':'0')+ss].join('');	
		
		}else{
			let yy = dateObj.getFullYear();
			let mm = dateObj.getMonth()+1;
			let dd = dateObj.getDate();
			
			return [yy,'/',(mm>9?'':'0')+mm, '/',(dd>9?'':'0')+dd].join('');	
		}	
	}// displayTime 종료
	
	
	return {
		add:add,
		getList:getList,
		get:get,
		update:update,
		remove:remove,
		displayTime:displayTime,
	}
	
})();

$(function(){
	
	// 댓글 리스트 영역 가져오기
	let replyUl = $(".chat");
	
	// 댓글 전체 가져오기 호출
	showList(1);
	
	// 모달 영역 가져오기
	let modal = $(".modal");
	// 모달 창 안에 있는 input 요소 찾기
	let modalInputReply = modal.find("input[name='reply']");
	let modalInputReplyer = modal.find("input[name='replyer']");
	let modalInputReplyDate = modal.find("input[name='replydate']");
	
	// New Reply 클릭시
	$("#addReplyBtn").click(function(){
		//날짜 input 숨기기
		modalInputReplyDate.closest("div").hide();
		
		// 등록, 닫기 버튼만 보여주기
		// 닫기 버튼을 제외한 모든 버튼 숨기기
		modal.find("button[id!='modalCloseBtn']").hide();
		// 등록 버튼 보여주기
		modal.find("#modalRegisterBtn").show();
		
		//모달 창 보여주기 
		modal.modal("show");
	})
	
	// 댓글 모달 창 등록 버튼 클릭시
	$("#modalRegisterBtn").click(function(){
		
		let reply = {
			bno:bno,
			reply:modalInputReply.val(),
			replyer:modalInputReplyer.val()
		};
	
		replyService.add(reply,function(result){
			if(result){
				//alert(result);
				// 댓글 등록이 성공하면 모달 input에 들어있는 내용 지우기
				modal.find("input").val("");
				
				// 모달 숨기기
				modal.modal("hide");
				
				// 리스트 호출
				showList(1);
			}
		});
	})
	
	
	function showList(page){
		
		// page : page||1 => page 변수값이 들어오면 사용하고 안들어오면 1
		replyService.getList({bno:bno, page:page||1},function(total,list){
			// console.log(list);
			if(list == null || list.length == 0){
				replyUl.html("");
				return;
			}
			
			let str ="";
			for(var i=0;i<list.length;i++){
				str += '<li class="left clearfix" data-rno="'+list[i].rno+'">';
				str += '<div>';
				str += '<div class="header">';
				str += '<strong class="primary-font">'+list[i].replyer+'</strong>';
				str += '<small class="pull-right text-muted">'+replyService.displayTime(list[i].replydate)+'</small>';
				str += '</div>';
				str += '<p>'+list[i].reply+'</p>';	
				str += '</div></li>';
			}
			replyUl.html(str);
		});
	} // showList 종료
	
	
	
/*	replyService.get(10,function(data){
		console.log(data);
	});*/
	
	/*replyService.update({rno:6, reply:"댓글 수정 중..."},function(result){
		if(result){
			alert(result);
		}
	});*/
	
	/*replyService.remove(5,function(result){
		if(result){
			alert(result);
		}
	});*/
	
})
