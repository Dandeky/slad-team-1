package assignment;

public class HotelBookingSystem {

    public static void main(String[] args) throws InterruptedException {
        Thread loginThread = new Thread(new LoginProcess());
        loginThread.run();
        loginThread.join();
        Thread homepageThread = new Thread(new HomepageProcess());
        homepageThread.run();
        homepageThread.join();
    }

    static class LoginProcess implements Runnable {

        @Override
        public void run() {
            Login login = new Login();
        }
    }

    static class HomepageProcess implements Runnable {

        @Override
        public void run() {
            Homepage homepage = new Homepage();
        }
    }

    static class CreateBookingProcess implements Runnable {

        @Override
        public void run() {
            CreateBooking createBooking = new CreateBooking();
        }
    }
}
