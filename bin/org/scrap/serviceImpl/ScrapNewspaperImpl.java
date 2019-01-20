import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


@Service
public class ScrapNewspaperImpl implements ScrapNewsPaperService {
	
	@Autowired
	private ScrapDTO scrapDTO;
	
	@Override
	public ScrapDTO authordetails(ScrapDTO scrapDTO) {
		
		String author=scrapDTO.getAuthoralldata();
		String searchinput=null;
		
		//Creating webclint object
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {  
			//cheaking Input details are not null
			if(scrapDTO!=null){
			//passing i/p into url	
		  String searchUrl = "https://www.thehindu.com/archive/search/sss?sort=rel&query=" + URLEncoder.encode(scrapDTO.getAuthoralldata(), "UTF-8");
		  HtmlPage page = client.getPage(searchUrl);
		  //getting details from url
		  List<HtmlElement> scrapes = (List<HtmlElement>) page.getByXPath("//p[@class='author']" );  
		  //ckecking scrapes are not empty
		  if(scrapes.isEmpty()){  
		    System.out.println("No items found !");
		  }else{
			  //iterating items
		  for(HtmlElement htmlItem : scrapes){  
		    HtmlAnchor itemAnchor =  ((HtmlAnchor) htmlItem.getFirstByXPath(".//a"));
		    //setting data into variables
		    String authName = itemAnchor.asText();
		    String itemUrl = itemAnchor.getHrefAttribute() ;
		    String authdetails=itemAnchor.getId();
		    
		   
		    //passing input data into htmlitem and filter data
		    HtmlElement deatils =((HtmlElement) htmlItem.getFirstByXPath(".//span[@class='author']")) ;
		    scrapDTO.setAuthor(authName);
		    scrapDTO.setTitle(itemUrl);
		   
		    //return scrapDTO;
		    
		    
		    }
		  }
			}
			
			
		}catch(Exception e){
		  e.printStackTrace();
		}
		
		return scrapDTO;
	}

}
