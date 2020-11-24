CREATE TABLE t_commodity
(
    id                      VARCHAR(64)     NOT NULL COMMENT '商品ID 使用雪花算法生成主键',
    merchant_id             VARCHAR(64)     NOT NULL COMMENT '商家ID 商家ID',
    name                    VARCHAR(128)    NOT NULL COMMENT '商品名称 商品名称',
    type                    VARCHAR(32)     NOT NULL COMMENT '商品类型 商品的分类类型',
    count                   BIGINT          NOT NULL DEFAULT 0 COMMENT '商品数量 商品数量',
    price                   DECIMAL(32, 8)  NOT NULL DEFAULT 100000000 COMMENT '商品价格 商品价格（分）',
    buy_count               BIGINT          NOT NULL DEFAULT 0 COMMENT '商品购买数量 商品购买数量',
    comment_level           DECIMAL(32, 10) NOT NULL DEFAULT 5.0 COMMENT '商品的评价等级 商品的评价等级（定时任务计算）',
    discount_ratio          DECIMAL(32, 10)   NOT NULL DEFAULT 100 COMMENT '折扣比例 折扣比例',
    discount_start_datetime DATETIME        NOT NULL COMMENT '打折开始时间 打折开始时间',
    discount_end_datetime   DATETIME        NOT NULL COMMENT '打折结束时间 打折结束时间',
    create_datetime         DATETIME        NOT NULL DEFAULT now() COMMENT '创建时间 创建时间',
    update_datetime         DATETIME        NOT NULL DEFAULT now() COMMENT '更新时间 更新时间',
    PRIMARY KEY (id)
) COMMENT = '商品信息表，包括但不限于商品名称、价格、数量、商户ID等';