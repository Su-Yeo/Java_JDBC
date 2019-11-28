package bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bank extends JFrame implements ActionListener{
	JButton btnSend; //송금
	JButton btnOut; //출금
	JButton btnLev; //등급
	JButton btnLoan; //대출
	JButton btnIn; //입급
	JButton btnInfo; //내정보
	
	Member loginMember;
	Member[] MemberArr;
	
	public Bank(Member[] MemberArr, Member loginMember) {
		this.loginMember = loginMember;
		this.MemberArr = MemberArr;
		setTitle("은행");
		setLayout(new GridLayout(3, 2, 20, 20));
		btnSend=new JButton("송금");
		btnOut=new JButton("출금");
		btnLev=new JButton("신용등급올리기");
		btnLoan=new JButton("대출");
		btnIn=new JButton("입금");
		btnInfo=new JButton("내 정보");
		add(btnSend);
		add(btnOut);
		add(btnLev);
		add(btnLoan);
		add(btnIn);
		add(btnInfo);
		btnSend.addActionListener(this);
		btnOut.addActionListener(this);
		btnLev.addActionListener(this);
		btnLoan.addActionListener(this);
		btnIn.addActionListener(this);
		btnInfo.addActionListener(this);
		setBounds(300, 250, 450, 450);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eBtn=e.getSource();
		if(eBtn==btnSend)
			new Send(MemberArr, loginMember); //송금
		else if(eBtn==btnOut)
			new Output(loginMember); //출금
		else if(eBtn==btnLev)
			new LevelUp(loginMember); //신용등급 올리기
		else if(eBtn==btnLoan)
			new Loan(loginMember); //대출
		else if(eBtn==btnIn)
			new Input(loginMember); //입금
		else if(eBtn==btnInfo)
			new Check(loginMember); //내정보
	}
	
}
