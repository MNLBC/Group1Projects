/*
Helper SCRIPTS
*/

SELECT * FROM order_items;
SELECT * FROM orders;
SELECT * FROM users;
SELECT * FROM combo_meal;
SELECT * FROM meal;
SELECT * FROM product_group;

UPDATE meal SET category = 'Chickens' WHERE id = 1;
UPDATE meal SET category = 'Sides' WHERE id = 2;

UPDATE meal SET code = 'M1' WHERE id = 1;
UPDATE meal SET code = 'M2' WHERE id = 2;
UPDATE meal SET code = 'M3' WHERE id = 3;

UPDATE combo_meal SET code = 'CM1' WHERE id = 1;
UPDATE combo_meal SET code = 'CM2' WHERE id = 2;
UPDATE combo_meal SET code = 'CM3' WHERE id = 3;

--------------------------------------------------------------------------------------------------------

ALTER TABLE product_group ADD CONSTRAINT meal_id FOREIGN KEY (id) REFERENCES meal (id);
ALTER TABLE product_group ADD CONSTRAINT combo_meal_id FOREIGN KEY (id) REFERENCES combo_meal(id);

ALTER TABLE orders ADD CONSTRAINT users_id FOREIGN KEY (id) REFERENCES users(id);

ALTER TABLE order_items ADD CONSTRAINT order_id FOREIGN KEY (id) REFERENCES orders(id);
ALTER TABLE order_items ADD CONSTRAINT meal_id FOREIGN KEY (id) REFERENCES meal(id);

ALTER TABLE orders ADD CONSTRAINT users_id FOREIGN KEY (id) REFERENCES users(id);

ALTER TABLE orders ADD CONSTRAINT users_id FOREIGN KEY (id) REFERENCES users(id);

CREATE INDEX index_name
ON table_name (column_name)

/*
DATA LOADING
*/
/*
USERS
*/

INSERT INTO users (FIRSTNAME, MIDDLENAME,LASTNAME,ADDRESS,CONTACTS,EMAIL,GENDER,USERNAME,PASSWORD,TYPE,IMAGE,DATE_CREATED,DATE_UPDATED,IS_DISABLED)
VALUES ('PETER','VISDA','BARREDO','GREENHEIGHTS VILLAGE','065496','peter.emmanuel.barredo@oocl.com','MALE','pvbarredo','admin','CUSTOMER','C:\IMAGE\JOKELANG',SYSDATE,SYSDATE,0);

INSERT INTO users (FIRSTNAME, MIDDLENAME,LASTNAME,ADDRESS,CONTACTS,EMAIL,GENDER,USERNAME,PASSWORD,TYPE,IMAGE,DATE_CREATED,DATE_UPDATED,IS_DISABLED)
VALUES ('PAULINE','JOYCE','RACELIS','QUEZON CITY','065496','pauline.racelis@oocl.com','FEMALE','racelpa','admin','CUSTOMER','C:\IMAGE\JOKELANG',SYSDATE,SYSDATE,0);

INSERT INTO users (FIRSTNAME, MIDDLENAME,LASTNAME,ADDRESS,CONTACTS,EMAIL,GENDER,USERNAME,PASSWORD,TYPE,IMAGE,DATE_CREATED,DATE_UPDATED,IS_DISABLED)
VALUES ('MARK','ANTHONY','ANDES','PULIS KALAWAKAN','065496','mark.anthony.andes@oocl.com','MALE','andema','admin','CUSTOMER','C:\IMAGE\JOKELANG',SYSDATE,SYSDATE,0);

/*
MEAL
*/

SELECT * FROM meal;

INSERT INTO meal (NAME,DESCRIPTION,CATEGORY,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED)
VALUES ('Rice', 'Senandomeng','sides','10','C:\image\meals\rice.jpg',sysdate,sysdate);

INSERT INTO meal (NAME,DESCRIPTION,CATEGORY,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED)
VALUES ('Coke', 'Coca~Cola','Drinks','15','C:\image\meals\coke.jpg',sysdate,sysdate);


INSERT INTO meal (NAME,DESCRIPTION,CATEGORY,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED)
VALUES ('Coke', 'Coca~Cola','Drinks','15','C:\image\meals\coke.jpg',sysdate,sysdate);



/*
Combo Meal
*/

SELECT * FROM combo_meal;

INSERT INTO combo_meal (NAME,DESCRIPTION,PRICE,IMAGE,DATE_CREATED,DATE_UPDATED) 
VALUES ('39ers Chicken', 'Chicken,Rice,Drinks',39, 'C:\image\meal\combo\39ersChicken.jpg', sysdate,sysdate);


/*
Product Group
*/
SELECT * FROM product_group;
TRUNCATE TABLE product_group;

INSERT INTO product_group (MEAL_ID,COMBO_MEAL_ID,DATE_CREATED,DATE_UPDATED)
VALUES (1,1,sysdate,sysdate);

INSERT INTO product_group (MEAL_ID,COMBO_MEAL_ID,DATE_CREATED,DATE_UPDATED)
VALUES (2,1,sysdate,sysdate);


CREATE TRIGGER pt
  AFTER UPDATE ON p
  FOR EACH ROW
BEGIN
  UPDATE f SET f1 = :NEW.p1 WHERE f1 = :OLD.p1;
END;

CREATE OR REPLACE TRIGGER product_group_update_date
AFTER UPDATE ON product_group
FOR EACH ROW
BEGIN
IF :new.PRODUCT_ID IS NULL THEN
SELECT PRODUCT_ID_SEQ.nextval INTO :new.PRODUCT_ID FROM DUAL;
END IF;
END;


SELECT * FROM USERS;

CREATE OR REPLACE TRIGGER update_user 
   AFTER UPDATE ON users 
   BEGIN
      RAISE_APPLICATION_ERROR (
         num => -20000,
         msg => 'Cannot drop object');
   END;
/



DBMS_OUTPUT.PUT_LINE('TRY'); 
dbms_output.put_line('TRY');




