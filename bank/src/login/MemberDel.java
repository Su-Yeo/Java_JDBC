
//구현:김승현
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bank.Member;

public class MemberDel extends JFrame implements ActionListener{
	private JLabel id_Label= new JLabel("ID : ");
	private JLabel pw_Label= new JLabel("PW : ");
	private JLabel alert_Label;
	private JTextField id_Text;
	private JTextField pw_Text;
	private JButton delete_Btn;
	private Member[] memberArr;
	
	
	public MemberDel(Member[] arr) {
		memberArr=arr;
		
		setLayout(null);
		
		alert_Label = new JLabel();
		id_Text = new JTextField();
		pw_Text = new JTextField();
		delete_Btn = new JButton("삭제하기");
		
		id_Label.setBounds(40,30,100,50);
		id_Text.setBounds(90, 40, 150, 30);
		pw_Label.setBounds(40,80,100,50);
		pw_Text.setBounds(90, 90, 150, 30);
		delete_Btn.setBounds(260,40,100,80);
		alert_Label.setBounds(90, 130, 300,30);
		
		add(id_Label);
		add(pw_Label);
		add(id_Text);
		add(pw_Text);
		add(delete_Btn);
		add(alert_Label);
		
		delete_Btn.addActionListener(this);
		
		setTitle("회원삭제");
		setBounds(200,200,400,200);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		int idx=-1;
		for(int i=0; i<memberArr.length; i++) {
			if(memberArr[i]!=null) {
				if(memberArr[i].getId().equals(id_Text.getText()) && memberArr[i].getPw().equals(pw_Text.getText())) {
					memberArr[i]=null;
					idx=i;
					new MemberDelRes(memberArr, idx, id_Text.getText());
					dispose();
					break;
				}
			}
		}
		if(idx==-1) {
			alert_Label.setText("아이디와 비밀번호를 확인해주세요");
		}
		
	}
}
