package tw.brad.h1.tutor;

import java.util.List;

import tw.brad.h1.entity.Order;
import tw.brad.h1.entity.OrderItem;
import tw.brad.h1.service.OrderService;
import tw.brad.h1.service.OrderServiceImp;

public class Lab11 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		//Long id = service.createOrder("Cana");
		//System.out.println(id);
		List<OrderItem> items = List.of(new OrderItem("item05", 3 , 110),
								new OrderItem("item06", 55 , 14),
								new OrderItem("item07", 8 , 263));
		Long id = service.createOrderWithItems("Dem", items);
		System.out.println(id);
	}

}
