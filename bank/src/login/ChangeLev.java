//2018-06-03 23:05 cording by ChoiWoojung
package login;

import bank.Member;
import game.RSPAlert;

public class ChangeLev {
	public ChangeLev(Member loginMember) {
		int point = loginMember.getPoint();
		String Lev = loginMember.getLev();
		if (point <500) {
			loginMember.setLev("�Ϲ�");
		}else if (point <1000) {
			loginMember.setLev("�����");
		}else if(point <1500) {
			loginMember.setLev("�ǹ�");
		}else if(point <2000) {
			loginMember.setLev("���");
		}else if(point < 2500) {
			loginMember.setLev("�÷�Ƽ��");
		}
		if (Lev != loginMember.getLev())
			new RSPAlert(Lev+" ��޿��� "+
						loginMember.getLev()+" ������� ����Ǿ����ϴ�.");
	}
}
