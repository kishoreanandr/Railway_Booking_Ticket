
import java.util.Scanner;

public class  Railway_Booking_Main{
    static Ticket_Book tb=new Ticket_Book();


    public static void cancelTicket(int cancel_id){
        if(!tb.passenger_stored_data.containsKey(cancel_id)){
            System.out.println("Passenger id is not found!...");
        }
        else{
            tb.cancelTicket(cancel_id);
        }
    }



    public static void bookTicket(Passenger p){
        

        //-------------------- Checking wailting list OR Checking ticket availability ------  //
        if(Ticket_Book.aWL==0){
            System.out.println("!!!!!.......No Tickets Available...........!!!!!");
            return;
        }
        if(p.age>=60 && Ticket_Book.aLB>0){
            System.out.println("You're a senior citizen, so we arrange a Lower Berth!!...");
            tb.bookTicket(p, Ticket_Book.lBP.get(0), "L");
            Ticket_Book.lBP.remove(0);
            Ticket_Book.aLB--;
        }
        else if(p.cname!=null && p.cage<=5&& Ticket_Book.aLB>0 ){
            System.out.println("You have a child, so we arrange a Lower Berth!...");
            tb.bookTicket(p, Ticket_Book.lBP.get(0), "L");
            Ticket_Book.lBP.remove(0);
            Ticket_Book.aLB--;
        }

        //------------------- Berths ---------------//

        else if( (p.bp.equals("L") && Ticket_Book.aLB>0) || (p.bp.equals("M") && Ticket_Book.aMB>0 ) || (p.bp.equals("U") && Ticket_Book.aUB>0) )
        {
            
            if(p.bp.equals("L") && Ticket_Book.aLB>0){
                System.out.println("Lower Berth Given..");

                //this is for alloting the and subtracting from arraylist
                tb.bookTicket(p, (Ticket_Book.lBP.get(0)),"L") ;

                Ticket_Book.lBP.remove(0); //for confirming and remove the index or ticket booked

                Ticket_Book.aLB--; // decrement the available tickets
            }
            else if(p.bp.equals("M") && Ticket_Book.aMB>0) {
                
                System.out.println("Middle Berth Given..");

                tb.bookTicket(p, (Ticket_Book.mBP.get(0)), "M" );
                Ticket_Book.mBP.remove(0);
                Ticket_Book.aMB--;
            }
            else if(p.bp.equals("U") && Ticket_Book.aUB>0) {
                System.out.println("Upper Berth Given..");
                tb.bookTicket(p, (Ticket_Book.uBP.get(0)), "U") ;
                Ticket_Book.uBP.remove(0);
                Ticket_Book.aUB--;
            }
        }

        // Available Tickets //
        else if(Ticket_Book.aUB>0){
            System.out.println(" ...Upper Berth Given ...");
            tb.bookTicket(p, Ticket_Book.uBP.get(0),"U");
            Ticket_Book.uBP.remove(0);
            Ticket_Book.aUB--;
        }
        else if(Ticket_Book.aMB>0){
            System.out.println("...Middle Berth Given...");
            tb.bookTicket(p, Ticket_Book.mBP.get(0), "M");
            Ticket_Book.mBP.remove(0);
            Ticket_Book.aMB--;
        }
        else if(Ticket_Book.aLB>0){
            System.out.println(".... Lower Berth Given....");
            tb.bookTicket(p, Ticket_Book.lBP.get(0), "L");
            Ticket_Book.lBP.remove(0);
            Ticket_Book.aLB--;
        }
        else if(Ticket_Book.aRAC>0){
            System.out.println("..... !!..RAC GIVEN..!!....");
            tb.racTicket(p, Ticket_Book.racP.get(0), "RAC");
            Ticket_Book.racP.remove(0);
            Ticket_Book.aRAC--;
        }
        else if(Ticket_Book.aWL>0){
            System.out.println("...!!...Oops..!!..You are in Waiting List");
            tb.waitingLTicket(p, Ticket_Book.wlP.get(0), "WL");
            Ticket_Book.wlP.remove(0);
            Ticket_Book.aWL--;
        }
        
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("1. Book\n2. Cancel\n3. Available Tickets\n4. Booked Tickets\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice=scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name=scan.next();
                    System.out.println("Enter your age: ");
                    int age=scan.nextInt();
                    System.out.println("Enter your gender: [M,F]");
                    String gender=scan.next();  
                    if(gender.equals("F")){
                        System.out.println("Press\n1. If you have a child.\n2. If you don't have a child");
                        int cChoice=scan.nextInt();
                        if(cChoice==1){
                            System.out.println("Enter Child name: ");
                            String cname=scan.next();
                            System.out.println("Enter Child age: ");
                            int cage=scan.nextInt();
                            System.out.println("Enter your birth prefernce: [U,M,L]");
                            String bp=scan.next();
                            Passenger p=new Passenger(name,age,cname,cage,gender,bp);
                            bookTicket(p);
                        }
                    }else{
                    System.out.println("Enter your birth prefernce: [U,M,L]");
                    String bp=scan.next();
                    Passenger p=new Passenger(name, age, gender, bp); //passenger Details
                    bookTicket(p); //Ticket book and storing details
                    }
                    break;
                case 2:
                    System.out.println("Enter Passenger Id: ");
                    int cancel_id=scan.nextInt();
                    cancelTicket(cancel_id);
                    break;
                case 3:
                    System.out.println("===============  Available Tickets are ================");
                    tb.displayAvailableTickets();
                    break;
                case 4:
                    tb.displayBookedTickets();
                    break;
                case 5:
                    System.out.println("Thank You for visiting!...");
                    loop=false;
                    break;
                default:
                    System.out.println("Check the number you have entered...");
                    break;
            }
        }
        scan.close();
    }
}