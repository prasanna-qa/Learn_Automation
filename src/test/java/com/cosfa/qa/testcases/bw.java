package com.cosfa.qa.testcases;


	
	import java.io.File;
	import java.io.IOException;
	import java.net.Inet4Address;
	import java.net.UnknownHostException;
	 
	import net.lightbody.bmp.BrowserMobProxyServer;
	import net.lightbody.bmp.client.ClientUtil;
	import net.lightbody.bmp.core.har.Har;
	 
	import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	 
	 
	public class bw {
	    public static WebDriver driver;
	    public static BrowserMobProxyServer proxy;
	 
	   public static void main(String[] args){
	 
	       System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin PC\\eclipse-workspace\\cosfa\\brw\\chromedriver.exe");
	       proxy = new BrowserMobProxyServer();
	       proxy.start();
	 
	       Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
	       try {
	           String hostIp = Inet4Address.getLocalHost().getHostAddress();
	           seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
	           seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
	       } catch (UnknownHostException e) {
	           e.printStackTrace();
	       }
	 
	        DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
	        seleniumCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
	        ChromeOptions options = new ChromeOptions();
	        options.merge(seleniumCapabilities);
	        driver = new ChromeDriver(options);
	 
	       proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
	 
	 
	       try {
	 
	           proxy.newHar("google");
	 
	           driver.get("http://www.google.com");
	           driver.findElement(By.id("q")).click();
	           try {
	               Thread.sleep(10000);
	           } catch (InterruptedException e) {
	               e.printStackTrace();
	           }
	 
	           Har har = proxy.getHar();
	 
	           File harFile = new File("academy.har");
	           har.writeTo(harFile);
	 
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	        driver.quit();
	        proxy.stop();
	    }
	}


