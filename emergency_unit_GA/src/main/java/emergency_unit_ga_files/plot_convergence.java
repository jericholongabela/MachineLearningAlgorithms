package emergency_unit_ga_files;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class plot_convergence extends Application {

    static XYChart.Series<Number, Number> series = new XYChart.Series<>();
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        xAxis.setLabel("Generation");
        yAxis.setLabel("Cost");
        lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);

        lineChart.getData().add(series);
        lineChart.setLegendVisible(false);
        lineChart.setCreateSymbols(true);

        Scene scene = new Scene (lineChart, 1020, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
