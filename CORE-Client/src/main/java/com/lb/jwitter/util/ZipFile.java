package com.lb.jwitter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
 
public class ZipFile
{
    List<String> fileList;
 
    public ZipFile(List<String> files){
    	fileList = files;
    }
 

 
    /**
     * Zip it
     * @param zipFile output ZIP file location
     */
    public void zipIt(String zipFile){
 
     byte[] buffer = new byte[1024];
 
     try{
 
    	FileOutputStream fos = new FileOutputStream(zipFile);
    	ZipOutputStream zos = new ZipOutputStream(fos);
 
    	System.out.println("Output to Zip : " + zipFile);
 
    	for(String file : this.fileList){
    		String filename = ZipFile.getFileName(file);
    		System.out.println("File Added : " + filename);
    		
    		ZipEntry ze= new ZipEntry(filename);
        	zos.putNextEntry(ze);
 
        	FileInputStream in = new FileInputStream(file);
 
        	int len;
        	while ((len = in.read(buffer)) > 0) {
        		zos.write(buffer, 0, len);
        	}
 
        	in.close();
    	}
 
    	zos.closeEntry();
    	//remember close it
    	zos.close();
 
    	System.out.println("Done");
    }catch(IOException ex){
       ex.printStackTrace();   
    }
   }
 
    /**
     * Traverse a directory and get all files,
     * and add the file into fileList  
     * @param node file or directory
     */
    public static List<String> generateFileList(File node){
    	List<String> files = new ArrayList<String>();
    	//add file only
		if(node.isFile()){
			files.add(node.getAbsoluteFile().toString());
		}
	 
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				generateFileList(new File(node, filename));
			}
		}
		return files;
    }
    
    public static String getFileName(String filePath){
    	int index = filePath.lastIndexOf('/');
    	return filePath.substring(index+1);
    }
 
}