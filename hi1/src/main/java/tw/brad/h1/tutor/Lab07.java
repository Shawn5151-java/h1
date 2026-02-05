package tw.brad.h1.tutor;

import tw.brad.h1.dao.MemberDao;
import tw.brad.h1.entity.Member;
import tw.brad.h1.entity.MemberInfo;
import tw.brad.h1.utils.BCrypt;

public class Lab07 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setEmail("brad05@iii.tw");
		member.setName("brad30");
		member.setPasswd(BCrypt.hashpw("12345678", BCrypt.gensalt()));
		
		MemberInfo info = new MemberInfo();
		info.setBirthday("1998-04-27");
		info.setGender(false);
		
		member.setMemberinfo(info);
		
		dao.addMember(member);
	}

}
