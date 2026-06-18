package dao;

public class TestConnection {

    public static void main(String[] args) {

        if (DBContext.getConnection() != null) {

            System.out.println("Connected");

        } else {

            System.out.println("Failed");
        }

    }
}