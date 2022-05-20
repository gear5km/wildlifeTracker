import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class connectionDao implements animalsDao{
    //@Override
    public static void addAnimals(Animals newAnimalReport) {
        //Sql2o sql2o = new Sql2o("jdbc:postgresql://127.0.0.1:5432/wildlife_tracker", "postgres", "Dabosskimani1");// sql2o object that manages the(LOCAL) conncetion to database
        Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-165-184-219.compute-1.amazonaws.com:5432/d1boqhjufs16fj", "postgres", "Dabosskimani1");// sql2o object that manages the(LOCAL) conncetion to database
        String sql = "INSERT INTO sightings (name, location, count, reportedby, reportedat) VALUES (:name, :location, :count, :reportedBy, now())"; // SQL instructions to be executed upon connection to database
        try (Connection con = sql2o.open()) { //binds variable to sql2o open sql communication with database
            int id = (int) con.createQuery(sql, false)// Runs a Query using the input in the sql variable- INSERT INTO ...
                    //.addParameter("name",matchNameInput)// Binds name parameter with matchNameInput Variable
                    //.addParameter("location",matchLocInput)// Binds name parameter with matchNameInput Variable

                    .bind(newAnimalReport) //use name and location from match object for sql
                    .executeUpdate()// Runs the Query
                    .getKey();//Gets the row number of the Data inputed
            //newAnimalReport.setId(id);
            if (con != null) {
                System.out.println("We Connected to the database kim!");
            }else {
                System.out.println("Failed to connect!");
            }
        } catch (Sql2oException e) {
            System.out.println("there was a problem adding the report");
            System.err.format(e.getMessage());
        }

    }

    public static List<Animals> displayReports() {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://127.0.0.1:5432/wildlife_tracker", "postgres", "Dabosskimani1");
        try (Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Animals.class);
        }
    }
}
