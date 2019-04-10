package com.example.Run.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.Run.domain.entity.Tb_order;
import com.example.Run.domain.service.Tb_orderService;

@Service
@RestController
@RequestMapping("tb_order")
@CrossOrigin(origins = "*")
public class Tb_orderController {
	@Autowired
	private Tb_orderService tb_orderService;
	
	@GetMapping("/listTb_order")
	public ResponseEntity<List<Tb_order>>  getAllTb_order(){
		List<Tb_order> list = tb_orderService.getAllTb_order();
		return new ResponseEntity<List<Tb_order>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getOrder/{id}")
	public Optional<Tb_order> getProductByID(@PathVariable("id") long id){
		return tb_orderService.findById(id);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createTb_order(@RequestBody Tb_order tb_order){
		tb_orderService.createTb_order(tb_order);
	    return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody Tb_order tb_order){
		Optional<Tb_order> listTb_order = tb_orderService.findById(tb_order.getId());
		if (!listTb_order.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			tb_orderService.Update(tb_order);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<Tb_order> delete(@PathVariable("id") long id){
		Optional<Tb_order> listTb_order = tb_orderService.findById(id);
		if (!listTb_order.isPresent()) {
			return new ResponseEntity<Tb_order>(HttpStatus.NOT_FOUND);
		}
		else 
			tb_orderService.deleteTb_orderById(id);
		return new ResponseEntity<Tb_order>(HttpStatus.NO_CONTENT);
	}
}
