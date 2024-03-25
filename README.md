Bài tập lớn Lập trình hướng đối tượng

Nhóm trưởng: Trần Duy Việt Hoằng

Thành viên: Nguyễn Tá Đặng Minh, Hà Nam Khánh

Đề bài: tạo 1 chương trình quản lý đăng ký lớp dậy của giảng viên

Bài được thực hiện theo mô hình MVC 
- Trong phần Model có các lớp thành phần như:
  + GiangVien : thông tin cơ bản của 1 giảng viên.
  + MonHoc : thông tin cơ bản của các môn học.
  + Class: thông tin cơ bản của 1 lớp.
  + Admin: khởi tạo thông tin của các giảng viên và các môn học.
- Trong Phần View có các thành phần:
  + DangKy: tạo trang đăng ký môn học với các chức năng: Hiển thị thông tin giảng viên, hiển thị các môn học, hiển thị các lớp của các môn học, đăng ký lớp, hủy lớp đã đăng ký.
  + SignIn: tạo trang đăng nhập cho giảng viên bằng UserName và PassWord.
- Phần Test là để chạy thử chương trình: Chạy file TestModel để thử đăng ký tín chỉ với UserName là **Hoang123** và PassWord là **Hoang123**, UserName là **Khanh123** và PassWord là **Khanh123**, UserName là **Minh123** và PassWord là **Minh123**
- Phần Đăng ký lớp dậy sau khi đăng nhập ấn vào tên các môn ở bên trái để hiển thị các lớp để đăng ký. Ấn đăng ký để đăng ký lớp dậy, nếu bị trùng tiết sẽ bị thông báo trùng môn học, nếu muốn hủy lớp đã đăng ký ấn vào các lớp ở phần lớp đã đăng ký để hủy lớp hoặc bỏ qua, sau khi hủy đăng ký ấn lại vào các môn bên cạnh để tiếp tục đăng ký tiếp.
- Nếu muốn đăng xuất dùng tài khoản khác hãy ấn nút Sign Out và đăng nhập tài khoản khác.
