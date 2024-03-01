package Model;

public class DaiCuong extends MonHoc {
    public DaiCuong(String MaMon, String Ten, int TongSoTiet) {
        super(MaMon, Ten, TongSoTiet);
        setLoaiMon();
    }

    public void setLoaiMon() {
        this.LoaiMon = "Dai Cuong";
    }
}