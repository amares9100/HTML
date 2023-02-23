/*

		사람[개발자]:DBA							DBMS								컴퓨터[DB]
		언어 : 영어,한글[문자]														기계어 : 0,1
       
       표만들기								create table 회원();					
       create table 회원();					기계어로 변환--------------------->		메모리할당


	- SQL 질의어
		1. DDL
			create
				create database DB명;		//DB생성
                create table 테이블명(		//테이블생성
					필드명 타입 제약조건,
                    필드명 타입 제약조건);
                
            drop
				drop database DB명;			// DB삭제
                drop table 테이블명;			// 테이블삭제
                drop database if exists DB명; // DB가 존재하면 삭제
                drop table if exists 테이블명; // 테이블이 존재하면 삭제
            alter
            truncate
        2. DML
			insert
				모든 필드에 데이터 추가할 경우 : insert into 테이블명 values(데이터1 , 데이터2);
                특정 필드에 데이터 추가할 경우 : insert into 테이블명(필드1 , 필드2) values(데이터1, 데이터2);
            select
				테이블의 모든 필드 검색 : select * from 테이블명;
                테이블의 특정 필드 검색 : select 필드명 , 필드명 from 테이블명;
                테이블의 조건 검색 : select * from 테이블명 where 필드값=찾을값;
									조건 and 조건 , 조건 or 조건
            update
				모든 레코드의 수정 : update 테이블명 set 필드명 = 새로운값;
                특정 레코드의 수정 : update 테이블명 set 필드명 = 새로운값 where 조건;
            delete
				모든 레코드 삭제 : delete from 테이블명;
                특정 레코드 삭제 : delete from 테이블명 where 조건;
                
        3. DCL
			grant
            revoke
        4. TCL
			commit
            rollback
		
        
        use DB명; 							// 해당 DB선택 / 사용
		auto_increment primary key 			// 자동번호부여
		not null							// 공백불가
        foreign key(현재 테이블 필드명) references member(외부테이블 PK필드명) // 해당 필드에 외부테이블의 pk를 참조
        
	-데이터 타입
		정수형 : TINYINT
				SMALLINT
                INT
                BIGINT
        실수형 : FLOAT
				DOUBLE
        문자형 : CHAR(길이) : 고정길이
				VARCHAR(길이) : 가변길이
		날짜형 : DATE 
				TIME
                DATETIME
		대용량 : TEXT
				LONGTEXT
                BOLB
                LONGBLOB
                
	- 연산자
		1. 산술연산자 : +더하기	 -빼기   *곱하기	 /나누기  div몫 mod나머지
        2. 비교연산자 : >=이상  <=이하  >초과  <미만  =같다  !=같지않다
        3. 논리연산자 : and이면서  or이거나  not부정
		4. 기타연산자
			-- in(값1 , 값2 , 값3) 		: 값1~값2 하나라도 존재하면 [ 값1 or 값2 or 값3]
            -- 값1 between 값2 and 값3	: 값2 부터 값3 사이이면 true
            -- like 					: 패턴검색
				% : 모든 문자수 대응
                _ : _개수만큼 문자수 대응
		5. null관련 연산자
			= null [x]
            필드명 is null				: null 이면
            필드명 is not null			: null이 아니면


*/




drop database market;   		-- 마켓 DB 삭제
drop database if exists market; -- 마켓 DB가 존재하면 삭제

create database market; 
use market;

drop table if exists member;	-- 테이즐이 존재하면 삭제

create table member(
	-- 필드선언
		-- 필드명은 테이블 앞글자_필드명
	mid char(8) not null primary key , -- 길이만큼 문자저장 : 최대 길이만큼
										-- not null : 공백 저장 불가능 [ 만일 공백이면 저장 실패]
										-- primary key : 식별키[필드내 중복 불가능,공백불가능]
	mname varchar(10) not null ,	   -- varchar(길이) : 가변길이 [ 데이터의 길이가 일정하지 않을때]
										-- 가변길이 : 저장된 데이터 만큼 메모리 할당
											-- varchar(8) 에서 'ABC' 저장시 5칸 메모리 자동제거
                                        -- 고정길이 : 선언된 길이 만큼 메모리 할당
											-- char(8) 에서 'ABC' 저장시 5칸 메모리 고정 [ 3칸 : ABC / 5칸 : 공백 ]
	mnumber int not null ,				-- int : 정수 +-20억정도 저장가능
    
    addr char(2) not null ,				-- 주소 최대 2글자 저장 공백불가능 
    phone1 char(3) , 					-- 국번 최대 3글자 저장 [공백 가능]
    phone2 char(8)	,					-- 전화번호 최대 8글자 저장 [공백가능]
    height smallint ,					-- smallint : +-3만정도 저장 가능
    mdebut date 						-- date : 날짜
	

);

