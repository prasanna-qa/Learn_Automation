package com.cosfa.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CharlesP {

	String charles_config="com.xk72.charles.gui.MainWithClassLoader";
    //static String charlesconfig = "/charles/CharlesConfig.xml";
	static String url="https://0.0.0.0";
    static String charlesRecord = "http://control.charles/recording/start";
    static String charlesSessionDownload = "http://control.charles/session/download";
    static String charlesStop = "http://control.charles/recording/stop";
    static String charlesSession="session.chls";
    static String new_file = "session_modified.chlsj";
    static String port="8888";

    


    public void startCharles() {
System.out.println("Charles -headless - config "+charles_config+" &");
       
    }
 public void charlesSessionStart() {
        System.out.println("curl -v -x "+url+":"+port+" "+charlesRecord);
    }
 public void downloadCharlesSession() throws InterruptedException {
     System.out.println("curl -o "+charlesSession+" -x "+url+":"+port+" "+charlesRecord);
 }

    public void stopCharles() {
       System.out.println("curl -v -x "+url+":"+port+" "+charlesStop);
    }

    public void converttoJson() throws InterruptedException {
       System.out.println("Charles Convert "+charlesSession+" "+new_file);

    }

   
    

    public void killCharlesSession() {
        
System.out.println("killall Charles");
    }

    public static void main(String args[]) throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin PC\\eclipse-workspace\\cosfa\\src\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
        CharlesP CharlesP = new CharlesP();
        CharlesP.startCharles();
        Thread.sleep(12000);
        CharlesP.charlesSessionStart();
        Thread.sleep(12000);
        driver.get("https://www.google.com");
        Thread.sleep(10000);
        CharlesP.downloadCharlesSession();
        Thread.sleep(12000); 
        CharlesP.stopCharles();
        Thread.sleep(12000);
        CharlesP.converttoJson();
        Thread.sleep(12000);
        CharlesP.killCharlesSession();
    }
}


//        try {
//
//
//
//            Process p = Runtime.getRuntime().exec("curl -v -x http://192.168.1.221:8888 http://control.charles/recording/start");
//
//
//            Process p1 = Runtime.getRuntime().exec("curl -o session.chls -x http://192.168.1.221:8888 http://control.charles/session/download");
//            p1.waitFor();
//            Thread.sleep(10000);
////            BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
////            String line = "";
////            while ((line = reader.readLine()) != null) {
////                System.out.println(line + "\n");
////            }
//            Process p2 = Runtime.getRuntime().exec("curl -v -x http://192.168.1.221:8888 http://control.charles/recording/stop");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
