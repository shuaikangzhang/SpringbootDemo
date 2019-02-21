### 说明
##### 项目介绍
- 项目基于简单的springboot，主要用于演示通过注解的方式实现多数据源的切换
- 执行流程
   - 测试方法在priv.zsk.second.controller.mutiDataSourceController.java
   - 具体流程，先查询第一个数据库中的用户信息，然后通过用户的id查询用户的住址信息，达到测试多数据源切换的目的。


##### 注意事项
- 项目结构分为了datasources、second、springbootdemo。（second和springbootdemo里面的东西可以在一个包中同时存在，当时是测试非注解方式后懒得修改项目结构了）
- 有关多数据源的配置都放在priv.zsk.datasources包下
- 有关多数据源的测试方法都在second包下。
- springbootdemo包下主要是测试swagger。辅助测试多数据源。（用到了里面的查询方法）
- 同时注意需要在启动类里面，加上： `@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})`
否则会出现如图1所示的错误：
![图1](markdown_img/wrong1.png "")


##### 新增数据源时修改项：
1. 需要在.yml中添加相应的数据源地址的配置
2. 在priv.zsk.datasources.DataSourceNames.java中增加数据源的名称
3. 在priv.zsk.datasources.DynamicDataSourceConfig.java中增加相关的配置

##### 测试方法
1. 运行项目后，在浏览器中输入http://localhost:8080/SpringbootDemo/mutiDataSource/mutiDataSourceCheck
2. 查看控制台，输出结果如图2所示：
![图2](markdown_img/result.png "")
