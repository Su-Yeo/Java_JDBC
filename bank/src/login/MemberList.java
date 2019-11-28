
//구현: 김승현
package login;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bank.Member;

	
public class MemberList extends JFrame {
	private Member[] memberArr;
	
	public MemberList(Member[] arr) {
		try {
			memberArr=arr;
			int joinNum=0;
			for(int i=0; i<memberArr.length; i++) {
				if(memberArr[i] != null) {
					joinNum++;
				}
			}
			
			String [] cols={"ID", "Password", "이름", "계좌번호", "잔액", "신용등급", "포인트"};
			String[][] conts=new String[joinNum][7];
			for(int i=0; i<joinNum; i++) {
				String id=memberArr[i].getId();
				String pw=memberArr[i].getPw();
				String name=memberArr[i].getName();
				String account=memberArr[i].getAccount();
				String money=memberArr[i].getMoney()+"";
				String lev=memberArr[i].getLev();
				String point=memberArr[i].getPoint()+"";
				
				conts[i][0]=id;
				conts[i][1]=pw;
				conts[i][2]=name;
				conts[i][3]=account;
				conts[i][4]=money;
				conts[i][5]=lev;
				conts[i][6]=point;
			}
			JTable table=new JTable(conts, cols);
			JScrollPane scrollpane=new JScrollPane(table);
			add(scrollpane);
			
			setTitle("회원 목록");
			setBounds(200,200,500,200);
			setResizable(false);
			setVisible(true);
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
