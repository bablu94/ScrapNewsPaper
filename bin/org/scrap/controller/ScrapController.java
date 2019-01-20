import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//creating RestController
@RestController
public class ScrapController {
	//Creating Service object
	@Autowired
	ScrapNewsPaperService paperService;
	
	//Creating RestApi 
	@RequestMapping(value="/rest/getscrapDetails")
	public void getHinduData(@RequestParam ScrapDTO scrapDTO)
	{
		//calling Service method
		scrapDTO=paperService.authordetails(scrapDTO);
		
		//returning  dto to the caller
		return scrapDTO
		
		
		
		}
     
		
	}

}
