

//공통
let categorylist = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']

let burgerList = [
	
	{name : '몰라몰라버거' , price : 9000 , img : 'burger1.png' , category : '프리미엄'},
	{name : '몰라몰라버거2' , price : 8000 , img : 'burger2.png' , category : '프리미엄'},
	{name : '몰라몰라버거3' , price : 5000 , img : 'burger3.png' , category : '스페셜'}
]

let cartList = []

let orderList = []

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
	console.log(cartList)
	// 총주문수량 표시
	카트프린트();
}


// 주문취소
function cancel(){
	alert('주문 취소합니다.')
	cartList.splice(0);
	카트프린트();
}


// 주문하기
function order(){
	alert('주문합니다.')
	console.log('주문전 카트 ' + cartList)
	console.log('주문전 카트 ' + burgerList)
	//주문번호 만들기
	let no = 0;
	// 만약게 길이가 0이면 [주문이 하나도 없으면 주문번호 1]
	if(orderList.length == 0){no = 1;}
	// 아니면 마지막 인덱스 주문객체의 주문번호+1을 다음 주문번호 사용
	else {no = orderList[orderList.length-1].no+1}

	//총가격 만들기
	let total = 0;
	for(let i = 0; i<cartList.length ; i++){total += cartList[i].price}
	console.log('토탈 ' + total )
	
	
	
	let order = {
		no : no ,
		items : cartList.map( (o) => {return o;} ) , 
		time : new Date() , // new date() : 현재 날짜/시간 호출
		state : true ,		// true : 주문중  // false : 주문완료 
		complete : 0,		// 아직 주문완료전
		price : total
	}
	
	
	
	orderList.push(order)
	console.log('주문후 카트 ' + orderList )

	cartList.splice(0);
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

























