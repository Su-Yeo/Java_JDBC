//2018-06-02 23:08 cording by ChoiWoojung
package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SendAlert extends JFrame implements ActionListener {
	JButton btn = new JButton("확인");
	
	public SendAlert(String send_Str) {
		JPanel pan = new JPanel();
		JLabel lbl = new JLabel(send_Str, JLabel.CENTER);
		add(lbl,"Center");
		add(pan,"South");
		pan.add(btn);
		btn.addActionListener(this);
		setTitle("알림");
		setBounds(200, 300, 300, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
