package com.rido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rido.dto.ReceiverInfoDto;
import com.rido.dto.SenderInfoDto;
import com.rido.dto.SenderReceiverInfoDto;
import com.rido.service.SenderReceiverInfoService;

@RestController
@RequestMapping("/sender-receiver")
public class SenderReceiverInfoController {

	@Autowired
	private SenderReceiverInfoService service;

	@PostMapping("/add-sender")
	public ResponseEntity<SenderInfoDto> addSender(@RequestBody SenderInfoDto infoDto) {
		SenderInfoDto addSender = this.service.addSender(infoDto);
		return new ResponseEntity<>(addSender, HttpStatus.CREATED);
	}

	@PutMapping("/update-receiver/{id}")
	public ResponseEntity<ReceiverInfoDto> updateReceiver(@RequestBody ReceiverInfoDto infoDto, @PathVariable Long id) {
		ReceiverInfoDto addReReceiver = this.service.addReReceiver(infoDto, id);
		return new ResponseEntity<>(addReReceiver, HttpStatus.CREATED);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<SenderReceiverInfoDto> getDetailsById(@PathVariable Long id){
		SenderReceiverInfoDto senderReceiverDetails = this.service.getSenderReceiverDetails(id);
		return new ResponseEntity<>(senderReceiverDetails, HttpStatus.OK);
	}

}
