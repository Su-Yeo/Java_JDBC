//2018-06-03 23:05 cording by ChoiWoojung
package login;

import bank.Member;
import game.RSPAlert;

public class ChangeLev {
	public ChangeLev(Member loginMember) {
		int point = loginMember.getPoint();
		String Lev = loginMember.getLev();
		if (point <500) {
			loginMember.setLev("일반");
		}else if (point <1000) {
			loginMember.setLev("브론즈");
		}else if(point <1500) {
			loginMember.setLev("실버");
		}else if(point <2000) {
			loginMember.setLev("골드");
		}else if(point < 2500) {
			loginMember.setLev("플레티넘");
		}
		if (Lev != loginMember.getLev())
			new RSPAlert(Lev+" 등급에서 "+
						loginMember.getLev()+" 등급으로 변경되었습니다.");
	}
}
