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

import com.example.Run.domain.entity.Catalog;
import com.example.Run.domain.service.CatalogService;

@Service
@RestController
@RequestMapping("catalog")
@CrossOrigin(origins = "*")
public class CatalogController {
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("/listCatalog")
	public ResponseEntity<List<Catalog>>  getAllCatalog(){
		List<Catalog> list = catalogService.getAllCatalog();
		return new ResponseEntity<List<Catalog>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/findImage/{id}")
    public List<String> getFindImage(@PathVariable("id") long id){
		return catalogService.findCatalogImage(id);
    }
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createCatalog(@RequestBody Catalog catalog, UriComponentsBuilder ucBuilder){
		List<Catalog> listCatalog = catalogService.getAllCatalog();
		for( Catalog catalogs : listCatalog)
			if(catalog.getName().equals(catalogs.getName())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				catalogService.createCatalog(catalog);
			} 
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/catalog/{id,name,image}").buildAndExpand(catalog.getId(),catalog.getName(),catalog.getImage()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody Catalog catalog, UriComponentsBuilder ucBuilder){
		List<Catalog> listCatalog = catalogService.findCatalog(catalog.getId());
		if (listCatalog.size()<=0) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			catalogService.Update(catalog);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/catalog/{id,name,image}").buildAndExpand(catalog.getId(),catalog.getName(),catalog.getImage()).toUri());
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
			@GetMapping("/delete/{id}")
		    public ResponseEntity<Catalog> delete(@PathVariable("id") long id){
				List<Catalog> listCatalog = catalogService.findCatalog(id);
				if (listCatalog.size()<=0) {
		            return new ResponseEntity<Catalog>(HttpStatus.NOT_FOUND);
		        }
				else 
					catalogService.deleteCatalogById(id);
		        return new ResponseEntity<Catalog>(HttpStatus.NO_CONTENT);
		    }
	
}
