package ch.dfr.address;
/**
 * Created by dfr on 02.11.2016.
 * This is the main app class
 */

import ch.dfr.address.model.Person;
import ch.dfr.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    // the data as an observable list of Persons
    private ObservableList<Person> personData = FXCollections.observableArrayList();


    /**
     * Constructor
     */
    public MainApp() {
        // add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Delbert", "Friesen"));
        personData.add(new Person("John", "Dyck"));
        personData.add(new Person("Maria", "Juarez"));
        personData.add(new Person("Josefina", "Erea"));
        personData.add(new Person("Peter", "Top"));
    }


    /**
     * Returns the data as an observable list of Persons
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    private void initRootLayout() {
        try {
            // load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            this.rootLayout = loader.load();

            // show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    private void showPersonOverview() {
        try {
            // load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = loader.load();

            // set person overview into center of the root layout.
            rootLayout.setCenter(personOverview);

            // give the controller access to the main app
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return Stage
     */
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
