package intelliBuy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

import intelliBuy.po.Items;

public class ItemsController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//调用service查找 数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		//向list中填充静态数据
		
		Items items_1 = new Items();
		items_1.setName("HP OMEN Gaming Laptop 15.6\" FHD, i7-8750H, 16GB, 1TB+128GB SSD, GTX1060, Win10".substring(0, 50));
		items_1.setPrice(799.99f);
		items_1.setDetail("HP OMEN Gaming Laptop 15.6\" FHD, i7-8750H, 16GB, 1TB+128GB SSD, GTX1060, Win10");
		
		Items items_2 = new Items();
		items_2.setName("Dell G5 15 5587 15.6\" (1 TB+256 GB, Intel Core i7 8th Gen., 2.20 GHz, 16 GB) Laptop - Black - G55877835BLK".substring(0, 50));
		items_2.setPrice(5000f);
		items_2.setDetail("Dell G5 15 5587 15.6\" (1 TB+256 GB, Intel Core i7 8th Gen., 2.20 GHz, 16 GB) Laptop - Black - G55877835BLK");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		//设置模型数据
		request.setAttribute("itemsList", itemsList);
		//设置转发的视图
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);

	}


}
