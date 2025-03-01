package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.application.Application;

/**
 * Panel containing the list of persons.
 */
public class ApplicationListPanel extends UiPart<Region> {
    private static final String FXML = "ApplicationListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ApplicationListPanel.class);

    @FXML
    private ListView<Application> personListView;

    /**
     * Creates a {@code ApplicationListPanel} with the given {@code ObservableList}.
     */
    public ApplicationListPanel(ObservableList<Application> applicationList) {
        super(FXML);
        personListView.setItems(applicationList);
        personListView.setCellFactory(listView -> new ApplicationListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Application} using a {@code ApplicationCard}.
     */
    class ApplicationListViewCell extends ListCell<Application> {
        @Override
        protected void updateItem(Application application, boolean empty) {
            super.updateItem(application, empty);

            if (empty || application == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ApplicationCard(application, getIndex() + 1).getRoot());
            }
        }
    }

}
