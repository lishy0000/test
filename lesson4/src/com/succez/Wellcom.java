package com.succez;
import java.io.*;   
import java.net.*;  
//    �������ȡͼƬ������ 
    public class Wellcom {  
    	
        public static void main(String[] args) {  
        	try{
            String url = "http://www.baidu.com/img/baidu_sylogo1.gif";  
            byte[] btImg = getImageFromNetByUrl(url);  
            if(null != btImg && btImg.length > 0){  
                System.out.println("��ȡ����" + btImg.length + " �ֽ�");  
                String fileName = "�ٶ�.gif";  
                writeImageToDisk(btImg, fileName);  
            }else{  
                System.out.println("û�дӸ����ӻ������");  
            } 
            } catch (Exception e)
 		   {
            	e.printStackTrace();
 		  System.out.println("δ֪����");
    		   }
             
        }  
//        ��ͼƬд�뵽���� 
        public static void writeImageToDisk(byte[] img, String fileName)throws Exception{  
             
                File file = new File("F:\\" + fileName);  
                BufferedOutputStream fops = new BufferedOutputStream(new FileOutputStream(file));  
                fops.write(img);  
                fops.flush();  
                fops.close();  
                System.out.println("ͼƬ�Ѿ�д�뵽F��");  
            } 
      
//        ���ݵ�ַ������ݵ��ֽ��� 
        public static byte[] getImageFromNetByUrl(String strUrl){  
            try {  
                URL url = new URL(strUrl);  
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
                conn.setRequestMethod("GET");  
                conn.setConnectTimeout(5 * 1000);  
                InputStream inStream = conn.getInputStream();//ͨ����������ȡͼƬ����  
                byte[] btImg = readInputStream(inStream);//�õ�ͼƬ�Ķ���������  
                return btImg;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return null;  
        }  
//        ���������л�ȡ���� 
        public static byte[] readInputStream(InputStream inStream) throws Exception{  
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
            byte[] buffer = new byte[1024];  
            int len = 0;  
            while( (len=inStream.read(buffer)) != -1 ){  
                outStream.write(buffer, 0, len);  
            }  
            inStream.close();  
            return outStream.toByteArray();  
        }  
    }  

