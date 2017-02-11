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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="tbl_TaiKhoan")
public class Tbl_TaiKhoan implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private String username;
   private String password;
   private Tbl_NhomQuyen maNhomQuyen = null;
   private Tbl_CanBo canBoId = null;
   
   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   public String getUsername() {
   	return username;
   }
   public void setUsername(String username) {
   	this.username= username;
   }

   public String getPassword() {
   	return password;
   }
   public void setPassword(String password) {
   	this.password= password;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="MaNhomQuyen")
   @ForeignKey(name="FK_tbl_NhomQuyen_tbl_TaiKhoan")
   public Tbl_NhomQuyen getMaNhomQuyen() {
	    return maNhomQuyen;
   }
   public void setMaNhomQuyen(Tbl_NhomQuyen maNhomQuyen) {
	    this.maNhomQuyen=maNhomQuyen;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="CanBoId")
   @ForeignKey(name="FK_tbl_CanBo_tbl_TaiKhoan")
   public Tbl_CanBo getCanBoId() {
	    return canBoId;
   }
   public void setCanBoId(Tbl_CanBo canBoId) {
	    this.canBoId=canBoId;
   }
   
}//endClass 

