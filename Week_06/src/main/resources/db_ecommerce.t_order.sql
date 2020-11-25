CREATE TABLE t_order
(
    id                VARCHAR(64)    NOT NULL COMMENT 'ID 使用雪花算法生成主键',
    purchaser_id      VARCHAR(64)    NOT NULL COMMENT '买家ID',
    commodity_id      VARCHAR(64)    NOT NULL COMMENT '商品ID',
    transaction_price DECIMAL(32, 8) NOT NULL COMMENT '交易时的价格（分）',
    transaction_count BIGINT         NOT NULL COMMENT '交易数量',
    address           VARCHAR(1024)  NOT NULL COMMENT '收货地址',
    order_status      VARCHAR(32)    NOT NULL DEFAULT 1 COMMENT '订单状态 1-交易创建/2-买家付款/3-卖家发货/4-货品到达/5-订单成功/6-订单评价完成/7-订单失败',
    create_datetime   DATETIME       NOT NULL COMMENT '创建时间',
    update_datetime   DATETIME       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) COMMENT = '订单表，包括但不限于订单买家ID、商品ID、购买时的价格、购买的数量';