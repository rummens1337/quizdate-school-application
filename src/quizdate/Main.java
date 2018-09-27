package quizdate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("QuizDater");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        LocalDate inputDate = LocalDate.of(2000,1,31);
        LocalDate inputDat = LocalDate.of(2010,3,4);
        LocalDate inputDa = LocalDate.of(2001,5,23);
        User u1 = new User("Vonk", "Robin", inputDate, "Male", "robin", "69","Hoorn");
        User u2 = new User("Rummens", "Michel", inputDat, "Male", "robin", "42","Hoorn2");
        User u3 = new User("Bootje", "Mootje", inputDa, "Male", "robin", "1337","Hoorn3");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        Match m = new Match();
        u1.addToLiked(u2.getUserId());
        u2.addToLiked(u1.getUserId());
        u1.addToLiked(u3.getUserId());
        u3.addToLiked(u1.getUserId());
        m.acceptMatch(u1,u2);
        m.acceptMatch(u1,u3);
        System.out.println(u1.getMatches());
        System.out.println(u2.getMatches());
        m.removeMatch(u1,u2);
        System.out.println(u1.getMatches());
        System.out.println(u2.getMatches());
        SQL db = new SQL();
        System.out.println(db.getRandomId());
        System.out.println(db.getRandomId());
        System.out.println(db.getRandomId());
        System.out.println(db.getRandomId());
        System.out.println(db.getRandomId());
        System.out.println(db.getRandomId());
        launch(args);
    }

}
