package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class Admin {
    public List<MonHoc> ListMon;
    public List<GiangVien> ListofGiangVien;

    public Admin() {
        this.ListMon = new ArrayList<>();
        this.ListofGiangVien = new ArrayList<>();

        // Save default data
        if(loadMonHoc().isEmpty()){
            this.ListMon.addAll(createSubject());
            saveMonHoc();
        }
        else{
            this.ListMon.addAll(loadMonHoc());
        }
        
        if(loadGiangVien().isEmpty()){
            this.ListofGiangVien.addAll(createGV());
            saveGiangVien();    
        }
        else{
            this.ListofGiangVien.addAll(loadGiangVien());
        }
    }
    
    public List<GiangVien> createGV(){
        this.ListofGiangVien = new ArrayList<>();
        GiangVien GV1 = new GiangVien("MH12", "Trần Duy Việt Hoằng", "0338042263", "CNTT", "Hoang123", "Hoang123");
        GiangVien GV2 = new GiangVien("NK37", "Nguyễn Tá Đặng Minh", "0975683131", "KTOTO", "Minh123", "Minh123");
        GiangVien GV3 = new GiangVien("HT79", "Hà Nam Khánh", "0795713549", "DTVT", "Khanh123", "Khanh123");
        
        ListofGiangVien.add(GV1);
        ListofGiangVien.add(GV2);
        ListofGiangVien.add(GV3);
        
        return ListofGiangVien;
    }
    
    public List<MonHoc> createSubject(){
        this.ListMon = new ArrayList<>();
        DaiCuong VL = new DaiCuong("1795", "Vật Lý", 3);
        Class Vl1 = new Class("Vật Lý N01");
        VL.AddClass(Vl1, "Thứ 2", 1, 3);
        
        Class Vl2 = new Class("Vật Lý N02");
        VL.AddClass(Vl2, "Thứ 4", 2, 4);
        
        Class Vl3 = new Class("Vật Lý N03");
        VL.AddClass(Vl3, "Thứ 5", 7, 9);
        
        Class Vl4 = new Class("Vật Lý N04");
        VL.AddClass(Vl4, "Thứ 7", 5, 7);
        
        Class Vl5 = new Class("Vật Lý N05");
        VL.AddClass(Vl5, "Thứ 7", 3, 5);
        ListMon.add(VL);
        
        DaiCuong TRR = new DaiCuong("1367", "Toán Rời Rạc", 3);
        Class Trr1 = new Class("Toán Rời Rạc N01");
        TRR.AddClass(Trr1, "Thứ 2", 2, 4);
        
        Class Trr2 = new Class("Toán Rời Rạc N02");
        TRR.AddClass(Trr2, "Thứ 2", 5, 7);
        
        Class Trr3 = new Class("Toán Rời Rạc N03");
        TRR.AddClass(Trr3, "Thứ 3", 1, 3);
        
        Class Trr4 = new Class("Toán Rời Rạc N04");
        TRR.AddClass(Trr4, "Thứ 5", 3, 5);
        
        Class Trr5 = new Class("Toán Rời Rạc N05");
        TRR.AddClass(Trr5, "Thứ 6", 7, 9);
        
        Class Trr6 = new Class("Toán Rời Rạc N06");
        TRR.AddClass(Trr6, "Thứ 6", 1, 3);
        ListMon.add(TRR);
        
        CoSoBatBuoc CTDL = new CoSoBatBuoc("2569", "Cấu Trúc Dữ Liệu", 3);
        Class Ctdl1 = new Class("Cấu Trúc Dữ Liệu N01");
        CTDL.AddClass(Ctdl1, "Thứ 2", 1, 3);
        
        Class Ctdl2 = new Class("Cấu Trúc Dữ Liệu N02");
        CTDL.AddClass(Ctdl2, "Thứ 4", 1, 3);
        
        Class Ctdl3 = new Class("Cấu Trúc Dữ Liệu N03");
        CTDL.AddClass(Ctdl3, "Thứ 5", 5, 7);
        
        Class Ctdl4 = new Class("Cấu Trúc Dữ Liệu N04");
        CTDL.AddClass(Ctdl4, "Thứ 6", 2, 4);
        
        Class Ctdl5 = new Class("Cấu Trúc Dữ Liệu N05");
        CTDL.AddClass(Ctdl5, "Thứ 7", 7, 9);
        ListMon.add(CTDL);
        
        CoSoBatBuoc OOP = new CoSoBatBuoc("2867", "Lập Trình Hướng Đối Tượng", 3);
        Class Oop1 = new Class("Lập Trình Hướng Đối Tượng N01");
        OOP.AddClass(Oop1, "Thứ 4", 5, 7);
        
        Class Oop2 = new Class("Lập Trình Hướng Đối Tượng N02");
        OOP.AddClass(Oop2, "Thứ 4", 2, 4);
        
        Class Oop3 = new Class("Lập Trình Hướng Đối Tượng N03");
        OOP.AddClass(Oop3, "Thứ 5", 1, 3);
        
        Class Oop4 = new Class("Lập Trình Hướng Đối Tượng N04");
        OOP.AddClass(Oop4, "Thứ 5", 2, 4);
        
        Class Oop5 = new Class("Lập Trình Hướng Đối Tượng N05");
        OOP.AddClass(Oop5, "Thứ 6", 3, 5);
        
        Class Oop6 = new Class("Lập Trình Hướng Đối Tượng N06");
        OOP.AddClass(Oop6, "Thứ 7", 5, 7);
        ListMon.add(OOP);
        
        CoSoKhongBatBuoc OS = new CoSoKhongBatBuoc("3196", "Hệ Điều Hành", 2);
        Class Os1 = new Class("Hệ Điều Hành N01");
        OS.AddClass(Os1, "Thứ 3", 1, 2);
        
        Class Os2 = new Class("Hệ Điều Hành N02");
        OS.AddClass(Os2, "Thứ 3", 4, 5);
        
        Class Os3 = new Class("Hệ Điều Hành N03");
        OS.AddClass(Os3, "Thứ 4", 5, 6);
        
        Class Os4 = new Class("Hệ Điều Hành N04");
        OS.AddClass(Os4, "Thứ 5", 7, 8);
        
        Class Os5 = new Class("Hệ Điều Hành N05");
        OS.AddClass(Os5, "Thứ 5", 1, 2);
        
        Class Os6 = new Class("Hệ Điều Hành N06");
        OS.AddClass(Os6, "Thứ 6", 3, 4);
        ListMon.add(OS);
        
        CoSoKhongBatBuoc MMT = new CoSoKhongBatBuoc("3267", "Mạng Máy Tính", 2);
        Class Mmt1 = new Class("Mạng Máy Tính N01");
        MMT.AddClass(Mmt1, "Thứ 2", 4, 5);
        
        Class Mmt2 = new Class("Mạng Máy Tính N02");
        MMT.AddClass(Mmt2, "Thứ 3", 4, 5);
        
        Class Mmt3 = new Class("Mạng Máy Tính N03");
        MMT.AddClass(Mmt3, "Thứ 4", 2, 3);
        
        Class Mmt4 = new Class("Mạng Máy Tính N04");
        MMT.AddClass(Mmt4, "Thứ 6", 8, 9);
        
        Class Mmt5 = new Class("Mạng Máy Tính N05");
        MMT.AddClass(Mmt5, "Thứ 7", 5, 6);
        ListMon.add(MMT);
        
        return ListMon;
    }
    
    //Lưu danh sách giảng viên
    public void saveGiangVien() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QuanLyGiangVien\\GiangVien.data"))) {
            for (GiangVien x : ListofGiangVien) {
                oos.writeObject(x);
            }
            System.out.println("GiangVien list saved to file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //lấy danh sách giảng viên từ file
    public List<GiangVien> loadGiangVien() {
        List<GiangVien> loadedList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QuanLyGiangVien\\GiangVien.data"))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof GiangVien) {
                        loadedList.add((GiangVien) obj);
                    }
                } catch (EOFException e) {
                    break; // Đã đọc hết tệp tin
                }
            }
            System.out.println("GiangVien list loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return loadedList;
    }
    
    
    public void saveMonHoc() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QuanLyGiangVien\\MonHoc.data"))) {
            for (MonHoc x : ListMon) {
                oos.writeObject(x);
            }
            System.out.println("MonHoc list saved to file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách môn học từ tệp tin
    public List<MonHoc> loadMonHoc() {
        List<MonHoc> loadedList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QuanLyGiangVien\\MonHoc.data"))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof MonHoc) {
                        loadedList.add((MonHoc) obj);
                    }
                } catch (EOFException e) {
                    break; // Đã đọc hết tệp tin
                }
            }
            System.out.println("MonHoc list loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return loadedList;
    }
    
    public void AddMon(MonHoc monhoc){
        this.ListMon.add(monhoc); 
    }

    public void DeleteMon(MonHoc monhoc){
        this.ListMon.remove(monhoc);
        
    }
    
    public void DeleteClass(MonHoc monhoc, Class Class1){
        for(MonHoc x : ListMon){
            if(x.equals(monhoc)){
                x.getListOfClass().remove(Class1);
            }
        }
    }
    
    public void AddGiangVien(GiangVien gv){
        this.ListofGiangVien.add(gv);
    }
    
}
