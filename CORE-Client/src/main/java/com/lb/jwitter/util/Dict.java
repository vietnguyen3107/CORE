package com.lb.jwitter.util;

import java.util.HashMap;
import java.util.Map;

import com.lb.jwitter.service.TblDonVi;


public class Dict {

	public static final String keHoachTrangThaiOptionGroup = "KhoaDaoTao_KeHoach_TrangThai";
	public static final String khoaDaoTaoTrangThaiOptionGroup = "KhoaDaoTao_TrangThai";
	

	public static final Map<String, String> keHoachTrangThaiList = new HashMap<String, String>(){
        {
            put("CREATED", "MO");
            put("APPROVED", "DU");
            put("CANCELED", "HU");
            put("SUBMITTED", "TR");
        }
    };
	public static final Map<String, String> khoaDaoTaoTrangThaiList = new HashMap<String, String>(){
        {
            put("CREATED", "TML");
            put("APPROVED", "CML");
            put("OPENED", "ML");
            put("FINISHED", "KT");
            put("PRECLOSED", "CGCN");
            put("CLOSED", "HT");
        }
    };
	public static String getDonViHQL(TblDonVi tblDonVi) {

		String donViHql = " SELECT dv "
				+ " FROM Tbl_DonVi dv "
				+ " LEFT JOIN dv.donViChaId dv2 "
				+ " LEFT JOIN dv2.donViChaId dv3 "
				+ " WHERE 1=1 ";
		
		donViHql += " and ( "
				+ " dv.id = " + tblDonVi.getId() + " "
				+ " OR dv2.id = " + tblDonVi.getId()
				+ " OR dv3.id = " + tblDonVi.getId() + " )"
				+ " ";
		donViHql += " ORDER BY dv.lvl asc, dv.donViChaId.id asc, dv.ma ";
		return donViHql;
	}
	
	public static String operator(String filter) {
		filter = filter.replace(":eq:", " = ");
		filter = filter.replace(":neq:", " <> ");
		filter = filter.replace(":gt:", " > ");
		filter = filter.replace(":ge:", " >= ");
		filter = filter.replace(":lt:", " < ");
		filter = filter.replace(":le:", " <= ");
		filter = filter.replace(":null:", " is null ");
		filter = filter.replace(":!null:", " is not null ");
		filter = filter.replace(":in:", " in ");
		filter = filter.replace(":!in:", " not in ");
		filter = filter.replace(":like:", " like ");
		
		return filter;
	}

}
