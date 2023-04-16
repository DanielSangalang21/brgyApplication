package com.dcs.brgy.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileHelper {

	@Value("${file.img.path}") //default app path
	private static String filePath;

	private static final String uploadsDir = "/uploads/";
	
	private static final String SRC_DIR_REPORTS = "src/main/webapp";
	// will return true if created otherwise false;
	private static File createFileDirectory(String path) {
		File file = new File(path);
		file.mkdirs();
		return file;
	}
	
	public static void multipartFileToFile(MultipartFile mpFile) throws IOException {
		//also converts multipartFileToFile to file
		createFileDirectory(filePath);
		Path path = Paths.get(filePath, mpFile.getOriginalFilename());
		OutputStream os = Files.newOutputStream(path);
		os.write(mpFile.getBytes());
	}
	
	public static String saveFile(HttpServletRequest request, MultipartFile file) throws IOException {
		String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
		if(!new File(realPathtoUploads).exists()) {
			new File(realPathtoUploads).mkdirs();
		}
		
		String orgFileName = file.getOriginalFilename();
		String fileUploadName = realPathtoUploads+orgFileName;
		File dest = new File(fileUploadName);
		file.transferTo(dest);
		return dest.getAbsolutePath();
	}
	
	//will set image uploaded with postfix '_temp' as applicant image and delete all other image in the server with same name
	public static String registerFile(String url) throws IOException, InterruptedException {
		String filePath  =  url.substring(0,url.indexOf("_temp"));
		//add extension
		String ext = url.substring(url.indexOf("_temp")+5,url.length());
		String filename = filePath + ext;
		
		File file = new File(url);
		
		ThreadedFileHelper tfh = new ThreadedFileHelper(file, filename, 1);
		tfh.createFile();
		return filename;
	}
	
	//format file path relative to uploads file for display
	public static String formatFilePathStr(String dir) {
		return ".."+dir.substring(dir.indexOf(uploadsDir.replace('/', '\\')));
		//return dir.substring(dir.indexOf(SRC_DIR_INTITIAL));
	}
	
	public static String imagePathForReport(String path) {
		
		return SRC_DIR_REPORTS + path.substring(2).replace('\\', '/');
		//return dir.substring(dir.indexOf(SRC_DIR_INTITIAL));
	}
	
	public static String fileNameGenerator() {
		return "";
	}
	
	public static String imagefileNmGenerator() {
		return "";
	}
}
