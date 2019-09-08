create table if not exists revinfo
(
	rev int auto_increment
		primary key,
	revtstmp bigint null
)
engine=MyISAM;

create table if not exists sms_log
(
	sms_id int auto_increment
		primary key,
	sender varchar(20) null,
	reciever varchar(20) null,
	sent_at datetime null,
	delivered tinyint(1) default 0 null,
	content text null,
	tracking_info varchar(255) null
);

create index sms_log_sent_at_index
	on sms_log (sent_at desc);

create table if not exists sms_log_aud
(
	sms_id int not null,
	rev int not null,
	revtype tinyint null,
	content varchar(255) null,
	delivered bit null,
	reciever varchar(255) null,
	sender varchar(255) null,
	sent_at datetime null,
	tracking_info varchar(255) null,
	primary key (sms_id, rev)
)
engine=MyISAM;

create index FK635d0ncfupktux4yeiso7lrfg
	on sms_log_aud (rev);

create table if not exists twillio_settings
(
	account_sid varchar(255) not null
		primary key,
	auth_token text null,
	created_at datetime null,
	updated_at datetime null
);

create index twillio_settings_created_at_index
	on twillio_settings (created_at desc);

create table if not exists twillio_settings_aud
(
	account_sid varchar(255) not null,
	rev int not null,
	revtype tinyint null,
	auth_token varchar(255) null,
	created_at datetime null,
	updated_at datetime null,
	primary key (account_sid, rev)
);

INSERT INTO twillio_settings (account_sid, auth_token, created_at, updated_at) VALUES ('AC65ac4a0bda555d3465bde8f511246fdb', '87c0a46c5157234ab66a4f25820f074d', '2019-08-07 21:50:52', '2019-08-07 21:50:59');
