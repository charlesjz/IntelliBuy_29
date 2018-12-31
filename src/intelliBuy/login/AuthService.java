package intelliBuy.login;

import java.io.IOException;

import intelliBuy.po.User;

public interface AuthService {
	
	public User authService(String username, String password) throws InvalidUsernameAndPasswordException, IOException, Exception;

}
