package sonect.sonect;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Screenshot extends TestBase{
	
	public byte[] takeScreenshot() throws IOException {
	byte[] pngBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	File file2  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file2, new File("F:/Screenshot21.png"));
	return pngBytes;
	}
}
