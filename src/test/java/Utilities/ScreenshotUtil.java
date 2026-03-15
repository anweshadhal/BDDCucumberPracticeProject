package Utilities;
import Driver.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static Driver.DriverFactory.driver;

public class ScreenshotUtil {

    public static String folder;
    @Attachment(value = "Step Screenshot", type = "image/png")
    public static byte[] attachScreenshot(WebDriver driver){

        return ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    public static File takeScreenshot(String path, String ScreenshotName) throws IOException {
        String screenshotPath=null;
        File src=((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);
        screenshotPath=System.getProperty("user.dir")+"/target/Screenshots/"+path+"/"+ScreenshotName+"_screenshot.png";
        FileUtils.copyFile(src,new File(screenshotPath));
        return src;
    }

    public String Timestamp(){
        Instant nowutc=Instant.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").withZone(ZoneOffset.UTC);
        return formatter.format(nowutc);
    }

    public String createFolder(String Foldername)
    {
        Foldername = Foldername+Timestamp();
        String path=System.getProperty("user.dir")+"/target/Screenshots/"+Foldername;
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        else{
            System.out.println("Folder already created");
        }

        return Foldername;
    }

    public static void addScreenshotToAllureReport(String Foldername, String ScreenshotName) throws IOException {
        File file1=takeScreenshot(Foldername,ScreenshotName);
        Allure.addAttachment(ScreenshotName, FileUtils.openInputStream(file1));
    }
}
