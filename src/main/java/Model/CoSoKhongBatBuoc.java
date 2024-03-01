package Model;

public class CoSoKhongBatBuoc extends MonHoc {
    public CoSoKhongBatBuoc(String MaMon, String Ten, int TongSoTiet) {
        super(MaMon, Ten, TongSoTiet);
        setLoaiMon();
    }

    public void setLoaiMon() {
        this.LoaiMon = "Co So Nganh Khong Bat Buoc";
    }
}