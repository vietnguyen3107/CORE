package com.lb.jwitter.action.core.htmlreport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date; 
import java.util.Map; 
import com.lb.jwitter.util.Message; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action;
import com.lb.jwitter.service.CommonService;
import com.lb.jwitter.service.Qresult;
import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportService;
 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class HtmlReportParamAutoCompleteAction{

    private String paramSql;
    private String paramVariable;
    private String q;

    private List<Qresult> results;
    

	
	 public List<Qresult> getResults() {
		return results;
	}
	public void setResults(List<Qresult> results) {
		this.results = results;
	}
	@Autowired // Injected by Spring 
     ApplicationContextProvider contextProvider; 
	 private TblTaiKhoan taiKhoanDangNhap; 
	 public TblTaiKhoan getTaiKhoanDangNhap() { 
	     return taiKhoanDangNhap; 
	 } 
	 public void setTaiKhoanDangNhap(TblTaiKhoan taiKhoanDangNhap) { 
	     this.taiKhoanDangNhap = taiKhoanDangNhap; 
	 } 
	 private TblQuyenChiTietService tblQuyenChiTietService;
	 
	 
	public String execute() throws Exception {
        try{
        	Map session = ActionContext.getContext().getSession();
			taiKhoanDangNhap = (TblTaiKhoan) session.get("taiKhoan");
			if (taiKhoanDangNhap == null)
				return "noprivilege";
			ApplicationContext context = ApplicationContextProvider
					.getApplicationContext();
			tblQuyenChiTietService = (TblQuyenChiTietService) context
					.getBean("tbl_Quyen_ChiTietClient");
			if (!tblQuyenChiTietService.checkRight(taiKhoanDangNhap
					.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport", "xem")) {
				return "noprivilege";
			}
			
            String sql = paramSql;
            String key = "{" + paramVariable + "}";
            if(sql != null && sql.contains(key)) {
                sql = sql.replace(key, q);

            }
            
            System.out.println(sql);
            sql.replaceAll("delete", "");
            sql.replaceAll("update", "");
            sql.replaceAll("insert", "");
            CommonService commonService = (CommonService) context
        			.getBean("commonClient");

	
            results = commonService.querySQLWithParamsAliasTransformer(sql, null, null, 20, 1);


        }
    	catch(Exception e)
    	{
    		e.printStackTrace();

    	}
        
        return Action.SUCCESS;
    }

    
    public String getParamSql() {
        return paramSql;
    }

    public void setParamSql(String paramSql) {
        this.paramSql = paramSql;
    }

    public String getParamVariable() {
		return paramVariable;
	}


	public void setParamVariable(String paramVariable) {
		this.paramVariable = paramVariable;
	}


	public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
