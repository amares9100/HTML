/*
 - 출력
	콘솔출력 : console.log( )
	알람메시지출력 : alert( )
	HTML 출력 : 
		1. document.write( )
		2. document.querySelector().innerHTML
 
 - 입력
 	1. 알람메시지입력 : prompt( )
 	2. html입력 : document.querySelector().value
 
 */
/*let out = ''
// ex1) 입력받은 수 만큼 * 출력

let ex1 = Number( prompt('ex1) 별 개수') )
for(let i = 1 ; i <= ex1 ; i++){ //for s
	//i는 1부터 입력받은 수까지 1씩 증가를 반복
	out += '*'
}//for e
console.log(out)*/

// ex2) 입력받은 수 만큼 * 출력 [ 3줄마다 줄바꿈]
/*out = ''
let ex2 = Number( prompt('ex2) 별 개수'))
for( let i = 1 ; i <= ex2 ; i++ ){ //for s
	//1. 별출력
	out += '*'
	//2. 줄바꿈 반복
	if( i % 3 == 0){out += '\n'}
}
console.log(out)*/


//문제1
/*1.입력받은 줄수[line]만큼 출력
ex)5입력
*
**
***
****
*****
*/
/*
let out = ''

let ex1 = Number( prompt('ex1) 별 개수') )

for(let i = 1 ; i <= ex1 ; i++ ){
	
	
	for(let s = 1 ; s<=i ; s++){
		out += '*'
}
	out += '\n'
}
console.log(out)*/



//문제2
/*
2.입력받은 줄수[line]만큼 출력 [역순]
*****
****
***
**
*
*/


/*out = ''

let ex2 = Number( prompt('ex2) 별 개수') )

for(let i = 1 ; i <= ex2 ; i++ ){
	
	
	for(let s = 1 ; s<=ex2-i+1 ; s++){
		out += '*'
}
	out += '\n'
}
console.log(out)
*/

//문제3
/*2.입력받은 줄수[line]만큼 출력 [역순]
    *
   **
  ***
 ****
*****
*/

/*let out3 = ''

let ex3 = Number( prompt('ex3) 별 개수') )

for(let i = 1 ; i <= ex3 ; i++ ){
	
	for(let s = 1 ; s<=ex3-i ; s++){
		out3 += ' '	
}
	for(let st = 1 ; st <= i ; st++ ){
		out3 += '*'		

}
out3 += '\n'
}
console.log(out3)
*/
//문제4
/*4.입력받은 줄수[line]만큼 출력
*****
 ****
  ***
   **
    *
*/

/*let out4 = ''

let ex4 = Number( prompt('ex3) 별 개수') )

for(let i = 1 ; i <= ex4 ; i++ ){
	
	for(let s = 1 ; s<=i-1; s++){
		out4 += ' '	
}
	for(let st = 1 ; st <= ex4-i+1 ; st++ ){
		out4 += '*'		

}
out4 += '\n'
}
console.log(out4)
*/

//문제5
/*5. 입력값
				i[line]			s[공백]			st
     *			i=1				1 2 3 4			1
    ***			i=2				1 2 3 			1 2 3
   *****		i=3				1 2 			1 2 3 4 5  
  *******		i=4				1				1 2 3 4 5 6 7 
 *********		i=5								1 2 3 4 5 6 7 8 9
*/
/*
let out5 = ''

let ex5 = Number( prompt('ex5) 별 개수') )

for(let i = 1 ; i <= ex5 ; i++ ){

	for(let s = 1 ; s<=ex5-i ; s++){
		out5 += ' '	
}
	for(let st = 1 ; st <= i*2-1 ; st++ ){
		out5 += '*'		
}

out5 += '\n'
}
console.log(out5)*/

//문제6
/*6.
     *     *     
      *   *      
       * *       
        *
       * *       
      *   *      
     *     *     
*/


//과제1
/*아래 코드 실행후 코드설명-2인1조
      *
     ***
    *****
   *******
   *******
    *****
     ***
      *
*/


/*let out6 = ''

let ex6 = Number( prompt('ex5) 별 개수') )


for(let i = 1 ; i <= ex6 ; i++ ){

	for(let s = 1 ; s<=ex6-i ; s++){
		out6 += ' '	
}
	for(let st = 1 ; st <= i*2-1 ; st++ ){
		out6 += '*'		
}

out6 += '\n'
}
*/

let out6 = ''

let ex6 = Number( prompt('과제)') )

						//피라미드 시작
for(let i = 1 ; i <= ex6 ; i++ ){  			//줄수=i 입력값(ex6)과 작거나 같을때까지 증가

	for(let s = 1 ; s<=ex6-i ; s++){		//빈칸=s 입력값(ex6)-줄수(i) 보다 작거나 같을때까지 증가
		out6 += ' '	
}
	for(let st = 1 ; st <= i*2-1 ; st++ ){	//별수=st 줄수(i)*2-1 보다 작거나 같을때까지 증가
		out6 += '*'		
}						
out6 += '\n'
}						//피라미드 끝	
						//역피라미드 시작
for(let i = 1 ; i <= ex6 ; i++ ){			//줄수=i 입력값(ex6)과 작거나 같을때까지 증가
	
	for(let s = 1 ; s<=i-1; s++){			//빈칸=s 줄수(i)-1 보다 작거나 같을때까지 증가
		out6 += ' '	
}
	for(let st = 1 ; st <= (ex6-i)*2+1 ; st++ ){ //별수=st (입력값-줄수)*2+1 보다 작거나 같을때까지 증가
		out6 += '*'
}
out6 += '\n'
}						//역피라미드 끝		
console.log(out6)





