package ch.dfr.address.view;

import ch.dfr.address.MainApp;
import ch.dfr.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by dfr on 02.11.2016.
 */
public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // reference to the main application
    private MainApp mainApp;


    /**
     * The constructor
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {}


    /**
     * Initializes the controller class. The method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize(){
        // initialize the person table with the two columns
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }


    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp){

        this.mainApp = mainApp;

        // add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
}
