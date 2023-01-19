

//공통--------------------------------------------------------------------------------
let categorylist = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']

let burgerList = [
	
	{name : '몰라몰라버거' , price : 9000 , img : 'burger1.png' , category : '프리미엄'},
	{name : '몰라몰라버거2' , price : 8000 , img : 'burger2.png' , category : '프리미엄'},
	{name : '몰라몰라버거3' , price : 5000 , img : 'burger3.png' , category : '스페셜'}
]

let cartList = []

let orderList = []

//------------------------------------------------------------------------------------


category_print();
category_select(0);
burger_print(0);

function category_print(){
	
	// 1. html 구성
	let html = `<ul>`
				
	for(let i = 0 ; i < categorylist.length ; i++){
		html += `<li class="categoryli" onclick="category_select(${i})">${categorylist[i]}</li>`
	}
	html +=`</ul>`
	document.querySelector('.category').innerHTML= html
				
}

// 2. 카테고리 선택 함수
function category_select(i){
	let categoryli = document.querySelectorAll(".categoryli")
	for(let j = 0 ; j<categoryli.length ; j++){
		if(j == i){ // 선택된 li
			categoryli[j].classList.add('categoryselect'); // 해당 마크업의 class 식별자 추가
		}
		else{
			categoryli[j].classList.remove('categoryselect'); // 선택되지않은 li
		}
	}
	burger_print(i)
}


// 3. 제품 출력 함수 [1. JS열었을때 / 2. 카테고리 바뀌었을때]
function burger_print(index){
	//1. html 구성
	
	let html = '';
	for(let i = 0 ; i<burgerList.length ; i++){
		if(burgerList[i].category == categorylist[index]){
			// i번째 버거 객체의 카테고리와 선택된 카테고리가 같으면
		
		html += `<div class="burger">
					<img src="${burgerList[i].img}" width="100%" onclick="cart_print(${i})">
					<div>
						<div class="btitle">${burgerList[i].name}</div>
						<div class="pprice" >${burgerList[i].price.toLocaleString()}원</div>
					</div>
				</div>`
	}
}
	
	//2. 구성된 html 마크업대입
	document.querySelector('.burgerbox').innerHTML=html

}

function cart_print(i){
	cartList.push(burgerList[i]) // 주문한 버거 카트에 담기
	// 총주문수량 표시
	카트프린트();
}


// 주문취소
function cancel(){
	alert('주문 취소합니다.')
	cartList.splice(0);
	카트프린트();
}


// 6. 주문 하기 버튼 
function order(){
	alert('주문 합니다.');
	// 1. 주문번호 만들기  [ // 마지막인덱스 : 배열명.length-1 ]
	let no = 0;
	if( orderList.length == 0 ){ no = 1;} // 1. 만약에 길이가 0 이면 [ 주문 하나도 없으면 주문번호 1 ]
	else{ no = orderList[ orderList.length-1 ].no+1 } // 2. 아니면 마지막인덱스 주문객체의 주문번호+1 를 다운 주문번호 사용 
	
	// 2. 카트배열 -> 새로운배열 [ 주문객체에 카트배열 대입시 카트배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 동일하기 때문에 ]
	let for배열 = cartList.forEach( (o) => { console.log(o); return o; } )
	console.log( for배열 )
	console.log("--------------------------------------")
	let map배열 = cartList.map( (o) => {console.log(o); return o; } )

	
	// 3. 총가격 만들기 
	let total = 0;
	for( let i = 0 ; i< map배열.length ; i++ ){ total += map배열[i].price }
	
	// 1. 주문
		// 1. order 객체 만들기 
		let order = { 
			no :  no ,
			items : map배열 ,			// 카트배열 ---> 새로운배열 
			time :  new Date() ,	// new Date() : 현재 날짜/시간 호출   
			state : true ,			// true : 일단 주문	// false : 주문완료  
			complete : 0 ,			// 아직 주문 완료 되기전 
			price : total			// cartlist 배열내 버거객체들의 총금액 합계 
		}
		// 2. order 객체 배열에 저장 
		orderList.push( order  );
	// 2. 주문완료 후 
	cartList.splice(0)
	카트프린트();
}	
	



// 카트내 버거출력

function 카트프린트(){
	document.querySelector('.pcount').innerHTML=cartList.length
	
	let total = 0; // 버거 총가격 저장할곳
	let html = ''; // 버거리스트 저장할곳
	for( let j = 0 ; j<cartList.length ; j++ ){
		html+=`<div class="item">
				<div class="ititle">${cartList[j].name}</div>
				<div class="iprice">${cartList[j].price.toLocaleString()}</div>
				</div>` // 주문한 버거리스트
		total += cartList[j].price // 버거 총가격
	}
	document.querySelector('.cartbottom').innerHTML=html
	document.querySelector('.ptotal').innerHTML=total.toLocaleString()
}


