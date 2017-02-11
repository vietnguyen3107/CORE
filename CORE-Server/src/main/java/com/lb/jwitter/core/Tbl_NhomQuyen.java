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
@Table (name="tbl_NhomQuyen")
public class Tbl_NhomQuyen implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private String tenNhomQuyen;
   private String defaultPage;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   public String getTenNhomQuyen() {
   	return tenNhomQuyen;
   }
   public void setTenNhomQuyen(String tenNhomQuyen) {
   	this.tenNhomQuyen= tenNhomQuyen;
   }

   public String getDefaultPage() {
   	return defaultPage;
   }
   public void setDefaultPage(String defaultPage) {
   	this.defaultPage= defaultPage;
   }
}//endClass 

