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
@Table (name="tbl_Quyen_ChiTiet")
public class Tbl_Quyen_ChiTiet implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private Tbl_Quyen quyenId = null;
   private Tbl_DBTable bangId = null;
   private Boolean xem;
   private Boolean them;
   private Boolean xoa;
   private Boolean sua;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="QuyenId")
   @ForeignKey(name="FK_tbl_Quyen_tbl_Quyen_ChiTiet")
   public Tbl_Quyen getQuyenId() {
	    return quyenId;
   }
   public void setQuyenId(Tbl_Quyen quyenId) {
	    this.quyenId=quyenId;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="BangId")
   @ForeignKey(name="FK_tbl_DBTable_tbl_Quyen_ChiTiet")
   public Tbl_DBTable getBangId() {
	    return bangId;
   }
   public void setBangId(Tbl_DBTable bangId) {
	    this.bangId=bangId;
   }

   public Boolean getXem() {
   	return xem;
   }
   public void setXem(Boolean xem) {
   	this.xem= xem;
   }

   public Boolean getThem() {
   	return them;
   }
   public void setThem(Boolean them) {
   	this.them= them;
   }

   public Boolean getXoa() {
   	return xoa;
   }
   public void setXoa(Boolean xoa) {
   	this.xoa= xoa;
   }

   public Boolean getSua() {
   	return sua;
   }
   public void setSua(Boolean sua) {
   	this.sua= sua;
   }
}//endClass 

