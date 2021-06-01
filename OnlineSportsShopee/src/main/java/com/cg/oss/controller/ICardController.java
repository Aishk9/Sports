package com.cg.oss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Card;

import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICardService;
import com.cg.oss.serviceexception.ICardServiceException;



@RestController
public class ICardController {
	
	
	@Autowired
	private ICardService cardService;
	
	@RequestMapping(value="/card/all", method=RequestMethod.GET)
	   public List<Card> getAllCardDetails(){
			
			return cardService.getAllCardDetails();
		}
	
	@RequestMapping(value= "/card/{id}", method= RequestMethod.GET)
    public Card getCardDetails(@PathVariable String id) throws ResourceNotFoundException,ICardServiceException{
		
		try {
			Card card = cardService.getCardDetails(id);
			if(card==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return card;
		}catch(ICardServiceException e) {
			throw new ICardServiceException("No Card Found");
		}
        
	}   
     
     @RequestMapping(value= "/card/add", method= RequestMethod.POST)
    	public Card addCard(@RequestBody Card newcard) {       
    	        return cardService.addCard(newcard);
    	}     
     
     
     @RequestMapping(value= "/card/update/{id}", method= RequestMethod.PUT)
     public Card updateCard(@RequestBody Card updcard, @PathVariable String id) throws ResourceNotFoundException,ICardServiceException {
    	 try {
 			Card card = cardService.getCardDetails(id);
 			if(card==null) {
 				throw new ResourceNotFoundException("Not Found");
 			}
 			return card;
 		}catch(ICardServiceException e) {
 			throw new ICardServiceException("No Card Found");
 		}
 }
     
        
	
     @RequestMapping(value= "/card/delete/{id}", method= RequestMethod.DELETE)
 	public Card deleteCard(@PathVariable String id) throws ResourceNotFoundException,ICardServiceException {

    	 try {
  			Card card = cardService.getCardDetails(id);
  			if(card==null) {
  				throw new ResourceNotFoundException("Not Found");
  			}
  			return card;
  		}catch(ICardServiceException e) {
  			throw new ICardServiceException("No Card Found");
  		}

 	}

	

}
