
package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class MonHoc {
    public String MaMon;
    public String Name;
    public String LoaiMon;
    public int TongSoTiet;
    private List<Class> ListOfClass;

    public MonHoc(String MaMon, String Ten, int TongSoTiet) {
        this.MaMon = MaMon;
        this.Name = Ten;
        this.TongSoTiet = TongSoTiet;
        this.ListOfClass = new ArrayList<>();
    }

    public void AddClass(Class newClass, String date, int start, int end) {
        newClass.addDate(date, start, end);
        for (Class existingClass : ListOfClass) {
            // Kiểm tra đã tồn tại class này chưa
            if (existingClass.getName().equals(newClass.getName())) {
                // Nếu đã tồn tại
                ListOfClass.remove(existingClass);
            }
        }
        ListOfClass.add(newClass);
    }

    public boolean isClassExists(Class newClass) {
        if (ListOfClass.isEmpty()) {
            return false;
        }
        for (Class existingClass : ListOfClass) {
            // Kiểm tra đã tồn tại class này chưa
            if (existingClass.getName().equals(newClass.getName())) {
                // Nếu đã tồn tại
                return true;
            }
                         
        }
        // Nếu không tìm thấy sự trùng lặp
        return false;
    }

    public List<Class> getListOfClass() {
        return ListOfClass;
    }

    
    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLoaiMon() {
        return LoaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.LoaiMon = loaiMon;
    }

    public int getTotalTiet() {
        return TongSoTiet * ListOfClass.size();
    }

    public void setTongSoTiet(int TongSoTiet) {
        this.TongSoTiet = TongSoTiet;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "MaMon= " + MaMon + ", Ten= " + Name + ", LoaiMon= " + LoaiMon + ", TongSoTiet= " + getTotalTiet() + ", ListOfClass= " + ListOfClass + '}';
    }
}
