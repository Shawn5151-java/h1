package tw.brad.h1.tutor;

import tw.brad.h1.service.OrderService;
import tw.brad.h1.service.OrderServiceImp;

public class Lab13 {

	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();

		service.addItem(2L, "item01", 3, 10);
		service.addItem(2L, "item02", 7, 60);
		service.addItem(2L, "item03", 6, 150);
		service.addItem(2L, "item04", 5, 110);
	}

}
