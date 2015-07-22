package com.succez;
import java.io.*;   
import java.net.*;  
//    从网络获取图片到本地 
    public class lesson4 {  
    	static String ur1 = "http://www.baidu.c//badugo1.gif";  
        public static void lesson(String url,String fileName){  
        	try{
            byte[] btImg = getImageFromNetByUrl(url);  
            if(null != btImg && btImg.length > 0){  
                System.out.println("读取到：" + btImg.length + " 字节");  
              
                writeImageToDisk(btImg, fileName,url);  
            }else{  
                System.out.println("没有从该连接获得内容");  
            } 
            } catch (Exception e)
 		   {
            	e.printStackTrace();
 		  System.out.println("未知错误！");
    		   }
             
        }  
//        将图片写入到磁盘 
        public static void writeImageToDisk(byte[] img, String fileName,String url)throws Exception{  
             
                File file = new File("F:\\" + fileName);
                if (file.exists()) { // 如果F盘有相同的文件名字就把它删除。没有的话就新建。
        			file.delete();
        		}
                BufferedOutputStream fops=null;
                fops = new BufferedOutputStream(new FileOutputStream(file));  
                fops.write(img);  
                fops.flush();  
                if(fops!=null)fops.close();  
                System.out.println("图片已经写入到F盘");  
            } 
      
//        根据地址获得数据的字节流 
        public static byte[] getImageFromNetByUrl(String strUrl){  
            try {  
                URL url = new URL(strUrl);  
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
                conn.setRequestMethod("GET");  
                conn.setConnectTimeout(5 * 1000); 
                InputStream inStream=null;
                 inStream = conn.getInputStream();//通过输入流获取图片数据  
                byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
                if(inStream!=null)inStream.close(); 
                return btImg;  
            } catch (Exception e) {  
                e.printStackTrace();
                return null;
            }  
           
        }  
//        从输入流中获取数据 
        public static byte[] readInputStream(InputStream inStream) throws Exception{  
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
            byte[] buffer = new byte[1024];  
            int len = 0;  
            while( (len=inStream.read(buffer)) != -1 ){  
                outStream.write(buffer, 0, len);  
            }   
            return outStream.toByteArray();  
        }  
        public static void main(String[] args) {
        	String fileName = "百度.gif"; 
        	lesson( ur1,fileName);
    		
    	}
    }  

