CREATE TABLE BUG (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    reporter int not null,
    project_id int not null,
    assignedto int,
    bug_description varchar(255) not null,
    criticality varchar(255) not null,
    bug_state varchar(255) not null,
    foreign key (reporter) references users(id),
    foreign key (project_id) references projects(id), 
    foreign key (assignedto) references developers(id)  
    )