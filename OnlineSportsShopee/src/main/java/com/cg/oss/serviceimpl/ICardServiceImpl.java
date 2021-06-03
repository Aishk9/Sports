package com.cg.oss.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.bean.Card;
import com.cg.oss.dao.ICardRepository;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICardService;


@Service
public class ICardServiceImpl implements ICardService {
	

@Autowired
	private ICardRepository cardRepo;

@Override
public Card addCard(Card card) {

	return cardRepo.save(card);
}

@Override
public Card deleteCard(int id)  throws ResourceNotFoundException {
	Optional<Card> card =  cardRepo.findById(id);
    if(!card.isPresent()) {
    	throw new ResourceNotFoundException("No Card Details Found For Deletion");
    }
    cardRepo.delete(card.get());
    return card.get();
	
	
}

@Override
public Card updateCard(int id, Card card) {
	// TODO Auto-generated method stub
	return cardRepo.save(card);
}

@Override
public Card getCardDetails(int id)  throws ResourceNotFoundException{
	Optional<Card> card =  cardRepo.findById(id);
    if(!card.isPresent()) {
    	throw new ResourceNotFoundException("No Card Details Found");
    }
  
    return card.get();


	
}

@Override
public List<Card> getAllCardDetails() {
	// TODO Auto-generated method stub
	return cardRepo.findAll();
}
















}
