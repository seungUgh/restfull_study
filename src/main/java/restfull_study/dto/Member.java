package restfull_study.dto;

import java.time.LocalDateTime;

import restfull_study.exception.WrongIdPasswordException;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member() {
	}


	public Member(Long id, String email, String password, String name, LocalDateTime registerDateTime) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	
	public Member(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}

	// 패스워드 일치 여부
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	@Override
	public String toString() {
		return String.format("Member [id=%s, email=%s, password=%s, name=%s, registerDateTime=%s]", id, email, password,
				name, registerDateTime);
	}

}