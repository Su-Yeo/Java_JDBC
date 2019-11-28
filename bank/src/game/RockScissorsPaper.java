//2018-06-03 15:13 cording by ChoiWoojung
package game;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bank.Member;
import login.ChangeLev;

public class RockScissorsPaper extends JFrame implements ActionListener {
	
	public final static int SCISSORS = 1;
	public final static int ROCK = 2;
	public final static int PAPER = 3;
	private JButton Seissors_Btn = new JButton("가위");
	private JButton Rock_Btn = new JButton("바위");
	private JButton Paper_Btn = new JButton("  보  ");
	private JLabel User_Lable = new JLabel("나",JLabel.CENTER);
	private JLabel Com_Lable = new JLabel("컴퓨터",JLabel.CENTER);
	private JLabel lbl1 = new JLabel();
	private JLabel lbl2 = new JLabel();
	private ImageIcon image = new ImageIcon("RSPimg/Rock.JPG");
	private Member loginMember;
	private RSPAlert exit;
	public RockScissorsPaper(Member loginMember) {
		this.loginMember = loginMember;
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		pan1.setLayout(new GridLayout(1, 3));
		pan2.setLayout(new GridLayout(1, 2));
		pan3.setLayout(new GridLayout(1, 2));
		
		add(pan1,"South");
		add(pan2,"Center");
		add(pan3,"North");

		Seissors_Btn.addActionListener(this);
		Rock_Btn.addActionListener(this);
		Paper_Btn.addActionListener(this);
		
		pan1.add(Seissors_Btn);
		pan1.add(Rock_Btn);
		pan1.add(Paper_Btn);
		
		pan3.add(User_Lable);
		pan3.add(Com_Lable);

		lbl1 = new JLabel(image,JLabel.CENTER);
		lbl2 = new JLabel(image,JLabel.CENTER);
		
		pan2.add(lbl1);
		pan2.add(lbl2);
		
		setTitle("가위바위보");
		setBounds(200, 300, 400, 250);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object check_Btn = e.getSource();
		int me, com, point = loginMember.getPoint();
		boolean win = false;
		if (exit != null)
			exit.dispose();
		if (check_Btn == Seissors_Btn) {
			me = SCISSORS;
			lbl1.setIcon(new ImageIcon("RSPimg/Scissors.JPG"));
		}else if(check_Btn == Rock_Btn) {
			me = ROCK;
			lbl1.setIcon(new ImageIcon("RSPimg/Rock.JPG"));
		}else {
			me = PAPER;
			lbl1.setIcon(new ImageIcon("RSPimg/Paper.JPG"));
		}
		
		Random random = new Random();
		com = random.nextInt(3)+1;
		switch (com) {
		case ROCK:
			image = new ImageIcon("RSPimg/Rock.JPG");
			break;
		case SCISSORS:
			image = new ImageIcon("RSPimg/Scissors.JPG");
			break;
		case PAPER:
			image = new ImageIcon("RSPimg/Paper.JPG");
			break;
		}
		lbl2.setIcon(image);
		
		
		if (me == com) {
			exit = new RSPAlert("비겼습니다. 현재포인트" + point);
			return;
		}
		
		switch (me) {
		case ROCK:
			win = (com==SCISSORS) ? true : false;
			break;
		case SCISSORS:
			win = (com==PAPER) ? true : false;
			break;
		case PAPER:
			win = (com==ROCK) ? true : false;
			break;
		}
		
		if (win == true) {
			point+=200;
			loginMember.setPoint(point);
			exit = new RSPAlert("이겼습니다. 포인트 200증가 현재포인트" + point);
		}else {
			if(point >= 100)
				point-=100;
			loginMember.setPoint(point);
			exit = new RSPAlert("졌습니다. 포인트 100감소 현재포인트" + point);
		}
		
		new ChangeLev(loginMember);
		
		
	}

}
