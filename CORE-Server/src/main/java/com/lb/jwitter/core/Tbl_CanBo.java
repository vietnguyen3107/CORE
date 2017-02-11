package com.lb.jwitter.core;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="tbl_canbo")
public class Tbl_CanBo implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;


   private Long id;
   private String ten;
   private String maQuanLy;
   private Date ngaySinh;
   private String noiSinh;
   private String diaChi;
   private String dienThoai;
   private String trinhDo;
   private String ngheNghiep;
   private String noiLam;
   private String ghiChu;
   private Tbl_DonVi donViId = null;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   public Date getNgaySinh() {
	return ngaySinh;
}
public void setNgaySinh(Date ngaySinh) {
	this.ngaySinh = ngaySinh;
}
public String getTen() {
   	return ten;
   }
   public void setTen(String ten) {
   	this.ten= ten;
   }

   public String getGhiChu() {
   	return ghiChu;
   }
   public void setGhiChu(String ghiChu) {
   	this.ghiChu= ghiChu;
   }

   public String getMaQuanLy() {
   	return maQuanLy;
   }
   public void setMaQuanLy(String maQuanLy) {
   	this.maQuanLy= maQuanLy;
   }


   public String getNoiSinh() {
   	return noiSinh;
   }
   public void setNoiSinh(String noiSinh) {
   	this.noiSinh= noiSinh;
   }

   public String getDiaChi() {
   	return diaChi;
   }
   public void setDiaChi(String diaChi) {
   	this.diaChi= diaChi;
   }

   public String getDienThoai() {
   	return dienThoai;
   }
   public void setDienThoai(String dienThoai) {
   	this.dienThoai= dienThoai;
   }

   public String getTrinhDo() {
   	return trinhDo;
   }
   public void setTrinhDo(String trinhDo) {
   	this.trinhDo= trinhDo;
   }

   public String getNgheNghiep() {
   	return ngheNghiep;
   }
   public void setNgheNghiep(String ngheNghiep) {
   	this.ngheNghiep= ngheNghiep;
   }

   public String getNoiLam() {
   	return noiLam;
   }
   public void setNoiLam(String noiLam) {
   	this.noiLam= noiLam;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="donViId")
   @ForeignKey(name="FK_tbl_DonVi_tbl_CanBo")
   public Tbl_DonVi getDonViId() {
	    return donViId;
   }
   public void setDonViId(Tbl_DonVi donViId) {
	    this.donViId=donViId;
   }
}//endClass 

