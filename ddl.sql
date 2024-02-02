create table box
(
    lecture_no int                                not null comment '강의 번호',
    user_no    int                                not null comment '회원번호',
    insert_dt  datetime default CURRENT_TIMESTAMP not null
)
    comment '보관함';

create table lecture
(
    lecture_no       int auto_increment comment '강의 번호'
        primary key,
    lecture_category varchar(50)              not null comment '강의 대분류',
    lecture_tag      varchar(200)             null comment '태그 (ex1, ex2, ex3...)',
    lecture_url      varchar(2083)            not null comment '강의 url',
    use_yn           char     default 'Y'     not null comment '사용여부',
    insert_dt        datetime default (now()) not null,
    insert_id        varchar(20)              not null,
    update_dt        datetime                 null,
    upate_id         varchar(20)              null
)
    comment '강의';

create table user
(
    user_no       int auto_increment comment '회원번호'
        primary key,
    user_id       varchar(20)              not null comment '회원ID',
    user_name     varchar(20)              not null comment '닉네임',
    user_password varchar(50)              not null comment '암호(TODO 암호화)',
    user_role     int      default 1       not null comment '0: 관리자, 1: 사용자',
    use_yn        char     default 'Y'     not null comment '사용여부',
    withdraw_dt   datetime                 null comment '탈퇴일',
    insert_dt     datetime default (now()) not null comment '등록일',
    insert_id     varchar(20)              not null comment '등록자',
    update_dt     datetime                 null comment '수정일',
    update_id     varchar(20)              null comment '수정자',
    constraint member_pk_2
        unique (user_id)
)
    comment '회원';

