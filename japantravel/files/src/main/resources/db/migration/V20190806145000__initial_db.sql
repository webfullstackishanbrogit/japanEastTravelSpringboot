create schema if not exists jt_files collate utf8mb4_0900_ai_ci;

create table if not exists file_storage
(
    file_id       varchar(100) not null
        primary key,
    original_name varchar(255) null,
    file_type     varchar(25)  null,
    absolute_path text         null,
    relative_path text         null,
    created_time  datetime     null,
    updated_time  datetime     null
);

create table if not exists file_metadata
(
    file_id  varchar(100) not null
        primary key,
    metadata json         null,
    constraint file_metadata_file_storage_file_id_fk
        foreign key (file_id) references file_storage (file_id)
);

