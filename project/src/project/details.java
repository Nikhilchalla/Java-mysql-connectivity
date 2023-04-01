package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class details {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details window = new details();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel r1 = new JLabel("Roll no:");
		r1.setFont(new Font("Tahoma", Font.BOLD, 16));
		r1.setBounds(70, 47, 73, 30);
		frame.getContentPane().add(r1);
		
		t1 = new JTextField();
		t1.setBounds(153, 54, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lb1 = new JLabel("Name:");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb1.setBounds(70, 143, 179, 14);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks:");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb2.setBounds(70, 168, 169, 14);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("Check!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollno=t1.getText();
				int roln=Integer.parseInt(rollno);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","mrec");
					String q="Select name,marks from project where rollno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, roln);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name:"+rs.getString(1));
					lb2.setText("Marks:"+rs.getInt(2));
		
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(150, 99, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
