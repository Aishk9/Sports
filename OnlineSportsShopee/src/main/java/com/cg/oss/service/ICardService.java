package com.cg.oss.service;

import java.util.List;

import com.cg.oss.bean.Card;
import com.cg.oss.exception.ResourceNotFoundException;


public interface ICardService {
	 public Card addCard(Card card);
		public Card deleteCard(int id) throws ResourceNotFoundException;
		public Card updateCard(int id, Card card) throws ResourceNotFoundException;
		public Card getCardDetails(int id) throws ResourceNotFoundException;
		public List<Card> getAllCardDetails();

}
