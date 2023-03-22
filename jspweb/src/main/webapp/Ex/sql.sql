use jspweb;

drop table if exists member;
create table member(
	mno int auto_increment primary key ,
    mid varchar(30) not null unique ,
    mpwd varchar(30) not null,
	mimg longtext ,
    memail varchar(100)
);


drop table if exists friend;
create table friend(
	fno int auto_increment primary key ,
    ffrom int ,
    fto int ,
    foreign key(ffrom) references member (mno) on delete set null,
    foreign key(fto) references member (mno) on delete set null
 );

drop table if exists mpoint;
create table mpoint(
	mpno int auto_increment primary key,
    mpcomment varchar(1000) not null,
    mpamount int default 0,
    mpdate datetime default now(),
    mno int ,
    foreign key (mno) references member (mno) on delete set null
);

insert into mpoint (mpcomment , mpamount , mno) values('회원가입축하' , 100 , 1);
insert into mpoint (mpcomment , mpamount , mno) values('회원가입축하' , 100 , 2);
insert into mpoint (mpcomment , mpamount , mno) values('회원가입축하' , 100 , 3);
insert into mpoint (mpcomment , mpamount , mno) values('회원가입축하' , 100 , 4);
insert into mpoint (mpcomment , mpamount , mno) values('회원가입축하' , 100 , 5);

insert into mpoint (mpcomment , mpamount , mno) values('포인트구매' , 5000 , 5);
insert into mpoint (mpcomment , mpamount , mno) values('제품구매' , -3000 , 5);


select * from member;
select * from mpoint;
-- 특정회원 보유포인트
select sum(mpamount) from mpoint where mno=?;

-- 아이디에 해당하는 회원의 보유포인트
select * from member m, mpoint p where m.mno = p.mno;

-- 조인후 필요한 필드와 통계 [두개 이상 필드를 출력시 그룹 필수~]
select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as 보유포인트
from member m , mpoint p
where m.mno = p.mno
group by mno;


-- 특정 회원 1명 필드와 통계 [두개 이상 필드를 출력시 그룹 필수~]
select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as 보유포인트
from member m , mpoint p
where m.mno = p.mno and m.mid='qwe1234';

select * from member where mid = 'qwe1234' and mpwd = 'qwe1234';



-- 카테고리 테이블[ 카테고리번호 . 카테고리 이름(공지사항 , 커뮤니티 , QnA , 노하우) 등등 ]
drop table category;
create table category(
	cno int auto_increment primary key,
    cname varchar(100)
 );
 
 create table board(
	bno 		int auto_increment primary key ,
    btitle 		varchar(1000) not null,
    bcontent 	longtext not null,
    bfile 		longtext ,
    bdate 		datetime default now(),
    bview 		int default 0,
    bup 		int default 0,
    bdown 		int default 0,
    mno 		int,	-- 회원번호 fk
    cno 		int,	-- 카테고리번호 fk
	foreign key(mno) references member(mno)on delete set null, -- 회원pk가 삭제되면 게시물fk는 null로 변경
    foreign key(cno) references category(cno)on delete cascade -- 카테고리pk가 삭제되면 게시물 같이 삭제
 );
 
 
insert into category(cname) values('공지사항');
insert into category(cname) values('커뮤니티');
insert into category(cname) values('QnA');
insert into category(cname) values('노하우');

select * from category;
select * from board;
select board.*, member.mid, member.mimg from board natural join member;
select count(*) from member m natural join board b ;
-- 조건 조인
	-- 1. where [ 합집합 ]
    
select count(*) from member;

select * from member limit 0 , 3;
select * from member m where m.memail like '%qwe%' limit 0 , 3;

-- 댓글 번호 , 내용 작성일 , 인덱스 (계층구분) , 작성자(mno) , 게시물번호
create table reply(
	rno int auto_increment primary key ,
    rcontent longtext ,
    rdate datetime default now(),
    rindex int  default 0,-- 0이면 최상위계층 , 1~ 해당 댓글의 하위댓글
	mno int ,
	bno int ,
    foreign key(mno) references member(mno) on delete set null,
    foreign key(bno) references board(bno) on delete cascade
);
select * from reply;
select count(*) from reply where bno=25;

/*
	3번게시물
		1번 댓글 			[rindex = 0]
			3번댓글		[rindex = 1]
			4번댓글		[rindex = 1]
				6번댓글	[rindex = 4]
		2번댓글			[rindex = 0]
        5번댓글			[rindex = 0]
*/

-- 외부 csv 파일데이터 import
select * from 아파트실거래가;
create table 아파트실거래가(
	식별번호 int auto_increment primary key ,
    시군구 text ,
    단지명 text ,
    전용면적 text ,
    계약일 text ,
    계약금액 text ,
    층 text 
);