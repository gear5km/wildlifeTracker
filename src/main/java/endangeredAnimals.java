public class endangeredAnimals extends Animals {
    int age;    // newborn, young, adult
    String health;  //healthy,okay,ill



    public endangeredAnimals (int id, String name, int count,int age, String health){
        super(id,name,count);
        this.id=id;
        this.name=name;
        this.count=count;
        this.isEndangered=true;
        this.age=age;
        this.health= health;
    }

    public int getAge(){return age;}
    public void setAge(int age) {this.age = age;}
    public String getHealth(){return health;}
    public void setHealth(String health) {this.health = health;}




    public static final int MAX_HEALTH=3;

}
