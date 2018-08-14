package metlife.handlebars;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {/*

	@Autowired
	private HandlebarsDemoTemplateLoader handlebarsDemoTemplateLoader;
    @RequestMapping("/")
    public String index(Model model) throws JsonParseException, JsonMappingException, IOException {
    	HelloHelper helloHelper=new HelloHelper();
    	String respString=helloHelper.readFileAsString();
    	JsonNode jsonNode = new ObjectMapper().readValue(respString, JsonNode.class);
        model.addAttribute("objects",jsonNode );
        Template template = handlebarsDemoTemplateLoader.getTemplate("home2");
		
		 template.apply(handlebarsDemoTemplateLoader.getContext(jsonNode));
		 return "home2";
    }

*/}