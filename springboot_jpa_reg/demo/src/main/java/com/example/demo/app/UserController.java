package com.example.demo.app;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService uService;

	@RequestMapping("/add") // Map 接收多種屬性 再用get取出需要的屬性
	public String add(@RequestParam Map<String, String> request, User user) {

		return uService.add(request, user);

	}

	@GetMapping("/GET/users")
	public List<User> show() {

		return uService.show();

	}
	
	@GetMapping("/GET/user/{id}") 
	public  Optional<User> find(@PathVariable("id") long id){
		
		return uService.find(id);
	}
	
	
	
	
	
}
