package com.rido.dto;

import com.rido.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderReceiverInfoDto {
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
	private User user;
}
