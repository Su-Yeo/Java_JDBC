package login;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JoinMember2 extends JFrame{
	public JoinMember2() {
		JLabel text=new JLabel("아이디 혹은 비밀번호를 입력하시지 않았습니다.");
		add(text);
		setTitle("오류");
	    setBounds(300, 250, 300, 100);
	    setVisible(true);
	    setResizable(false);
	}
}
