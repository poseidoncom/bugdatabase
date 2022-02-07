CREATE TABLE BUG (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tester_id bigint not null,
    project_id bigint not null,
    votes int,
    version varchar(255),
    date bigint,
    developer_id bigint,
    description varchar(255) not null,
    criticality varchar(255),
    state varchar(255),
    last_update bigint not null,
    foreign key (tester_id) references tester(id),
    foreign key (project_id) references project(id), 
    foreign key (developer_id) references developer(id)  
    )