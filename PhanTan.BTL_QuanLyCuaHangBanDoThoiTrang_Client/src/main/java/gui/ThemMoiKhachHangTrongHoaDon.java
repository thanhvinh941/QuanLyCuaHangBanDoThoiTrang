package gui;

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
import dao_imp.GenerateKeyImp;
import dao_imp.KhachHangImp;
import dao_imp.MySessionFactory;
import entity.KhachHang;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooserBeanInfo;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JDayChooserBeanInfo;
import com.toedter.calendar.demo.DateChooserPanelBeanInfo;
import java.awt.Color;

public class ThemMoiKhachHangTrongHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	private JTextField txtKh;
	private JComboBox cboGioiTinh;

	
	SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
	SimpleDateFormat df;
	private JDateChooser dateChooser;
	private JLabel lblLoi;
	//String maKH = generateKeyDAO.getKey("KhachHang");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemMoiKhachHangTrongHoaDon frame = new ThemMoiKhachHangTrongHoaDon();
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
	public ThemMoiKhachHangTrongHoaDon() {
		setFocusCycleRoot(true);
		setFocusableWindowState(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int y = 80;
		
		JLabel lblNewLabel = new JLabel("T??n kh??ch h??ng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 130, 130, 25);
		contentPane.add(lblNewLabel);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKH.setBounds(150, 130, 337, 25);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblSCmnd = new JLabel("S??? CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(10, 180, 130, 25);
		contentPane.add(lblSCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(150, 180, 337, 25);
		contentPane.add(txtCMND);
		
		JLabel lblNewLabel_2 = new JLabel("Th??m kh??ch h??ng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 0, 477, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("S??? ??i???n tho???i");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 230, 130, 25);
		contentPane.add(lblNewLabel_1_1);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 230, 337, 25);
		contentPane.add(txtSDT);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("?????a ch???");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 280, 130, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(150, 280, 337, 25);
		contentPane.add(txtDiaChi);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Th??nh ph???");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 330, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(150, 330, 337, 25);
		contentPane.add(txtThanhPho);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ng??y sinh:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 380, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(150, 345, 337, -14);
		contentPane.add(calendarDemo);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Gi???i t??nh:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 430, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		cboGioiTinh = new JComboBox<Object>();
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N???"}));
		cboGioiTinh.setBounds(150, 430, 110, 25);
		contentPane.add(cboGioiTinh);
		
		
		
		JButton btnNewButton = new JButton("Th??m kh??ch h??ng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {
					String tenKH = txtTenKH.getText();
					// String gioiTinh = cboGioiTinh.getSelectedItem().toString();

					// Boolean gioiTinh =
					// Boolean.parseBoolean(cboGioiTinh.getSelectedItem().toString());
					boolean gioiTinh = true;
					if (cboGioiTinh.getSelectedItem().equals("Nam"))
						gioiTinh = false;
					String cmnd = txtCMND.getText();
					String sdt = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					String thanhPho = txtThanhPho.getText();
					// String ngaySinh = dateChooser.getDateFormatString();
					// String ngaySinh = txtNgaySinh.getText();
					Date ngaySinh = dateChooser.getDate();

					df = new SimpleDateFormat("dd/MM/yyyy");
					if(ngaySinh != null) {
						try {
							KhachHangDAO khachHangDAO = (KhachHangDAO) Naming.lookup("rmi://localhost:9999/khachhang");
							GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");

							KhachHang kh = new KhachHang(generateKeyDAO.getKey("KhachHang"), tenKH, cmnd, sdt, diaChi,
									thanhPho, ngaySinh, gioiTinh);
							if (khachHangDAO.themKhachHang(kh))
								JOptionPane.showMessageDialog(rootPane, "Th??m m????t kha??ch ha??ng tha??nh c??ng");
							else
								JOptionPane.showMessageDialog(rootPane, "Ta??o m????i kh??ng tha??nh c??ng");

						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else
						lblLoi.setText("L???i: Ng??y sinh kh??ng ???????c ????? r???ng");
					
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/themKH.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(33, 523, 211, 50);
		contentPane.add(btnNewButton);
		
		JButton btnThot = new JButton("Tho??t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				ThemHoaDonBanHang gui = new ThemHoaDonBanHang();
				gui.setVisible(true);
				gui.themVaoLuaChonKh(txtSDT.getText());
			}
		});
		btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(277, 523, 210, 50);
		contentPane.add(btnThot);
		
		JLabel lblNewLabel_1 = new JLabel("M?? kh??ch h??ng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 80, 130, 25);
		contentPane.add(lblNewLabel_1);
		
		txtKh = new JTextField();
		txtKh.setEnabled(false);
		txtKh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKh.setColumns(10);
		txtKh.setBounds(150, 80, 337, 25);
		contentPane.add(txtKh);
		
		try {
			GenerateKeyDAO generateKeyDAO = (GenerateKeyDAO) Naming.lookup("rmi://localhost:9999/generateKey");

			txtKh.setText(generateKeyDAO.getKey("KhachHang"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 380, 337, 25);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser);
		
		lblLoi = new JLabel("");
		lblLoi.setForeground(Color.RED);
		lblLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoi.setBounds(10, 470, 477, 43);
		contentPane.add(lblLoi);
		
		//System.out.println(maKH);
	}
	
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		JOptionPane.showMessageDialog(null, message);
	}

	private boolean validData() {
		String tenKH = txtTenKH.getText().trim();
		java.sql.Date ns;
		ns = new java.sql.Date(System.currentTimeMillis());
		String sdt = txtSDT.getText().trim();
		String cmnd = txtCMND.getText().trim();
		String dc = txtDiaChi.getText().trim();
		String tp = txtThanhPho.getText().trim();
		String ngay = dateChooser.getDateFormatString();

		if (!(tenKH.length() > 0)) {
			/*showMessage(
					"Error: T??n kh??ch h??ng kh??ng ???????c b??? tr???ng",
					txtTenKH);*/
			lblLoi.setText("Error: T??n kh??ch h??ng kh??ng ???????c b??? tr???ng");
			txtTenKH.requestFocus();
			txtTenKH.selectAll();
			return false;
		}
		if (!((sdt.length() > 0 || sdt.length() == 0) && (sdt.matches("[0-9]{10}") || sdt.matches("[0-9]{11}") ) )) {
			/*showMessage("Error: Sai cu?? pha??p! S???? ??i????n thoa??i pha??i nh????p theo m???u: G????m 10 ho???c 11 ch???? s????",
					txtSDT);*/
			lblLoi.setText("Error: Sai cu?? pha??p! S???? ??i????n thoa??i pha??i nh????p theo m???u: G????m 10 ho???c 11 ch???? s????");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		if (!(cmnd.length() >= 0 && (cmnd.matches("[0-9]{12}") || cmnd.matches("[0-9]{9}")))) {
			/*showMessage("Error: Sai cu?? pha??p! M?? s??ch pha??i nh????p theo m???u: g????m 12 ch???? s????", txtCMND);*/
			lblLoi.setText("Error: Sai cu?? pha??p! M?? s??ch pha??i nh????p theo m???u: g????m 12 ch???? s????");
			txtCMND.requestFocus();
			txtCMND.selectAll();
			return false;
		}
		if (!(tp.length() > 0)) {
			/*showMessage("Error: Sai cu?? pha??p! Tha??nh ph???? pha??i nh????p theo m???u: G????m da??y ca??c ch???? ca??i",
					txtThanhPho);*/
			lblLoi.setText("Error: Sai cu?? pha??p! Tha??nh ph???? pha??i nh????p theo m???u: G????m da??y ca??c ch???? ca??i");
			txtThanhPho.requestFocus();
			txtThanhPho.selectAll();
			return false;
		}
		if(ngay.length() == 0) {
			lblLoi.setText("L???i: Ng??y sinh kh??ng ???????c ????? tr???ng!");
			dateChooser.requestFocus();

		}

		return true;
	}
}
