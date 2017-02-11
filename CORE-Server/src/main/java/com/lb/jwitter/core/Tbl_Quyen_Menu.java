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
@Table (name="tbl_Quyen_Menu")
public class Tbl_Quyen_Menu implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private Tbl_Quyen quyenId = null;
   private Tbl_Menu menuId = null;
   private Boolean choPhep;

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
   @ForeignKey(name="FK_tbl_Quyen_tbl_Quyen_Menu")
   public Tbl_Quyen getQuyenId() {
	    return quyenId;
   }
   public void setQuyenId(Tbl_Quyen quyenId) {
	    this.quyenId=quyenId;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="MenuId")
   @ForeignKey(name="FK_tbl_Menu_tbl_Quyen_Menu")
   public Tbl_Menu getMenuId() {
	    return menuId;
   }
   public void setMenuId(Tbl_Menu menuId) {
	    this.menuId=menuId;
   }

   public Boolean getChoPhep() {
   	return choPhep;
   }
   public void setChoPhep(Boolean choPhep) {
   	this.choPhep= choPhep;
   }
}//endClass 

