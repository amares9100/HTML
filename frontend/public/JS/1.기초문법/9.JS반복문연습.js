/*



 */

//ex1) 1부터 10이하까지 1씩 증가 반복 [한줄씩 출력]
console.log('-----------ex1-----------')
for(let i = 1 ; i <= 10 ; i++){
	console.log(i)
}
/*console.log('-----------ex2-----------')
let output = ''
for(let i = 1 ; 1 <= 10 ; i++){
	output += i
}
console.log(output)*/

console.log('-----------ex3-----------')
output = ''
// ex3) i는 1부터 10이하까지 1씩 증가 반복 [HTML출력]
for(let i = 1 ; i <=10 ; i++){
	output += i+"\t"
	document.querySelector('body').innerHTML = output
}
console.log('-----------ex4-----------')
// ex4) i는 1부터 10이하까지 1씩 증가 반복 누계
let sum = 0;
for(let i = 1 ; i <= 10 ; i++){
	sum += i
}
console.log(sum)

console.log('-----------ex5-----------')
// ex5)
sum = 0;
for( let i = 0 ; i <=100 ; i+=7){
	sum += i
//console.log( "i = " + i + "\t"+i+"<=10 " + (i<=10 ) +"\t"+ sum+"+="+i +"\t i++" ) 
}
console.log(sum)

sum = 0;
for( let i = 1 ; i<=100 ; i++){
	if(i % 7 == 0){ sum += i}
}
console.log(sum)

console.log('-----------ex6-----------')
out = ''
// ex6) (2단)구구단
for(let 곱 = 1 ; 곱 <= 9 ; 곱++){
	console.log('2 * ' + 곱 + ' = ' + (2*곱))
	out +='2 * ' + 곱 + ' = ' + (2*곱) + '<br/>'
}
document.querySelector('body').innerHTML = out

console.log('-----------ex7-----------')
// ex7) 단 : 2~9 변수 / 곱 : 1~9 변수

//1. 단만들기
for(let 단 = 2 ; 단<=9 ; 단++){
		
}

//2. 곱만들기
for(let 곱 = 1 ; 곱<=9 ; 곱++){
}

//3. 합치기
// 단이 <=9 일때 곱을 1부터 9이하까지 1씩 증가하며 반복하고 
// 이후에 단이 1씩 증감

for(let 단 = 2 ; 단<=9 ; 단++){ 
	for(let 곱 = 1 ; 곱<=9 ; 곱++){
		//4. 출력
		console.log(단 + ' * ' + 곱 + ' = ' + (단 * 곱))
}
	
}









