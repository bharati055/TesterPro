package pageObject;
import org.openqa.selenium.WebElement;
import elementRepository.ElementFactory;
import utility.Log;

public class SampleTestPage{
   //Page object method for - btn_sample
   public WebElement btn_sample(){
     Log.info("Element Page Object >> btn_sample");
     return ElementFactory.getElement("btn_sample");
   }

   //Page object method for - txt_sample
   public WebElement txt_sample(){
     Log.info("Element Page Object >> txt_sample");
     return ElementFactory.getElement("txt_sample");
   }

}
