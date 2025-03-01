package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalApplications.getTypicalInternship;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_APPLICATION;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_APPLICATION;

import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.application.Application;
import seedu.address.model.application.Company;
import seedu.address.model.application.Completion;
import seedu.address.model.application.Deadline;
import seedu.address.model.application.Position;
import seedu.address.model.application.Status;
import seedu.address.model.tag.Tag;


public class CompleteCommandTest {

    private Model model = new ModelManager(getTypicalInternship(), new UserPrefs());

    @Test
    public void execute_validIndexApplicationList_success() {
        Application applicationToComplete = model.getFilteredApplicationList()
                .get(INDEX_FIRST_APPLICATION.getZeroBased());

        Company company = applicationToComplete.getCompany();
        Position position = applicationToComplete.getPosition();
        Deadline deadline = applicationToComplete.getDeadline();
        Status status = applicationToComplete.getStatus();
        Set<Tag> tagList = applicationToComplete.getTags();
        Completion completion = new Completion("Completed");
        Application completedApplication = new Application(company, position, deadline, completion, status, tagList);

        String expectedMessage = String.format(CompleteCommand.MESSAGE_SUCCESS, completedApplication);
        ModelManager expectedModel = new ModelManager(model.getInternship(), new UserPrefs());
        expectedModel.setApplication(applicationToComplete, completedApplication);

        CompleteCommand completeCommand = new CompleteCommand(INDEX_FIRST_APPLICATION);

        assertCommandSuccess(completeCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexApplicationList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredApplicationList().size() + 1);
        CompleteCommand completeCommand = new CompleteCommand(outOfBoundIndex);

        assertCommandFailure(completeCommand, model, Messages.MESSAGE_INVALID_APPLICATION_DISPLAYED_INDEX);
    }


    @Test
    public void equals() {
        CompleteCommand completeFirstCommand = new CompleteCommand(INDEX_FIRST_APPLICATION);
        CompleteCommand completeSecondCommand = new CompleteCommand(INDEX_SECOND_APPLICATION);

        // same object -> returns true
        assertTrue(completeFirstCommand.equals(completeFirstCommand));

        // same values -> returns true
        CompleteCommand completeFirstCommandCopy = new CompleteCommand(INDEX_FIRST_APPLICATION);
        assertTrue(completeFirstCommand.equals(completeFirstCommandCopy));

        // different types -> returns false
        assertFalse(completeFirstCommand.equals(1));

        // null -> returns false
        assertFalse(completeFirstCommand.equals(null));

        // different application -> returns false
        assertFalse(completeFirstCommand.equals(completeSecondCommand));
    }
}
