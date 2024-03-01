
package Model;

public class CoSoBatBuoc extends MonHoc {
    public CoSoBatBuoc(String MaMon, String Ten, int TongSoTiet) {
        super(MaMon, Ten, TongSoTiet);
        setLoaiMon();
    }

    public void setLoaiMon() {
        this.LoaiMon = "Co So Nganh Bat Buoc";
    }
}
