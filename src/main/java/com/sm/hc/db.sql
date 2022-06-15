create table user_info_tbl(
user_id varchar2(16 char) primary key,
user_pw varchar2(30 char) not null,
user_name varchar2(20 char) not null,
user_gender char(1 char) not null,
user_addr varchar2(100 char) not null,
user_phoneNumber varchar2(100 char) not null,
user_age varchar2(10 char) not null
);

create table user_cocktail_tbl(
cocktail_num number(5) primary key,
cocktail_name varchar2(20 char) not null,
cocktail_info varchar2(300 char) not null,
cocktail_ingredient varchar2(200 char) not null,
cocktail_recipe varchar2(300 char) not null,
cocktail_img varchar2(500 char) not null,
cocktail_tag varchar2(30 char),
user_id varchar2(16 char) not null
);

create table board_tbl(
board_num number(5) primary key,
user_id varchar2(16 char) not null,
board_title varchar2(50 char) not null,
board_txt varchar2(300 char) not null
);

create table comment_tbl(
comment_num number(5) primary key,
board_num number(5) not null,
user_id varchar2(16 char) not null,
comment_txt varchar2(100 char) not null,
parent_commentNum number(5) not null
);



--������� ����
drop table user_info_tbl cascade constraints purge;


--������ ����
create SEQUENCE user_cocktail_tbl_seq;
create SEQUENCE board_tbl_seq;
create SEQUENCE comment_tbl_seq;

drop SEQUENCE cocktail_recipe_tbl_seq;
-- ��������.nextval �� ���

insert into user_info_tbl values('Id','Pw','�̸�','��','�ּ�','010-1234-5678','20');
insert into user_cocktail_tbl values(user_cocktail_tbl_seq.nextval,'�׽�Ʈ�̸�','�׽�Ʈ������','�׽�Ʈ���','�׽�Ʈ������','test.jpg','�׽�Ʈ�±�','testId');
insert into board_tbl values(board_tbl_seq.nextval,'testId','�Խñ�����','�Խñ۳���');
insert into comment_tbl values(comment_tbl_seq.nextval,'123','user_id','��۳���','456');

SELECT * FROM user_info_tbl;
SELECT * FROM user_cocktail_tbl;
SELECT * FROM board_tbl;
SELECT * FROM comment_tbl;