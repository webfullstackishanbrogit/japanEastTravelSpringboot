create table smtp_settings
(
    id                 int auto_increment
        primary key,
    smtp_host          varchar(50) default 'smtp.gmail.com'  null,
    smtp_port          int         default 587               null,
    smtp_username      varchar(100)                          null,
    smtp_password      varchar(255)                          null,
    protocol           varchar(50) default 'smtp'            null,
    auth               tinyint(1)  default 1                 null,
    timeout            int         default 5000              null,
    connection_timeout int         default 5000              null,
    write_timeout      int         default 5000              null,
    tls                tinyint(1)  default 1                 null,
    created_time       datetime    default CURRENT_TIMESTAMP null,
    updated_time       datetime                              null
);

create index smtp_settings_updated_time_index
    on smtp_settings (updated_time desc);

insert into smtp_settings (smtp_username, smtp_password)
value ('epic14973@gmail.com', 'think12bigepic');