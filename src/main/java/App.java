import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFiles.location("/public"); // Static files Directory for storing things like CSS and Images



        get("/", (request, response) -> {

            return new ModelAndView(new HashMap(), "index.html");
        }, new HandlebarsTemplateEngine());

        get("/reportAnimals", (request, response) -> {
            ArrayList speciesList=Animals.getSpecies();
            Map<String, ArrayList<Animals>> model = new HashMap<String,ArrayList<Animals>>();
            model.put("animalSpecies", speciesList); //Gets the list of animal species from the animals class and binds it to "animalSpecies" handlebar
            return new ModelAndView(new HashMap(), "reportAnimals.html");
        }, new HandlebarsTemplateEngine());

        post("/reportAnimals/Post", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputedRangerName= request.queryParams("rangerName"); // Gets the rangerName

            ranger.employeeList.add(new ranger(inputedRangerName));// posts a rangername to the employee list

            String reportedAnimalName =request.queryParams("animalSpotted");//Adds an animal selected from the dropdown to a variable for
            int reportedAnimalCount = Integer.parseInt(request.queryParams("animalCount")); // Sets the number of Animals spotted
            String reportedAnimalLocation = request.queryParams("animalLocation");// Sets the location of the animal spotted




            Animals reportedAnimal= new Animals(0,"",0); // Creates a new reported animal object empty until set, see bellow

            reportedAnimal.setName(reportedAnimalName); // Sets reported animal name, based on dropdown selection
            reportedAnimal.setCount(reportedAnimalCount); // Sets reported animal name, based on ranger input
            reportedAnimal.setLocation(reportedAnimalLocation);// Sets report animal location, based on dropdown selection
            reportedAnimal.setReportedBy(inputedRangerName);// Sets ranger name as reportedBy property for reportedAnimal object

            connectionDao.addAnimals(reportedAnimal); // Posts reportedAnimal object to SQL server by calling method in connection DAO

            response.redirect("/reportAnimals");
            return null;
        });

        post("/reportEndangeredAnimals/Post", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputedRangerName= request.queryParams("rangerName"); // Gets the rangerName

            ranger.employeeList.add(new ranger(inputedRangerName));// posts a rangername to the employee list

            String reportedAnimalName =request.queryParams("animalSpotted");//Adds an animal selected from the dropdown to a variable for
            int reportedAnimalCount = Integer.parseInt(request.queryParams("animalCount")); // Sets the number of Animals spotted
            String reportedAnimalLocation = request.queryParams("animalLocation");// Sets the location of the animal spotted
            String reportedAnimalStatus =request.queryParams("animalStatus");// Sets the status of the (endangered) animal spotted
            String reportedAnimalAge = request.queryParams("animalage");// Sets the age of the (endangered) animal spotted


            endangeredAnimals reportedEndangeredAnimal= new endangeredAnimals(0,"",0,"","");// Creates a new reported animal object empty until set, see bellow

            reportedEndangeredAnimal.setName(reportedAnimalName); // Sets reported animal name, based on dropdown selection
            reportedEndangeredAnimal.setCount(reportedAnimalCount); // Sets reported animal name, based on ranger input
            reportedEndangeredAnimal.setLocation(reportedAnimalLocation);// Sets report animal location, based on dropdown selection
            reportedEndangeredAnimal.setReportedBy(inputedRangerName);// Sets ranger name as reportedBy property for reportedAnimal object
            reportedEndangeredAnimal.setAge(reportedAnimalAge);//Sets endangered animal health
            reportedEndangeredAnimal.setHealth(reportedAnimalStatus);//Sets endangered animal health

            connectionDao.addAnimals(reportedEndangeredAnimal); // Posts reportedAnimal object to SQL server by calling method in connection DAO

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
