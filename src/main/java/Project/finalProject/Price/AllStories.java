package Project.finalProject.Price;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllStories {
    @GetMapping("/all")
    public String allStories(){
        return "stories.html";
    }
}
