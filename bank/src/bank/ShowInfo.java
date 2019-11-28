package bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.ArrowGame;

public class ShowInfo extends JFrame implements ActionListener {
	JButton btnOk;
	JButton btnNo;
	private Member loginMember;
	
	public ShowInfo(Member loginMember, String title, String str) {
		this.loginMember = loginMember;
		setTitle(title);
		JPanel pNorth = new JPanel();
		JPanel pSouth = new JPanel();
		JLabel Info = new JLabel(str, JLabel.CENTER);
		btnOk=new JButton("확인");
		btnNo=new JButton("재도전");
		add(pNorth,"North");
		add(pSouth,"South");
		pNorth.setLayout(new GridLayout(3, 1));
		pNorth.add(Info);
		pSouth.add(btnOk);
		pSouth.add(btnNo);
		btnOk.addActionListener(this);
		btnNo.addActionListener(this);
		setBounds(100, 150, 400, 300);
		setVisible(true);
	}
	
	public ShowInfo(Member loginMember, String title) {
		JLabel Info;
		JLabel Info2;
		JLabel Info3;
		
		setTitle(title);
		JPanel pNorth = new JPanel();
		JPanel pSouth = new JPanel();
		if(title.equals("잔액부족")){
			Info = new JLabel(loginMember.getName()+"님 "+"잔액이 부족합니다.", JLabel.CENTER);
			Info2 = new JLabel("현재 출금 가능하신 금액은 "+loginMember.getMoney()+"원 입니다.", JLabel.CENTER);
			Info3 = new JLabel();
		}else{
			Info=new JLabel("죄송합니다.", JLabel.CENTER);
			Info2=new JLabel("신용등급이 부족하여 현재 대출하실 수 없습니다.", JLabel.CENTER);
			Info3=new JLabel(loginMember.getName()+"님의 "+"현재 신용 등급은 "+loginMember.getLev()+"입니다.", JLabel.CENTER);
		}
		btnOk=new JButton("확인");
		add(pNorth,"North");
		add(pSouth,"South");
		pNorth.setLayout(new GridLayout(3, 1));
		pNorth.add(Info);
		pNorth.add(Info2);
		pNorth.add(Info3);
		pSouth.add(btnOk);
		btnOk.addActionListener(this);
		setBounds(100, 150, 400, 300);
		setVisible(true);
	}
	
	public ShowInfo(Member loginMember, String title, long money) {
		setTitle(title);
		JPanel pNorth = new JPanel();
		JPanel pSouth = new JPanel();
		JLabel Info = new JLabel(loginMember.getName()+"님 "+money+"원을 "+title+"하셨습니다.", JLabel.CENTER);
		JLabel totalMoney = new JLabel("현재금액은 "+loginMember.getMoney()+"원 입니다.", JLabel.CENTER);
		btnOk=new JButton("확인");
		add(pNorth,"North");
		add(pSouth,"South");
		pNorth.setLayout(new GridLayout(2, 1));
		pNorth.add(Info);
		pNorth.add(totalMoney);
		pSouth.add(btnOk);
		btnOk.addActionListener(this);
		setBounds(100, 150, 400, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object eBtn=e.getSource();
		if(eBtn==btnOk){
			dispose();
		}else{
			new ArrowGame(loginMember);
			dispose();
		}
		
	}

}
