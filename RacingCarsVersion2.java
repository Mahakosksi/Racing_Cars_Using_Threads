package folder;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RacingCarsVersion2 extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    public int X1;
    public int Y1;
    public int X2;
    public int Y2;
    public int X3;
    public int Y3;
    public int X4;
    public int Y4;

    public ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {

        Car car1 = new Car(0, 80);
        Car car2 = new Car(0, 120);
        Car car3 = new Car(0, 165);
        Car car4 = new Car(0, 210);
        int x = car1.getX();
        int y = car1.getY();
        Y1 = y;
        X1 = x;
        int x2 = car2.getX();
        int y2 = car2.getY();
        Y2 = y2;
        X2 = x2;
        int x3 = car3.getX();
        int y3 = car3.getY();
        Y3 = y3;
        X3 = x3;
        int x4 = car4.getX();
        int y4 = car4.getY();
        Y4 = y4;
        X4 = x4;
        FlowPane box = new FlowPane();

        Label label1 = new Label("Car 1:");
        Label label2 = new Label("Car 2:");
        Label label3 = new Label("Car 3:");
        Label label4 = new Label("Car 4:");

        TextField f1 = new TextField("0");
        f1.setMaxWidth(50);
        f1.setMaxHeight(40);
        TextField f2 = new TextField("0");
        f2.setMaxWidth(50);
        f2.setMaxHeight(40);
        TextField f3 = new TextField("0");
        f3.setMaxWidth(50);
        f3.setMaxHeight(40);
        TextField f4 = new TextField("0");
        f4.setMaxWidth(50);
        f4.setMaxHeight(40);

        Line l1 = new Line(0, 80, 500, 80);

        Line l2 = new Line(0, 80, 0, 40);

        Line l3 = new Line(500, 80, 500, 40);

        Line l4 = new Line(0, 40, 500, 40);

        Line l5 = new Line(0, 85, 500, 85);

        Line l6 = new Line(0, 120, 0, 85);

        Line l7 = new Line(500, 120, 500, 85);

        Line l8 = new Line(0, 120, 500, 120);

        Line l9 = new Line(0, 165, 0, 125);

        Line l0 = new Line(0, 165, 500, 165);

        Line l01 = new Line(500, 165, 500, 125);

        Line l02 = new Line(0, 125, 500, 125);

        Line l03 = new Line(0, 210, 0, 170);

        Line l04 = new Line(0, 210, 500, 210);

        Line l05 = new Line(500, 210, 500, 170);

        Line l06 = new Line(0, 170, 500, 170);

        box.getChildren().addAll(label1, f1, label2, f2, label3, f3, label4, f4);
        box.setAlignment(Pos.CENTER);
        BorderPane pane1 = new BorderPane();
        BorderPane pane2 = new BorderPane();

        pane2.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l0, l01, l02, l03, l04, l05, l06);
        pane1.getChildren().addAll(car1, car2, car3, car4);

        pane1.getChildren().add(pane2);

        pane1.setTop(box);

        EventHandler<ActionEvent> eventHandler1 = e -> {
            X1 += 10;
            if (X1 >= 500) {
                X1 = 0;
            }
            car1.paintCar(X1, Y1);

        };
        EventHandler<ActionEvent> eventHandler2 = e -> {
            X2 += 10;
            if (X2 >= 500) {
                X2 = 0;
            }
            car2.paintCar(X2, Y2);

        };
        EventHandler<ActionEvent> eventHandler3 = e -> {
            X3 += 10;
            if (X3 >= 500) {
                X3 = 0;
            }
            car3.paintCar(X3, Y3);

        };
        EventHandler<ActionEvent> eventHandler4 = e -> {
            X4 += 10;
            if (X4 >= 500) {
                X4 = 0;
            }
            car4.paintCar(X4, Y4);

        };
        Timeline animation1 = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler1));
        animation1.setCycleCount(Timeline.INDEFINITE);

        Timeline animation2 = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler2));
        animation2.setCycleCount(Timeline.INDEFINITE);

        Timeline animation3 = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler3));
        animation3.setCycleCount(Timeline.INDEFINITE);

        Timeline animation4 = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler4));
        animation4.setCycleCount(Timeline.INDEFINITE);

        Scene scene = new Scene(pane1, 500, 210);
        list.addAll(f1.getText(), f2.getText(), f3.getText(), f4.getText());
        scene.setOnKeyPressed(event -> {

            if (event.getCode().equals(KeyCode.ENTER)) {

                list.add(0, f1.getText());
                list.add(1, f2.getText());
                list.add(2, f3.getText());
                list.add(3, f4.getText());

                new Thread(new ThreadControl(Integer.parseInt(list.get(0)), animation1)).start();
                new Thread(new ThreadControl(Integer.parseInt(list.get(1)), animation2)).start();
                new Thread(new ThreadControl(Integer.parseInt(list.get(2)), animation3)).start();
                new Thread(new ThreadControl(Integer.parseInt(list.get(3)), animation4)).start();

            }

        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Racing Cars");
        primaryStage.show();

    }

}
