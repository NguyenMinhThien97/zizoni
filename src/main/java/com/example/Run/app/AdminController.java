package com.example.Run.app;

import java.util.List;

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

import com.example.Run.domain.entity.Admin;
import com.example.Run.domain.service.AdminService;



@Service
@RestController("")
@RequestMapping("admin")
@CrossOrigin(origins = "*")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	//Xuất DS
	@GetMapping("/listAd")
	public ResponseEntity<List<Admin>>  getAllUser(){
		List<Admin> list = adminService.getAllAd();
		return new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createAdmin(@RequestBody Admin ad, UriComponentsBuilder ucBuilder){
		List<Admin> listAD = adminService.getAllAd();
		for( Admin ad1 : listAD)
			if(ad.getUserName().equals(ad1.getUserName())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				adminService.createAdmin(ad);
			} 
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/admin/{id,userName,password,name}").buildAndExpand(ad.getId(),ad.getUserName(),ad.getPassword(),ad.getName()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> updateUser(@RequestBody Admin ad, UriComponentsBuilder ucBuilder){
		List<Admin> ad1 = adminService.findAdmin(ad.getId());
		if (ad1.size()<=0) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			adminService.update(ad);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/admin/{id,userName,password,name}").buildAndExpand(ad.getId(),ad.getUserName(),ad.getPassword(),ad.getName()).toUri());
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
			@GetMapping("/delete/{id}")
		    public ResponseEntity<Admin> deleteUser(@PathVariable("id") long id){
				List<Admin> user = adminService.findAdmin(id);
				if (user.size()<=0) {
		            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		        }
				else 
					adminService.deleteAdminById(id);
		        return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
		    }
	
}
