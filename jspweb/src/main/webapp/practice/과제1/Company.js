function regist(){
	let  signupForm = document.querySelectorAll('.signupForm')[0]
	console.log(signupForm);
	let formDate = new FormData(signupForm);
	console.log(formDate);
	$.ajax({
		url:"/jspweb/Company",
		method:"post",
		data:formDate,
		contentType : false ,			
		processData : false ,	
		success: (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
				print();
			}else{ alert('회원가입실패') }
		}
	})
}
print();
function print(){
	
	$.ajax({
		url : "/jspweb/Company" ,
		method : "get" ,
		data : {"state" : 1} ,
		success : (r) =>{console.log('ajax확인')
		console.log(r)
		
			let html = 
						`<tr>
							<th> 사원번호 </th>
							<th> 사원사진 </th>
							<th> 사원명 </th>
							<th> 직급 </th>
							<th> 고용형태 </th>
							<th> 부서 </th>
							<th> 입사일 </th>
							<th> 퇴사일 </th>
							<th> 퇴사사유 </th>
							<th> 비고 </th>
						</tr>`;
			
			
			r.forEach((o , i ) => {
				//<img src="/jspweb/Ex/Member/pimg/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%">
				html += 
						`<tr>
							<td> ${o.wno}</td>
							<td><img src="/jspweb/practice/과제1/img/${o.picture == null ? 'X.jpg' : o.picture}" width="20%"></td>
							<td> ${o.name}</td>
							<td> ${o.grade}</td>
							<td> ${o.worker}</td>
							<td> ${o.department}</td>
							<td> ${o.joinDate}</td>
							<td> ${o.retire == null ? ' ' : o.retire}</td>
							<td> ${o.reason == null ? ' ' : o.reason}</td>
							<td> <button type="button" onclick="upDate(${o.wno})">수정</button><button type="button" onclick="openModal2(${o.wno})">삭제</button></td>
						</tr>`;
			})
			document.querySelector('.print').innerHTML = html;
			}
	});	
}

function openModal2(wno){
	document.querySelector('.modal_wrap2').style.display = 'flex';
	
	let html = `<div>선택한 사원번호 : ${wno}</div>
				삭제할 사원번호 확인 : <input type="text" class="del_wno">`
	let html2=`<button onclick="del2(${wno})" class="modal_check" 	type="button">확인</button>
				<button onclick="closeModal2()" class="modal_cencel" type="button">닫기</button>`
				
				document.querySelector('.modal_content2').innerHTML =html;
				document.querySelector('.modal_btns2').innerHTML =html2;
}
function closeModal2(){
	document.querySelector('.modal_wrap2').style.display = 'none';
}
function del2(wno){
	console.log(wno);
	let del_wno = document.querySelector('.del_wno').value;
	console.log(del_wno);
	if(del_wno == wno){
		$.ajax({
		url:"/jspweb/Company",
		method:"delete",
		data: {"wno" : wno},
		success: (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('삭제성공');
				closeModal2();
				print();
			}else{ alert('삭제실패') }
		}
	})
	}else{alert('삭제실패 : 번호를 확인해주세요.')}
	
}


/* 수정 */

//수정
function upDate(wno){
		document.querySelector('.modal_wrap').style.display = 'flex';
		
		$.ajax({
		url:"/jspweb/Company",
		method:"get",
		data:{"wno":wno ,
			"state" : 2
			},
		success: (r)=>{
		let html = `<tr>
							<th width="10%"> 사원번호 </th>
							<th width="10%" > 사원사진 </th>
							<th width="10%"> 사원명 </th>
							<th width="10%"> 직급 </th>
							<th width="10%"> 고용형태 </th>
							<th width="10%"> 부서 </th>
							<th width="10%"> 입사일 </th>
							<th width="10%"> 퇴사일 </th>
							<th width="10%"> 퇴사사유 </th>
					</tr>
				
				<tr>
					
						<td> <input type="number"   value="${r.wno}" name="wno" readonly></td>
						<td><img src="/jspweb/practice/과제1/img/${r.picture == null ? '' : r.picture}" width="40%"
							 name="picture">
							<input type="file"  class="picture" name="picture">
						</td>
								<td> <input type="text" value="${r.name}" name="name"></td>
								<td> <div>${r.grade}</div>
									<select class="grade" name="grade"> 
										<option value="사원" > 사원 </option>
										<option value="대리" > 대리 </option>
										<option value="부장" > 부장 </option>
										<option value="과장" > 과장 </option>
										<option value="대표" > 대표 </option>
									</select> 
								</td>
								<td> <div>${r.worker}</div>
									<select class="worker" name="worker"> 
										<option value="일용직" > 일용직 </option>
										<option value="정규직" > 정규직 </option>
										<option value="임원" > 임원 </option>
									</select> 
								</td>
								<td>  <div>${r.department}</div>
									<select class="department" name="department"> 
										<option value="인사팀" > 인사팀 </option>
										<option value="영업팀"> 영업팀 </option>
										<option value="개발팀" > 개발팀 </option>
									</select> 
								</td>
								<td>  <div>${r.joinDate}</div>
								<input type="date" value="${r.joinDate}" name="join"></td>
								<td>  <input type="date" value="${r.retire}" name="retire"></td>
								<td>  <input type="text" value="${r.reason}" name="reason"></td>
					
				</tr>`;
						
	document.querySelector('.edit').innerHTML= html;
		}
	});
}

