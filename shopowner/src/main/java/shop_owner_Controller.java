package com.tns.shopowner;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class shop_owner_Controller 
{
  @Autowired(required=true)
  private shop_owner service;
  
  @GetMapping("/shopowner")
  public java.util.List<shop>list()
  {
	  return service.listAll();
  }
  @GetMapping("/shopowner/{shop_Id}")
  public ResponseEntity <shop> get(@PathVariable Integer shop_Id)
  {
	  try
	  {
		shop shop = service.get(shop_Id);
		return new ResponseEntity<shop>(shop,HttpStatus.OK);
	  }
	  catch(NoResultException e)
	  {
		  return new ResponseEntity<shop>(HttpStatus.NOT_FOUND);
	  }
   
  }
	  @PostMapping("/shopowner")
	  public void add(@RequestBody shop shop)
	  {
		  service.save(shop);
	  }
	  @PutMapping ("/shopowner/{shop_Id}")
	  public ResponseEntity<?> update(@RequestBody shop shop, @PathVariable Integer shop_Id)
	  {
		  shopowner.existshopowner = service.get(shop_Id);
		  service.save(existshopowner);
		  return new ResponseEntity<>(HttpStatus.OK);
	  }
	  @DeleteMapping("/shopowner/{shop_Id}")
	  public void delete (@PathVariable Integer shop_Id)
	  {
		  service.delete(shop_Id);
	  }
   
}
