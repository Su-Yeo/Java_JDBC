

//구현: 김승현
package login;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class JoinMember1 extends JFrame{
	public JoinMember1() {
		JLabel text=new JLabel("계좌번호는 숫자 5자리여야합니다.");
		add(text);
		setTitle("오류");
	    setBounds(300, 250, 300, 100);
	    setVisible(true);
	    setResizable(false);
	}
}
