package com.rido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiverInfoDto {
	private Long SRId;
	private Double receiverLatitude;
	private Double receiverLongitude;
	private String receiverLocation;
	private String receiverAddress;
	private String receiverName;
	private String receiverPhoneNumber;
}
