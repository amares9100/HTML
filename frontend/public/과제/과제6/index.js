// 1. userbox DOM객체 가져오기

let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let monbox = document.querySelector('.monbox')
let mlogbox = document.querySelector('.mlogbox')
let monHP = document.querySelector('.monHP')
let monatk = document.querySelector('.monatk')
let monatk2 = document.querySelector('.monatk2')
let userHP = document.querySelector('.userHP')
let lv = document.querySelector('.lv')

let u_left = 10; // 유저 첫위치
let m_left = 800;// 몬스터 첫위치

let user = {
	HP : 100 , exp : 0 , Lv : 1 , pwr : 10 , exp : 0
}
let monster = [
	{name : 'm1' , HP : 100 , pwr : 5 , img : 'img/mon1.gif' , exp : 100},
	{name : 'm2' , HP : 130 , pwr : 7 , img : 'img/mon2.gif' , exp : 100},
	{name : 'm3' , HP : 160 , pwr : 10 , img : 'img/mon3.gif' , exp : 100},
	{name : 'm4' , HP : 200 , pwr : 12 , img : 'img/mon4.gif' , exp : 200},
	{name : 'm5' , HP : 240 , pwr : 15 , img : 'img/mon5.gif' , exp : 300}
	]

let stage = 0;




document.addEventListener( 'keydown' , (e) => {
	
	//console.log(e.keyCode)
	
	let key = e.keyCode
	
	
	if(key == 83){
		userbox.style.backgroundImage = `url("img/esc.gif")`
		user.HP = 100+(user.Lv*20);
		userHP.innerHTML=`${user.HP}`
		userHP.style.width = `${ user.HP*2 }px`;
	}
	else if(key == 37){ // 왼쪽 이동
		u_left -= 10
	u_left = u_left < 0 ? 0 : u_left;
	body();
	}
	else if (key == 39){ // 오른쪽 이동
		u_left += 10
		u_left = u_left > 910 ? 910 : u_left;
		userbox.style.backgroundImage = `url("img/user1.png")`
		body()
	}
	else if(key == 65){ // 공격
		userbox.style.backgroundImage = `url("img/user1.png")`
		// 과제6 
		document.querySelector('.userbox').innerHTML=`<div class="att"></div>`
		if(m_left-u_left < 150 ){
			m_left += 50;
			monbox.style.left = `${ m_left }px`;
			let atk = parseInt((user.Lv*user.pwr)+parseInt(Math.random()*10));
			
			monster[stage].HP -= atk
			monHP.style.width = `${ monster[stage].HP }px`;
			monatk.innerHTML=`<div>남은체력: ${monster[stage].HP}</div>`
			monatk2.innerHTML=`<div>${atk}</div>`
			end();
			st();
			
		}
	}
	userbox.style.left = `${ u_left }px`
	
	logbox.innerHTML=`<div>유저 좌표 : ${u_left}</div>`
	
})




document.addEventListener('keyup' , (e)=> {
	userbox.style.backgroundImage = `url("img/user.png")`
	document.querySelector('.userbox').innerHTML=''
})

// 3. 몬스터 이동 난수[랜덤 -> 1초]
	// setInterval(()=> , 밀리초(1000/1초))
setInterval(mon_moving , 1000 );

function mon_moving(){
	// 1. 난수 +-10
	let rand = parseInt(Math.random()*70+1); // 이동 거리
	let rand2 = parseInt(Math.random()*2); // 이동방향
	if(rand2 == 1 ) m_left += rand
	else m_left -= rand
	
	
	m_left += rand
	m_left -= rand
	body()
	// 화면고정
	if(m_left < 0 )m_left = 0;
	if(m_left > 900)m_left = 900;
	
	
	
	monbox.style.left = `${ m_left }px`;
	mlogbox.innerHTML=`<div>몬스터 좌표 : ${m_left}</div>`
}

function st(){
	
	if(monster[stage].HP <= 0){
	LV();
	stage++;
	monbox.style.backgroundImage = `url("${monster[stage].img}")`
	monHP.style.width = `${ monster[stage].HP }px`;
	monatk2.innerHTML=`<div></div>`
	monatk.innerHTML=`<div>남은체력:</div>`
	user.HP = 100+(user.Lv*20);
	userHP.innerHTML=`${user.HP}`
	userHP.style.width = `${ user.HP*2 }px`;
	u_left = 10;
	m_left = 800;
	lv.innerHTML=`Lv : ${user.Lv}`
	alert('stage' + (stage+1))

}
}

function end(){
	if(monster[4].HP <= 0){
		alert('승리하였습니다.')
}
}


lv.innerHTML=`Lv : ${user.Lv}`
userHP.innerHTML=`${100+(user.Lv*20)}`
function body(){
	if(m_left-u_left < 100){
		user.HP -= monster[stage].pwr
		userHP.innerHTML=`${user.HP}`
		userHP.style.width = `${ user.HP*2 }px`;
		}
	if(user.HP <= 0){
		alert('패배하였습니다.')
		user.HP = 999999;
		return false;
	}
}

function LV(){
	user.exp += monster[stage].exp
		if(user.exp > 100+(user.Lv*50)){
		user.Lv++;
		let eexp = user.exp-(100+(user.Lv*50))
		console.log(eexp)
		user.exp = eexp
		console.log(user.exp)
		alert('lv업')
		return false;
	}
}









