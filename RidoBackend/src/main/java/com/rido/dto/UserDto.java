package com.rido.dto;

import java.util.ArrayList;
import java.util.List;

import com.rido.entity.SenderReceiverInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long userId;
	@NonNull
	private String userEmail;
	@NonNull
	private String userPassword;
	private List<SenderReceiverInfo> senderReceiverInfos = new ArrayList<>();
}
