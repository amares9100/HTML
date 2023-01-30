

let product_list = 
[{img : '/JSP/img/item1.gif' , title : '롱 패딩 코트' , size : '[M , L]' , price : 200000 ,discount : 0.23 , like : 54 , review : 412},
{img : '/JSP/img/item2.gif' , title : '오프숄더 라운드넥' , size : '[M , L]' , price : 300000 ,discount : 0.25 , like : 55 , review : 200},
{img : '/JSP/img/item3.gif' , title : '오프숄더 셔츠' , size : '[M , L]' , price : 100000 ,discount : 0.30 , like : 60 , review : 100},
{img : '/JSP/img/item4.gif' , title : '루즈핏 가디건' , size : '[M , L]' , price : 240000 ,discount : 0.25 , like : 100 , review : 60},
{img : '/JSP/img/item5.gif' , title : '샤 스커트 셋트' , size : '[M , L]' , price : 270000 ,discount : 0.20 , like : 220 , review : 500},
{img : '/JSP/img/item6.gif' , title : '카라 스트라이프 셔츠' , size : '[M , L]' , price : 150000 ,discount : 0.30 , like : 80 , review : 752}
]

product_print();
function product_print(){
	let html =''
	product_list.forEach((o , i) => {
	html+=`
			<div class="item"><!-- 제품 1개 -->
				<img src="${o.img}"> <!-- 제품 이미지 -->
				<div class="item_info"><!-- 제품정보 구역 -->
					<div class="item_title">${o.title}</div>	<!-- 제품명 -->
					<div class="item_size">${o.size}</div>	<!-- 제품사이즈 -->
					<div class="item_price">${o.price}</div>	<!-- 원가 -->
					<div>
						<span class="item_sale">${(o.price*(1-o.discount)).toLocaleString()}</span>	<!-- 판매가 -->
						<span class="item_discount">${parseInt(o.discount*100)}%</span><!-- 할인율 -->
					</div>
				</div>
				<div class="item_bottom"><!-- 제품정보 하단구역 -->
					<div>
						<span class="badge rounded-pill text-bg-primary">주문폭주</span>
						<span class="badge rounded-pill text-bg-danger">1+1</span>
					</div>
					<div class="item_review">찜 ${o.like} · 리뷰수 ${o.review}</div>
				</div>
			</div>
	`
	})
	document.querySelector('.itembox').innerHTML=html;
}




