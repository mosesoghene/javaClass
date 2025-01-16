import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private final List<Booking> bookings = new ArrayList<>();

    public User(String username, String email, Booking booking) {
        this.username = username;
        this.email = email;
        this.bookings.add(booking);
    }


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Booking findBooking(String refID) {
        for (Booking booking : bookings) {
            if (booking.getUserID().equals(refID)) return booking;
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', Room Number(s)=" + getBookings() + "}";
    }

    public String getBookings() {
        return bookings.toString();
    }

    public void createBooking(String userID, String checkinDate, String checkoutDate) {
        this.bookings.add(new Booking(userID, checkinDate, checkoutDate));
    }
}