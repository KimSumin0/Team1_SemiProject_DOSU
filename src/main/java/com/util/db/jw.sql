insert into ProductTbl values (Product_Number_Seq.nextval, '�̸�', '����', 10000, '�̹���','�±�');

delete ProductTbl;

select * from productTbl;


alter table ProductTbl
modify Product_Img null;

create table ProductTbl
(
	Product_Num Number(8 ) PRIMARY KEY,
	Product_Name VARCHAR2(20 char) not null,
	Product_Exp VARCHAR2(200 char) not null,
	Product_Price Number(8) not null,
	Product_Img1 varchar2(100 char)  not null,
	Product_Img2 varchar2(100 char)  ,
	Product_Img3 varchar2(100 char)  ,
	Product_Img4 varchar2(100 char)  ,
	Product_Tag varchar2(200 char) not null
);

insert into OrderTbl values (Order_Number_Seq.nextval, sysdate,'�ּ�', '��ۻ���', '�ֹ���', 'yorunohosi');

delete orderTbl;

select * from OrderTbl
create table OrderTbl
(
	Order_Num Number(8) PRIMARY KEY,
	Order_Date date not null,
	Order_State VARCHAR2(10 char) not null,
	Order_Address VARCHAR2(100 char) not null,
	Order_Detail VARCHAR2(400 char) not null,
	Order_UserId varchar(16 char) not null
);


create sequence Product_Number_Seq;
create sequence Order_Number_Seq;



--����


drop table ProductTbl;
drop table OrderTbl;
