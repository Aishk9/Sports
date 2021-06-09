package com.cg.oss.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Payment {

	    @Id
	    private long paymentId;
	    @NotEmpty(message = "type is required")
		private String type;
	    @NotEmpty(message = "status is required")
		private String status;

		@ManyToOne
		@JoinColumn(name="card")
		private Card card;

		public Payment() {
			super();
		
		}
		
		public Payment(long paymentId, String type, String status) {
			super();
			this.paymentId = paymentId;
			this.type = type;
			this.status = status;
		}

		@Override
		public String toString() {
			return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}

		public long getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(long paymentId) {
			this.paymentId = paymentId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Card getCard() {
			return card;
		}

		public void setCard(Card card) {
			this.card = card;
		}

		
	

}
