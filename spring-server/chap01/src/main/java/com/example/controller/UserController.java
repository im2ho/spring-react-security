package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.service.UserService;
import com.example.vo.Users;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<Users> getAllUsers(Model model) {
		return userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Users> addUser(@RequestBody Users user){
		Users saveUser = userService.saveUser(user);
		return ResponseEntity.ok(saveUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUserById(id);
		return ResponseEntity.ok("user 삭제 성공");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id,
									@RequestBody Users updatedUser){
		Users existUser = userService.getUserById(id);
		existUser.setUsername(updatedUser.getUsername());
		existUser.setEmail(updatedUser.getEmail());
		
		Users updateUser = userService.saveUser(existUser);
		return ResponseEntity.ok(updateUser);
	}
}
