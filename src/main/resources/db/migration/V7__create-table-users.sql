create table users(
    id bigserial not null,
    login varchar(100) not null unique,
    senha varchar(100) not null,

    primary key(id)

)