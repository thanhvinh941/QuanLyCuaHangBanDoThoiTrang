package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.demo.JCalendarDemo;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThemSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtSp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemSanPham frame = new ThemSanPham();
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
	public ThemSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 130, 130, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(150, 130, 467, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSCmnd = new JLabel("Loại sản phẩm");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSCmnd.setBounds(10, 180, 130, 25);
		contentPane.add(lblSCmnd);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(150, 180, 467, 25);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thêm sản phẩm");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(10, 0, 477, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hãng sản xuất");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 230, 130, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Size:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 280, 130, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Màu sắc");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 330, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 380, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JCalendarDemo calendarDemo = new JCalendarDemo();
		calendarDemo.setBounds(150, 345, 337, -14);
		contentPane.add(calendarDemo);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giá sản phẩm:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 430, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Thêm sản phẩm");
		btnNewButton.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/themKH.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(28, 495, 190, 50);
		contentPane.add(btnNewButton);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThot.setIcon(new ImageIcon(ThemKhachHang.class.getResource("/img/cancel.png")));
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(279, 495, 190, 50);
		contentPane.add(btnThot);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nike"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(150, 230, 170, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"S", "M"}));
		comboBox_1.setBounds(150, 280, 170, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Đen"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1_1.setBounds(150, 330, 170, 25);
		contentPane.add(comboBox_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(150, 380, 170, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(150, 430, 256, 25);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Thêm hãng sản xuất nếu chưa có");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(342, 230, 275, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Nhập size mới nếu chưa có:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(341, 280, 197, 25);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(565, 280, 170, 25);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nhập màu mới nếu chưa có:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2_1.setBounds(341, 330, 209, 25);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(565, 330, 170, 25);
		contentPane.add(textField_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(762, 0, 1, 579);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Phần nhập sản phẩm đã có sẵn ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(773, 64, 463, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSnPhm.setBounds(773, 150, 130, 25);
		contentPane.add(lblMSnPhm);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SP001", "SP002", "SP003"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBounds(912, 150, 170, 25);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Size:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_3.setBounds(773, 200, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2_1.setBounds(912, 200, 170, 25);
		contentPane.add(comboBox_2_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Màu sắc");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2.setBounds(773, 250, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JComboBox comboBox_2_1_1 = new JComboBox();
		comboBox_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2_1_1.setModel(new DefaultComboBoxModel(new String[] {"Đen", "Trắng"}));
		comboBox_2_1_1.setBounds(912, 250, 170, 25);
		contentPane.add(comboBox_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Số lượng");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_2.setBounds(773, 300, 130, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(912, 300, 170, 25);
		contentPane.add(textField_6);
		
		JButton btnThmVoKho = new JButton("Thêm vào kho");
		btnThmVoKho.setIcon(new ImageIcon(ThemSanPham.class.getResource("/img/icons8_add_40px.png")));
		btnThmVoKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThmVoKho.setBounds(892, 460, 190, 50);
		contentPane.add(btnThmVoKho);
		
		JLabel lblMSnPhm_1 = new JLabel("Mã sản phẩm:");
		lblMSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSnPhm_1.setBounds(10, 80, 130, 25);
		contentPane.add(lblMSnPhm_1);
		
		txtSp = new JTextField();
		txtSp.setText("SP009");
		txtSp.setEditable(false);
		txtSp.setEnabled(false);
		txtSp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSp.setColumns(10);
		txtSp.setBounds(150, 80, 170, 25);
		contentPane.add(txtSp);
		
		JButton btnToMi = new JButton("Tạo mới");
		btnToMi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnToMi.setBounds(534, 495, 190, 50);
		contentPane.add(btnToMi);
	}
}
