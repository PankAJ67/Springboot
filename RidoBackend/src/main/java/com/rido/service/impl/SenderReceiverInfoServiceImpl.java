package com.rido.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rido.dto.ReceiverInfoDto;
import com.rido.dto.SenderInfoDto;
import com.rido.dto.SenderReceiverInfoDto;
import com.rido.entity.SenderReceiverInfo;
import com.rido.exception.ResourceNotFoundException;
import com.rido.repository.SenderReceiverInfoRepository;
import com.rido.service.SenderReceiverInfoService;

@Service
public class SenderReceiverInfoServiceImpl implements SenderReceiverInfoService{
	
	@Autowired
	private SenderReceiverInfoRepository srRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SenderInfoDto addSender(SenderInfoDto senderDto) {
		SenderReceiverInfo info = this.modelMapper.map(senderDto, SenderReceiverInfo.class);
		SenderReceiverInfo savedInfo = this.srRepo.save(info);
		SenderInfoDto senderInfoDto = this.modelMapper.map(savedInfo, SenderInfoDto.class);
		return senderInfoDto;
	}

	@Override
	public ReceiverInfoDto addReReceiver(ReceiverInfoDto receiverDto, Long id) {
		SenderReceiverInfo info = this.srRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User"));
		this.modelMapper.map(receiverDto, info);
		info.setSRId(id);
		SenderReceiverInfo savedInfo = this.srRepo.save(info);
		ReceiverInfoDto infoDto = this.modelMapper.map(savedInfo, ReceiverInfoDto.class);
		return infoDto;
	}

	@Override
	public SenderReceiverInfoDto getSenderReceiverDetails(Long id) {
		SenderReceiverInfo info = this.srRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User"));
		SenderReceiverInfoDto map = this.modelMapper.map(info, SenderReceiverInfoDto.class);
		return map;
	}

}
