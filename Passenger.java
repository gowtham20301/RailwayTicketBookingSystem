package TrainReservationSystem;

public class Passenger {
    public static int id=1;
    String name;
    int age;
    String brpr;
    int passengerId;
    String allotedBerth;
    int seatNo;
    Passenger(String n,int a,String b)
    {
        name=n;
        age=a;
        brpr=b;
        passengerId=id++;
        allotedBerth=" ";
        seatNo=-1;


    }
}