function edit(){
	let  editForm = document.querySelectorAll('.editForm')[0]
	console.log(editForm);
	let formDate = new FormData(editForm);
	console.log(formDate);
	
	$.ajax({
		url:"/jspweb/Company",
		method:"put",
		data:formDate,
		contentType : false ,			
		processData : false ,	
		success: (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('수정 성공');
				print();
				closeModal();
			}else{ alert('수정 실패') }
		}
	})
}

function closeModal(){
	document.querySelector('.modal_wrap').style.display = 'none';
}

function all_list(){
	print();
}

function grade(){
	let grade = document.querySelector('.list_grade').value;
	
	$.ajax({
		url : "/jspweb/Company" ,
		method : "get" ,
		data : {"state" : 3,
				"grade" : grade	} ,
		success : (r) =>{console.log('ajax확인')
		
		let html = 
						`<tr>
							<th> 사원번호 </th>
							<th> 사원사진 </th>
							<th> 사원명 </th>
							<th> 직급 </th>
							<th> 고용형태 </th>
							<th> 부서 </th>
							<th> 입사일 </th>
							<th> 퇴사일 </th>
							<th> 퇴사사유 </th>
							<th> 비고 </th>
						</tr>`;
			
			
			r.forEach((o , i ) => {
				//<img src="/jspweb/Ex/Member/pimg/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%">
				html += 
						`<tr>
							<td> ${o.wno}</td>
							<td><img src="/jspweb/practice/과제1/img/${o.picture == null ? 'X.jpg' : o.picture}" width="20%"></td>
							<td> ${o.name}</td>
							<td> ${o.grade}</td>
							<td> ${o.worker}</td>
							<td> ${o.department}</td>
							<td> ${o.joinDate}</td>
							<td> ${o.retire == null ? ' ' : o.retire}</td>
							<td> ${o.reason == null ? ' ' : o.reason}</td>
							<td> <button type="button" onclick="upDate(${o.wno})">수정</button><button type="button" onclick="openModal2(${o.wno})">삭제</button></td>
						</tr>`;
			})
			document.querySelector('.print').innerHTML = html;
			}
		});
}

function retire(){
	$.ajax({
		url : "/jspweb/Company" ,
		method : "get" ,
		data : {"state" : 4} ,
		success : (r) =>{console.log('ajax확인')
		
		let html = 
						`<tr>
							<th> 사원번호 </th>
							<th> 사원사진 </th>
							<th> 사원명 </th>
							<th> 직급 </th>
							<th> 고용형태 </th>
							<th> 부서 </th>
							<th> 입사일 </th>
							<th> 퇴사일 </th>
							<th> 퇴사사유 </th>
							<th> 비고 </th>
						</tr>`;
			
			
			r.forEach((o , i ) => {
				//<img src="/jspweb/Ex/Member/pimg/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%">
				html += 
						`<tr>
							<td> ${o.wno}</td>
							<td><img src="/jspweb/practice/과제1/img/${o.picture == null ? 'X.jpg' : o.picture}" width="20%"></td>
							<td> ${o.name}</td>
							<td> ${o.grade}</td>
							<td> ${o.worker}</td>
							<td> ${o.department}</td>
							<td> ${o.joinDate}</td>
							<td> ${o.retire == null ? ' ' : o.retire}</td>
							<td> ${o.reason == null ? ' ' : o.reason}</td>
							<td> <button type="button" onclick="upDate(${o.wno})">수정</button><button type="button" onclick="openModal2(${o.wno})">삭제</button></td>
						</tr>`;
			})
			document.querySelector('.print').innerHTML = html;
			}
		});
}
























