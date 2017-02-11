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
@Table (name="tbl_qldtlt_optiongroup")
public class Tbl_QLDTLT_OptionGroup implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private String ma;
   private String ten;
   private String maLoai;

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

   public String getMaLoai() {
   	return maLoai;
   }
   public void setMaLoai(String maLoai) {
   	this.maLoai= maLoai;
   }
}//endClass 

