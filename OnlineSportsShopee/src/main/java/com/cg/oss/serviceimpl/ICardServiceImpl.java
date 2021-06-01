package com.cg.oss.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.bean.Card;
import com.cg.oss.dao.ICardRepository;
import com.cg.oss.service.ICardService;
import com.cg.oss.serviceexception.ICardServiceException;

@Service
public class ICardServiceImpl implements ICardService {
	

@Autowired
	private ICardRepository cardRepo;

@Override
public Card addCard(Card card) {

	return cardRepo.save(card);
}

@Override
public Card deleteCard(String id)  throws ICardServiceException {
	Optional<Card> card =  cardRepo.findById(id);
    if(!card.isPresent()) {
    	throw new ICardServiceException("No Card Details Found For Deletion");
    }
    cardRepo.delete(card.get());
    return card.get();
	
	
}

@Override
public Card updateCard(String id, Card card) {
	// TODO Auto-generated method stub
	return cardRepo.save(card);
}

@Override
public Card getCardDetails(String id)  throws ICardServiceException{
	Optional<Card> card =  cardRepo.findById(id);
    if(!card.isPresent()) {
    	throw new ICardServiceException("No Card Details Found");
    }
  
    return card.get();


	
}

@Override
public List<Card> getAllCardDetails() {
	// TODO Auto-generated method stub
	return cardRepo.findAll();
}
















}
