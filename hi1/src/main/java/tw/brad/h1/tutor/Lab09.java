package tw.brad.h1.tutor;

import tw.brad.h1.dao.MemberDao;
import tw.brad.h1.entity.Member;

public class Lab09 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = dao.findById(10);
		if(member != null) {
			System.out.printf("%d.%s : %s\n", member.getId(),
					member.getEmail(),member.getMemberinfo(),
					member.getName());
			dao.delMember(member);
			System.out.println("以刪除");
		}else {
			System.out.println("ID不存在");
		}
	}

}
