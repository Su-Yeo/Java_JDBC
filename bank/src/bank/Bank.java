package bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bank extends JFrame implements ActionListener{
	JButton btnSend; //�۱�
	JButton btnOut; //���
	JButton btnLev; //���
	JButton btnLoan; //����
	JButton btnIn; //�Ա�
	JButton btnInfo; //������
	
	Member loginMember;
	Member[] MemberArr;
	
	public Bank(Member[] MemberArr, Member loginMember) {
		this.loginMember = loginMember;
		this.MemberArr = MemberArr;
		setTitle("����");
		setLayout(new GridLayout(3, 2, 20, 20));
		btnSend=new JButton("�۱�");
		btnOut=new JButton("���");
		btnLev=new JButton("�ſ��޿ø���");
		btnLoan=new JButton("����");
		btnIn=new JButton("�Ա�");
		btnInfo=new JButton("�� ����");
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
			new Send(MemberArr, loginMember); //�۱�
		else if(eBtn==btnOut)
			new Output(loginMember); //���
		else if(eBtn==btnLev)
			new LevelUp(loginMember); //�ſ��� �ø���
		else if(eBtn==btnLoan)
			new Loan(loginMember); //����
		else if(eBtn==btnIn)
			new Input(loginMember); //�Ա�
		else if(eBtn==btnInfo)
			new Check(loginMember); //������
	}
	
}
