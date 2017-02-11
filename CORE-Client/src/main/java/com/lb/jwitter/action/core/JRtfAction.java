package com.lb.jwitter.action.core;
//package com.lb.jwitter.action.util;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
//
//import com.lb.jwitter.service.TblCanBo;
//import com.lb.jwitter.util.AbstractRTFUseCase;
//
//import net.sourceforge.rtf.RTFTemplate;
//import net.sourceforge.rtf.helper.RTFTemplateBuilder;
//import net.sourceforge.rtf.template.IContext;
//
//
//
//
///**
// * This is a test suite in which all kinds of RTF functionality are tested
// * with RtfWriter and RtfWriter2.
// * 
// * @author Mark Hall
// */
//
//
//public class JRtfAction extends AbstractRTFUseCase {
//
//    public JRtfAction(String outDirectory) {
//        super(outDirectory);
//    }
//	/**
//	 * Creates 2 RTF files with the same content, but using different Writers.
//	 * 
//	 * @param args no arguments needed
//	 */
//
//	  
//    protected void putContext(IContext context) {
//        
//        List listOfString = new ArrayList();
//        listOfString.add("value 1");
//        listOfString.add("value 2");            
//        context.put("list", listOfString );
//		  
//		  List tblCanBos = new ArrayList();
//		  for(int i=0; i <4; i++){
//
//			  TblCanBo canBo = new TblCanBo();
//			  canBo.setTen("Viet thứ" + i);
//			  canBo.setDienThoai("SDT thứ" + i);
//			  tblCanBos.add(canBo); 
//		  }
//
//        context.put("canbos", tblCanBos );        
//        
//    }
//    
//	public boolean execute(String rtfSource, String outDirectory) throws Exception {
//		try{
//
//			if(rtfSource == null || rtfSource.equals(""))
//				rtfSource = "./template/rtftemplate/models/loop/loop.rtf";
//
//			if(outDirectory == null || outDirectory.equals(""))
//				outDirectory = "./template/rtftemplate/models/loop";
//		        
////		    JRtfAction usecase = new JRtfAction(outDirectory);
////		    usecase.saveTransformedDocument(true); // Save RTF file with velocity macro
//		    super.run(rtfSource);
//		    
//		    return true;
//
//		
////		return Action.SUCCESS; 
//		}catch(Exception e){
//			 e.printStackTrace(); 
//			 return false; 
//		}
//	}
//    
////	  public static void main( String[] args ) throws Exception {
////		try{
////
////				String rtfSource = "./template/rtftemplate/models/loop/loop.rtf";
////				String outDirectory = "./template/rtftemplate/models/loop";
////		        
////		    JRtfAction usecase = new JRtfAction(outDirectory);
//////		    usecase.saveTransformedDocument(true); // Save RTF file with velocity macro
////		    usecase.run(rtfSource);
////		    
////		}catch(Exception e){
////			 e.printStackTrace(); 
////		}
////	}
//}