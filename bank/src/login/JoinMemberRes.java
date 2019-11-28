package login;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JoinMemberRes extends JFrame{
	public JoinMemberRes() {
		JLabel text=new JLabel("가입을 축하합니다!!");
		add(text);
		setTitle("가입완료");
	    setBounds(300, 250, 300, 100);
	    setVisible(true);
	    setResizable(false);
	    
	}
}
