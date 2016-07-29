--------------------------------------------------------
--  File created - Friday-July-29-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEAL
--------------------------------------------------------

  CREATE TABLE "GROUP1"."MEAL" 
   (	"ID" NUMBER(15,0), 
	"CODE" VARCHAR2(40 BYTE), 
	"NAME" VARCHAR2(100 BYTE), 
	"PRICE" FLOAT(126), 
	"DESCRIPTION" VARCHAR2(200 BYTE), 
	"IMAGE" VARCHAR2(200 BYTE), 
	"CATEGORY" VARCHAR2(50 BYTE), 
	"POINTS" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
REM INSERTING into GROUP1.MEAL
SET DEFINE OFF;
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100001,'M01','Fried Chicken',15,'Chicken! Chicken! Chicken! Taste our original recipe chicken made with 89 secret spices','resources/images/chicken/fried.png','Chickens',5);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100002,'M02','Coke',3,'Make your meal more delicious by adding one of the worlds famous sodas','resources/images/beverages/coke.png','Beverages',1);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100004,'M04','Coke Zero',3,'Coke Zero Fat Zero Grade!!! Just like your love ZERO.','resources/images/beverages/cokezero.png','Beverages',1);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100006,'M06','Sprite',3,'Sprite Tru White. ','resources/images/beverages/sprite.png','Beverages',1);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100007,'M07','Chicken Nuggets',5,'Chicken Nuggets! Nuggets for everwine! Taste the original chicken nuggets more precious than gold.','resources/images/chicken/Nuggets.png','Chickens',5);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100008,'M08','Bacon And Cheese',12,'What is better than bacon and cheese? BACON and CHEESE in a burger!','resources/images/burgers/baconAndCheese.png','Burgers',8);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100009,'M09','Onion Rings',6,'Rings? We got them! Try our special onion rings together with any dish that you want.','resources/images/sides/onionrings.jpg','Sides',2);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100012,'M12','XtraLong Cheeseburger',25,'Yes! Its extra long!','resources/images/burgers/XtraLongCheeseburger.png','Burgers',8);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100013,'M13','Caramel Sundae',5,'Caramel Sundae. Now with Camels and Sands','resources/images/desserts/caramelSundae.png','Desserts',3);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100014,'M14','Dr Pepper Shake',5,'Meet and Greet with Dr Pepper Shake','resources/images/desserts/drPepperShake.png','Desserts',3);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100015,'M15','Oreo Shake',5,'Oreo Shake. Never Oh Rio','resources/images/desserts/oreoShake.png','Desserts',3);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100016,'M16','Hash Brown',13,'Hash Brown,Number one favorite of HashTFive','resources/images/sides/hashbrown.png','Sides',2);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100094,'M66','Oreo Cheesecake',10,'OREO Ma Loveeee!','resources/images/Logo.png','desserts',2);
Insert into GROUP1.MEAL (ID,CODE,NAME,PRICE,DESCRIPTION,IMAGE,CATEGORY,POINTS) values (100093,'M99','Royal',10,'Royal Milk Tea','resources/images/Logo.png','beverages',2);
--------------------------------------------------------
--  DDL for Index SYS_C007353
--------------------------------------------------------

  CREATE UNIQUE INDEX "GROUP1"."SYS_C007353" ON "GROUP1"."MEAL" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
--------------------------------------------------------
--  DDL for Index SYS_C007354
--------------------------------------------------------

  CREATE UNIQUE INDEX "GROUP1"."SYS_C007354" ON "GROUP1"."MEAL" ("CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
--------------------------------------------------------
--  Constraints for Table MEAL
--------------------------------------------------------

  ALTER TABLE "GROUP1"."MEAL" MODIFY ("POINTS" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."MEAL" MODIFY ("CATEGORY" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."MEAL" ADD CONSTRAINT "MEAL_CODE" UNIQUE ("CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT"  ENABLE;
  ALTER TABLE "GROUP1"."MEAL" ADD CONSTRAINT "PK_MEAL_ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT"  ENABLE;
  ALTER TABLE "GROUP1"."MEAL" MODIFY ("DESCRIPTION" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."MEAL" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."MEAL" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."MEAL" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."MEAL" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger MEAL_ID_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GROUP1"."MEAL_ID_TRIG" 
BEFORE INSERT ON MEAL
FOR EACH ROW
BEGIN
IF :NEW.ID IS NULL THEN
SELECT MEAL_ID_SEQ.nextval INTO :NEW.ID FROM SYS.DUAL;
END IF;
END;
/
ALTER TRIGGER "GROUP1"."MEAL_ID_TRIG" ENABLE;
