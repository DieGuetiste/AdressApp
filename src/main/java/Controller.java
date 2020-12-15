import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.stream.Collectors;

public class Controller {
    public ListView lv_entries;
    public TextField tf_firstname;
    public TextField tf_lastname;
    public TextField tf_street;
    public TextField tf_plz;
    public TextField tf_city;
    public TextField tf_email;
    public TextField tf_filter;
    public ListView lv_filtered;
    private Model myModel;

    public void setMyModel(Model myModel) {
        this.myModel = myModel;
        lv_entries.setItems(myModel.entries);
    }

    public void saveAdd(ActionEvent actionEvent) {
        String firstname = tf_firstname.getText();
        String lastname = tf_lastname.getText();
        String street = tf_street.getText();
        int plz = Integer.parseInt(tf_plz.getText());
        String city = tf_city.getText();
        String email = tf_email.getText();
        myModel.add(new Entry(firstname,lastname,street,city,plz,email));
    }

    public void cancel(ActionEvent actionEvent) {
    }

    public void saveEdit(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void filter(ActionEvent actionEvent) {
        ObservableList<Entry> filtered = FXCollections.observableArrayList();
        String filter = tf_filter.getText();
        myModel.entries.forEach(entry -> {
            if (entry.matches(filter)){
                filtered.add(entry);
            }
        });
        lv_filtered.setItems(filtered);

    }
}
