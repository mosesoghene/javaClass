public class Room {
    private String refNumber;
    private String roomNumber;
    private String roomType;
    private String roomName;
    private boolean isAvailable;
    private double price;

    public Room(String roomName, String roomNumber, String roomType,  double price) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
        this.price = price;
        this.refNumber = setRefNumber();
    }

    private String setRefNumber() {
        return "REF-" + roomName + this.roomNumber;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }
}
