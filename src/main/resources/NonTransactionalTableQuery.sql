CREATE TABLE "SCOTT"."US_STATES_MASTER" 
   (	"STATE_ID" NUMBER NOT NULL ENABLE, 
	"STATE_NAME" VARCHAR2(20 BYTE), 
	"STATE_CODE" VARCHAR2(10 BYTE), 
	 CONSTRAINT "US_STATES_MASTER_PK" PRIMARY KEY ("STATE_ID"));
	 
=================================================================

insert into US_STATES_MASTER VALUES (1,'Alabama','AL');
insert into US_STATES_MASTER VALUES (2,'Alaska','AK');
insert into US_STATES_MASTER VALUES (3,'Arizona','AZ');
insert into US_STATES_MASTER VALUES (4,'Arkansas','AR');
insert into US_STATES_MASTER VALUES (5,'California','CA');
insert into US_STATES_MASTER VALUES (6,'Colorado','CO');
insert into US_STATES_MASTER VALUES (7,'Connecticut','CT');
insert into US_STATES_MASTER VALUES (8,'Delaware','DE');
insert into US_STATES_MASTER VALUES (9,'Florida','FL');
insert into US_STATES_MASTER VALUES (10,'Georgia','GA');
insert into US_STATES_MASTER VALUES (11,'Hawaii','HI');
insert into US_STATES_MASTER VALUES (12,'Idaho','ID');
insert into US_STATES_MASTER VALUES (13,'Massachusetts','MA');
insert into US_STATES_MASTER VALUES (14,'New Jersey','NJ');
insert into US_STATES_MASTER VALUES (15,'New York','NY');
insert into US_STATES_MASTER VALUES (16,'Rhode Island','RI');
insert into US_STATES_MASTER VALUES (17,'Texas','TX');
insert into US_STATES_MASTER VALUES (18,'Virginia','VA');
insert into US_STATES_MASTER VALUES (19,'Washington','WA');
insert into US_STATES_MASTER VALUES (20,'West Virginia','WV');
	 
commit;	 
	 