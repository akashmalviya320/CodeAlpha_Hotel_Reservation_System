import java.util.Scanner;

 class HotelReservationSystem {

    private static Scanner scanner=new Scanner(System.in);
    private static Room[]rooms;

    //Starting our Hotel Reservation System
    void start(){
        assignRooms();
        boolean status=true;

        while (status){

            //This will call menu method again & again to show menu to the customer.
            displayMenu();
            //Accepting choice of customer.
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingInfo();
                    break;
                case 4:
                    status=false;
                    System.out.println("Thank you for using the hotel reservation system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void assignRooms(){
        rooms=new Room[5];
        rooms[0]=new Room("Single Room", 100);
        rooms[1]=new Room("Double Room", 150);
        rooms[2]=new Room("Deluxe Room", 200);
        rooms[3]=new Room("Suite", 300);
        rooms[4]=new Room("Penthouse", 500);
    }

    //This will show Menu.
    private static void displayMenu(){
        System.out.println("Hotel Reservation System Menu:");
        System.out.println("1. Search Rooms");
        System.out.println("2. Make Reservation");
        System.out.println("3. View Booking Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void searchRooms(){
        System.out.println("Available Rooms:");
        for(Room room:rooms){
            if(!room.isReserved()){
                System.out.println(room);
            }
        }
    }

    //Code to make reservation.
    private static void makeReservation(){
        System.out.print("Enter room number to reserve: ");
        int roomNumber=scanner.nextInt();
        
        if (roomNumber>=1 && roomNumber<=rooms.length){
            Room selectedRoom=rooms[roomNumber-1];
            if (!selectedRoom.isReserved()){
                selectedRoom.reserveRoom();
                System.out.println("Room reserved successfully!");
            } 
            else{
                System.out.println("Room is already reserved. Please select another room.");
            }
        } 
        else{
            System.out.println("Invalid room number.");
        }
    }

    //This will show booking informations
    private static void viewBookingInfo(){
        System.out.println("Booking Details:");
        for (Room room : rooms){
            if (room.isReserved()){
                System.out.println(room);
            }
        }
    }

    //Room Class to store detail about rooms
    private static class Room{
        private String type;
        private double price;
        private boolean reserved;

        
        public Room(String type,double price){
            this.type=type;
            this.price=price;
            this.reserved=false;
        }
        //method modifying availability of rooms
        public void reserveRoom(){
            this.reserved=true;
        }

        //method displaying availability of rooms
        public boolean isReserved(){
            return reserved;
        }

        //Overriding value of tostring() method.
        @Override
        public String toString(){
            return "Room Type: " +type+", Price: "+price+", Reserved: "+(reserved ? "Yes" : "No");
        }
    }
}


public class Task3 {
        public static void main(String[] args) {
            HotelReservationSystem obj=new HotelReservationSystem();

            //Starting Our Reservation System
            obj.start();
        }
    
}