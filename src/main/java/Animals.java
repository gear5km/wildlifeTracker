import java.util.ArrayList;

public class Animals {
    int id;
    String name;
    int count;
    String location;

    String reportedBy;

    String reportedAt;

    boolean isEndangered;

    static ArrayList<Animals> species = new ArrayList<>();

    public Animals (int id, String name, int count){
        this.id=id;
        this.name=name;
        this.count=count;
        this.location=location;
        this.reportedBy=reportedBy;
        this.isEndangered=false;
        species.add(this);
    }


    public int getid(){return id;}
    public String getName(){return name;}

    public int getCount(){return count;}
    public String getLocation(){return location;}

    public String getReportedBy(){return reportedBy;}
    public String getReportedAt(){return reportedAt;}

    public void setName(String name) {this.name = name;}
    public void setCount(int count) {this.count = count;}

    public void setLocation(String location) {this.location = location;}

    public void setReportedBy(String reportedBy) {this.reportedBy = reportedBy;}



    public static void setSpecies(ArrayList<Animals> species) {
        Animals.species = species;
    }

    public static ArrayList<Animals> getSpecies(){
        return species;
    }


    static ArrayList<Animals>dataList = new ArrayList<Animals>();


}
