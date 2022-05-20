public class endangeredAnimals extends Animals {
    String age;    // newborn, young, adult
    String health;  //healthy,okay,ill



    public endangeredAnimals (int id, String name, int count,String age, String health){
        super(id,name,count);
        this.id=id;
        this.name=name;
        this.count=count;
        this.isEndangered=true;
        this.age=age;
        this.health= health;
    }

    public String getAge(){return age;}
    public void setAge(String age) {this.age = age;}
    public String getHealth(){return health;}
    public void setHealth(String health) {this.health = health;}




    public static final int MAX_HEALTH=3;

}
