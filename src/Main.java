import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner kb = new Scanner(System.in);
    public static List<Room> rooms = new ArrayList<>();
    public static String answer;
    public static boolean isGameOver = false;
    public static Room currentRoom;
    public static int secretRoomId;

    public static void main(String[] args) {

        secretRoomId = (new Random().nextInt(4) == 0) ? 1 : 0;

        rooms.add(new Room(1, "foyer", "You see a dead scorpion.", 2, -1, -1, -1));
        rooms.add(new Room(2, "frontroom", "You see a piano.", -1, 1, 4, 3));
        rooms.add(new Room(3, "library", "You see spiders.", 5, -1, 2, -1));
        rooms.add(new Room(4, "kitchen", "You see bats.", 7, -1, -1, 2));
        rooms.add(new Room(5, "dinningroom", "You see an empty box and the exit from the castle.", 9, 3, -1, -1));
        rooms.add(new Room(6, "vault", "You see 3 walking skeletons.", -1, -1, (7 + secretRoomId), -1));
        rooms.add(new Room(7, "parlor", "You see a treasure chest.", -1, 4, -1, 6));
        rooms.add(new Room(8, "secretroom", "You found a pile of gold! Congratulations!.", -1, -1, -1, 6));
        rooms.add(new Room(9, "exit", "You found the exit.", -1, 5, -1, -1));

        currentRoom = rooms.get(0);
        System.out.println("\nWELCOME TO DANIEL'S CASTLE!\n");

        while (!isGameOver) currentRoom = checkAnswer(currentRoom);

        System.out.println("\nGAME OVER\n\nThanks for playing!\n");
    }

    private static Room checkAnswer(Room currentRoom){
        boolean isValidAnswer = false;
        int nextRoomId = currentRoom.getId();
        String options = " Which direction do you want to go? ( ";

        if (currentRoom.getNorthtId() != -1) {
            options = options.concat("north ");
        }
        if (currentRoom.getSouthId() != -1) {
            options = options.concat("south ");
        }
        if (currentRoom.getEastId() != -1) {
            options = options.concat("east ");
        }
        if (currentRoom.getWestId() != -1) {
            options = options.concat("west ");
        }
        options = options.concat(")");
        /*if (currentRoom.getNorthtId() != -1) {
            options = options.concat(rooms.get(currentRoom.getNorthtId()).getName() + " ");
        }
        if (currentRoom.getSouthId() != -1) {
            options = options.concat(rooms.get(currentRoom.getSouthId()).getName() + " ");
        }
        if (currentRoom.getEastId() != -1) {
            options = options.concat(rooms.get(currentRoom.getEastId()).getName() + " ");
        }
        if (currentRoom.getWestId() != -1) {
            options = options.concat(rooms.get(currentRoom.getWestId()).getName() + " ");
        }
        options = options.concat(")");*/

        System.out.println(currentRoom.getMessage() + options);

        if (currentRoom.getId() == 9){
            isGameOver = true;
            return null;
        }

        while (!isValidAnswer){
            answer = kb.nextLine();

            if (options.contains(answer)) {
                isValidAnswer = true;
                switch (answer) {
                    case "north" : {
                        nextRoomId = currentRoom.getNorthtId();
                        break;
                    }
                    case "south" : {
                        nextRoomId = currentRoom.getSouthId();
                        break;
                    }
                    case "east" : {
                        nextRoomId = currentRoom.getEastId();
                        break;
                    }
                    case "west" : {
                        nextRoomId = currentRoom.getWestId();
                        break;
                    }
                    default: break;
                }
                for (Room room : rooms)
                    if (nextRoomId == room.getId())
                        return room;
            }
        }
        return currentRoom;
    }
}