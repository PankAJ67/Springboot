package com.rido.service;

import com.rido.dto.ReceiverInfoDto;
import com.rido.dto.SenderInfoDto;
import com.rido.dto.SenderReceiverInfoDto;

public interface SenderReceiverInfoService {
	SenderInfoDto addSender(SenderInfoDto senderDto);

	ReceiverInfoDto addReReceiver(ReceiverInfoDto receiverDto, Long id);
	
	SenderReceiverInfoDto getSenderReceiverDetails(Long id);
}
