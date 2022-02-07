CREATE TABLE Tester (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- sqlite AUTOINCREMENT, mysql: AUTO_INCREMENT
    usr_name varchar(255) not null,
    usr_email varchar(255) not null,
    usr_password varchar(255) not null,
    last_update bigint not null
    )