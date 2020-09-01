create table tblboard
(
    seq number primary key,
    subject varchar2(100) not null,
    writer varchar2(50) not null,
    content varchar2(1500) not null,
    regdate date default sysdate not null,
    viewcnt number default 0 not null
);
drop table tblboard;
create sequence seqBoard;

insert into tblboard values(seqBoard.nextVal,'제목입니다.1','찬우','내용 테스트입니다.',default,default);  
insert into tblboard values(seqBoard.nextVal,'제목입니다.2','찬우','내용 테스트입니다.',default,default);  
insert into tblboard values(seqBoard.nextVal,'제목입니다.3','찬우','내용 테스트입니다.',default,default);  
insert into tblboard values(seqBoard.nextVal,'제목입니다.4','찬우','내용 테스트입니다.',default,default);  
insert into tblboard values(seqBoard.nextVal,'제목입니다.5','찬우','내용 테스트입니다.',default,default);  
insert into tblboard values(seqBoard.nextVal,'제목입니다.6','찬우','내용 테스트입니다.',default,default);  
insert into tblboard values(seqBoard.nextVal,'제목입니다.7','찬우','내용 테스트입니다.',default,default);  
create view vwboardlist
as
(
    select rownum as rnum ,b.* from tblboard b 
);
select * from vwboardlist b where rownum>=1 and rownum<=16 order by rnum desc;
update tblBoard set subject='오오오오잉?', content='호오오오오오오오잉?' where seq=21;