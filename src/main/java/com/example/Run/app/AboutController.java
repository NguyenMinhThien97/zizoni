package com.example.Run.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Run.domain.entity.About;
import com.example.Run.domain.service.AboutService;

@Service
@RestController("")
@RequestMapping("about")
@CrossOrigin(origins = "*")
public class AboutController {
	@Autowired
	private AboutService aboutService;
	
	//Xuất thong tin 
	@GetMapping("/getAbout")
	public ResponseEntity<Optional<About>>  getAbout(){
		Optional<About> about = aboutService.getAbout();
		return new ResponseEntity<Optional<About>>(about, HttpStatus.OK);
	}	
	
	//Sửa || tạo mới
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> updateUser(@RequestBody About about){
		aboutService.update(about);
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
