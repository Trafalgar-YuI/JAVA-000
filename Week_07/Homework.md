# 作业

## Week07 作业题目（周四）

### 2.（必做）按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率

### 3.（选做）按自己设计的表结构，插入 1000 万订单模拟数据，测试不同方式的插入效

#### 第一步，创建函数

1. 创建随机生成**人名**的函数

   ```mysql
   create
       definer = `yui`@`%` function `rand_name`() returns varchar(255) charset utf8mb4 collate utf8mb4_general_ci
   begin
       declare char_str1 varchar(100) default 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
       declare char_str2 varchar(100) default 'abcdefghijklmnopqrstuvwxyz';
       declare return_str varchar(255) default '';
       declare i int default 0;
       declare n int default 5;
   -- 	firstname
       set return_str := substring(char_str1, floor(1 + rand() * 26), 1);
       set n := floor(1 + rand() * 5);
       while i < n
           do
               set return_str := concat(return_str, substring(char_str2, floor(1 + rand() * 26), 1));
               set i = i + 1;
           end while;
   -- 	lastname
       set return_str := concat(return_str, ' ');
       set return_str := concat(return_str, substring(char_str1, floor(1 + rand() * 26), 1));
       set n := floor(1 + rand() * 5);
       set i := 0;
       while i < n
           do
               set return_str := concat(return_str, substring(char_str2, floor(1 + rand() * 26), 1));
               set i = i + 1;
           end while;
       return return_str;
   end;
   ```

2. 创建随机生成 **id** 的函数

   ```mysql
   create
       definer = `yui`@`%` function `rand_id`() returns varchar(255) charset utf8mb4 collate utf8mb4_general_ci
   begin
       declare char_str varchar(100) default 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
       declare return_str varchar(255) default '';
       declare i int default 0;
       declare n int default 5;
       set n := floor(1 + rand() * 40);
       while i < n
           do
               set return_str := concat(return_str, substring(char_str, floor(1 + rand() * 52), 1));
               set i = i + 1;
           end while;
       return return_str;
   end;
   ```

3. 创建随机生成**身份证号**的函数

   ```mysql
   create
       definer = `yui`@`%` function `rand_id_card`() returns varchar(18) charset utf8mb4 collate utf8mb4_general_ci
   begin
       declare char_number varchar(100) default '0123456789';
       declare char_last varchar(100) default '0123456789X';
       declare return_str varchar(255) default '';
       declare i int default 0;
       declare n int default 17;
       while i < n
           do
               set return_str := concat(return_str, substring(char_number, floor(1 + rand() * 10), 1));
               set i = i + 1;
           end while;
       set return_str := concat(return_str, substring(char_last, floor(1 + rand() * 11), 1));
       return return_str;
   end;
   ```

4. 创建随机生成**手机号**的函数

   ```mysql
   create function `rand_phone`() returns char(11) charset utf8
       deterministic
   begin
       declare head varchar(100) default '000,156,136,176,183';
       declare content char(10) default '0123456789';
       declare phone char(11) default substring(head, 1 + (floor(1 + (rand() * 3)) * 4), 3);
       declare i int default 1;
       declare len int default length(content);
       while i < 9
           do
               set i = i + 1;
               set phone = concat(phone, substring(content, floor(1 + rand() * len), 1));
           end while;
       return phone;
   end;
   ```

5. 创建生成**买家表**数据的函数

   ```mysql
   create
       definer = `yui`@`%` procedure `create_purchaser`(num int)
   begin
       declare i bigint default 0;
       declare d timestamp default now();
       declare exit handler for sqlexception begin
           rollback; select -1;
       end;
       start transaction;
       repeat
           set i = i + 1;
           set d := now();
           insert into t_purchaser
           values (uuid(), rand_id(), md5('123456'), rand_name(), rand_id_card(), rand_phone(), 0, 1, d, d);
       until i = num end repeat;
       commit;
   end;
   ```

6. 创建生成**商品表**数据的函数

   ```mysql
   create
       definer = `yui`@`%` procedure `create_commodity`(num int)
   begin
       declare i bigint default 0;
       declare d timestamp default now();
       declare exit handler for sqlexception begin
           rollback; select -1;
       end;
       start transaction;
       repeat
           set i = i + 1;
           set d := now();
           insert into t_commodity
           values (uuid(), uuid(), rand_name(), rand_name(), 0, 0, 0, 5, 100, d, d, d, d);
       until i = num end repeat;
       commit;
   end;
   ```

7. 创建生成**订单表**数据的函数

   ```mysql
   create
       definer = `yui`@`%` procedure `create_order`(num int)
   begin
       declare i bigint default 0;
       declare d timestamp default now();
       declare exit handler for sqlexception begin
           rollback; select -1;
       end;
       start transaction;
       repeat
           set i = i + 1;
           set d := now();
           insert into t_order
           values (uuid(), uuid(), uuid(), uuid(), 0, 0, 1, d, d);
       until i = num end repeat;
       commit;
   end;
   ```




#### 第二步，生成数据

1. 买家 数据

    ```mysql
    MariaDB [db_ecommerce]> call create_purchaser(10000);
    Query OK, 10000 rows affected (2.398 sec)
    ```

    ```mysql
    MariaDB [db_ecommerce]> select count(*) from t_purchaser;
    +----------+
    | count(*) |
    +----------+
    |    10000 |
    +----------+
    1 row in set (0.002 sec)
    ```

2. 商品 数据

   ```mysql
   MariaDB [db_ecommerce]> call create_commodity(1000);
   Query OK, 1000 rows affected (0.138 sec)
   ```
   
```mysql
   MariaDB [db_ecommerce]> select count(*) from t_commodity;
   +----------+
   | count(*) |
   +----------+
   |     1000 |
   +----------+
   1 row in set (0.000 sec)
   ```
   
3. 订单 数据

    生成 100w 条数据

    ```mysql
    MariaDB [db_ecommerce]> call create_order(1000000);
    Query OK, 1000000 rows affected (33.045 sec)
    ```

    ```mysql
    MariaDB [db_ecommerce]> select count(*) from t_order;
    +----------+
    | count(*) |
    +----------+
    |  1000000 |
    +----------+
    1 row in set (0.250 sec)
    ```

    清除数据

    ```mysql
    MariaDB [db_ecommerce]> truncate t_order;
    Query OK, 0 rows affected (0.024 sec)
    ```

    ```mysql
    MariaDB [db_ecommerce]> select count(*) from t_order;
    +----------+
    | count(*) |
    +----------+
    |        0 |
    +----------+
    1 row in set (0.000 sec)
    ```

    生成 1000w 条数据

    ```mysql
    MariaDB [db_ecommerce]> call create_order(10000000);
    Query OK, 10000000 rows affected (4 min 34.832 sec)
    ```

    ```mysql
    MariaDB [db_ecommerce]> select count(*) from t_order;
    +----------+
    | count(*) |
    +----------+
    | 10000000 |
    +----------+
    1 row in set (47.154 sec)
    ```

    