package TrainReservationSystem;
import java.util.*;
public class TicketBooking {
  // TicketBooking tb= new TicketBooking();
    public static int alb=1;//21 Total seats available in Lower berth
    public static int amb=1;//21 Total seats availbale in Middle berth
    public static int aub=1;//21 Total seats available in Upper berth
    public static int arac=1;//18 Total seats available in RAC
    public static int awl=1;//10  Total seats available in Waiting list

    static List<Integer> lb= new ArrayList<>(Arrays.asList(1));
    static List<Integer> mb= new ArrayList<>(Arrays.asList(1));
    static List<Integer> ub= new ArrayList<>(Arrays.asList(1));
    static List<Integer> rac= new ArrayList<>(Arrays.asList(1));
    static List<Integer> wl= new ArrayList<>(Arrays.asList(1));

    static Queue<Integer> racList= new LinkedList<>();
    static Queue<Integer> wList= new LinkedList<>();

    static Map<Integer,Passenger> hm= new HashMap<Integer,Passenger>();
///Ticket booking function-----------------------------
    public void booking(Passenger p,String allotedBerth,int seatNumber)
    {
        p.allotedBerth= allotedBerth;
        p.seatNo= seatNumber;
        hm.put(p.passengerId,p);
        System.out.println("PassengerId " + p.passengerId);
        System.out.println("Name :" + p.name);
        System.out.println("Alloted Berth :" +p.seatNo+ p.allotedBerth);
        System.out.println("Your Ticket Booked Successfully");
        System.out.println("--------------------------------------");
        System.out.println();
    }
    //--------------------Add into Rac------------------------------
    public void addRac(Passenger p,String allotedBerth,int seatNo)
    {
          p.allotedBerth=allotedBerth;
          p.seatNo= seatNo;
          hm.put(p.passengerId,p);
          racList.add(p.passengerId);
        System.out.println("PassengerId " + p.passengerId);
        System.out.println("Name :" + p.name);
        System.out.println("Alloted Berth :" +p.seatNo+ p.allotedBerth);
        System.out.println(" Rac was Booked Successfully");
        System.out.println("-------------------------------------");
        System.out.println();
    }
    //---------------------Add into Waiting list--------------------
    public void addWl(Passenger p,String allotedBerth,int seatNo)
    {
        p.allotedBerth=allotedBerth;
        p.seatNo= seatNo;
        hm.put(p.passengerId,p);
        wList.add(p.passengerId);
        System.out.println("PassengerId " + p.passengerId);
        System.out.println("Name :" + p.name);
        System.out.println("Alloted Berth :" +p.seatNo+ p.allotedBerth);
        System.out.println("Your in waiting List");
        System.out.println("-------------------------------------");
        System.out.println();
    }
    //--------------------cancel Ticket-------------------------
      public void cancelTicket(int passengerId)
      {
          Passenger pp= hm.get(passengerId);
          hm.remove(passengerId);
          System.out.println("cancelled successfully----------------------");
          if(pp.allotedBerth.equals("L"))
          {
              TicketBooking.alb++;
              TicketBooking.lb.add(pp.seatNo);
          }
          else if(pp.allotedBerth.equals("M"))
          {
              TicketBooking.amb++;
              TicketBooking.mb.add(pp.seatNo);
          }
          else if(pp.allotedBerth.equals("U"))
          {
              TicketBooking.aub++;
              TicketBooking.ub.add(pp.seatNo);
          }

//============checking for any rac list is there========================================
          if(racList.size()>0) {
              Passenger racDetails = hm.get(racList.poll());
              int seatNum = racDetails.seatNo;
              rac.add(seatNum);
              racList.remove(racDetails.passengerId);
              arac++;

              if (wList.size() > 0) {
                  Passenger wlDetails = hm.get(wList.poll());
                  wl.add(wlDetails.seatNo);
                  wList.remove(wlDetails.passengerId);//remove(racList.poll());

                 // addRac(wlDetails, "RAC", rac.get(0));
                  wlDetails.seatNo=rac.get(0);
                  wlDetails.allotedBerth="RAC";
                  rac.remove(0);
                  racList.add(wlDetails.passengerId);

                  awl++;
                  arac--;

              }
              Main.bookCheck(racDetails);
          }
      }
      //---------------------Print all booked Ticket Details-------------------
        public void printAllDetails() {
            if (hm.size() == 0) {
                System.out.println("No Ticket Details are available ");

            } else {
                for (Passenger p : hm.values()) {
                    System.out.println("PassegerId : " + p.passengerId);
                    System.out.println("Name : " + p.name);
                    System.out.println("Age : " + p.age);
                    System.out.println("Alloted : " + p.seatNo + p.allotedBerth);
                    System.out.println("--------------------------------------------------");

                }
            }
        }
        //--------------------Print Available Tickets------------------------
    public void AvailableTickets()
    {
        System.out.println("Available ticket details :");
        System.out.println("Lower berth " + alb);
        System.out.println("Middle berth " + amb);
        System.out.println("Upper berth "+  aub);
        System.out.println("RAC Ticket " +  arac);
        System.out.println("WL Ticket "  +   awl);
        System.out.println("--------------------------------------------------");
    }

}