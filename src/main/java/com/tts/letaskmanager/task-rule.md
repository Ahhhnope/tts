# Task rules

### 1. Flow of 'Task status'
+ Todo → In progress → Done
+ Không được quay ngược trạng thái
+ Các task ở trạng thái "Done" sẽ không thể update nữa

### 2. Create task
+ Phải có ProjectId
+ Task mới sẽ có default status = "Todo"

### 3. Assign task
+ Task sẽ chỉ có thể được giao cho user thuộc project đó
+ Nếu user không thuộc project → từ chối

### 4. Update task status
+ Không cho update nếu task ở trạng thái "Done"

### 5. Deadline thingy
+ Deadline không thể là trước ngày tạo task 
+ Title không được rỗng, tối đa 50 ký tự 

### 6. Create task
+ Status mặc định = "Todo"

### 7. Assign Task -> chỉ Manager mới có thể làm