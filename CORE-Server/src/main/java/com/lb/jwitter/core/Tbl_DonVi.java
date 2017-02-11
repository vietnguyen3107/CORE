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
@Table (name="tbl_donvi")
public class Tbl_DonVi implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private String ma;
   private String ten;
   private Tbl_DonVi donViChaId = null;
   private String email;
   private String sdt;
   private String diaChi;
   private String truongDonVi;


    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    private Integer lvl;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   public String getMa() {
   	return ma;
   }
   public void setMa(String ma) {
   	this.ma= ma;
   }

   public String getTen() {
   	return ten;
   }
   public void setTen(String ten) {
   	this.ten= ten;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="donViChaId")
   @ForeignKey(name="FK_tbl_DonVi_tbl_DonVi")
   public Tbl_DonVi getDonViChaId() {
	    return donViChaId;
   }
   public void setDonViChaId(Tbl_DonVi donViChaId) {
	    this.donViChaId=donViChaId;
   }

   public String getEmail() {
   	return email;
   }
   public void setEmail(String email) {
   	this.email= email;
   }

   public String getSdt() {
   	return sdt;
   }
   public void setSdt(String sdt) {
   	this.sdt= sdt;
   }

   public String getDiaChi() {
   	return diaChi;
   }
   public void setDiaChi(String diaChi) {
   	this.diaChi= diaChi;
   }

   public String getTruongDonVi() {
   	return truongDonVi;
   }
   public void setTruongDonVi(String truongDonVi) {
   	this.truongDonVi= truongDonVi;
   }
}//endClass 

