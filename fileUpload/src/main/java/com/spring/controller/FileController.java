package com.spring.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.entity.FileItem;
import com.spring.repository.FileItemRepository;

@RestController
public class FileController {

	@Autowired
	private FileItemRepository  repository;

private final String   FOLDER_PATH = "D:/upload/";

	// api for testing purpose
	@GetMapping("/")
	public String home() {
		return "welcome to uploading file in springboot";
		// System.out.println("ok");
	}

	@PostMapping("/upload")
	public ResponseEntity<Object> uploadfile(@RequestParam("file")MultipartFile file) throws  IOException{
		
		
		
		String path  = FOLDER_PATH + file.getOriginalFilename();
		
		FileItem item = FileItem.builder()
				.fileName(file.getOriginalFilename())
				.fileType(file.getContentType())
			.fileLocation(path)
				.build();
		 repository.save(item);
	file.transferTo(new File(path).toPath()) ;
	return ResponseEntity.status(HttpStatus.OK).body("file uppload "+path);
	} 
//	
//public  ResponseEntity<Object> downloadFile(@PathVariable("filename") String fileName) throws IOException{
// FileItem fileItem = repository.




}
}





	
	

