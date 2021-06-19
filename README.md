## JSP-Product

### 1. 简介

+ 简单的实现了商品的增删改查

+ 思维导图

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/JSP商品案例.png)

### 2. 项目列表

![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/项目列表.png)

## 项目部署

### 1. 搭建环境

+ `MySQL` 5.2 以上
+ `JDK` 1.8.0 

### 2. 创建数据库

+ 创建 `product` 数据库

  ```mysql
  create table product(
  	pno int primary key,      
  	pname varchar(50),       
  	price double,            
  	category varchar(50),     
  	num int                   	
  );
  ```

+ 插入几条数据

  ```mysql
  insert into product values(10001,'女装',100,'服装',10);
  insert into product values(10002,'冰箱',1000,'家电',50);
  insert into product values(10003,'蛋糕',55,'食品',50);
  ```

### 3. 配置参数

+ 找到 `ch12/Java Resources/jdbc` 下的 `JDBCUtils.java`

  ```java
  Class.forName("com.mysql.jdbc.Driver");		//	5.6版本以上
  // Class.forName("com.mysql.cj.jdbc.Driver");  //	8.0版本以上
  
  //	product为数据库名
  String url = "jdbc:mysql://localhost:3306/product";	
  String username = "root";			//	用户名
  String password = "942674";			//	密码
  ```

### 4. 报错

+ 示例

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/报错.png)

+ 点击 `Build Path`

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/build.png)

+ 移除 `jre`

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/移除.png)

+ 重新添加 `jre`

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/添加.png)
  
+ 选择 `default JRE`

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/添加2.png)

+ 应用并关闭 `Apply and Close`

  ![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/添加3.png)

### 5. 配置成功，启动服务器，访问 [http://localhost:8080/ch12/ShowProductServlet](http://localhost:8080/ch12/ShowProductServlet) ，就能看到商品列表了

## 项目演示

### 1. 添加商品信息

![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/添加.gif)

### 2. 删除商品信息

![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/delete.gif)

### 3. 修改商品信息

![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/update.gif)

### 4. 查询商品信息

![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/select.gif)

### 5. 查看商品信息

![](https://gitee.com/zxiaosi/image/raw/master/Project/Java/JSP-Product/show.gif)