select * from member;
-- 예제 레코드 추가 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
select * from member;
-- ---------------------------------------------------------
drop table if exists buy;
create table buy(
	bnum int auto_increment primary key , 	-- 구매번호
    mid char(8) ,							-- 구매한 회원
    bpname char(6) ,						-- 제품 이름
    bgname char(4) , 						-- 분류명
    bprice int not null ,					-- 가격
    bamout smallint not null	,			-- 수량
	foreign key(mid) references member(mid) -- 관계
    -- foreign key(외래키)
    -- foreign key(현재 테이블 필드명) references member(외부테이블 PK필드명)
);
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);
select * from buy;


-- select : 검색 
-- 1. select 필드명1 , 필드명2 from 테이블명
	select mid from member;
	select mid,mname from member;
-- 2. select * from 테이블명 
	-- *(와일드카드) : 모든것 의미 = 모든 필드 뜻
	select * from member;
-- 3. select 필드명 as '별칭명' from 테이블명
	select mid as '회원아이디' from member;
	select mid '회원아이디' from member;
-- 4. select 필드명 from 테이블명 where 조건 
	select * from member where mname = '블랙핑크';	-- 회원명[필드] 이 '블랙핑크' 인 레코드 검색
    select * from member where mnumber = 4;			-- 멤버수 필드 가 4이면
	select * from member where mheight <= 162;		-- 키 필드가 162 이하이면 
    select * from member where mheight >= 165 and mnumber > 6; -- 키 필드가 165 이상 이면서 멤버수 필드가 6 초과이면 
    select * from member where mheight >= 165 or mnumber > 6; -- 키 필드가 165 이상 이거나 멤버수 필드가 6 초과이면
	select * from member where mheight >= 163 and mheight <= 165;	-- 키 필드 163~165
    select * from member where mheight between 163 and 165;			-- 키 필드 163~165
    select * from member where maddr = '경기' or maddr ='전남' or maddr = '경남';
    select * from member where maddr in( '경기' ,'전남','경남');	-- 주소가 경기 혹은 전남 혹은 경남 중 하나이면
    select * from member where mname ='우주소녀';			-- = 같다 [ 모두 동일했을때 ]
    select * from member where mname like '우%';			-- '우' 로 시작하는 문자 찾기 
    select * from member where mname like '%우';			-- '우' 로 끝나는 문자 찾기 
    select * from member where mname like '%우%';		-- '우' 가 포함된 문자 찾기 
    select * from member where mname like '우_'	;		-- '우' 로 시작하는 두글자 찾기 
    select * from member where mname like '__우'	;		-- '우' 로 끝나는 세글자 찾기 
    select * from member where mname like '_우_';		-- 세글자 중 가운데 글자가 '우'인 문자 찾기 
    select 	mnumber 원본필드 , mnumber+1 as 더하기 ,  mnumber-1 빼기, 
			mnumber*2 곱하기 , mnumber/2 나누기 , mnumber div 2 몫 , mnumber mod 2 나머지
    from member;
    select mnumber * mheight 멤버키점수 from member;

