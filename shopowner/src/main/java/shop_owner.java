package com.tns.shopowner;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class shop_owner

{
  @Autowired
  private shop_owner_Repository repo;
        
      public List<shop> listAll()
      {
    	  return repo.findAll();
      }
      
      public void save(shop shop)
      {
    	  repo.save(shop);
      }
      
      public shop get(Integer shop_Id)
      {
    	  return repo.findById(shop_Id).get();
      }
      
      public void delete(Integer shop_Id)
      {
    	  repo.deleteById(shop_Id);
      }
  
}
