CREATE TABLE t_order
(
    id                VARCHAR(64)    NOT NULL COMMENT 'ID 使用雪花算法生成主键',
    purchaser_id      VARCHAR(64)    NOT NULL COMMENT '买家ID 买家ID',
    commodity_id      VARCHAR(64)    NOT NULL COMMENT '商品ID 商品ID',
    merchant_id       VARCHAR(64)    NOT NULL COMMENT '商家ID 商家ID',
    address           VARCHAR(1024)  NOT NULL COMMENT '发货地址',
    transaction_price DECIMAL(32, 8) NOT NULL COMMENT '交易价格 交易时的价格（分）',
    transaction_count BIGINT         NOT NULL COMMENT '交易数量 交易数量',
    order_status      VARCHAR(32)    NOT NULL DEFAULT 1 COMMENT '订单状态 订单状态1-交易创建/2-买家付款/3-卖家发货/4-货品到达/5-订单成功/6-订单评价完成/7-订单失败',
    create_datetime   DATETIME       NOT NULL COMMENT '创建时间 创建时间',
    update_datetime   DATETIME       NOT NULL COMMENT '更新时间 更新时间',
    PRIMARY KEY (id)
) COMMENT = '订单表，包括但不限于订单买家ID、商品ID、购买时的价格、购买的数量';