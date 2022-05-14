import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args){
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/reportAnimals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(new HashMap(), "reportAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        post("/reportAnimals/Post", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputedRangerName= request.queryParams("rangerName"); // Gets the rangerName

            ranger.employeeList.add(new ranger(inputedRangerName));// posts a rangername to the employee list

            response.redirect("/reportAnimals");
            return null;
        });
    }
}
