package com.cg.oss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Card;

import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICardService;




@RestController
public class ICardController {
	
	
	@Autowired
	private ICardService cardService;
	
	@RequestMapping(value="/card/all", method=RequestMethod.GET)
	   public List<Card> getAllCardDetails(){
			
			return cardService.getAllCardDetails();
		}
	
	@RequestMapping(value= "/card/{id}", method= RequestMethod.GET)
    public Card getCardDetails(@PathVariable int id) throws ResourceNotFoundException{
		
		try {
			Card card = cardService.getCardDetails(id);
			if(card==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return card;
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("No Card Found");
		}
        
	}   
     
     @RequestMapping(value= "/card/add", method= RequestMethod.POST)
    	public Card addCard(@Valid @RequestBody Card newcard) {       
    	        return cardService.addCard(newcard);
    	}     
     
     
     @RequestMapping(value= "/card/update/{id}", method= RequestMethod.PUT)
     public Card updateCard(@PathVariable("id")  int id,@Valid @RequestBody Card card) throws ResourceNotFoundException{
//    		
    	 
    	 try {
 			Card card1 = cardService.updateCard(id,card);
 			if(card1==null) {
 				throw new ResourceNotFoundException("Not Found");
 			}
 			return card1;
 		}catch(ResourceNotFoundException e) {
 			throw new ResourceNotFoundException("No Card Found");
 		}
 }
     
        
	
     @RequestMapping(value= "/card/delete/{id}", method= RequestMethod.DELETE)
 	public Card deleteCard(@PathVariable("id") int id) throws ResourceNotFoundException {

    	 try {
  			Card card = cardService.deleteCard(id);
  			if(card==null) {
  				throw new ResourceNotFoundException("Not Found");
  			}
  			return card;
  		}catch(ResourceNotFoundException e) {
  			throw new ResourceNotFoundException("No Card Found");
  		}

 	}
     

 	//to display error messages to client

     @ResponseStatus(value = HttpStatus.BAD_REQUEST)
     @ExceptionHandler(MethodArgumentNotValidException.class)
     public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
         Map<String, String> errors = new HashMap<>();
      
         ex.getBindingResult().getFieldErrors().forEach(error -> 
             errors.put(error.getField(), error.getDefaultMessage()));
          
         return errors;
     }

	

}
