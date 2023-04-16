package com.dcs.brgy.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Base64decodedMultiPartfile implements MultipartFile {
	private final byte[] imgContent;
	private final String fullName;
    public Base64decodedMultiPartfile(byte[] imgContent, String fullName) {
        this.imgContent = imgContent;
        this.fullName = fullName;
    }

    @Override
    public String getName() {
        // TODO - implementation depends on your requirements 
        return null;
    }

    @Override
    public String getOriginalFilename() {
    	return fullName+"_temp.jpg";
        // TODO - implementation depends on your requirements
    }

    @Override
    public String getContentType() {
        // TODO - implementation depends on your requirements
        return null;
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @SuppressWarnings("resource")
	@Override
    public void transferTo(File dest) throws IOException, IllegalStateException { 
        new FileOutputStream(dest).write(imgContent);
    }

}
