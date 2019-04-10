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

import com.example.Run.domain.entity.Tag;
import com.example.Run.domain.service.TagService;

@Service
@RestController
@RequestMapping("tag")
@CrossOrigin(origins = "*")
public class TagController {
	@Autowired
	private TagService tagService;
	
	@GetMapping("/listTag")
	public ResponseEntity<List<Tag>>  getAllTag(){
		List<Tag> list = tagService.getAllTag();
		return new ResponseEntity<List<Tag>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createProduct(@RequestBody Tag tag, UriComponentsBuilder ucBuilder){
		List<Tag> listTag = tagService.getAllTag();
		for( Tag tags : listTag)
			if(tag.getName().equals(tags.getName())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				tagService.createTag(tag);
			} 
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/Product/{id,name}").buildAndExpand(tag.getId(),tag.getName()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody Tag tag){
		Optional<Tag> listTag = tagService.findById(tag.getId());
		if (!listTag.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			tagService.Update(tag);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<Tag> delete(@PathVariable("id") long id){
		Optional<Tag> listTag = tagService.findById(id);
		if (!listTag.isPresent()) {
			return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
		}
		else 
			tagService.deleteTagById(id);
		return new ResponseEntity<Tag>(HttpStatus.NO_CONTENT);
	}
}
