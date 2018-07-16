package com.kb.struts;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kb.ExportDB;
 

/**
 * Servlet implementation class AddSingerServ
 */

public class AddSingerServ extends Action {
   

    private String singer_name;
    private String singer_py;
 
    public String getSinger_py() {
		return singer_py;
	}

	public void setSinger_py(String singer_py) {
		this.singer_py = singer_py;
	}

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}

	/**
     * 上传数据及保存文件
	 * @throws UnsupportedEncodingException 
     */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		
        // 检测是否为多媒体上传
     
		LoginActionFrom laf=(LoginActionFrom)form;
		singer_name=laf.getSinger_name();
		singer_py=laf.getSinger_py();
		singer_name=new String(singer_name.trim().getBytes("ISO-8859-1"), "UTF-8"); 
		singer_py=new String(singer_py.trim().getBytes("ISO-8859-1"), "UTF-8"); 

		
		
		
           ExportDB.insert_singer(singer_name, singer_py);
                        
  
     
           return mapping.findForward("delsuccess");
			
    }
}
