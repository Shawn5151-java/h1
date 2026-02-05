package tw.brad.h1.tutor;

import java.util.List;

import tw.brad.h1.dao.MemberDao;
import tw.brad.h1.entity.Member;
import tw.brad.h1.entity.MemberInfo;

public class Lab10 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		List<Member> members = dao.findAll();
		for(Member member : members) {
			System.out.printf("%d. %s(%s)\n", member.getId(),
					member.getName(),member.getEmail());
			MemberInfo m1 = member.getMemberinfo();
			if(m1 != null) {
				System.out.printf("\t%s:%s\n", m1.getBirthday()
						,m1.isGender()?"F":"M");
			}
		}

	}

}
