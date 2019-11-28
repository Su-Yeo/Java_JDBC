//2018-06-01 18:08 cording by ChoiWoojung
//2018-06-03 23:14 modifying by ChoiWoojung
package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bank.Member;
import style.Style;

public class MainForm extends JFrame implements ActionListener {
	private Member loginMember= new Member();
	private Member MemberArr[] = new Member[5];
	private JButton	join_Btn;
	private JButton login_Btn;
	private JButton MemberList_Btn;
	private JButton MemberDel_Btn;
	private JButton exit_Btn;
	
	public MainForm() {
		setLayout(new GridLayout(5,1));
		
		join_Btn = new JButton("ȸ������");
		login_Btn = new JButton("�α���");
		MemberList_Btn = new JButton("ȸ��Ȯ��");
		MemberDel_Btn = new JButton("ȸ��Ż��");
		exit_Btn = new JButton("����");
		
		new Style(join_Btn);
		new Style(login_Btn);
		new Style(MemberList_Btn);
		new Style(MemberDel_Btn);
		new Style(exit_Btn);
		
		add(join_Btn);
		add(login_Btn);
		add(MemberList_Btn);
		add(MemberDel_Btn);
		add(exit_Btn);
		
		join_Btn.addActionListener(this);
		login_Btn.addActionListener(this);
		MemberList_Btn.addActionListener(this);
		MemberDel_Btn.addActionListener(this);
		exit_Btn.addActionListener(this);
		
		setTitle("����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		new Style(300, 350, this);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object btn = e.getSource();
		if (btn == exit_Btn) {
			System.exit(0);
		}
		
		if (btn == join_Btn) {
			new JoinMember(MemberArr);
			return;
		}
		
		if (btn == MemberList_Btn) {
			new MemberList(MemberArr);
			return;
		}
		
		if (btn == MemberDel_Btn) {
			new MemberDel(MemberArr);
			return;
		}
		
		if (login_Btn.getText().equals("�α���")) {
			new Login(MemberArr,loginMember,login_Btn);
		} else {
			login_Btn.setText("�α���");
			loginMember = null;
		}
	}

	public static void main(String[] args) {
		MainForm mainWindow = new MainForm();
	}

}
