package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class GiangVien {
    private String maGV, HoTen, Sdt, Khoa, Username, Password;
    public List<Class> ListOfRegisterClass;
    public Set<MonHoc> SetOfRegisterSubject;

    public GiangVien(String maGV, String HoTen, String Sdt, String Khoa, String Username, String Password) {
        this.maGV = maGV;
        this.HoTen = HoTen;
        this.Sdt = Sdt;
        this.Khoa = Khoa;
        this.Username = Username;
        this.Password = Password;
        this.ListOfRegisterClass = new ArrayList<>();
        this.SetOfRegisterSubject = new HashSet<>();
    }
    public List<Class> getListOfRegisterClass(){
        return this.ListOfRegisterClass;
    }
    public Set<MonHoc> getSetOfRegisterSubject(){
        return this.SetOfRegisterSubject;
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }
    
    public int getRegisterClass(){
        return this.ListOfRegisterClass.size();
    }
    public int getRegisterSubject(){
        return this.SetOfRegisterSubject.size();
    }

    
    
    public boolean isClassExists(Class newClass) {
        if (ListOfRegisterClass.isEmpty()) {
            return false;
        }

        for (Class existingClass : ListOfRegisterClass) {
            // Kiểm tra đã tồn tại class này chưa
            if (existingClass.getName().equals(newClass.getName())) {
                return true;
            }

            // Lọc trùng tiết dậy nếu ngày học giống nhau
            if (existingClass.getDate().getFirst().equals(newClass.getDate().getFirst())) {
                Pair<Integer, Integer> existingTime = existingClass.getDate().getSecond();
                Pair<Integer, Integer> newTime = newClass.getDate().getSecond();

                int start1 = existingTime.getFirst();
                int end1 = existingTime.getSecond();

                int start2 = newTime.getFirst();
                int end2 = newTime.getSecond();

                // Kiểm tra trùng lặp thời gian
                if ((start1 <= start2 && start2 <= end1) || (start1 <= end2 && end2 <= end1) || (start2 <= start1 && start1 <= end2) || (start2 <= end1 && end1 <= end2)) {
                    return true;
                }
            }
        }

        // Nếu không tìm thấy sự trùng lặp
        return false;
    }


    public void ResiterSubject(MonHoc monhoc){
        if(SetOfRegisterSubject.size() < 5){
            //monhoc.getListOfClass().clear();
            this.SetOfRegisterSubject.add(monhoc);
        }
        else{
            System.out.println("Bạn đã đăng ký quá số lượng môn!");
        }
    }
    public void ResiterClass(Class newClass){
        if(ListOfRegisterClass.size() < 10){
            if(isClassExists(newClass)){
                System.out.println("Lop khong the bi trung!");
            }
            else{
                ListOfRegisterClass.add(newClass);
            }
        }
        else{
            System.out.println("Ban Da Dang Ky Qua So Luong Lop!");      
        }
    }
    
    @Override
    public String toString() {
        return "GiangVien{" + "maGV= " + maGV + ", HoTen= " + HoTen + ", Sdt= " + Sdt + ", Khoa= " + Khoa + '}';
        
    }
}
    