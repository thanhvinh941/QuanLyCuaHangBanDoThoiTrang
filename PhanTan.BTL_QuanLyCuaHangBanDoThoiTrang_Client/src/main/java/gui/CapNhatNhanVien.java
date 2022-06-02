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
import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.KhachHang;
import entity.NhanVienBanHang;

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

public class CapNhatNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenNV;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	private JTextField txtMaNV;


	SimpleDateFormat df;
	private JDateChooser dateChooser_1;
	private JComboBox cboGioiTinh;
	private JDateChooser dateChooserNgaySinh;
	private JDateChooser dateChooserNgayVaoLam;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatNhanVien frame = new CapNhatNhanVien();
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
	public CapNhatNhanVien() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(10, 130, 130, 25);
		contentPane.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setBounds(150, 130, 337, 25);
		contentPane.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblSCmnd = new JLabel("Số CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(10, 180, 130, 25);
		contentPane.add(lblSCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(150, 180, 337, 25);
		contentPane.add(txtCMND);
		
		JLabel lblNewLabel_2 = new JLabel("Cập nhật nhân viên");
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
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(10, 380, 130, 25);
		contentPane.add(lblNgaySinh);
		
		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(150, 345, 337, -14);
		contentPane.add(calendarDemo);
		
		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(150, 380, 337, 25);
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooserNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(10, 430, 130, 25);
		contentPane.add(lblGioiTinh);
		
		cboGioiTinh = new JComboBox();
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cboGioiTinh.setBounds(150, 430, 110, 25);
		contentPane.add(cboGioiTinh);
		
		JButton btnCapNhatNV = new JButton("Cập nhật");
		btnCapNhatNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNV = txtMaNV.getText();
				String tenNV = txtTenNV.getText();
				//String gioiTinh =  cboGioiTinh.getSelectedItem().toString();
				
				//Boolean gioiTinh = Boolean.parseBoolean(cboGioiTinh.getSelectedItem().toString());
				boolean gioiTinh = true;
				if(cboGioiTinh.getSelectedItem().equals("Nam"))
					gioiTinh = false;
				String cmnd = txtCMND.getText();
				String sdt  = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				String thanhPho = txtThanhPho.getText();
				Date ngaySinh = dateChooserNgaySinh.getDate();
				Date ngayVaoLam = dateChooserNgayVaoLam.getDate();
				//String ngaySinh = txtNgaySinh.getText();
				
				df = new SimpleDateFormat("dd/MM/yyyy");
				try {
					NhanVienDAO nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
					NhanVienBanHang nv = new NhanVienBanHang(maNV, tenNV, gioiTinh,cmnd, sdt, diaChi, thanhPho, ngaySinh,  ngayVaoLam, true);
					boolean rs = nhanvienDAO.capNhatNhanVien(nv);
					if(rs) {
						JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin nhân viên thành công");
					
					} else 
						JOptionPane.showMessageDialog(rootPane, "Cập nhật nhân viên không thành công");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCapNhatNV.setIcon(new ImageIcon(CapNhatNhanVien.class.getResource("/img/updateKH.png")));
		btnCapNhatNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapNhatNV.setBounds(29, 521, 190, 50);
		contentPane.add(btnCapNhatNV);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
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
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(278, 521, 190, 50);
		contentPane.add(btnThoat);
		
		JLabel lblNgayVaoLam = new JLabel("Ngày vào làm");
		lblNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayVaoLam.setBounds(10, 480, 130, 25);
		contentPane.add(lblNgayVaoLam);
		
		dateChooserNgayVaoLam = new JDateChooser();
		dateChooserNgayVaoLam.setBounds(150, 480, 337, 25);
		dateChooserNgayVaoLam.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooserNgayVaoLam);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên ");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNV.setBounds(10, 80, 130, 25);
		contentPane.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(150, 80, 337, 25);
		contentPane.add(txtMaNV);
	}

	public void showData(String ma) {
		NhanVienDAO nhanvienDAO = null;
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:9999/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NhanVienBanHang nv = null;
		try {
			nv = nhanvienDAO.layNhanVienTheoMa(ma);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtMaNV.setText(ma);
        txtTenNV.setText(nv.getTenNhanVien());
        txtSDT.setText(nv.getSoDienThoai());
        txtCMND.setText(nv.getSoCMND());
        txtDiaChi.setText(nv.getDiaChi());
        txtThanhPho.setText(nv.getThanhPho());
        cboGioiTinh.setSelectedItem(nv.isGioiTinh()?"Ná»¯":"Nam");
        
        Date dateNgaySinh;
        Date dateNgayVaoLam;
        df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateNgaySinh = new SimpleDateFormat("dd/MM/yyyy").parse( df.format(nv.getNgaySinh()) );
			dateChooserNgaySinh.setDate(dateNgaySinh);
			dateNgayVaoLam = new SimpleDateFormat("dd/MM/yyyy").parse( df.format(nv.getNgayVaoLam()) );
			dateChooserNgayVaoLam.setDate(dateNgayVaoLam);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
