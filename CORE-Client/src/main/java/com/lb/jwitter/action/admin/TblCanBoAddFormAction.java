package com.lb.jwitter.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import com.lb.jwitter.util.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action;
import com.lb.jwitter.service.ConditionReport;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.lb.jwitter.util.Message;
import com.lb.jwitter.service.TblQuyenChiTietService;
import com.lb.jwitter.service.TblTaiKhoan;
import com.lb.jwitter.service.TblCanBo;
import com.lb.jwitter.service.TblCanBoService;

import com.lb.jwitter.service.TblDonVi;
import com.lb.jwitter.service.TblDonViService;

/**
 * @author QUOCVIET
 */


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblCanBoAddFormAction {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private Date today;

    public Date getToday() {
        return new Date();
    }

    private Message msg;

    public Message getMsg() {
        return msg;
    }

    private List<TblDonVi> tblDonVis;

    public List<TblDonVi> getTblDonVis() {
        return tblDonVis;
    }

    private TblDonViService tblDonViService;

    private TblTaiKhoan taiKhoanDangNhap;

    public TblTaiKhoan getTaiKhoanDangNhap() {
        return taiKhoanDangNhap;
    }

    public void setTaiKhoanDangNhap(TblTaiKhoan taiKhoanDangNhap) {
        this.taiKhoanDangNhap = taiKhoanDangNhap;
    }

    private TblQuyenChiTietService tblQuyenChiTietService;

    @Autowired // Injected by Spring
            ApplicationContextProvider contextProvider;

    public String execute() throws Exception {
        try {
            Map session = ActionContext.getContext().getSession();
            taiKhoanDangNhap = (TblTaiKhoan) session.get("taiKhoan");
            if (taiKhoanDangNhap == null) return "noprivilege";
            ApplicationContext context = ApplicationContextProvider.getApplicationContext();
            tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient");
            if (!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_CanBo", "them")) {
                return "noprivilege";
            }
            tblDonViService = (TblDonViService) context.getBean("tbl_DonViClient");
            List<ConditionReport> cons = new ArrayList<ConditionReport>();
            {
                ConditionReport con = new ConditionReport();
                con.setCol("ten");
                con.setValue1("asc");
                con.setOperator("order");
                cons.add(con);
            }

            String donViHql = Dict.getDonViHQL(taiKhoanDangNhap.getCanBoId().getDonViId());
            tblDonVis = tblDonViService.queryHQLTblDonVi(donViHql, 0, 0);

            return Action.SUCCESS;
        } catch (Exception e) {
            System.out.println("Loi AddForm tbl_CanBo Action");
            e.printStackTrace();
            msg.setPostMessage_b(false);
            msg.setPostMessage_s(e.getMessage());
            return Action.ERROR;
        }
    }
}
 
