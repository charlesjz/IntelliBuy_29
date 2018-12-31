package intelliBuy.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intelliBuy.po.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        
        try {
			User user = AuthServiceImpl.getInstance().authService(username, password);
			if(user==null) throw new InvalidUsernameAndPasswordException();
			user.setPassword(null);
			req.setAttribute("User", user);
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        } catch (InvalidUsernameAndPasswordException e){
			e.printStackTrace();
			resp.sendRedirect("login.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
			

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
