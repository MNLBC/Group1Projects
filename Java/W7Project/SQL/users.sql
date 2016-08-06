--------------------------------------------------------
--  File created - Friday-July-29-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "GROUP1"."USERS" 
   (	"ID" NUMBER(15,0), 
	"USERNAME" VARCHAR2(40 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"FIRSTNAME" VARCHAR2(60 BYTE), 
	"MIDDLENAME" VARCHAR2(60 BYTE), 
	"LASTNAME" VARCHAR2(60 BYTE), 
	"GENDER" VARCHAR2(60 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"ADDRESS" VARCHAR2(200 BYTE), 
	"CONTACTS" VARCHAR2(15 BYTE), 
	"IS_DISABLED" NUMBER(1,0) DEFAULT 0, 
	"TYPE" VARCHAR2(10 BYTE) DEFAULT 0, 
	"USER_LEVEL" NUMBER(1,0) DEFAULT 0, 
	"POINTS" NUMBER(38,0) DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
--------------------------------------------------------
--  DDL for Index SYS_C007320
--------------------------------------------------------

  CREATE UNIQUE INDEX "GROUP1"."SYS_C007320" ON "GROUP1"."USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
--------------------------------------------------------
--  DDL for Index SYS_C007321
--------------------------------------------------------

  CREATE UNIQUE INDEX "GROUP1"."SYS_C007321" ON "GROUP1"."USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT" ;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "GROUP1"."USERS" MODIFY ("POINTS" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("CONTACTS" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("USER_LEVEL" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" ADD CONSTRAINT "USER_NAME" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT"  ENABLE;
  ALTER TABLE "GROUP1"."USERS" ADD CONSTRAINT "PK_USER_ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "WEEK5_PROJECT"  ENABLE;
  ALTER TABLE "GROUP1"."USERS" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("IS_DISABLED" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("GENDER" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("LASTNAME" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("FIRSTNAME" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "GROUP1"."USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger USER_ID_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GROUP1"."USER_ID_TRIG" 
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
IF :NEW.ID IS NULL THEN
SELECT USER_ID_SEQ.nextval INTO :NEW.ID FROM SYS.DUAL;
END IF;
END;
/
ALTER TRIGGER "GROUP1"."USER_ID_TRIG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PASSWORD_NULL
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GROUP1"."PASSWORD_NULL" 
BEFORE UPDATE OF PASSWORD ON USERS 
FOR EACH ROW
BEGIN
  IF :NEW.PASSWORD IS NULL THEN
    :NEW.PASSWORD := :OLD.PASSWORD;
  END IF;
END;
/
ALTER TRIGGER "GROUP1"."PASSWORD_NULL" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_LEVEL
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GROUP1"."UPDATE_LEVEL" 
BEFORE UPDATE OF POINTS ON USERS 
FOR EACH ROW
BEGIN
  IF :NEW.POINTS != :OLD.POINTS THEN
    IF :NEW.POINTS >= 1000 THEN
      :NEW.USER_LEVEL := 3;
      
    ELSIF :NEW.POINTS >= 500 THEN
      :NEW.USER_LEVEL := 2;
      
    ELSIF :NEW.POINTS >= 100 THEN
      :NEW.USER_LEVEL := 1;
      
    ELSE
      :NEW.USER_LEVEL := 0;
    END IF;
  END IF;
END;
/
ALTER TRIGGER "GROUP1"."UPDATE_LEVEL" ENABLE;