package com.cn.zhou.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/upAndDown")
public class UpAndDownController {
	@RequestMapping("/showUpload") 
	public String showUpload(){
		return "upload";
	}
	
	@RequestMapping("/showDownload") 
	public String showDownload(){
		return "download";
	}
	
	@RequestMapping("/upload")  
    public String upload(@RequestParam MultipartFile[] myfiles,HttpServletRequest request) throws IOException {  
        for(MultipartFile file : myfiles){     
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了  
            if(file.isEmpty()){   
                System.out.println("文件未上传!");  
            }  
            else{  
                //得到上传的文件名  
                String fileName = file.getOriginalFilename();  
                //得到服务器项目发布运行所在地址  
                String path1 = request.getSession().getServletContext().getRealPath("WEB-INF/image")+File.separator; 
                System.out.println(path1);
                //  此处未使用UUID来生成唯一标识,用日期做为标识  
                String path = path1+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ fileName;
   
                //查看文件上传路径,方便查找  
                System.out.println(path);  
                //把文件上传至path的路径  
                File localFile = new File(path);
                if(localFile.exists()){
                	System.out.println("存在");
                }
                //此处的file是上传的file，通过该方法转存到制定文件夹中
                file.transferTo(localFile);  
                }  
            }  
        return "uploadSuccess";  
    }
	
	@RequestMapping("/download")  
	   public String download(String fileName, HttpServletRequest request,  
	           HttpServletResponse response) {  
	       response.setCharacterEncoding("utf-8");  
	       response.setContentType("multipart/form-data");  
	       response.setHeader("Content-Disposition", "attachment;fileName="  
	               + fileName);  
	       try {  
	           String path = request.getSession().getServletContext().getRealPath  
	                   ("WEB-INF/image")+File.separator;  
	           System.out.println(path);
	           InputStream inputStream = new FileInputStream(new File(path  
	                   + fileName));  
	 
	           OutputStream os = response.getOutputStream();  
	           byte[] b = new byte[2048];  
	           int length;  
	           while ((length = inputStream.read(b)) > 0) {  
	               os.write(b, 0, length);  
	           }  
	 
	            // 这里主要关闭。  
	           os.close();  
	 
	           inputStream.close();  
	       } catch (FileNotFoundException e) {  
	           e.printStackTrace();  
	       } catch (IOException e) {  
	           e.printStackTrace();  
	       }  
	           //  返回值要注意，要不然就出现下面这句错误！  
	           //java+getOutputStream() has already been called for this response  
	       return null;  
	   } 
	
}