/*관리자 요구사항

1. 버거목록
	1. 버거 이름
	2. 카테고리명
	3. 가격
	4. 이미지 : img폴더에 이미지 이름과 확장자명까지 맞춰서 등록
		-예) 
			버거 이름 : ????버거
			카테고리명 : 와퍼		- 카테고리배열에 존재하는 카테고리만 입력가능/ 아니면 등록실패
			가격 : 3000 		- 가격은 숫자만 입력
			이미지명 : ????버거.JPG        - 업로드 불가능해서 img폴더에 미리 넣어두기
				- 이미지 3개정도

2. 등록된 버거 현황 출력
	테이블로 출력
예시)
	번호	이미지		버거이름		카테고리		가격		비고
	1	[img](작게)	몰라몰라버거	프리미엄		9000원		삭제/수정
	2	[img](작게)	몰라몰라버거2	프리미엄		8000원		삭제/수정
	3	[img](작게)	몰라몰라버거3	스페셜		7000원		삭제/수정

		*수정은 가격만 가능하게.

3. 주문된 주문 목록 현황 출력
	주문번호		버거이름		상태		비고
	1		몰라몰라버거	[주문완료]		
	1		몰라몰라버거	[주문완료]	
	2		몰라몰라버거2	주문요청		[주문완료]
	3		몰라몰라버거3	주문요청		[주문완료]
	3		몰라몰라버거	주문요청		[주문완료]
		*주문 완료 버튼 클릭시 상태를 주문완료로 변경
		*주문 완료시 주문완료버튼 숨기기


4. 버거 구매량과 매출액
	번호		버거이름			판매수량			매출액		순위[매출액]
	1		몰라몰라버거		n개			n * 가격		1
	2		몰라몰라버거2		n개			n * 가격		2
	3		몰라몰라버거3		n개			n * 가격		3

		* 판매수량은 주문목록내 주문된 items안에 있는 모든 제품들을의 총수량*/

// 관리자 --------------------------------------------
 

admin_burgerlist();
admin_burger();


function admin_burgerlist(){ // 버거 현황
	let admin_table =`<tr>
						<th>버거 이름</th><th>카테고리명</th><th>가격</th><th>이미지</th>
						</tr>`
	for(let i = 0 ; i <burgerList.length ; i++){
		admin_table +=`<tr>
						<td>${burgerList[i].name}</td><td>${burgerList[i].category}</td><td>${burgerList[i].price}</td><td><img src="${burgerList[i].img}" style="width: 40px;"></td>
						</tr>`
	}
	document.querySelector('.admin_burgerlist').innerHTML=admin_table
}

function admin_burger(){ // 버거 목록(삭제/제거)
	let admin_burgertable = `<tr>
						<th>등록번호</th><th>버거이미지</th><th>버거이름</th><th>카테고리</th><th>가격</th><th>비고</th>
						</tr>`
	for(let i = 0 ; i <burgerList.length ; i++){
		admin_burgertable +=`<tr>
						<td>${i+1}</td><td><img src="${burgerList[i].img}" style="width: 40px;"></td><td>${burgerList[i].name}</td><td>${burgerList[i].category}</td><td>${burgerList[i].price}</td><td><button onclick="burgerDel(${i})">삭제하기</button></td>
						</tr>`
	}
	document.querySelector('.admin_burger').innerHTML=admin_burgertable
}

function burgerDel(y){
	burgerList.splice( y , 1 )
	admin_burger();
	admin_burgerlist();
	burger_print(0);
}

function new_burger(){
	 let new_name = document.querySelector('.new_name').value
	 let new_category = document.querySelector('.new_category').value
	 let new_price = 0;
	 new_price = parseInt(document.querySelector('.new_price').value)
	 let new_img = document.querySelector('.new_img').value
	
	for(let i = 0 ; i<categorylist.length ; i++){
		if(new_category.includes(categorylist[i])){
		
		let new_burger = 
		[{name : new_name , price : new_price , img : new_img , category : new_category}]
		
		burgerList.push(new_burger[0])
		admin_burger();
		admin_burgerlist();
		burger_print(0);
		alert('등록되었습니다.')
		return false;
		}	
	}
} 
ordercu();
function ordercu(){
	let admin_ordercu =`<tr>
						<th>주문번호</th><th>주문목록</th><th>상태</th><th>요청시간</th><th>완료</th>
						</tr>`

	
	

	
	
	
	document.querySelector('.admin_ordercu').innerHTML=admin_ordercu
}



function re(){

	console.log(orderList) 
	console.log(orderList[0]) 

	

	let arr = orderList[Object.keys(orderList)[0]].items
	
	console.log('주문시간 : ' + orderList[Object.keys(orderList)[0]].time)
	
	console.log('주문순서 : ' + orderList[Object.keys(orderList)[0]].no)
	
	console.log('가격 : ' + orderList[Object.keys(orderList)[0]].price)
	
	// 버거이름 가져오기 + 확인
	for (let i = 0; i < arr.length; i++ ) {
	
  	console.log(arr[Object.keys(arr)[i]].name);
}
	
}













