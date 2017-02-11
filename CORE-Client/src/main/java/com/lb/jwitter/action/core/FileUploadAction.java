package com.lb.jwitter.action.core;


import java.io.File;
 
import com.lb.jwitter.util.ExcelToJSon;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;



public class FileUploadAction extends ActionSupport{
 

    private File file;

    private String fileContentType;

    private String fileFileName;

    private String msg;

    private String baseFolder;
    
    private String fileId;
    

	private String destFile;
	
	private String ngayBatDau;
	private String ngayKetThuc;
	
	private String loaiCapNhat;

	public String getLoaiCapNhat() {
		return loaiCapNhat;
	}

	public void setLoaiCapNhat(String loaiCapNhat) {
		this.loaiCapNhat = loaiCapNhat;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	private String[] quyen;

	public String[] getQuyen() {
		return quyen;
	}

	public void setQuyen(String[] quyen) {
		this.quyen = quyen;
	}

	public String getDestFile() {
		return destFile;
	}

	public void setDestFile(String destFile) {
		this.destFile = destFile;
	}
	
	private int dotDKId;

	public int getDotDKId() {
		return dotDKId;
	}

	public void setDotDKId(int dotDKId) {
		this.dotDKId = dotDKId;
	}
	
	private String quyenDK;

	public String getQuyenDK() {
		return quyenDK;
	}

	public void setQuyenDK(String quyenDK) {
		this.quyenDK = quyenDK;
	}

	@Override
    public String execute() throws Exception
    {
		String w = "-";
		String u = "-";
		String d = "-";
		if(quyen != null){
	        for(String s : quyen){
	
	    		if(s.equals("w"))
	    			w = "w";
	    		if(s.equals("u"))
	    			u = "u";
	    		if(s.equals("d"))
	    			d = "d";
	    	}
    	}
        
        quyenDK = w + u + d;
        
        String randomName = "a" + Math.round(Math.random()*100000000000000.0);
        
        fileFileName = fileFileName.replace(" ", "_");

        destFile = "./file/UploadFile/" + randomName + "_" + fileFileName;
               

        fileFileName = randomName + "_" + fileFileName;

        fileId = fileFileName.split("\\.")[0];
        
        try{
        if ( file != null )
        {
            if (  ((file.length() / 1024) / 1024) < 20 )

            {
                FileUtils.copyFile( file, new File( destFile ) );
                msg = "Upload successfully";
            }
            else
            {
                msg = "Size must be less then 20MB";
            }

        }
        }
        catch(Exception e){
        	System.out.println("---CHUMANO---");
        	e.printStackTrace();
        }
       // jsons = ExcelToJSon.execute(destFile);
//        System.out.println("Size = " + jsons.size());
//        for(int i = 0; i < jsons.size() ; i++){
//    		JSONObject obj = jsons.getJSONObject(i);
//    	    String tencu = obj.getString("TenCu");  	
//    	    String tenmoi = obj.getString("TenMoi");  
//    	     
//    	    System.out.println( "tencu: " + tencu );
//    	    System.out.println( "tenmoi: " + tenmoi );
//    	}
//        return "forward";
        
        return Action.SUCCESS;
    }

    public File getFile()
    {
        return file;
    }

    public void setFile( File file )
    {
        this.file = file;
    }

    public String getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType( String fileContentType )
    {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName( String fileFileName )
    {
        this.fileFileName = fileFileName;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg( String msg )
    {
        this.msg = msg;
    }


	public String getBaseFolder()
    {
        return baseFolder;
    }

    public void setBaseFolder( String baseFolder )
    {
        this.baseFolder = baseFolder;
    }

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
     private int hocKyId;

	public int getHocKyId() {
		return hocKyId;
	}

	public void setHocKyId(int hocKyId) {
		this.hocKyId = hocKyId;
	}
    
	private int lopMonHocId;

	public int getLopMonHocId() {
		return lopMonHocId;
	}

	public void setLopMonHocId(int lopMonHocId) {
		this.lopMonHocId = lopMonHocId;
	}

	private String tuNhanDang;

	public String getTuNhanDang() {
		return tuNhanDang;
	}

	public void setTuNhanDang(String tuNhanDang) {
		this.tuNhanDang = tuNhanDang;
	}
	
	private String tpl;
	
	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}
}
