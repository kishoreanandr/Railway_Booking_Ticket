import java.util.*;
public class Ticket_Book {

    //Booking tickets 
    static int aLB=2;
    static int aMB=1;
    static int aUB=1;
    static int aRAC=1;
    static int aWL=1;

    static List<Integer> lBP=new ArrayList<>(Arrays.asList(1,2));
    static List<Integer> mBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> uBP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> racP=new ArrayList<>(Arrays.asList(1));
    static List<Integer> wlP=new ArrayList<>(Arrays.asList(1));

    static Queue<Integer> wlList=new LinkedList<>();
    static Queue<Integer> racList=new LinkedList<>();
    static List<Integer> bookedTicketList=new ArrayList<>(); //for canceling purpose => storing Passenger id 

    //For storing multiple details
    Map<Integer,Passenger> passenger_stored_data=new HashMap<>();


    public void bookTicket(Passenger p,int snumber,String allotedBerth){
        p.seat_num=snumber;
        p.alloted=allotedBerth;
        passenger_stored_data.put(p.passengerId, p);
        bookedTicketList.add(p.passengerId); //for canceling purpose => storing Passenger id 
        System.out.println("Passenger Id: "+p.passengerId);
        System.out.println("Passenger Name: "+p.name);
        System.out.println("Passenger Age: "+p.age);
        System.out.println("Passenger Gender: "+p.gender);
        if(p.cname!=null){
            System.out.println("Child Name: "+p.cname);
            System.out.println("Child Age: "+p.cage);
        }
        System.out.println("Passenger Berth: "+snumber+" [ "+allotedBerth+ " ] ");
        System.out.println("---------------------------------- Booked Successfully -------------------------------");
    }

    public void racTicket(Passenger p,int snumber,String racBerth){
        p.seat_num=snumber;
        p.alloted=racBerth;
        passenger_stored_data.put(p.passengerId,p);
        racList.add(p.passengerId);
        System.out.println("Passenger Id: "+p.passengerId);
        System.out.println("Passenger Name: "+p.name);
        System.out.println("Passenger Age: "+p.age);
        System.out.println("Passenger Gender: "+p.gender);
        System.out.println("Passenger Berth: "+snumber+" [ "+racBerth+" ]");
        System.out.println("---------------------------------- RAC GIVEN-------------------------------");

    }

    public void waitingLTicket(Passenger p,int snumber,String WLBerth){
        p.seat_num=snumber;
        p.alloted=WLBerth;
        passenger_stored_data.put(p.passengerId,p);
        wlList.add(p.passengerId);
        System.out.println("Passenger Id: "+p.passengerId);
        System.out.println("Passenger Name: "+p.name);
        System.out.println("Passenger Age: "+p.age);
        System.out.println("Passenger Gender: "+p.gender);
        System.out.println("Passenger Berth: "+snumber+" [ "+ WLBerth +" ]");
        System.out.println("---------------------------------- You are in Wailting List -------------------------------");
    }

    // ======================== Available Tickets ===================================//
    public void displayAvailableTickets(){
        System.out.println("The Lower Berth Tickets is: "+aLB);
        System.out.println("The Middle Berth Tickets is: "+aMB);
        System.out.println("The Upper Berth Tickets is: "+aUB);
        System.out.println("The RAC Tickets is: "+aRAC);
        System.out.println("The Waiting List Tickets is:  "+aWL);
    }

    // ========================= Displaying Booked Tcikets============================ //
   
    // ========================= Displaying Booked Tickets ============================ //
public void displayBookedTickets() {

    if (passenger_stored_data.isEmpty()) {
        System.out.println("######### ===== No Tickets Booked!!.. ======== ########");
        return;
    }

    System.out.println("======================== Booked Passenger Details ========================");

    for (Passenger p : passenger_stored_data.values()) {
        System.out.println("Passenger Id: " + p.passengerId);
        System.out.println("Passenger Name: " + p.name);
        System.out.println("Passenger Age: " + p.age);
        System.out.println("Passenger Gender: " + p.gender);
        if(p.cname!=null){
            System.out.println("Child Name: "+p.cname);
            System.out.println("Child Age: "+p.cage);
        }
        System.out.println("Allotted Seat: " + p.seat_num + " [" + p.alloted + "]");
        
        // Display RAC or Waiting List status
        if ("RAC".equals(p.alloted)) {
            System.out.println("Status: RAC Passenger");
        } else if ("WL".equals(p.alloted)) {
            System.out.println("Status: Waiting List Passenger");
        } else {
            System.out.println("Status: Confirmed Passenger");
        }

        System.out.println("===================================================================");
    }
}

    //=========================== Cancel Ticket ===============================//

    public void cancelTicket(int cancel_id){
        Passenger p=passenger_stored_data.get(cancel_id);
        passenger_stored_data.remove(cancel_id);
        bookedTicketList.remove(cancel_id);
        int snumber=p.seat_num;
        System.out.println("-------------  Cancelled Successfully ---------");

        switch (p.alloted) {
            case "L":
                lBP.add(snumber);
                aLB++;
                break;
            case "M":
                mBP.add(snumber);
                aMB++;
                break;
            case "U":
                uBP.add(snumber);
                aUB++;
                break;
            default:
                System.err.println("Error in adding cancelled seat");
                break;
        }
        if(!racList.isEmpty()){

            Passenger passengerFromRAC=passenger_stored_data.get(racList.poll());
            int pracnumber=passengerFromRAC.seat_num;
            racP.add(pracnumber);
            racList.remove(passengerFromRAC.passengerId);
            aRAC++;
            
            if(!wlList.isEmpty()){
                Passenger passengerFromWl=passenger_stored_data.get(wlList.poll());
                int pwlnumber=passengerFromWl.seat_num;
                wlP.add(pwlnumber);
                wlList.remove(passengerFromWl.passengerId);
                
                passengerFromWl.seat_num=racP.get(0);
                passengerFromWl.alloted="RAC";
                racP.remove(0);
                racList.add(passengerFromWl.passengerId);
                aWL++;
                aRAC--;
            }
            Railway_Booking_Main.bookTicket(passengerFromRAC);
        }

        
    } 

}
