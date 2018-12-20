package com.example.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileUploadService")
public class FileUploadService {
	private final String PATH = "/upload";
	public String restore(MultipartFile multipartFile) {
		String uri = null;
		try {
			String originalName = multipartFile.getOriginalFilename();
			String extName = originalName.substring(originalName.lastIndexOf("."),originalName.length());
			long fileSize = multipartFile.getSize();
			String savedFileName = this.GenerateSavedName(extName); 
			System.out.println("originalName = " + originalName);
			System.out.println("extName = " + extName);
			System.out.println("size = " + fileSize);
			System.out.println("savedFileName = " + savedFileName);
			
			saveToFileSystem(multipartFile,savedFileName);
			uri = "upload/" + savedFileName;
			
		}catch(Exception e) {
			System.out.println(e);
		}	
		return uri;
	}
	
	private String GenerateSavedName(String extName) {
		String newName="";
		Calendar now = Calendar.getInstance();
		newName += now.get(Calendar.YEAR);
		newName += now.get(Calendar.MONTH) +1;
		newName += now.get(Calendar.DATE);
		newName += now.get(Calendar.HOUR_OF_DAY);
		newName += now.get(Calendar.MINUTE);
		newName += now.get(Calendar.SECOND);
		newName += now.get(Calendar.MILLISECOND);
		newName += extName;
		return newName;
	}
	
	private void saveToFileSystem(MultipartFile mFile, String savedFileName) throws IOException{
		byte [] buffer = mFile.getBytes();
		File file = new File(this.PATH + "/" + savedFileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(buffer);
		fos.close();
	}
}
