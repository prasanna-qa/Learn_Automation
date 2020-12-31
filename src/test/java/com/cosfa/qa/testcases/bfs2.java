     package com.cosfa.qa.testcases;
import java.io.File;
import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.ArrayList;
    import net.lightbody.bmp.BrowserMobProxy;
    import net.lightbody.bmp.BrowserMobProxyServer;
    import net.lightbody.bmp.core.har.Har;
    import net.lightbody.bmp.proxy.CaptureType;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.phantomjs.PhantomJSDriver;
    import org.openqa.selenium.phantomjs.PhantomJSDriverService;
    import org.openqa.selenium.remote.CapabilityType;
    import org.openqa.selenium.remote.DesiredCapabilities;
    public class bfs2 {
        public static void main(String[] args) throws IOException, InterruptedException {
            //BrowserMobProxy
            BrowserMobProxy server = new BrowserMobProxyServer();
            server.start(0);
            server.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
            server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
            server.newHar("Google");
            //PHANTOMJS_CLI_ARGS
            ArrayList<String> cliArgsCap = new ArrayList<String>();
            cliArgsCap.add("--proxy=localhost:"+server.getPort());
            cliArgsCap.add("--ignore-ssl-errors=yes");
            //DesiredCapabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"C:\\phantomjs.exe");
            //WebDriver
            WebDriver driver = new PhantomJSDriver(capabilities);
			driver.get("https://www.google.co.in");
            //HAR
            Har har = server.getHar();
            File fos = new File("HAR-Information.har");
            har.writeTo(fos);
            
            server.stop();
        }
    }