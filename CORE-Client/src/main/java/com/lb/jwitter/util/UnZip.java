package com.lb.jwitter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class UnZip {
	List<String> fileList;
	
	public List<String> getFileList() {
		return fileList;
	}

	/**
     * Unzip it
     * @param zipFile input zip file
     * @param output zip file output folder
	 * @throws IOException 
     */
    public void unZipIt(String zipFile, String outputFolder) throws IOException, ZipException{
 
     byte[] buffer = new byte[1024];
     fileList = new ArrayList<String>();
    
    	//create output directory is not exists
    	File folder = new File(outputFolder);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
 
    	//get the zip file content
    	ZipInputStream zis = 
    		new ZipInputStream(new FileInputStream(zipFile));
    	//get the zipped file list entry
    	ZipEntry ze = zis.getNextEntry();
 
    	while(ze!=null){
 
    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);
 
           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
           fileList.add(newFile.getAbsolutePath());
            //create all non exists folders
            //else you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();
 
            FileOutputStream fos = new FileOutputStream(newFile);             
 
            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
 
            fos.close();   
            ze = zis.getNextEntry();
    	}
 
        zis.closeEntry();
    	zis.close();
 
    	System.out.println("Done");
 
   }    
}
