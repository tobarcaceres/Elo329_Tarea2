import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;

import javafx.scene.control.Button;

public class Stage1 extends Application {
    @Override
    public void start(Stage primaryStage){
       List<String> args = getParameters().getRaw();   // this way we get access to program's arguments
        if (args.size() != 1){
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = null;
        try {
            in = new Scanner(new File(args.get(0)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File: " + args.get(0));
            System.exit(-1);
        }

        //Hacemos los eventhandlers


        House house = new House(in);
        in.close();
        Scene scene = new Scene(house, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("T2 Stage 1");
        primaryStage.show();

        /*WindowView lastWindowView = house.getLastWindowView();
        lastWindowView.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY){
                lastWindowView.startOpening();
             }
            if(e.getButton()== MouseButton.SECONDARY){
                lastWindowView.startClosing();
             }
        });*/
    }
    public static void main(String[] args) {
        launch(args);
    }
}
