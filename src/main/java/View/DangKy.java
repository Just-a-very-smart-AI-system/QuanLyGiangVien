package View;
import Model.Admin;
import Model.GiangVien;
import Model.MonHoc;
import Model.Class;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DangKy extends JFrame {
    private GiangVien giangVien;
    private Admin admin ;
    private JLabel HoVaTen;
    private JLabel Sdt;
    private JLabel MaGV;
    private JLabel Khoa;
    private JLabel RegisterClass;
    private JLabel RegisterSubject;
    private JPanel centerPanel_1;
    private JPanel centerPanel;

    
    public DangKy(GiangVien GV) {
        this.giangVien = GV;
        this.admin = new Admin();
        
        this.centerPanel = new JPanel(new BorderLayout());
        this.centerPanel_1 = new JPanel(new GridLayout(3, 4, 4, 4));
        this.init();
    }

    public void init() {
        this.setTitle("Dang Ky Mon Hoc");
        this.setSize(1300, 760);
        this.setLocationRelativeTo(null);
        
        //Tạo phần khung chương trình
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(300, 760));
        sidePanel.setBorder(new LineBorder(Color.BLACK, 2));

        centerPanel.setPreferredSize(new Dimension(1000, 560));
        centerPanel.setBorder(new LineBorder(Color.BLACK, 2));
        //Tạo topPanel
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1000, 200));
        topPanel.setBorder(new LineBorder(Color.BLACK, 2));

        this.HoVaTen = new JLabel("Ho va ten: " + giangVien.getHoTen());
        this.Sdt = new JLabel("So dien thoai: " + giangVien.getSdt());
        this.MaGV = new JLabel("Ma Giang Vien: " + giangVien.getMaGV());
        this.Khoa = new JLabel("Khoa: " + giangVien.getKhoa());
        this.RegisterClass = new JLabel("Số lớp đã đăng ký: " + giangVien.getRegisterClass());
        this.RegisterSubject = new JLabel("Số môn đã đăng ký: " + giangVien.getRegisterSubject());


        JPanel topPanel_1 = new JPanel();
        ImageIcon icon = createImageIcon("C:\\Users\\Admin\\Pictures\\icon.png");
        if (icon != null) {
            JLabel iconLabel = new JLabel(icon);
            topPanel_1.add(iconLabel);
        }

        JPanel topPanel_2 = new JPanel();
        topPanel_2.setLayout(new GridLayout(2, 3, 5, 5));
        topPanel_2.add(HoVaTen);
        topPanel_2.add(Sdt);
        topPanel_2.add(MaGV);
        topPanel_2.add(Khoa);
        topPanel_2.add(RegisterClass);
        topPanel_2.add(RegisterSubject);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topPanel_1, BorderLayout.WEST);
        topPanel.add(topPanel_2, BorderLayout.CENTER);
        
        //Tạo sidePanel
        JPanel DaiCuong = new JPanel(new GridLayout(5, 1, 3, 3));
        JLabel DcJLabel = new JLabel("Đại Cương");
        DaiCuong.add(DcJLabel);
        DaiCuong.setBorder(new LineBorder(Color.BLACK, 1));

        JPanel CoSoBatBuoc = new JPanel(new GridLayout(5, 1, 3, 3));
        JLabel CSBBLaybel = new JLabel("Cơ Sở Nghành Bắt Buộc");
        CoSoBatBuoc.add(CSBBLaybel);
        CoSoBatBuoc.setBorder(new LineBorder(Color.BLACK, 1));

        JPanel CoSoKhongBatBuoc = new JPanel(new GridLayout(5, 1, 3, 3));
        JLabel CSKBBLaybel = new JLabel("Cơ Sở Nghành Không Bắt Buộc");
        CoSoKhongBatBuoc.add(CSKBBLaybel);
        CoSoKhongBatBuoc.setBorder(new LineBorder(Color.BLACK, 1));
        
        //Tạo centerPanel_1
        JLabel center_1Laybel = new JLabel("Các lớp đã đăng ký: ");
        center_1Laybel.setPreferredSize(new Dimension(120, 40));
        centerPanel_1.add(center_1Laybel);
        
        for (Class x : giangVien.getListOfRegisterClass()) {
            JButton jButton = new JButton(x.getName());
            jButton.setPreferredSize(new Dimension(120, 40));
            centerPanel_1.add(jButton);
        }

        centerPanel_1.setBorder(new LineBorder(Color.BLACK, 2));
      
        JPanel centerPanel_2 = new JPanel(new GridLayout(3, 3, 4, 4));
        centerPanel_2.setBorder(new LineBorder(Color.BLACK, 2));
        
        JButton signOutButton = new JButton("Sign out");
        //Thêm action cho signOutButton
        signOutButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        //Thêm thành phần vào centerPanel
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(centerPanel_1, BorderLayout.NORTH);
        centerPanel.add(centerPanel_2, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(signOutButton);

        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        for (MonHoc x : this.admin.ListMon) {
            JButton jButton = new JButton(x.getName());
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Component> newCenterPanel_2 = newCenterPanel_2(x, giangVien);
                    updateCenterPanel_2(centerPanel_2, newCenterPanel_2);
                    
                }
            });

            if (x.getLoaiMon().equals("Dai Cuong")) {
                DaiCuong.add(jButton);
            } else if (x.getLoaiMon().equals("Co So Nganh Bat Buoc")) {
                CoSoBatBuoc.add(jButton);
            } else {
                CoSoKhongBatBuoc.add(jButton);
            }
        }

        sidePanel.add(DaiCuong);
        sidePanel.add(CoSoBatBuoc);
        sidePanel.add(CoSoKhongBatBuoc);
        sidePanel.setLayout(new GridLayout(3, 1, 1, 1));

        this.setLayout(new BorderLayout());
        this.add(sidePanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        
        admin.saveGiangVien();
        admin.saveMonHoc();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private List<Component> newCenterPanel_2(MonHoc x, GiangVien giangVien) {
        List<Component> newComponents = new ArrayList<>();

        for (Class newClass : x.getListOfClass()) {
            JPanel newClassPanel = new JPanel(new BorderLayout());
            newClassPanel.setBorder(new LineBorder(Color.BLACK, 1));
            //newClassPanel.setPreferredSize(new Dimension(150, 150));

            JLabel ClassName = new JLabel(newClass.getName());
            newClassPanel.add(ClassName, BorderLayout.NORTH);

            JPanel ClassInfo = new JPanel(new GridLayout(3, 1, 2, 2));

            JLabel DateLabel = new JLabel(newClass.getDateFirst());
            JLabel TietLabel = new JLabel("Tiết: " + newClass.getDateSecond());
            JLabel TeacherLabel = new JLabel("Giảng Viên: " + newClass.getTeacher());
            ClassInfo.add(DateLabel);
            ClassInfo.add(TietLabel);
            ClassInfo.add(TeacherLabel);

            newClassPanel.add(ClassInfo, BorderLayout.CENTER);

            JButton RegisterButton = new JButton("Đăng ký");
            RegisterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(giangVien.getRegisterClass() >= 10){
                        showErrorDialog("Bạn đã đăng ký quá số lớp");
                    }
                    else if(giangVien.getRegisterSubject() >= 5){
                        showErrorDialog("Bạn đã đăng ký quá số môn");
                    }
                    else {
                        if (!newClass.getTeacher().equals("Null")) {
                            showErrorDialog("Lớp này đã bị đăng ký");
                        } else if (giangVien.isClassExists(newClass)) {
                            showErrorDialog("Bạn bị trùng môn");
                        } else {
                            giangVien.ResiterClass(newClass);
                            giangVien.ResiterSubject(x);
                            newClass.setTeacher(giangVien.getHoTen());
                            showSuccessDialog("Đăng ký thành công");
                            admin.saveMonHoc();
                            TeacherLabel.setText("Giảng Viên: " + newClass.getTeacher());
                        }
                    }
                    refreshTopPanel();
                    refreshCenterPanel1();
                }
            });

            newClassPanel.add(RegisterButton, BorderLayout.SOUTH);

            newComponents.add(newClassPanel);
        }

        return newComponents;
    }
      

    private void updateCenterPanel_2(JPanel centerPanel_2, List<Component> newCenterPanel_2) {
        // Xóa tất cả các thành phần trong centerPanel_2
        centerPanel_2.removeAll();

        // Thêm các thành phần mới vào centerPanel_2
        for (Component component : newCenterPanel_2) {
            centerPanel_2.add(component);
        }

        centerPanel_2.revalidate();
        centerPanel_2.repaint();
        
    }
    
    private void refreshTopPanel() {
        // Cập nhật nội dung của topPanel dựa trên dữ liệu mới
        HoVaTen.setText("Ho va ten: " + giangVien.getHoTen());
        Sdt.setText("So dien thoai: " + giangVien.getSdt());
        MaGV.setText("Ma Giang Vien: " + giangVien.getMaGV());
        Khoa.setText("Khoa: " + giangVien.getKhoa());
        RegisterClass.setText("Số lớp đã đăng ký: " + giangVien.getRegisterClass());
        RegisterSubject.setText("Số môn đã đăng ký: " + giangVien.getRegisterSubject());
    }

    private void refreshCenterPanel1() {
        // Cập nhật nội dung của centerPanel_1 dựa trên dữ liệu mới
        centerPanel_1.removeAll();
        
        JLabel center_1Laybel = new JLabel("Các lớp đã đăng ký: ");
        center_1Laybel.setPreferredSize(new Dimension(120, 40));
        centerPanel_1.add(center_1Laybel);
        
        for (Class x : giangVien.ListOfRegisterClass) {
            JButton jButton = new JButton(x.getName());
            jButton.setPreferredSize(new Dimension(120, 40));
            centerPanel_1.add(jButton);
        }

        centerPanel_1.revalidate();
        centerPanel_1.repaint();
    }
    
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    private void showSuccessDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private ImageIcon createImageIcon(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
