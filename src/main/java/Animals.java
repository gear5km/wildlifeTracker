import java.util.ArrayList;

public class Animals {
    int id;
    String name;
    int count;
    String location;

    String reportedBy;

    String reportedAt;

    public Animals (int id, String name, int count){
        this.id=id;
        this.name=name;
        this.count=count;
        this.location=location;
        this.reportedBy=reportedBy;
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


    static ArrayList<Animals>dataList = new ArrayList<Animals>();

}
