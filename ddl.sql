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

create table ai_response
(
    user_no           int                                not null comment '회원번호',
    ai_id             varchar(100)                       not null comment 'ai 응답 고유 번호'
        primary key,
    ai_message        varchar(2000)                      null comment 'ai 응답 내용',
    ai_prompt         varchar(500)                       null comment 'ai 요청 내용',
    ai_model          varchar(20)                        not null comment '사용된 ai 모델',
    prompt_tokens     int      default 0                 not null comment '프롬프트 토큰수',
    completion_tokens int      default 0                 not null comment '응답 토큰수',
    total_tokens      int      default 0                 not null comment '최종 토큰수',
    insert_dt         datetime default CURRENT_TIMESTAMP not null,
    insert_id         varchar(20)                        not null
)
    comment 'AI 처리 결과';

create table design_bytes.video
(
    video_no           int auto_increment
        primary key,
    video_title        varchar(20)   not null comment '영상 제목',
    video_url          varchar(2083) null comment 'url',
    video_running_time int           not null comment '영상 길이(ms)',
    video_maker_id     varchar(20)   null comment '제작자id',
    video_maker_name   varchar(20)   null comment '제작자명',
    video_file_size    int           not null comment '파일사이즈(mb)',
    video_paid_yn      char          not null comment '유료여부(y: 유료, n: 무료)',
    video_price        int           null comment '영상가격()',
    video_thumbnail_id int           null comment '썸네일ID'
)
    comment '영상';


