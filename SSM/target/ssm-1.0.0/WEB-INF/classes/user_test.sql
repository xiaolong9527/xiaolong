-- Create table
create table USER_TEST
(
  id        INTEGER not null,
  user_name VARCHAR2(14),
  password  VARCHAR2(20),
  age       INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
  insert  into USER_TEST(id,user_name,password,age) values (1,'测试','sfasgfaf',25);