-- 5. select * from 테이블명 order by 정렬기준필드
	-- select * from 테이블명 where 조건 order by 정렬기준
    -- 다중정렬 : 앞 정렬 후  동일한 데이터가 있을경우 하위 정렬
		-- select * from 테이블명 order by 정렬기준필드1 , 정렬기준필드2
	select * from member order by mdebut asc;	-- 과거순 -오름차순 [ asc 생략가능 ]
    select * from member order by mdebut desc;	-- 최신순 -내림차순 [ 과거날짜 작다 / 최근날짜 크다 ]
    select * from member order by mheight desc where mheight >= 164; -- 오류
    select * from member where mheight >=164 order by mheight; -- 오류 해결 
    -- 키를 내림차순으로 정렬후 동일한 키가 있을경우 동일한 키 중에서 데뷔날짜 오름차순 
    select * from member order by mheight desc , mdebut asc ;
		/*
			학년 점수		학년 정렬 -> 점수 정렬 		학년	점수
            1	50								1	50
            3	20								1 	60
			1	60								3	20
        */
        
-- 6. select * from 테이블명 limit 레코드수			: 검색 레코드 수 제한 
	-- select * from 테이블명 limit 시작레코드번호 , 개수 
	select * from member limit 3;
	select * from member limit 0 , 3;
    select * from member order by mheight desc limit 3; -- 키 상위 레코드 3개
    
-- 7. select distinct 필드명 from 테이블명			: 필드내 데이터 중복 제거 
	select maddr from member;
    select distinct maddr from member;

-- 8. select * from 테이블명 group by 그룹기준필드
	select bamout 		from buy;			-- 판매수량 필드 검색 
    select sum(bamout) 	from buy; 	-- 판매수량 필드 합계 
    select avg(bamout) 	from buy;	-- 판매수량 필드 평균 
    select max(bamout) 	from buy;	-- 판매수량 필드내 최대값 
    select min(bamout) 	from buy;	-- 판매수량 필드내 최소값 
	select count( bamout ) from buy;	-- 판매수량 필드의 레코드수	[ null 미포함]
    select count( * ) 	from buy;			-- 전체 레코드 수 			[ null 포함 ] 

	-- 1. 회원아이디[그룹] 별 로 판매수량 합계 
    select mid 회원아이디 , sum(bamout) as 구매수량총합  			from buy group by mid;
    -- 2. 회원아이디[그룹] 별 로 총매출액[ 가격*수량 ] 합계 
    select mid 회원아이디 , sum( bprice * bamout ) as 총매출액 	from buy group by mid;
	-- 3. 회원아이디[그룹] 별 로 판매수량 평균 
    select mid 회원아이디 , avg( bamout ) as 판매수량평균  		from buy group by mid;
    -- 4. 
    select mid 회원아이디 , count( * ) as 결제수량 from buy group by mid;

-- 9. select * from 테이블명 group by 그룹기준필드 having 그룹내조건 
	-- *. 회원아이디[그룹] 별 로 총매출액[ 가격*수량 ] 합계 가 1000 이상 검색 
	select mid 회원아이디 , sum( bprice * bamout ) as 총매출액
    from buy 
    group by mid 
    having sum( bprice * bamout ) >= 1000;
    
    select mid 회원아이디 , sum( bprice * bamout ) as 총매출액
    from buy 
    where sum( bprice * bamout ) >= 1000	-- 오류 발생 : sum() 집계함수 이므로 그룹 후에 조건 사용 가능 
    group by mid;	
    
-- 10.[ 전체 ] 
	-- select * from 테이블명 where 조건 group by 그룹 having 그룹조건 order by 정렬 limit 레코드수 제한
    
-- insert 
	-- 1. 특정필드에 값 삽입 : insert into 테이블명( 필드명1 , 필드명2 ) values( 값1 , 값2 );
	-- 2. 전체필드에 값 삽입 : insert into 테이블명 values( 값1 , 값2 );
    -- 3. 다중 레코드 삽입 : insert into 테이블명 values( 값1 , 값2 ) , ( 값1 , 값2 );
    -- 4. 검색된 결과를 삽입 : insert into 테이블명 select ~
		-- 검색된 필드와 삽입할 테이블내 필드명과 동일할 경우 
	-- 5. 마지막으로 추가된 레코드의 자동번호[auto_increment] 확인 : select last_insert_id();
create table maddr( mid char(8) , maddr char(2) ); 	-- 회원아이디 , 주소 필드를 갖는 테이블 
select mid , maddr  from member limit 5;	-- 레코드 5개 검색 
insert into maddr select mid , maddr from member limit 5;
select * from maddr;
select last_insert_id();


