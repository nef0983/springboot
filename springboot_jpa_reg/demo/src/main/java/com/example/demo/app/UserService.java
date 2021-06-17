package com.example.demo.app;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository uRepository;

	
	public String add(Map<String, String> request, User user) {// Map 接收多種屬性 再用get取出需要的屬性

		String account = request.get("account");
		String password = request.get("password");
		String pwcheck = request.get("pwcheck");

		if (password.equals(pwcheck)) {

			user.setAccount(account);
			user.setPassword(password);
			uRepository.save(user);
			
			return "reg ok";

		} else {
			return "try again";
		}
	}

	public List<User> show (){// 查詢全部data
		
		return uRepository.findAll();
	}
	
	public Optional<User> find(long id) {
		
		
		return uRepository.findById(id);
	}
	
	
	
	
}
