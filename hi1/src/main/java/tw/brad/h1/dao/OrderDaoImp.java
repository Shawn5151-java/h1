package tw.brad.h1.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import tw.brad.h1.entity.Order;

public class OrderDaoImp implements OrderDao {

	@Override
	public Long save(Session session, Order order) {
		session.persist(order);
		return order.getId();
	}

	@Override
	public Optional<Order> findById(Session session, Long id) {
	    // 1. 先把查到的結果 (Order 物件) 暫存起來
	    Order order = session.get(Order.class, id);
	    
	    // 2. 把這個結果包進 Optional 盒子裡回傳
	    // 如果 order 是 null (真的沒查到)，ofNullable 會自動包成 empty
	    return Optional.ofNullable(order); 
	}

	@Override
	public Optional<Order> findByIdWithItems(Session session, Long id) {
		String hql = """
				SELECT o
				FROM Order o
				LEFT JOIN FETCH o.items
				WHERE o.id = :id
				""";
		Order o = session.createQuery(hql, Order.class)
				.setParameter("id", id)
				.uniqueResult();
		return Optional.ofNullable(o);
	}

	@Override
	public void delete(Session session, Order order) {
		session.remove(order);

	}

	@Override
	public List<Order> findAll(Session session, int start, int siza) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.id DESC
				""";
		return session.createQuery(hql, Order.class)
				.setFirstResult(start)
				.setMaxResults(siza)
				.list();
	}
	
	//HQL
	
	public void test1(Session session) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.odate DESC
				
				""";
		List<Order> orders = session.createQuery(hql, Order.class).list();
		
	}
	
	public void test2(Session session){
		String hql = """
				SELECT o
				FROM order o
				WHERE o.customer = :cname
				""";
		session.createQuery(hql, Order.class)
		.setParameter("cname","brad").list();
	}
	
	public void test3(Session session){
		String hql = """
				SELECT o
				FROM order o
				WHERE o.id = :id
				""";
		Order order = session.createQuery(hql, Order.class)
		.setParameter("id","1L").uniqueResult();
	}
	
	public void test4(Session session){
		String hql = """
				SELECT o
				FROM order o
				JOIN o.items i
				WHERE i.pname LIKE :key
				ORDER BY o.id
				""";
		List<Order> order = session.createQuery(hql, Order.class)
				.setParameter("id","1L").list();
	}
	
	public void test5(Session session){
		String hql = """
				SELECT o
				FROM order o
				LEFT JOIN FETCH o.items
				WHERE o.id = :id
				""";
		Order order = session.createQuery(hql, Order.class)
				.setParameter("id","1L").uniqueResult();
	}

}
