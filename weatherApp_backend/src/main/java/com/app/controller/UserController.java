package com.app.controller;

import com.app.model.city;
import com.app.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.User;
import com.app.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepo repo;

	@Autowired
	private CityRepo cityRepo;

	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		
	 System.out.println("Controller called");
	 return ResponseEntity.ok(repo.save(user));
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		String tempPass = user.getPassword();
		if(tempEmailId != null && tempPass != null){
			return repo.findByEmailAndPassword(tempEmailId, tempPass);
		}
		throw new Exception("invalid credentials");
	}

	@PostMapping("/wishlist/{city}/{id}")
	public User addCityToUser(@PathVariable("city") String city, @PathVariable("id") String userid){
		System.out.println(city + userid);
		city c = new city();
		Optional<User> tempUser = repo.findById(userid);
		List<User> userList = repo.findAll();
		userList.forEach(user -> {
			System.out.println(user.toString());
		});
		if(tempUser.isPresent()){
			System.out.println("user : "+userid);
			c.setCity(city);
			List<User> users = new ArrayList<>();
			users.add(tempUser.get());
			c.setUserList(users);
			cityRepo.save(c);
			List<city> cityList = tempUser.get().getCities();
			cityList.add(c);
			repo.save(tempUser.get());
			return tempUser.get();
		}
		return null;
	}
}
