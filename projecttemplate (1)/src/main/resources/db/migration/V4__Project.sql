CREATE TABLE Project (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- sqlite AUTOINCREMENT, mysql: AUTO_INCREMENT
    project_name varchar(255) not null,
    last_update bigint not null
    
    )