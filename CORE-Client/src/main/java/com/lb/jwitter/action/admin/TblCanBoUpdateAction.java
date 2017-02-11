package com.lb.jwitter.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.Date; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.ConditionReport; 
import java.util.Map; 
 import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.Message; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblCanBo;
import com.lb.jwitter.service.TblCanBoService;

import com.lb.jwitter.service.TblDonVi;
import com.lb.jwitter.service.TblDonViService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblCanBoUpdateAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    private int page; 
    public int getPage() { return page; }

    public void setPage(int page) { this.page = page; }

    private int pages; 
    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

    private String dataString; 
    public String getDataString() { return dataString; }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private int id; 
    public int getId() {
       return id;
 }

    public void setId(int id) {
       this.id = id;
 }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private String ghiChu; 
    public void setGhiChu(String ghiChu) {
       this.ghiChu = ghiChu;
 }

    public String getGhiChu() {
       return ghiChu;
 }

    private String maQuanLy; 
    public void setMaQuanLy(String maQuanLy) {
       this.maQuanLy = maQuanLy;
 }

    public String getMaQuanLy() {
       return maQuanLy;
 }

    private String ngaySinh; 
    public void setNgaySinh(String ngaySinh) {
       this.ngaySinh = ngaySinh;
 }

    public String getNgaySinh() {
       return ngaySinh;
 }

    private String noiSinh; 
    public void setNoiSinh(String noiSinh) {
       this.noiSinh = noiSinh;
 }

    public String getNoiSinh() {
       return noiSinh;
 }

    private String diaChi; 
    public void setDiaChi(String diaChi) {
       this.diaChi = diaChi;
 }

    public String getDiaChi() {
       return diaChi;
 }

    private String dienThoai; 
    public void setDienThoai(String dienThoai) {
       this.dienThoai = dienThoai;
 }

    public String getDienThoai() {
       return dienThoai;
 }

    private String trinhDo; 
    public void setTrinhDo(String trinhDo) {
       this.trinhDo = trinhDo;
 }

    public String getTrinhDo() {
       return trinhDo;
 }

    private String ngheNghiep; 
    public void setNgheNghiep(String ngheNghiep) {
       this.ngheNghiep = ngheNghiep;
 }

    public String getNgheNghiep() {
       return ngheNghiep;
 }

    private String noiLam; 
    public void setNoiLam(String noiLam) {
       this.noiLam = noiLam;
 }

    public String getNoiLam() {
       return noiLam;
 }

    private int donViId; 
    public void setDonViId(int donViId) {
       this.donViId = donViId;
 }

    public int getDonViId() {
       return donViId;
 }

    private TblDonViService tblDonViService; 

    private TblCanBo tblCanBo; 
    public void setTblCanBo (TblCanBo tblCanBo) {
        this.tblCanBo = tblCanBo;
 }

    private TblCanBoService tblCanBoService; 

	private int preUpdate(Message msg, TblCanBo obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblCanBo obj ){ 
        msg.setPostMessage_b(true); 
        msg.setPostMessage_s("success"); 
        return 1; 
    } 
  private TblTaiKhoan taiKhoanDangNhap; 
 public TblTaiKhoan getTaiKhoanDangNhap() { 
     return taiKhoanDangNhap; 
 } 
 public void setTaiKhoanDangNhap(TblTaiKhoan taiKhoanDangNhap) { 
     this.taiKhoanDangNhap = taiKhoanDangNhap; 
 } 
    private TblQuyenChiTietService tblQuyenChiTietService; 

	 @Autowired // Injected by Spring 
     ApplicationContextProvider contextProvider; 
 public String execute() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_CanBo", "sua")){ 
        return "noprivilege"; 
    }tblCanBoService = (TblCanBoService) context.getBean("tbl_CanBoClient"); 
 tblDonViService = (TblDonViService) context.getBean("tbl_DonViClient"); 
         msg = new Message(); 
        tblCanBo = tblCanBoService.gettblCanBo(new Long(id)); 
        preUpdate(msg,tblCanBo); 
        tblCanBo.setTen(ten); 
        tblCanBo.setGhiChu(ghiChu); 
        tblCanBo.setMaQuanLy(maQuanLy); 
       try{ 
//       DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
//       Date dd = df.parse(ngaySinh); 
//       GregorianCalendar c = new GregorianCalendar(); 
//       c.setTime(dd);
//       XMLGregorianCalendar d = DatatypeFactory.newInstance().newXMLGregorianCalendar(c); 
//        tblCanBo.setNgaySinh(d); 
}catch(Exception e){  e.printStackTrace(); } 
         tblCanBo.setNoiSinh(noiSinh); 
        tblCanBo.setDiaChi(diaChi); 
        tblCanBo.setDienThoai(dienThoai); 
        tblCanBo.setTrinhDo(trinhDo); 
        tblCanBo.setNgheNghiep(ngheNghiep); 
        tblCanBo.setNoiLam(noiLam); 
        tblCanBo.setDonViId(tblDonViService.getTblDonVi(new Long(donViId))); 
       if (msg.isPreMessage_b()) 
       { 
           tblCanBoService.updatetblCanBo(tblCanBo); 
           postUpdate(msg, tblCanBo); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 

        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_CanBo Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
