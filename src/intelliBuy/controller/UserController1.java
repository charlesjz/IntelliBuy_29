package intelliBuy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import intelliBuy.po.Items;
import intelliBuy.po.User;
import intelliBuy.service.UserService;

@Controller
public class UserController1 {

	private UserService userService;
	@RequestMapping("/user/queryAllUser")
	public ModelAndView queryUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<User> usersList = userService.findAllUsers();

		ModelAndView modelAndView =  new ModelAndView();

		modelAndView.addObject("usersList", usersList);
		
		modelAndView.setViewName("user/usersList");

		return modelAndView;
	}

//	@RequestMapping("/user/addUser")
//	public ModelAndView adduser(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		User user = new User();
//		user.setUsername(request.getParameter(arg0));
//		List<User> usersList = new ArrayList<>();
//		usersList = new UserService().findAllUsers();
//
//		ModelAndView modelAndView =  new ModelAndView();
//
//		modelAndView.addObject("usersList", usersList);
//		
//		modelAndView.setViewName("user/usersList");
//
//		return modelAndView;
//	}

}
