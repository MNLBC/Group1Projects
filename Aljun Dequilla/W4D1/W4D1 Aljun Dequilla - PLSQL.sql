SELECT * FROM ORDERHW;
SELECT * FROM ORDERITEMHW;
SELECT * FROM USERHW;

DESCRIBE ORDERHW;

INSERT INTO USERHW VALUES (1,'DEQUIAL','ALJUN','DEQUILLA','PASSWORD','07-MAR-16');
INSERT INTO USERHW VALUES (2,'RNSK','REN','SICKO','PASSWORD1','15-OCT-05');
INSERT INTO USERHW VALUES (3,'MOLLA','MORENA','DELIKS','WALA','28-FEB-11');

INSERT INTO ORDERITEMHW VALUES (1,'AQUA','PURIFIED WATER',5.3,'22-JUL-01');
INSERT INTO ORDERITEMHW VALUES (2,'DELL','HIGH DEFINITION MONITOR',91.5,'01-DEC-13');
INSERT INTO ORDERITEMHW VALUES (3,'STIKY','STICKY NOTES',2.1,'14-SEP-16');

INSERT INTO ORDERHW VALUES (1,1,10,1,'26-APR-08');
INSERT INTO ORDERHW VALUES (2,3,25,1,'21-JUN-13');
INSERT INTO ORDERHW VALUES (3,2,2,2,'30-JUL-16');
INSERT INTO ORDERHW VALUES (4,3,5,2,'23-JUL-14');
INSERT INTO ORDERHW VALUES (5,2,3,3,'06-SEP-16');
INSERT INTO ORDERHW VALUES (6,1,20,1,'08-JUL-10');

SELECT  U.FIRST_NAME,
        I.ITEM_NAME,
        (O.QUANTITY * I.ITEM_COST) AS SUB_COST
FROM  ORDERHW O, 
      ORDERITEMHW I,
      USERHW U 
WHERE 
      O.ITEM_ID = I.ITEM_ID AND   
      O.USER_ID = U.USER_ID AND
      O.DATE_ORDER LIKE '%JUL%';
      
RENAME orderHW TO ordersHW;
RENAME userHW TO usersHW;
RENAME orderitemHW TO itemHW;

GRANT SELECT ON orderHW TO DEQUIAL;
GRANT SELECT, INSERT, UPDATE, DELETE ON userHW TO public;
REVOKE ALL ON orderitemHW FROM DEQUIAL;
