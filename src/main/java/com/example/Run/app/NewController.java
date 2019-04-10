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

import com.example.Run.domain.entity.New;
import com.example.Run.domain.service.NewService;

@Service
@RestController
@RequestMapping("new")
@CrossOrigin(origins = "*")
public class NewController {
	@Autowired
	private NewService newService;
	
	@GetMapping("/listNew")
	public ResponseEntity<List<New>>  getAllNew(){
		List<New> list = newService.getAllNew();
		return new ResponseEntity<List<New>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listNew/{id}")
	public Optional<New> getNewByID(@PathVariable("id") long id){
		return newService.findById(id);
	}
	
	@GetMapping("/topListNew")
	public ResponseEntity<List<New>>  getTopListNew(){
		List<New> list = newService.getTopNew();
		return new ResponseEntity<List<New>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createNew(@RequestBody New news, UriComponentsBuilder ucBuilder){
		List<New> listNews = newService.getAllNew();
		for( New newss : listNews)
			if(news.getTitle().equals(newss.getTitle())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				newService.createNew(news);
			} 
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/new/{id,title,description}").buildAndExpand(news.getId(),news.getTitle(),news.getDescription()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody New news){
		Optional<New> listNew = newService.findById(news.getId());
		if (!listNew.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			newService.Update(news);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<New> delete(@PathVariable("id") long id){
		Optional<New> listNew = newService.findById(id);
			if (!listNew.isPresent()) {
				return new ResponseEntity<New>(HttpStatus.NOT_FOUND);
			}
			else 
				newService.deleteNewById(id);
			return new ResponseEntity<New>(HttpStatus.NO_CONTENT);
		    }
}
