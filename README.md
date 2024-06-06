# springboot-lucake
## 此專案是用來筆記一些SpringBoot相關用法
* Spring Data Jpa
* Spring Security + JWT
* AOP
* Redis
* Swagger

## 簡單用Docker建立DB和Redis
* PostgreSQL:
``docker run -d -p 5432:5432 --name some-postgres -e POSTGRES_PASSWORD=123 -d postgres``
* Redis:
``docker run -d -p 6379:6379 --name some-redis -d redis``
