package tw.brad.h1.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.h1.utils.HibernateUtil;

public class Lab03 {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();

			String sql = """
					SELECT * FROM member
					""";
			NativeQuery query = session.createNativeQuery(sql);
			List list = query.getResultList();
			for(Object obj : list) {
				Object[] date = (Object[])obj;
				System.out.printf("%d:%s:%s:%s\n", date[0], date[1], date[2], date[3]);
			}
	
			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
