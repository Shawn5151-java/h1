package tw.brad.h1.tutor;

import tw.brad.h1.service.OrderService;
import tw.brad.h1.service.OrderServiceImp;

public class Lab12 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		Long id = service.createOrder("Eric");
		System.out.println(id);
		service.addItem(id, "item02", 2, 150);
		service.addItem(id, "item03", 8, 78);

	}

}
