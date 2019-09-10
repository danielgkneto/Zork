public class Room {
    private int id;
    private String name;
    private String message;
    private int northtId;
    private int southId;
    private int eastId;
    private int westId;

    public Room(int id, String name, String message, int northtId, int southId, int eastId, int westId) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.northtId = northtId;
        this.southId = southId;
        this.eastId = eastId;
        this.westId = westId;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNorthtId() {
        return northtId;
    }

    public void setNorthtId(int northtId) {
        this.northtId = northtId;
    }

    public int getSouthId() {
        return southId;
    }

    public void setSouthId(int southId) {
        this.southId = southId;
    }

    public int getEastId() {
        return eastId;
    }

    public void setEastId(int eastId) {
        this.eastId = eastId;
    }

    public int getWestId() {
        return westId;
    }

    public void setWestId(int westId) {
        this.westId = westId;
    }
}