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
@Table (name="tbl_qldt_htmlreport_param")
public class Tbl_QLDT_HTMLReport_Param implements Serializable {
   private static final long serialVersionUID = -1989579066723007050L;

   private Long id;
   private Tbl_QLDT_HTMLReport reportId = null;
   private String ten;
   private String label;
   private String type;
   private String paramSql;
   private String paramVariable;

   @Id
   @GeneratedValue
   public Long getId() {
	    return id;
   }
   public void setId(Long id) {
	    this.id= id;
   }

   @ManyToOne(fetch=FetchType.EAGER)
   @JoinColumn(name="reportId")
   @ForeignKey(name="FK_tbl_QLDT_HTMLReport_tbl_QLDT_HTMLReport_Param")
   public Tbl_QLDT_HTMLReport getReportId() {
	    return reportId;
   }
   public void setReportId(Tbl_QLDT_HTMLReport reportId) {
	    this.reportId=reportId;
   }

   public String getTen() {
   	return ten;
   }
   public void setTen(String ten) {
   	this.ten= ten;
   }

   public String getLabel() {
   	return label;
   }
   public void setLabel(String label) {
   	this.label= label;
   }

   public String getType() {
   	return type;
   }
   public void setType(String type) {
   	this.type= type;
   }

   public String getParamSql() {
   	return paramSql;
   }
   public void setParamSql(String paramSql) {
   	this.paramSql= paramSql;
   }

   public String getParamVariable() {
   	return paramVariable;
   }
   public void setParamVariable(String paramVariable) {
   	this.paramVariable= paramVariable;
   }
}//endClass 

