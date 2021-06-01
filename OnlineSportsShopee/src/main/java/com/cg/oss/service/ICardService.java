package com.cg.oss.service;

import java.util.List;

import com.cg.oss.bean.Card;
import com.cg.oss.serviceexception.ICardServiceException;

public interface ICardService {
	 public Card addCard(Card card);
		public Card deleteCard(String id) throws ICardServiceException;
		public Card updateCard(String id, Card card) throws ICardServiceException;
		public Card getCardDetails(String id) throws ICardServiceException;
		public List<Card> getAllCardDetails();

}
