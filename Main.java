package TrainReservationSystem;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void bookCheck(Passenger p)
    {
        TicketBooking tb= new TicketBooking();
        if(TicketBooking.awl==0) {
            System.out.println("Tickets are full, No tickets are available");
            return;
        }
        //if(p.brpr.equals("L") && TicketBooking.alb>0 || p.brpr.equals("M")&& TicketBooking.amb>0
        //|| p.brpr.equals("U") && TicketBooking.aub>0) {
            if (p.brpr.equals("L") && TicketBooking.alb > 0) {
                System.out.println("Lower Berth Given-------");
                tb.booking(p, "L", TicketBooking.lb.get(0));
                TicketBooking.alb--;
                TicketBooking.lb.remove(0);
            } else if (p.brpr.equals("M") && TicketBooking.amb > 0) {
                System.out.println("Middle Berth Given---------");
                tb.booking(p, "M", TicketBooking.mb.get(0));
                TicketBooking.amb--;
                TicketBooking.mb.remove(0);
            } else if (p.brpr.equals("U") && TicketBooking.aub > 0) {
                System.out.println("Upper Berth Given------------");
                tb.booking(p, "U", TicketBooking.ub.get(0));
                TicketBooking.aub--;
                TicketBooking.ub.remove(0);

            }
        //}
        else if(TicketBooking.alb>0)
        {
            System.out.println("Lower berth is Given-----------");
            tb.booking(p,"L",TicketBooking.lb.get(0));
            TicketBooking.alb--;
            TicketBooking.lb.remove(0);

        }
        else if(TicketBooking.amb>0)
        {
            System.out.println("Middle berth is Given--------");
            tb.booking(p,"M",TicketBooking.mb.get(0));
            TicketBooking.amb--;
            TicketBooking.mb.remove(0);
        }
        else if(TicketBooking.aub>0)
        {
            System.out.println("Upper berth is Given------");
            tb.booking(p,"U",TicketBooking.ub.get(0));
            TicketBooking.aub--;
            TicketBooking.ub.remove(0);
        }
        //For rac booking Check-----------
        else if(TicketBooking.arac>0)
            {
               // System.out.println("RAC is Given--------");
                tb.addRac(p,"RAC",TicketBooking.rac.get(0));
                TicketBooking.arac--;
                TicketBooking.rac.remove(0);

            }
        else if(TicketBooking.awl>0)
            {
               // System.out.println("Your in Waiting List-------");
                tb.addWl(p,"WL",TicketBooking.wl.get(0));
                TicketBooking.awl--;
                TicketBooking.wl.remove(0);
            }
    }
    //----------------cancel ticket checking----------------
       public static void cancelCheck(int id)
       {
         TicketBooking tb= new TicketBooking();
           if(!TicketBooking.hm.containsKey(id))//check the Id is valid or not
           {
                  System.out.println("Invalid passenge Id");
           }
           else {

               tb.cancelTicket(id);
           }
       }



    //--------------------------------------------------------
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
            System.out.println("----------------------------------------------------");
            System.out.println("Press \n 1: Book Ticket \n 2:Cancel Ticket \n 3:Booked Ticket Details" +
                    "\n 4:Available Tickets ");
            System.out.print("\n Please enter your choice :  ");
            int choice= sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Please Enter your name :");
                    String name=sc.next();
                    System.out.println("Enter your age :");
                    int age=sc.nextInt();
                    System.out.println("Berth Preference you want L,M,U ?");
                    String berthPreference=sc.next();
                    Passenger p= new Passenger(name,age,berthPreference);
                    System.out.println();
                    bookCheck(p);
                    break;
                }
                case 2:
                {
                    System.out.println("Please enter your passenger Id");
                    int id=sc.nextInt();
                    cancelCheck(id);
                    break;
                }
                case 3:
                {
                    TicketBooking tb= new TicketBooking();
                    tb.printAllDetails();
                    break;
                }
                case 4:
                {
                    TicketBooking tb= new TicketBooking();
                    tb.AvailableTickets();
                    break;
                }
                case 5: {
                    loop = false;
                    break;
                }
            }
        }
    }
}
