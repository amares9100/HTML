
let contents=[
	{no : 1 , title : '샘플' , name : '재석' , ymd : '20230131' , read : 555}
]


content_print();

function content_print(){
	let html =`<tr>
					<th width="10%">순번</th>
					<th width="50%">제목</th>
					<th width="10%">이름</th>
					<th width="20%">등록일</th>
					<th width="10%">조회수</th>
				</tr>`;
				
	contents.forEach((o , i)=> {
		
		html += `<tr>
					<td>${o.no}</td>
					<td>${o.title}</td>
					<td>${o.name}</td>
					<td>${o.ymd}</td>
					<td>${o.read}</td>
				</tr>`
	})
	document.querySelector('.table').innerHTML=html;
}




























