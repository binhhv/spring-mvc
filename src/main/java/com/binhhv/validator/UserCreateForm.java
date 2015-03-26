package com.binhhv.validator;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class UserCreateForm {
	@NotEmpty
    private String username = "";

	@NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

 
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    

    @Override
    public String toString() {
        return "UserCreateForm{" +
        		"email='" + username + '\'' +
                "email='" + email.replaceFirst("@.+", "@***") + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                '}';
    }
}
