package com.cg.oss.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Card {

		@Id
		private int cardNumber;
		 @NotEmpty(message = "card name is required")
		private String cardName;
		 @NotEmpty(message = "expiry date of card is required")
		private LocalDate cardExpiry;
		 @NotEmpty(message = "cvv is required")
		private int cvv;
		public Card() {
			super();
		}
		public Card(String cardName, LocalDate cardExpiry, int cvv) {
			super();
			this.cardName = cardName;
			this.cardExpiry = cardExpiry;
			this.cvv = cvv;
		}
		public int getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(int cardNumber) {
			this.cardNumber = cardNumber;
		}
		public String getCardName() {
			return cardName;
		}
		public void setCardName(String cardName) {
			this.cardName = cardName;
		}
		public LocalDate getCardExpiry() {
			return cardExpiry;
		}
		public void setCardExpiry(LocalDate cardExpiry) {
			this.cardExpiry = cardExpiry;
		}
		public int getCvv() {
			return cvv;
		}
		public void setCvv(int cvv) {
			this.cvv = cvv;
		}
		@Override
		public String toString() {
			return "Card [cardNumber=" + cardNumber + ", cardName=" + cardName + ", cardExpiry=" + cardExpiry + ", cvv="
					+ cvv + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
		
	
	
}
