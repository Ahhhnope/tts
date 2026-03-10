# Hướng dẫn test project — Task Manager

## Bước 1: Clone và run
Mở IntelliJ → git clone link GitHub trong gg drive 
- sửa application.properties → Run

## Bước 2: Tạo tài khoản
- POST http://localhost:8080/api/auth/register
- với body:
{ "name":"Test", "email":"test@gmail.com",
"password":"123456", "role":"MANAGER" }

## Bước 3: Đăng nhập lấy token
- POST http://localhost:8080/api/auth/login
- với body:
{ "email":"test@gmail.com", "password":"123456" }
→ Copy token trong "data"

## Bước 4: Test API
+ Postman: vào Authorization → Bearer Token → paste token từ bước 3 
+ Swagger: bấm Authorize → Bearer → paste token từ bước 3

## Các API cần test
1. POST /api/projects — tạo project
2. POST /api/tasks — tạo task
3. PUT /api/tasks/1/assign/2 — assign task
4. PATCH /api/tasks/1/status — update status