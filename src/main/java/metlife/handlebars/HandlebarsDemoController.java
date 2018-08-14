package metlife.handlebars;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jknack.handlebars.Template;

import metlife.handlebars.helpers.HandlebarsDemoTemplateLoader;
import metlife.handlebars.helpers.HelloHelper;

@RestController
@RequestMapping("/")
public class HandlebarsDemoController {

	@Autowired
	private HandlebarsDemoTemplateLoader handlebarsDemoTemplateLoader;
	
	@RequestMapping(value="/home", method=RequestMethod.GET, produces="text/html")
	public String getHomeTemplate(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		HelloHelper helloHelper=new HelloHelper();
		String respString=helloHelper.readFileAsString();		
		JsonNode jsonNode = new ObjectMapper().readValue(respString, JsonNode.class);
		Template template = handlebarsDemoTemplateLoader.getTemplate("home");
		
		return template.apply(handlebarsDemoTemplateLoader.getContext(jsonNode));
	}
}
