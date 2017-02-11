package com.lb.jwitter.action;



import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Collection; 
import java.util.Collections; 
import java.util.Date; 
import java.util.List; 
import java.util.GregorianCalendar; 
import javax.xml.datatype.DatatypeFactory; 
import javax.xml.datatype.XMLGregorianCalendar; 

import org.springframework.test.context.ContextConfiguration;

import com.lb.jwitter.core.Tbl_CanBo;
import com.opensymphony.xwork2.Action;


 /** 
 * @author QUOCVIET  
 * 
 */ 


@ContextConfiguration(locations="classpath:beans.xml") 
public class BienNhanReportAction{


    private String tungayNhan; 
    public void setTungayNhan(String tungayNhan) {
       this.tungayNhan = tungayNhan;
   }

    public String getTungayNhan() {
       return tungayNhan;
   }

    private String denngayNhan; 
    public void setDenngayNhan(String denngayNhan) {
       this.denngayNhan = denngayNhan;
   }

    public String getDenngayNhan() {
       return denngayNhan;
   }

    private String soBienLai; 
    public void setSoBienLai(String soBienLai) {
       this.soBienLai = soBienLai;
   }

    public String getSoBienLai() {
       return soBienLai;
   }

    private int canBoId; 
    public void setCanBoId(int canBoId) {
       this.canBoId = canBoId;
  }

    public int getCanBoId() {
       return canBoId;
  }

    private Collection<Tbl_CanBo> tblCanBos; 
    public Collection<Tbl_CanBo>  getTblCanBos() {
        return this.tblCanBos ; 
      } 

    private int hoSoId; 
    public void setHoSoId(int hoSoId) {
       this.hoSoId = hoSoId;
  }

    public int getHoSoId() {
       return hoSoId;
  }


	   
 public String execute() throws Exception 
{ 
 try{ 	
 
	 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Report tbl_QLDTTXA_BienNhanHoSo Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 }

 } 
 
