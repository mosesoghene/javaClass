public class Booking {
    private String userID;
    private String checkinDate;
    private String checkoutDate;

    public Booking(String userID, String checkinDate, String checkoutDate) {
        this.userID = userID;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public String getUserID() {
        return userID;
    }

    public String getCheckinDate() {
        return checkinDate;
    }
    public String getCheckoutDate() {
        return checkoutDate;
    }

}
