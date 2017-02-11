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
@Table (name="tbl_Quyen_NhomQuyen")
public class Tbl_Quyen_NhomQuyen implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private Tbl_NhomQuyen maNhomQuyen = null;
   private Tbl_Quyen maQuyen = null;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="MaNhomQuyen")
   @ForeignKey(name="FK_tbl_NhomQuyen_tbl_Quyen_NhomQuyen")
   public Tbl_NhomQuyen getMaNhomQuyen() {
	    return maNhomQuyen;
   }
   public void setMaNhomQuyen(Tbl_NhomQuyen maNhomQuyen) {
	    this.maNhomQuyen=maNhomQuyen;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="MaQuyen")
   @ForeignKey(name="FK_tbl_Quyen_tbl_Quyen_NhomQuyen")
   public Tbl_Quyen getMaQuyen() {
	    return maQuyen;
   }
   public void setMaQuyen(Tbl_Quyen maQuyen) {
	    this.maQuyen=maQuyen;
   }
}//endClass 

