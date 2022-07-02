

create or replace procedure test_proc
(
	UserId 			IN	varchar2(16 char) 	 	,
	Reciever		IN		varchar2(16 char) 	,
	PhoneNumber		IN	varchar2(20 char) 	 	,
	ProductNumber 	IN 	varchar2(8 char) 	 	,
	deleteCart	IN 	varchar2	 	,
	productQuantity IN 	NUMBER(4) 			,
	State VARCHAR2(10 char) := '�ֹ�Ȯ����'	,
	Address 		IN	VARCHAR2(100 char) 	,
	DeliveryState 	VARCHAR2(20 char) :='�ֹ�Ȯ����',
	PaymentState 	VARCHAR2(20 char) :='����Ȯ����',
	ProductPrice 	IN	NUMBER(10) 			,
	DeliveryPrice 	IN	NUMBER(5) 			 	,
	TotalPrice 		IN	NUMBER(10) 			 
)
IS
	BEGIN
		insert into OrderTbl values (Order_Number_Seq.nextval,UserId,Reciever,PhoneNumber,ProductNumber,productQuantity,
		sysdate,State,Address,DeliveryState,PaymentState,ProductPrice,DeliveryPrice,TotalPrice);
		
		DELETE from cartTbl where Cart_Product_Num = deleteCart;
		COMMIT;
end;