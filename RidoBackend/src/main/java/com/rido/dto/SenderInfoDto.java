package com.rido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderInfoDto {
	private Long SRId;
	private Double senderLatitude;
	private Double SenderLongitude;
	private String senderLocation;
	private String senderAddress;
	private String senderName;
	private String senderPhoneNumber;
}
