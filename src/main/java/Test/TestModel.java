package Test;

import Model.Admin;
import Model.GiangVien;
import Model.DaiCuong;
import Model.CoSoBatBuoc;
import Model.CoSoKhongBatBuoc;
import Model.Class;
import View.DangKy;
import View.SignIn;
import java.util.List;

public class TestModel {
    private Admin admin;
    
    public TestModel(){
        admin = new Admin();
        
    }
    public static void main(String[] args) {
        TestModel Test1 = new TestModel();
        
        new SignIn();
        
    }
}
