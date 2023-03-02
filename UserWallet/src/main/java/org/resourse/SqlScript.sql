-- 用户钱包表
create table t_user_wallet
(
    uid         bigint primary key comment 用户id,
    balance     varchar(16) not null default '0.00' comment 钱包余额,
    update_time timestamp   not null comment 修改时间
);
-- 用户钱包历史表，如果数据量多起来了，可以为uid和两个时间字段设置索引，方便查询
create table t_user_wallet_his
(
    fid                bigint primary key comment 主键,
    uid                bigint      not null comment 用户id,
    amount_consumption varchar(16) not null default '0.00' comment 变动金额,
    type               int         not null default 0 comment 消费类型- 0充值 1消费 2 退款..,
    data_type          int         not null default 1 comment 数据状态-1生效0未生效,
    create_time        timestamp   not null comment 创建时间,
    update_time        timestamp   not null comment 修改时间
);

