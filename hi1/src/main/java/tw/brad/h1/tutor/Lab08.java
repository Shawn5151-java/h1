package tw.brad.h1.tutor;

import tw.brad.h1.dao.MemberDao;
import tw.brad.h1.entity.Member;
import tw.brad.h1.entity.MemberInfo;

public class Lab08 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member m1 = dao.findById(2);
		if (m1 != null) {
			MemberInfo i1 = m1.getMemberinfo();
			if(i1 != null) {
				System.out.printf("%d:%s:%s\n", m1.getId(),m1.getName(),i1.getBirthday());
				i1.setBirthday("1974-03-23");
				dao.updateMember(m1);
			}else {
				i1 = new MemberInfo();
				i1.setBirthday("2001-07-12");
				i1.setGender(true);
				m1.setMemberinfo(i1);
				
				dao.updateMember(m1);
			}
		}else {
			System.out.println("ID不存在");
		}
	}

}
