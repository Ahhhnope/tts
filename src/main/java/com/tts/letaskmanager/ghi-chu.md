# Mô tả - Task manager

### Main entities
+ User: Người dùng hệ thống (users / managers)
+ Project: Dự án, gồm nhiều Task và nhiều User
+ Task: Công việc của 1 Project, được giao cho 1 User
+ Role: Quyền (user / manager)

### Relationships
+ 1 User --> n Task (1–n)
+ 1 Project --> n Task (1–n)
+ n User <--> n Project (n–n) qua user_project
+ 1 User <--> 1 Role (1-1)