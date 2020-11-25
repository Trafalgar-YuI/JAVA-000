CREATE TABLE t_purchaser
(
    id              VARCHAR(64)    NOT NULL COMMENT '买家ID 使用雪花算法生成主键',
    login_id        VARCHAR(64)    NOT NULL COMMENT '买家登录帐号',
    login_password  VARCHAR(64)    NOT NULL COMMENT '买家登录密码 存储MD5加密的值',
    nick_name       VARCHAR(32)    NOT NULL COMMENT '昵称',
    id_card         VARCHAR(32)    NOT NULL COMMENT '身份证号',
    phone_number    VARCHAR(32)    NOT NULL COMMENT '手机号',
    balance         DECIMAL(32, 8) NOT NULL DEFAULT 0 COMMENT '余额（分）',
    account_status  VARCHAR(32)    NOT NULL DEFAULT 1 COMMENT '帐号状态 1-正常/2-注销/3-冻结',
    create_datetime DATETIME       NOT NULL DEFAULT now() COMMENT '创建时间',
    update_datetime DATETIME       NOT NULL DEFAULT now() COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT = '存储买家的账户，包括但不限于帐号、密码、昵称、余额';