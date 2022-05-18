import static spark.Spark.*;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args){
        staticFiles.location("/public"); // Static files Directory for storing things like CSS and Images
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.html");
        }, new HandlebarsTemplateEngine());

        get("/reportAnimals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(new HashMap(), "reportAnimals.html");
        }, new HandlebarsTemplateEngine());

        post("/reportAnimals/Post", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputedRangerName= request.queryParams("rangerName"); // Gets the rangerName

            ranger.employeeList.add(new ranger(inputedRangerName));// posts a rangername to the employee list

            String reportedAnimalName =request.queryParams("animalSpotted");//Adds an animal selected from the dropdown to a variable for
            int reportedAnimalCount = Integer.parseInt(request.queryParams("animalCount")); // Sets the number of Animals spotted
            String reportedAnimalLocation = request.queryParams("animalLocation");


            Animals reportedAnimal= new Animals(0,"",0); // Creates a new reported animal object empty until set, see bellow

            reportedAnimal.setName(reportedAnimalName); // Sets reported animal name, based on dropdown selection
            reportedAnimal.setCount(reportedAnimalCount); // Sets reported animal name, based on ranger input
            reportedAnimal.setLocation(reportedAnimalLocation);// Sets report animal location, based on dropdown selection
            reportedAnimal.setReportedBy(inputedRangerName);// Sets ranger name as reportedBy property for reportedAnimal object

            connectionDao.addAnimals(reportedAnimal); // Posts reportedAnimal object to SQL server by calling method in connection DAO

            response.redirect("/reportAnimals");
            return null;
        });


        get("/animalsDataBaseView", (request,response) -> {
            List<Animals>animalsDataBaseList = connectionDao.displayReports();//Gets all animal objects in database using displayReports() Method
            Map<String,List<Animals>> model=new HashMap<>();
            model.put("animalsDataBase", animalsDataBaseList);
            return new ModelAndView(model,"dataBaseViewer.html");
        },new HandlebarsTemplateEngine());
    }
}
