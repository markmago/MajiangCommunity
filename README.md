##码匠社区 学习springboot

##资料
[Spring web文档](https://spring.io/guides/gs/serving-web-content/)
[es](https://elasticsearch.cn/explore)
[bootstrap](https://v3.bootcss.com/getting-started/)
[github oauth](https://developer.github.com/apps/building-oauth-apps/)
[spring官方文档](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)

##工具
[git](https://git-scm.com/download)
[visual-paradigm](https://www.visual-paradigm.com)

##脚本
```sql
create table USER
(
	ID INTEGER  auto_increment
		primary key,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN VARCHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT
);


``` 