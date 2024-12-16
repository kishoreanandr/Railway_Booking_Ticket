public class Passenger {

    //Passenger  details
    static int id=1;
    String name;
    int age;
    String gender;
    String bp;
    int passengerId=id++;
    String alloted;
    int seat_num;
    int cage;
    String cname;

    public Passenger(String name,int age,String gender,String bp) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.bp=bp;
        alloted=" ";
        seat_num=-1;
    }
    public Passenger(String name,int age,String cname,int cage,String gender,String bp){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.bp=bp;
        this.cname=cname;
        this.cage=cage;
        alloted=" ";
        seat_num=-1;
        
    }
    
}
