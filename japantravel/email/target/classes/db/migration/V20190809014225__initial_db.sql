
create table if not exists email_attachments_aud
(
	id int not null,
	rev int not null,
	revtype tinyint null,
	attachment_path longtext null,
	email_log_id int null,
	primary key (id, rev)
)
engine=MyISAM;

create index FK9j32x2ln3u8ppduwrve75tap4
	on email_attachments_aud (rev);

create table if not exists email_log
(
	id int auto_increment
		primary key,
	sent_by varchar(100) null,
	sent_to varchar(100) null,
	subject text null,
	sent_status tinyint(1) null,
	sent_time datetime null,
	body longtext null
);

create table if not exists email_attachments
(
	id int auto_increment
		primary key,
	email_log_id int not null,
	attachment_path text null,
	constraint email_attachments_email_log_id_fk
		foreign key (email_log_id) references email_log (id)
);

create table if not exists email_log_aud
(
	id int not null,
	rev int not null,
	revtype tinyint null,
	body longtext null,
	sent_by varchar(255) null,
	sent_status bit null,
	sent_time datetime null,
	sent_to varchar(255) null,
	subject longtext null,
	primary key (id, rev)
)
engine=MyISAM;

create index FKmrtk0j7qx95uj6k6b6s9qi5m7
	on email_log_aud (rev);

create table if not exists revinfo
(
	rev int auto_increment
		primary key,
	revtstmp bigint null
)
engine=MyISAM;

