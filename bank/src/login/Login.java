//2018-06-01 21:23 cording by ChoiWoojung
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bank.Bank;
import bank.Member;

public class Login extends JFrame implements ActionListener {
	private JLabel id_Label= new JLabel("ID : ");
	private JLabel pw_Label= new JLabel("PW : ");
	private JLabel alert_Label;
	private JTextField id_Text;
	private JPasswordField pw_Text;
	private JButton login_Btn;
	private JButton repLogin_Btn;
	private Member MemberArr[];
	private Member loginMember;
	
	public Login(Member[] MemberArr, Member loginMember, JButton repLogin_Btn) {
		setLayout(null);
		this.MemberArr = MemberArr;
		this.loginMember = loginMember;
		this.repLogin_Btn = repLogin_Btn;
		
		alert_Label = new JLabel();
		id_Text = new JTextField();
		pw_Text = new JPasswordField();
		login_Btn = new JButton("로그인");
		
		id_Label.setBounds(40,30,100,50);
		id_Text.setBounds(90, 40, 150, 30);
		pw_Label.setBounds(40,80,100,50);
		pw_Text.setBounds(90, 90, 150, 30);
		login_Btn.setBounds(260,40,80,80);
		alert_Label.setBounds(90, 130, 300,30);
		
		add(id_Label);
		add(pw_Label);
		add(id_Text);
		add(pw_Text);
		add(login_Btn);
		add(alert_Label);
		
		login_Btn.addActionListener(this);
		setTitle("로그인");
		setBounds(200,200,400,200);
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		boolean id_check = false;
		boolean pw_check = false;
		String id_str = id_Text.getText();
		String pw_str = new String(pw_Text.getPassword());
		
		for (int i =0; i<MemberArr.length; i++) {
			if (MemberArr[i] == null)
				break;
			
			String id_str2 = MemberArr[i].getId();
			String pw_str2 = MemberArr[i].getPw();
			
			id_check = id_str.equals(id_str2);
			pw_check = pw_str.equals(pw_str2);
			
			if (id_check && pw_check) {
				loginMember = MemberArr[i];
				repLogin_Btn.setText("로그아웃");
				new Bank(MemberArr, loginMember);
				dispose();
				break;
			}
			alert_Label.setText("아이디와 비밀번호를 확인해주세요");
		}
	}

}
