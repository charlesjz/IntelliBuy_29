package intelliBuy.po;

import java.time.LocalDate;

public class User {

	private Integer id;
	private String username;
    private LocalDate birthday;
    private String sex;
    private String address;
    private String password;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public User() {
    	super();
    }
    
	public User(Integer id, String username, String password, LocalDate birthday, String sex, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public Integer getId() {
        return id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    
    @Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + ", password=" + password + "]";
	}
}