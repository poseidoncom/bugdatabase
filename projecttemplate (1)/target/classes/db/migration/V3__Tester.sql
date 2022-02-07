CREATE TABLE Tester (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- sqlite AUTOINCREMENT, mysql: AUTO_INCREMENT
    usr_name varchar(255) not null,
    email varchar(255) not null,
    user_password varchar(255) not null
    )