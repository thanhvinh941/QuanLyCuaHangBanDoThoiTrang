package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.SessionFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.demo.JCalendarDemo;

import dao.GenerateKeyDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import dao_imp.GenerateKeyForNhanVienBangHang;
import dao_imp.GenerateKeyImp;
import dao_imp.MySessionFactory;
import dao_imp.NhanVienImp;
import dao_imp.TaiKhoanImp;
import entity.ChuCuaHang;
import entity.KhachHang;
import entity.NhanVienBanHang;
import entity.TaiKhoan;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThemNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenNV;
	private JTextField txtSoCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	private JTextField txtMaNV;

	SimpleDateFormat df;
	private JDateChooser dateChooser_1;
	private JLabel lblLoi;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhanVien frame = new ThemNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemNhanVien() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(10, 130, 130, 25);
		contentPane.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setBounds(150, 130, 337, 25);
		contentPane.add(txtTenNV);
		txtTenNV.setColumns(10);

		JLabel lblSoCmnd = new JLabel("Số CMND");
		lblSoCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoCmnd.setBounds(10, 180, 130, 25);
		contentPane.add(lblSoCmnd);

		txtSoCMND = new JTextField();
		txtSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoCMND.setColumns(10);
		txtSoCMND.setBounds(150, 180, 337, 25);
		contentPane.add(txtSoCMND);

		JLabel lblNewLabel_2 = new JLabel("Thêm nhân viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 0, 477, 60);
		contentPane.add(lblNewLabel_2);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSDT.setBounds(10, 230, 130, 25);
		contentPane.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 230, 337, 25);
		contentPane.add(txtSDT);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiaChi.setBounds(10, 280, 130, 25);
		contentPane.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(150, 280, 337, 25);
		contentPane.add(txtDiaChi);

		JLabel lblThanhPho = new JLabel("Thành phố");
		lblThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThanhPho.setBounds(10, 330, 130, 25);
		contentPane.add(lblThanhPho);

		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(150, 330, 337, 25);
		contentPane.add(txtThanhPho);

		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(10, 380, 130, 25);
		contentPane.add(lblNgaySinh);

		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(150, 345, 337, -14);
		contentPane.add(calendarDemo);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 380, 337, 25);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(10, 430, 130, 25);
		contentPane.add(lblGioiTinh);

		JComboBox cboGioiTinh = new JComboBox();
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cboGioiTinh.setBounds(150, 430, 110, 25);
		contentPane.add(cboGioiTinh);

		JButton btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {
					String tenNV = txtTenNV.getText();
					// String gioiTinh = cboGioiTinh.getSelectedItem().toString();

					// Boolean gioiTinh =
					// Boolean.parseBoolean(cboGioiTinh.getSelectedItem().toString());
					boolean gioiTinh = true;
					if (cboGioiTinh.getSelectedItem().equals("Nam"))
						gioiTinh = false;
					String cmnd = txtSoCMND.getText();
					String sdt = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					String thanhPho = txtThanhPho.getText();
					// String ngaySinh = dateChooser.getDateFormatString();
					// String ngaySinh = txtNga.getText();
					// String ngayVaoLam = dateChooser_1.getDateFormatString();
					Date ngaySinh = dateChooser.getDate();
					Date ngayVaoLam = dateChooser_1.getDate();

					df = new SimpleDateFormat("dd/MM/yyyy");
					try {
						NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
						NhanVienBanHang nv = new NhanVienBanHang(taoMa(), tenNV, cmnd, sdt,
								diaChi, thanhPho, ngaySinh, gioiTinh, ngayVaoLam);
						if (nhanVienDAO.themNhanVien(nv)) {
							JOptionPane.showMessageDialog(rootPane,
									"Thêm một nhân viên thành công. Tài khoản của nhân viên đã tạo với tên đăng nhập là mã nhân viên và mật khẩu mặc định là 123456");
							ChuCuaHang cch = new ChuCuaHang("CCH001");
							TaiKhoan tk = new TaiKhoan(txtMaNV.getText(), "123456", "Nhân viên", false, false, cch, nv);
							TaiKhoanDAO taiKhoanDAO = (TaiKhoanDAO) Naming.lookup("rmi://localhost:9999/taiKhoan");
							taiKhoanDAO.themTaiKhoan(tk);

						} else
							JOptionPane.showMessageDialog(rootPane, "Tạo mới không thành công");

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnThemNV.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/themKH.png")));
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemNV.setBounds(27, 572, 190, 50);
		contentPane.add(btnThemNV);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/*GDChucnangQLNhanVien gui = null;
				try {
					gui = new GDChucnangQLNhanVien();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				QuanLyNhanVien qlnv = new QuanLyNhanVien();
				gui.setVisible(true);
				qlnv.showTable();*/
			}
		});
		btnThoat.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(275, 572, 190, 50);
		contentPane.add(btnThoat);

		JLabel lblNgayVaoLam = new JLabel("Ngày vào làm:");
		lblNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayVaoLam.setBounds(10, 480, 130, 25);
		contentPane.add(lblNgayVaoLam);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(150, 480, 337, 25);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser_1);

		txtMaNV = new JTextField();
		txtMaNV.setEnabled(false);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(150, 80, 337, 25);
		contentPane.add(txtMaNV);

		// txtMaNV.setText(generateKeyDAO.getKey("NhanVienBanHang"));
		txtMaNV.setText(taoMa());
		String a = txtMaNV.getText();
		System.out.println(a);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNV.setBounds(10, 80, 130, 25);
		contentPane.add(lblMaNV);

		lblLoi = new JLabel("");
		lblLoi.setForeground(Color.RED);
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoi.setBounds(10, 531, 491, 25);
		contentPane.add(lblLoi);
	}
	
	private String taoMa() {
		String ma = "";
		try {
			int n=0;
			NhanVienDAO nhanVienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
			List<NhanVienBanHang> listNV = nhanVienDAO.layToanBoDanhSachNhanVien();
			for (NhanVienBanHang nv : listNV) {
				n++;
			}
			if(n < 9)
				ma = "NV00" + String.valueOf(n+1);
			else if(n > 9 && n <99)
				ma = "NV0" + String.valueOf(n+1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}

	private boolean validData() {
		String tenKH = txtTenNV.getText().trim();
		java.sql.Date ns;
		ns = new java.sql.Date(System.currentTimeMillis());
		String sdt = txtSDT.getText().trim();
		String cmnd = txtSoCMND.getText().trim();
		String dc = txtDiaChi.getText().trim();
		String tp = txtThanhPho.getText().trim();
		Date ngay = dateChooser.getDate();

		if (!(tenKH.length() > 0)) {
			/*
			 * showMessage( "Error: Tên khách hàng không được bỏ trống", txtTenKH);
			 */
			lblLoi.setText("Error: Tên khách hàng không được bỏ trống");
			txtTenNV.requestFocus();
			txtTenNV.selectAll();
			return false;
		}
		if (!((sdt.length() > 0 || sdt.length() == 0) && (sdt.matches("[0-9]{10}") || sdt.matches("[0-9]{11}")))) {
			/*
			 * showMessage("Error: Sai cú pháp! Số điện thoại phải nhập theo mẫu: Gồm 10 hoặc 11 chữ số"
			 * , txtSDT);
			 */
			lblLoi.setText("Error: Sai cú pháp! Số điện thoại phải nhập theo mẫu: Gồm 10 hoặc 11 chữ số");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		if (!(cmnd.length() >= 0 && (cmnd.matches("[0-9]{12}") || cmnd.matches("[0-9]{9}")))) {
			/*
			 * showMessage("Error: Sai cú pháp! Mã sách phải nhập theo mẫu: gồm 12 chữ số"
			 * , txtCMND);
			 */
			lblLoi.setText("Error: Sai cú pháp! Mã sách phải nhập theo mẫu: gồm 12 chữ số");
			txtSoCMND.requestFocus();
			txtSoCMND.selectAll();
			return false;
		}
		if (!(tp.length() > 0)) {
			/*
			 * showMessage("Error: Sai cú pháp! Thành phố phải nhập theo mẫu: Gồm dãy các chữ cái"
			 * , txtThanhPho);
			 */
			lblLoi.setText("Error: Sai cú pháp! Thành phố phải nhập theo mẫu: Gồm dãy các chữ cái");
			txtThanhPho.requestFocus();
			txtThanhPho.selectAll();
			return false;
		}
		if (ngay == null) {
			lblLoi.setText("Lỗi: Ngày sinh không được để trống!");
			dateChooser.requestFocus();

		}

		return true;
	}

}