-- update 
	-- update 테이블명 set 필드명 = 수정할값 where 조건식 
	-- 1. 해당 테이블에서 주소가 서울 이면 'seoul'
    select * from member;
    update member set maddr = 'seoul' where maddr = '서울'; 		-- 오류1 [ char(2) : 최대 2글자  ] 
    -- 오류2 워크벤치에서  update,delete 기본적으로 사용 불가능 
		-- 메뉴 -> edit -> preferences ->  사이드메뉴 SQL editor 선택 -> 가장 아래 safe updates 체크 해제
    update member set maddr = 'se' where maddr = '서울';
	update member set mnumber = mnumber/3;		-- 연산 가능 
    update member set maddr = '안산';			-- 조건[where] 없을경우 전체 변경 

-- delete 
	-- delete from 테이블명 where 조건식 
    -- * 만일 관계테이블 일 경우 다른 테이블에서 fk필드로 사용된 레코드는 삭제 불가능 [ * 제약조건 ]
    -- 1. 만약에 핑크가 포함된 이름 삭제 
    delete from member where mname like '%핑크%';	-- ??? 오류 [ 관계가 있는 테이블에서 pk필드가 포함된 레코드 삭제불가능  ]
    delete from member where mname = '잇지';			-- ??? 성공 [ 관계가 있는 테이블에서 fk필드가 없을 경우 pk필드 삭제 가능 ]
    
    

/*
	연산자
		1. 산술연산자	:	+더하기	-빼기	*곱하기 	/나누기 	div몫 mod나머지
        2. 비교연산자 : >=이상 <=이하 >초과 <미만 =같다 !=같지않다
        3. 논리연산자 : and이면서 	or이거나		not부정
        4. 기타연산자 :
				in( 값1, 값2, 값3 ) 		: 값1~값3 하나라도 존재하면 true [ 값1 or 값2 or 값3 ]
                값 between 값1 and 값2 	: 값이 값1 부터 값2 사이이면 true [ 값>=값1 and 값<=값2 ]
                like					: 패턴 검색 
					% : 모든 문자수 대응 		_ :  _개수만큼 문자수 대응 
		5. null관련 연산자
                필드명 is null		: null 이면 		[ = null [X] ]
                필드명 is not null	: null 이 아니면 	[ != null [X] ]
	
    집계함수
		sum( 필드명 )		: 해당 필드내 데이터 총합 
        avg( 필드명 ) 	: 해당 필드내 데이터 평균 
        max( 필드명 ) 	: 해당 필드내 데이터 최대값
        min( 필드명 ) 	: 해당 필드내 데이터 최소값 
        count( 필드명 ) 	: 해당 필드내 데이터 수 [null 미포함 ]	
		count( * ) 		: 레코드 수  [ null 포함 ] 
*/


-- 타입 확인 
drop table if exists testtype;
create table testtype( 
	tinyint_col tinyint , 		-- 1바이트 +-128 저장 
    smallint_col smallint , 	-- 2바이트 +-3만정도 저장 
    int_col	int	,				-- 4바이트 +-21억정도 저장 
    int_col2 int unsigned,		-- 4바이트 + 43억정도 저장 [ unsigned : 음수사용x : 음수용량 -> 양수용량증가 ]
    bigint_col bigint,			-- 8바이트 +-21억이상 저장  
    char_col char( 10 ),		-- char( 길이 )		: 고정길이 [ 1~255 ] 저장 
    varchar_col varchar(10),	-- varchar( 길이 )	: 가변길이 [ 1~16383] 저장 *버전 mysql 5.0 이상 
    text_col text,				-- 1~65535 글자 저장 
	longtext_col longtext , 	-- 1~ 42억 정도 글자 저장 
	float_col float	,			-- 소수점 7자리 저장 
    double_col double ,			-- 소수점 15자리 저장 
    date_col date ,				-- 날짜 저장 [ yyyy - MM - dd ]
    time_col time ,				-- 시간 저장 [ hh : mm : ss ]
    datetime_col datetime		-- 날짜/시간 저장 [ yyyy-MM-dd hh:mm:ss ]
);
select * from testtype;
