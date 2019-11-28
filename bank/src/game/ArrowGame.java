package game;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bank.Member;
import bank.ShowInfo;

public class ArrowGame extends JFrame implements KeyListener {
	JLabel lbls[];
	int j = 0;
	private Member loginMember;
	private int[] arrow = new int[10];
	public ArrowGame(Member loginMember) {
		this.loginMember = loginMember;
		JPanel panN = new JPanel();
		JPanel panC = new JPanel();
		JPanel panS = new JPanel();
		JLabel lbl=new JLabel("start");
		lbls = new JLabel[10];
		add(panN,"North");
		add(panC,"Center");
		add(panS,"South");
		panN.setLayout(new GridLayout(1, 5));
		panC.setLayout(new GridLayout(2, 1));
		panS.setLayout(new GridLayout(1, 5));
		panN.add(lbl);
		JLabel lbl2=new JLabel("space");
		panS.add(lbl2);
		addKeyListener(this);
		Random random = new Random();
		for (int i = 0; i < arrow.length; i++) {
			arrow[i]=random.nextInt(4)+1;
			lbls[i] = new JLabel(new ImageIcon("arrowImg/"+arrow[i]+".png"),JLabel.RIGHT);
	        if(i<=3) 
	        	panN.add(lbls[i]);
	        else if(i<=5)
	        	panC.add(lbls[i]);
		}
		panS.add(lbls[9]);
		panS.add(lbls[8]);
		panS.add(lbls[7]);
		panS.add(lbls[6]);
		setTitle("포인트 쌓기 게임");
		setBounds(250, 200, 600, 500);
		setVisible(true);
		requestFocus();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		int point = loginMember.getPoint();
		try{
			switch (code) {
			case KeyEvent.VK_UP:
				if(arrow[j]==1){
					lbls[j].setIcon(new ImageIcon("arrowImg/y"+arrow[j]+".png"));
				}else{
					new ShowInfo(loginMember, "GAME OVER", "GAME OVERㅠㅠ");
					dispose();
				}
				break;
			case KeyEvent.VK_DOWN:
				if(arrow[j]==2){
					lbls[j].setIcon(new ImageIcon("arrowImg/y"+arrow[j]+".png"));
				}else{
					new ShowInfo(loginMember, "GAME OVER", "GAME OVERㅠㅠ");
					dispose();
				}
				break;
			case KeyEvent.VK_LEFT:
				if(arrow[j]==3){
					lbls[j].setIcon(new ImageIcon("arrowImg/y"+arrow[j]+".png"));
				}else{
					new ShowInfo(loginMember, "GAME OVER", "GAME OVERㅠㅠ");
					dispose();
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(arrow[j]==4){
					lbls[j].setIcon(new ImageIcon("arrowImg/y"+arrow[j]+".png"));
				}else{
					new ShowInfo(loginMember, "GAME OVER", "GAME OVERㅠㅠ");
					dispose();
				}
				break;
			default:
				point+=200;
				loginMember.setPoint(point);
				new ShowInfo(loginMember, "GAME CLEAR!", "GAME CLEAR! 현재포인트는 "+ point +"점 입니다.");
				dispose();
				break;
			}
		}catch (Exception exception) {
			new RSPAlert("마지막에 스페이스바를 눌러주세요!");
		}
		j++;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

}
