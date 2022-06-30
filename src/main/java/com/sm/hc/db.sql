create table user_info_tbl(
user_id varchar2(16 char) primary key,
user_pw varchar2(30 char) not null,
user_name varchar2(20 char) not null,
user_gender char(1 char) not null,
user_addr varchar2(100 char) not null,
user_phoneNumber varchar2(100 char) not null,
user_age number(3) not null
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
board_txt varchar2(1000 char) not null,
board_img varchar2(500 char),
board_date date not null
);

create table comment_tbl(
comment_num number(5) primary key,
board_num number(5) not null, --�Խù� �ȿ� ���� �Խù�(�ѹ�)�� �ٽ� �Ѱ���
user_id varchar2(16 char) not null,
comment_txt varchar2(100 char) not null,
comment_date date not null
);
--parent_commentNum number(5), --����???

--���̺� �÷� �߰�
alter table board_tbl add board_category varchar2(50 char);
--���̺� �÷� ����
alter table board_tbl drop column board_category;

--������� ����
drop table comment_tbl cascade constraints purge;


--������ ����
create SEQUENCE user_cocktail_tbl_seq;
create SEQUENCE board_tbl_seq;
create SEQUENCE comment_tbl_seq;

drop SEQUENCE comment_tbl_seq;
-- ��������.nextval �� ���
--11111

insert into user_info_tbl values('Id','Pw','�̸�','��','�ּ�','010-1234-5678','20');
insert into user_cocktail_tbl values(user_cocktail_tbl_seq.nextval,'�׽�Ʈ�̸�','�׽�Ʈ������','�׽�Ʈ���','�׽�Ʈ������','test.jpg','�׽�Ʈ�±�','testId');
insert into board_tbl values(board_tbl_seq.nextval,'testId','�Խñ�����','�Խñ۳���','aa.img', sysdate);
insert into comment_tbl values(comment_tbl_seq.nextval,'123','user_id','��۳���', sysdate);

SELECT * FROM user_info_tbl;
SELECT * FROM user_cocktail_tbl;
SELECT * FROM board_tbl;
SELECT * FROM comment_tbl;

insert into comment_tbl values(comment_tbl_seq.nextval,456,'789','101010',sysdate);
insert into board_tbl values(board_tbl_seq.nextval,'testId2','�Խñ�����2','�Խñ۳���2','bb.img', sysdate, 'review');

delete from user_info_tbl where user_id = '';

update board_tbl set user_id = 'ADMIN' where board_num = '29';