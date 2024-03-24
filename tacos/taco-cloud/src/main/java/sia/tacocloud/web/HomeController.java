package sia.tacocloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")  // This annotation maps the method to handle GET requests for the root ("/") path
    public String home() {
        return "home"; // This is the logical view name, typically resolved by a view resolver
    }
}


/*
 * @Controller Annotation:

The @Controller annotation is used to mark the class as a Spring MVC controller. It indicates that this class will handle incoming HTTP requests.
@GetMapping("/") Annotation:

The @GetMapping("/") annotation is a shortcut for @RequestMapping(method = RequestMethod.GET, path = "/"). It specifies that the home() method will handle HTTP GET requests for the root ("/") path.
home() Method:

Yes, that's correct. In the context of @GetMapping("/"), the "/" refers to the root path of the web application, not the root package or directory structure of your Java classes.

When you annotate a method with @GetMapping("/"), it means that the method will handle HTTP GET requests for the root path of your web application. In other words, it's associated with the main context of your web application.

This method is the actual request-handling method. It returns a String that represents the logical view name. In Spring MVC, this logical view name is typically resolved to an actual view (HTML page, template, etc.) by a view resolver.
Return Value:

In this case, the method returns the string "home". This logical view name is then resolved to a Thymeleaf template or another view based on the configuration.
In a typical Spring Boot application, you would have Thymeleaf or another view technology configured, and "home" would be resolved to the actual HTML page to be rendered in response to the client's request.

Make sure that you have the necessary dependencies and configurations for Thymeleaf or your chosen view technology in your Spring Boot project for this example to work as intended.

 */
