--------------------------------------------------------
--  File created - Friday-July-29-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table INQUIRY
--------------------------------------------------------

  CREATE TABLE "GROUP1"."INQUIRY" 
   (	"ID" NUMBER(15,0), 
	"USER_ID" NUMBER(15,0), 
	"MESSAGE" VARCHAR2(100 BYTE), 
	"DATE_CREATED" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
REM INSERTING into GROUP1.INQUIRY
SET DEFINE OFF;
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (23,100031,'Nie Hau!',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (27,100031,'Yehey, love you guys',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (24,100031,'Hi love it',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (25,100031,'Hi again, love it',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (28,100031,'Hi, thanks for the discounts',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (1,100027,'Hello I am fan of your store . Can I ask if you have branch in this area. Thanks',to_date('08-MAR-12','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (3,100035,'Hi, we sell tomato ketchup. Contact 038729487 iif you want to order our ketchup for your burgers.',to_date('29-MAY-09','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (4,100028,'Does your burger use pork for your patties? Because I''m a muslim so... you know :P',to_date('13-APR-13','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (5,100043,'Poor treatment to customers',to_date('30-OCT-15','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (6,100047,'To whom it may concern, I''m allergic to peanuts.',to_date('01-SEP-13','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (7,100027,'Thanks for setting up your branch here. <3',to_date('27-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (21,100027,'badesa~',to_date('28-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (29,100031,'test',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (22,100031,'Hi! My name is Mark!',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (26,100027,'Hello from the otherside',to_date('29-JUL-16','DD-MON-RR'));
Insert into GROUP1.INQUIRY (ID,USER_ID,MESSAGE,DATE_CREATED) values (30,100031,'Hi, Do you have a branch here in zhuhai',to_date('29-JUL-16','DD-MON-RR'));
--------------------------------------------------------
--  DDL for Index INQUIRY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GROUP1"."INQUIRY_PK" ON "GROUP1"."INQUIRY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
--------------------------------------------------------
--  Constraints for Table INQUIRY
--------------------------------------------------------

  ALTER TABLE "GROUP1"."INQUIRY" ADD CONSTRAINT "INQUIRY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT"  ENABLE;
  ALTER TABLE "GROUP1"."INQUIRY" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."INQUIRY" MODIFY ("MESSAGE" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."INQUIRY" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."INQUIRY" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table INQUIRY
--------------------------------------------------------

  ALTER TABLE "GROUP1"."INQUIRY" ADD CONSTRAINT "FK_USER_ID_INQUIRY" FOREIGN KEY ("USER_ID")
	  REFERENCES "GROUP1"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger INQUIRY_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GROUP1"."INQUIRY_TRG" 
BEFORE INSERT ON INQUIRY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT INQUIRY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "GROUP1"."INQUIRY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger INQUIRY_DATE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GROUP1"."INQUIRY_DATE" 
BEFORE INSERT ON INQUIRY 
FOR EACH ROW
DECLARE
  nowDate DATE;
BEGIN

  SELECT CURRENT_DATE INTO nowDate
  FROM dual;

  IF :NEW.DATE_CREATED IS NULL THEN
    :NEW.DATE_CREATED := nowDate;
  END IF;
END;
/
ALTER TRIGGER "GROUP1"."INQUIRY_DATE" ENABLE;
