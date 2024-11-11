package com.rido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SenderReceiverInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SRId;
	private Double senderLatitude;
	private Double senderLongitude;
	private String senderLocation;
	
	private String senderAddress;
	private String senderName;
	private String senderPhoneNumber;
	private Double receiverLatitude;
	private Double receiverLongitude;
	private String receiverLocation;
	private String receiverAddress;
	private String receiverName;
	private String receiverPhoneNumber;
	
	@ManyToOne
	@JsonIgnore
	private User user;

}
