# Task Manager API

## Yêu cầu cài đặt
- Java 17 hoặc hơn
- Maven
- SQL Server (localhost, port:1433)

## Cách chạy
1. Mở SQL Server, chạy file SQL để tạo DB
2. Clone project trong IntelliJ IDEA
3. Sửa application.properties:
    - spring.datasource.username=sa
    - spring.datasource.password= <password>
4. Run TaskmanagerApplication.java

## Tài khoản test ( hoặc tự tạo )
- MANAGER: Boi@gmail.com / 123456
- USER: matikanetannhauser@uma.com / 123456

## Cách test có auth
1. POST /api/auth/login → copy token trong "data"
2. Swagger: click Authorize → nhập Bearer <token>
3. Postman: tab Authorization → Bearer Token → paste token

## API chính
- POST /api/auth/register — Đăng ký
- POST /api/auth/login — Đăng nhập -> nhận JWT token
- GET  /api/users — Danh sách user
- POST /api/projects — Tạo project (MANAGER only)
- GET  /api/projects — Danh sách project
- POST /api/tasks — Tạo task
- GET  /api/tasks?userId=1 — Task theo user
- PUT  /api/tasks/{id}/assign/{userId} — Assign task (MANAGER only)
- PATCH /api/tasks/{id}/status — Cập nhật status của task