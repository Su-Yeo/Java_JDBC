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
		btnOk=new JButton("Ȯ��");
		btnNo=new JButton("�絵��");
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
		if(title.equals("�ܾ׺���")){
			Info = new JLabel(loginMember.getName()+"�� "+"�ܾ��� �����մϴ�.", JLabel.CENTER);
			Info2 = new JLabel("���� ��� �����Ͻ� �ݾ��� "+loginMember.getMoney()+"�� �Դϴ�.", JLabel.CENTER);
			Info3 = new JLabel();
		}else{
			Info=new JLabel("�˼��մϴ�.", JLabel.CENTER);
			Info2=new JLabel("�ſ����� �����Ͽ� ���� �����Ͻ� �� �����ϴ�.", JLabel.CENTER);
			Info3=new JLabel(loginMember.getName()+"���� "+"���� �ſ� ����� "+loginMember.getLev()+"�Դϴ�.", JLabel.CENTER);
		}
		btnOk=new JButton("Ȯ��");
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
		JLabel Info = new JLabel(loginMember.getName()+"�� "+money+"���� "+title+"�ϼ̽��ϴ�.", JLabel.CENTER);
		JLabel totalMoney = new JLabel("����ݾ��� "+loginMember.getMoney()+"�� �Դϴ�.", JLabel.CENTER);
		btnOk=new JButton("Ȯ��");
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
