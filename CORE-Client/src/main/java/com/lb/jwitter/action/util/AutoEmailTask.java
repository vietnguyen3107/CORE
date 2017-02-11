//package com.lb.jwitter.action.util;
//
//import java.io.UnsupportedEncodingException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.xml.datatype.DatatypeFactory;
//import javax.xml.datatype.XMLGregorianCalendar;
//
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import com.lb.jwitter.service.ConditionReport;
//import com.lb.jwitter.service.TblQLDTDKMHLogMail;
//import com.lb.jwitter.service.TblQLDTDKMHLogMailBK;
//import com.lb.jwitter.service.TblQLDTDKMHLogMailBKService;
//import com.lb.jwitter.service.TblQLDTDKMHLogMailService;
//import com.lb.jwitter.util.ApplicationContextProvider;
//import com.lb.jwitter.util.ChumanoLogger;
//
//public class AutoEmailTask {
//
//	//private Log log = LogFactory.getLog(AutoEmailTask.class);
//	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//	private String mailSubject;
//
//	public String getMailSubject() {
//		return mailSubject;
//	}
//
//	public void setMailSubject(String mailSubject) {
//		this.mailSubject = mailSubject;
//	}
//
//	private String mailFrom;
//
//	public String getMailFrom() {
//		return mailFrom;
//	}
//
//	public void setMailFrom(String mailFrom) {
//		this.mailFrom = mailFrom;
//	}
//	
//	private String mailCc;
//	
//	public String getMailCc() {
//		return mailCc;
//	}
//
//	public void setMailCc(String mailCc) {
//		this.mailCc = mailCc;
//	}
//
//	private String mailFromPersonal;
//
//	public String getMailFromPersonal() {
//		return mailFromPersonal;
//	}
//
//	public void setMailFromPersonal(String mailFromPersonal) {
//		this.mailFromPersonal = mailFromPersonal;
//	}
//
//	private JavaMailSender mailSender;
//
//	public void setMailSender(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}
//
//	TblQLDTDKMHLogMailService tblQLDTDKMHLogMailService ;
//	TblQLDTDKMHLogMailBKService tblQLDTDKMHLogMailBKService ;
//	
//	public AutoEmailTask() {
//		ApplicationContext context = ApplicationContextProvider
//				.getApplicationContext();
//		
//		tblQLDTDKMHLogMailService = (TblQLDTDKMHLogMailService) context.getBean("tbl_QLDT_DKMH_LogMailClient");
//		tblQLDTDKMHLogMailBKService = (TblQLDTDKMHLogMailBKService) context.getBean("tbl_QLDT_DKMH_LogMail_BKClient");
//	}
//	
//	public void sendMail(String mailToAddress, String mailToPersonal, String subject, String content) throws MessagingException, UnsupportedEncodingException
//	{
//		String encodingOptions = "text/html; charset=UTF-8";		
//		MimeMessage msg = mailSender.createMimeMessage();
//		
//		msg.setHeader("Content-Type", encodingOptions);
//		msg.setFrom(new InternetAddress(mailFrom,mailFromPersonal));
//		
//		//nguoi nhan
//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailToAddress, mailToPersonal));
//		if(!mailCc.isEmpty())
//			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(mailCc));
//		
//		//chu de va noi dung
//		msg.setSubject(subject, "UTF-8");
//		msg.setContent(content, encodingOptions);
//		
//		/*
//		//attach mail
//        // Set the email message text.
//        MimeBodyPart messagePart = new MimeBodyPart();
//        messagePart.setText(content);
//
//        // Set the email attachment file
//        FileDataSource fileDataSource = new FileDataSource("");
//
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//        attachmentPart.setDataHandler(new DataHandler(fileDataSource));
//        attachmentPart.setFileName(fileDataSource.getName());
//
//        // Create Multipart E-Mail.
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messagePart);
//        multipart.addBodyPart(attachmentPart);
//
//        msg.setContent(multipart);*/
//		
//		//send
//		mailSender.send(msg);
//	}
//	
//	public void execute1(){
//		ChumanoLogger.init1("Auto_email1");
//		ChumanoLogger.init1("Auto_email2");
//		System.out.println("======================SEND MAIL==================");
//		try {
//			Date d = new Date();
//			for(int i = 0; i < 10; i++){
//				System.out.println("send-"+i);
//				sendMail("testsendmailto@gmail.com" , "PERSONAL - LOC - " + i, i + "-Kiem tra dkmh mail: "+d.toString(), " noi dung");
//				ChumanoLogger.log("Auto_email1", "mail1");
//				ChumanoLogger.log("Auto_email2", "mail2");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void execute() {
//		ChumanoLogger.init("Auto_email");
//		try {			
//			ChumanoLogger.log("Bat dau quet gui mail tu dong ");
//			
//			//lay mot so mail de load len bo nho
//			List<TblQLDTDKMHLogMail> tblQLDTDKMHLogMails = new ArrayList<TblQLDTDKMHLogMail>();
//			
//			List<ConditionReport> cons = new ArrayList<ConditionReport>();
//			{
//				ConditionReport con = new ConditionReport();
//				con.setCol("ngayXacNhan");
//				con.setValue1("asc");
//				con.setOperator("order");
//				cons.add(con);
//			}
//			
//			tblQLDTDKMHLogMails = tblQLDTDKMHLogMailService.findtblQLDTDKMHLogMailByCondition(cons, 1000, 1);
//			
//			
//			String encodingOptions = "text/html; charset=UTF-8";
//			GregorianCalendar c = new GregorianCalendar();
//			XMLGregorianCalendar d;
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//
//			if (tblQLDTDKMHLogMails != null) {
//				for (TblQLDTDKMHLogMail tblQLDTDKMHLogMail : tblQLDTDKMHLogMails) {
//					try {
//						if (tblQLDTDKMHLogMail.getHocVienId() != null
//								&& tblQLDTDKMHLogMail.getHocVienId().getEmail() != null
//								&& !tblQLDTDKMHLogMail.getHocVienId().getEmail().isEmpty()) {
//							
//							//subject
//							String subject = "PDT-" + (tblQLDTDKMHLogMail.getDotDKId().getMa() == null ? "DKMH" : tblQLDTDKMHLogMail.getDotDKId().getMa()) + "-" + df.format(new Date());
//							//content
//							String content = tblQLDTDKMHLogMail.getNoiDung();
//							//receiver
//							String mail_receiver =tblQLDTDKMHLogMail.getHocVienId().getEmail();
//							String name_receiver = (tblQLDTDKMHLogMail.getHocVienId().getTen() != null ? tblQLDTDKMHLogMail.getHocVienId().getTen(): "");
//							
//							//----------
//							//send mail
//							sendMail(mail_receiver, name_receiver, subject, content);
//							
//							
//							//----------
//							//update tbl_logmail
//							c.setTime(new Date());
//							d = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//							
//							//luu sang bang  moi
//							TblQLDTDKMHLogMailBK tblQLDTDKMHLogMailBK = new TblQLDTDKMHLogMailBK();
//							tblQLDTDKMHLogMailBK.setDotDKId(tblQLDTDKMHLogMail.getDotDKId());
//							tblQLDTDKMHLogMailBK.setEmail(tblQLDTDKMHLogMail.getEmail());
//							tblQLDTDKMHLogMailBK.setHocKyId(tblQLDTDKMHLogMail.getHocKyId());
//							tblQLDTDKMHLogMailBK.setHocVienId(tblQLDTDKMHLogMail.getHocVienId());
//							tblQLDTDKMHLogMailBK.setGhiChu(tblQLDTDKMHLogMail.getGhiChu());
//							tblQLDTDKMHLogMailBK.setNoiDung(tblQLDTDKMHLogMail.getNoiDung());
//							tblQLDTDKMHLogMailBK.setNgayGui(d);
//							
//							tblQLDTDKMHLogMailBKService.createtblQLDTDKMHLogMailBK(tblQLDTDKMHLogMailBK);
//							
//							//xoa o bang cu
//							tblQLDTDKMHLogMailService.deletetblQLDTDKMHLogMail(tblQLDTDKMHLogMail.getId());
//							
//							ChumanoLogger.log(dateFormat.format(new Date()) + ": Hoc vien " + tblQLDTDKMHLogMail.getHocVienId().getMshv() + ": da gui");
//							//System.out.println(TblQLDTDKMHLogMail.getHocVienId().getEmail() + "da gui");
//						}else{
//							ChumanoLogger.log("Học viên không có email");
//						}
//						
//					} catch (Exception e) {
//						ChumanoLogger.log(dateFormat.format(new Date()) + ": Hoc vien " + tblQLDTDKMHLogMail.getHocVienId().getMshv()+ ": loi");
//						ChumanoLogger.log("ERROR: " + e.getMessage());
//						e.printStackTrace();						
//					}
//
//				}
//			}
//			ChumanoLogger.log(dateFormat.format(new Date()) + ": Ket thuc gui email tu dong: thanh cong");
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			ChumanoLogger.log(dateFormat.format(new Date()) + ": Ket thuc gui email tu dong: co loi trong qua trinh chay");
//			ChumanoLogger.log("ERROR: " + e1.getMessage());
//			e1.printStackTrace();
//		} 
//		ChumanoLogger.stop();
//	}
//
//}
