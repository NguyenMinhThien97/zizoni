package com.example.Run.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Run.domain.entity.User;
import com.example.Run.domain.service.UserService;


@Service
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@GetMapping("/listUser")
	public ResponseEntity<List<User>>  getAllUser(){
		List<User> list = userService.getAllUser();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<User> getProductByID(@PathVariable("id") long id){
		return userService.findById(id);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		List<User> listUser = userService.getAllUser();
		for( User users : listUser)
			if(user.getName().equals(users.getName())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				userService.createUser(user);
			} 
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/User/{id,name,parentId}").buildAndExpand(user.getId(),user.getName(),user.getEmail()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody User user, UriComponentsBuilder ucBuilder){
		Optional<User> listUser = userService.findById(user.getId());
		if (!listUser.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			userService.Update(user);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/User/{id,name,parentId}").buildAndExpand(user.getId(),user.getName(),user.getEmail()).toUri());
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
			@GetMapping("/delete/{id}")
		    public ResponseEntity<User> delete(@PathVariable("id") long id){
				Optional<User> listUser = userService.findById(id);
				if (!listUser.isPresent()) {
		            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		        }
				else 
					userService.deleteUserById(id);
		        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		    }
}
