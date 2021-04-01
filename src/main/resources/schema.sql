DROP TABLE IF EXISTS MEMBER ;
CREATE TABLE MEMBER (
  seq int primary key auto_increment,
  id varchar(255) not null unique,
  name varchar(255) not null,
  password varchar(255) not null,
  age int
)