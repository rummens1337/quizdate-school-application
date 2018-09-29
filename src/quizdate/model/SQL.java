package quizdate.model;

import java.sql.*;

public class SQL {

    private static Connection connection;
    private static final int START_ID = 1000;

    public SQL() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://oege.ie.hva.nl:3306/zhadiyem?useUnicode=true&useJDBCCompliantTimezoneShift" +
                        "=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "hadiyem", "F+OYAvrrsj26nQ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

//
//    private static int getAvailableUserId() {
//
//        int id = START_ID;
//        boolean status = false;
//
//        try {
//            do {
//                Statement statement = connection.createStatement();
//                ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Account WHERE userId = " + id);
//                rs.next();
//                int value = rs.getInt(1);
//                if (value == 1) {
//                    ++id;
//                } else {
//                    status = true;
//                }
//
//            } while (!status);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return id;
//
//    }

    public boolean checkLoginInformation(String email, String password) {
        boolean status = false;

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Account WHERE email ='" + email + "' AND password ='" + password + "'");
            rs.next();
            int value = rs.getInt(1);
            if (value == 1) {
                status = true;
            } else {
                status = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;

    }

    // grabs a random userId from the database
    public int getRandomId() {

        int data = 1;
        try {
            Statement statement = connection.createStatement();
            ResultSet back = statement.executeQuery("SELECT userId FROM Account ORDER BY RAND() LIMIT 1");
            back.next();
            data = back.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;

    }

    public boolean saveUser(User user) {

        boolean status = false;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Account (email, password, lastName, firstName, dateOfBirth," +
                    " sex, phoneNumber, adres) VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getLastName() + "', '" +
                    user.getFirstName() + "', '" + user.getDateOfBirth() + "', '" + user.getSex() + "', '" +
                    user.getPhoneNumber() + "', '" + user.getAdres() + " ' )");
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;

    }

    public void getUser(int userId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Account WHERE userId = " + userId);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //RETURN USER
    }


    public void deleteUser(int userId) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Account WHERE userId = '" + userId + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean getUser() {
        boolean status = false;

        return status;
    }


}