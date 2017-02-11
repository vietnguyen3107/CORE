package com.lb.jwitter.action.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;

import com.lb.jwitter.service.TblCanBo;
import com.lb.jwitter.service.TblCanBoService;
import com.lb.jwitter.service.TblQuyenChiTietService;
import com.lb.jwitter.service.TblTaiKhoan;
import com.lb.jwitter.service.TblTaiKhoanService;
import com.lb.jwitter.util.ApplicationContextProvider;
import com.lb.jwitter.util.Encrypt;
import com.lb.jwitter.util.Message;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

//@ContextConfiguration(locations="classpath:beans.xml") 
public class UserInfoAction {


    private Long id; 
    public Long getId() {
       return id;
 }

    public void setId(Long id) {
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
    
    private String username;
    private String password;

	  public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private TblTaiKhoan taiKhoanDangNhap; 
	  
	  public TblTaiKhoan getTaiKhoanDangNhap() { 
	      return taiKhoanDangNhap; 
	  } 
	  public void setTaiKhoanDangNhap(TblTaiKhoan taiKhoanDangNhap) { 
	      this.taiKhoanDangNhap = taiKhoanDangNhap; 
	  } 
	  
	  private TblCanBo tblCanBo;
	  
	public TblCanBo getTblCanBo() {
		return tblCanBo;
	}
	public void setTblCanBo(TblCanBo tblCanBo) {
		this.tblCanBo = tblCanBo;
	}

	@Autowired // Injected by Spring 
	ApplicationContextProvider contextProvider; 
	 	 
	public String form() throws Exception
	{

		Map session = ActionContext.getContext().getSession();
	     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
	     if( taiKhoanDangNhap == null) return "noprivilege";
	     
	     tblCanBo = taiKhoanDangNhap.getCanBoId();
	     
//	    ApplicationContext context = contextProvider.getApplicationContext();   
//	    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 



		return Action.SUCCESS;

	}
	
	private Message msg;
	
	  public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	private TblCanBoService tblCanBoService; 

	public String update() throws Exception
	{
		msg = new Message();

	     try{ 	
	         Map session = ActionContext.getContext().getSession();
	         taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
	         if( taiKhoanDangNhap == null){
		            msg.setPreMessage_b(false);
		            msg.setPreMessage_s("Chưa đăng nhập tài khoản!");
	        	 return Action.ERROR;
	         }
	         
	        ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
	        
	         tblCanBoService = (TblCanBoService)context.getBean("tbl_CanBoClient"); 
	         TblQuyenChiTietService tblQuyenChiTietService = (TblQuyenChiTietService) context
						.getBean("tbl_Quyen_ChiTietClient");
				
				if (!tblQuyenChiTietService.checkRight(taiKhoanDangNhap
						.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "sua")) {

					msg.setPreMessage_b(false);
		            msg.setPreMessage_s("Tài khoản không được cấp quyền!");
					return Action.ERROR;
				}
				
	            tblCanBo = taiKhoanDangNhap.getCanBoId();
	            //tblCanBo.setId(id);
	            
	            tblCanBo.setTen(ten); 
	            //tblCanBo.setGhiChu(ghiChu); 
	            //tblCanBo.setMaQuanLy(maQuanLy); 
	           DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	           try{
	    	       Date dd = df.parse(ngaySinh); 
	    	       GregorianCalendar c = new GregorianCalendar(); 
	    	       c.setTime(dd);
	    	       XMLGregorianCalendar d = DatatypeFactory.newInstance().newXMLGregorianCalendar(c); 
//	    	       tblCanBo.setNgaySinh(d); 
	           }catch(Exception e){
//	        	   e.printStackTrace();
	           }
	            tblCanBo.setNoiSinh(noiSinh); 
	            tblCanBo.setDiaChi(diaChi); 
	            tblCanBo.setDienThoai(dienThoai); 
	            tblCanBo.setTrinhDo(trinhDo); 
	            tblCanBo.setNgheNghiep(ngheNghiep); 
	            tblCanBo.setNoiLam(noiLam); 

	            tblCanBoService.updatetblCanBo(tblCanBo); 
	              
	            
	            TblTaiKhoanService tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
	            taiKhoanDangNhap.setUsername(username);
	            if(password !=null && !password.equals(""))
	            {
	            	taiKhoanDangNhap.setPassword(Encrypt.sha(password, "SHA-1"));
	            }
	            tblTaiKhoanService.updatetblTaiKhoan(taiKhoanDangNhap);

	            msg.setPostMessage_b(true);
	            msg.setPostMessage_s("");
	            msg.setPreMessage_b(true);
	            msg.setPreMessage_s("Cập nhật thành công!");
	            return Action.SUCCESS; 
	     } 
	     catch(Exception e){ 
	             System.out.println("Loi Update UserInfo Action"); 
	             e.printStackTrace(); 
	             return Action.ERROR; 
	     } 

	}
	
	
	
	
	
}
