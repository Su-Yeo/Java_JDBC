//2018-06-03 14:55 cording by ChoiWoojung
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RSPAlert extends JFrame implements ActionListener {
	JButton btn = new JButton("Ȯ��");
	
	public RSPAlert(String RSP_Str) {
		JPanel pan = new JPanel();
		JLabel lbl = new JLabel(RSP_Str, JLabel.CENTER);
		add(lbl,"Center");
		add(pan,"South");
		pan.add(btn);
		btn.addActionListener(this);
		setTitle("�˸�");
		setBounds(200, 300, 300, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
