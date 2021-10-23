package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPLETION_AMAZON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPLETION_BYTEDANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPLETION_GRAB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPLETION_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEADLINE_AMAZON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEADLINE_BYTEDANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEADLINE_GRAB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEADLINE_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMAZON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BYTEDANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_GRAB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POSITION_AMAZON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POSITION_BYTEDANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POSITION_GRAB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POSITION_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRIORITY_AMAZON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRIORITY_BYTEDANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRIORITY_GRAB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRIORITY_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REQUIREMENTS_ONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REQUIREMENTS_TWO;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REQUIREMENTS_THREE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STATUS_AMAZON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STATUS_BYTEDANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STATUS_GRAB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STATUS_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_ONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_TWO;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_THREE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.Internship;
import seedu.address.model.application.Application;

/**
 * A utility class containing a list of {@code Application} objects to be used in tests.
 */
public class TypicalApplications {

    // Manually added - Application's details found in {@code CommandTestUtil}
    public static final Application AMAZON = new ApplicationBuilder().withCompany(VALID_NAME_AMAZON)
            .withPosition(VALID_POSITION_AMAZON).withDeadline(VALID_DEADLINE_AMAZON)
            .withCompletion(VALID_COMPLETION_AMAZON).withStatus(VALID_STATUS_AMAZON)
            .withPriority(VALID_PRIORITY_AMAZON).
            withRequirements(VALID_REQUIREMENTS_ONE, VALID_REQUIREMENTS_TWO, VALID_REQUIREMENTS_THREE)
            .withTags(VALID_TAG_ONE).build();
    public static final Application BYTEDANCE = new ApplicationBuilder().withCompany(VALID_NAME_BYTEDANCE)
            .withPosition(VALID_POSITION_BYTEDANCE).withDeadline(VALID_DEADLINE_BYTEDANCE)
            .withCompletion(VALID_COMPLETION_BYTEDANCE).withStatus(VALID_STATUS_BYTEDANCE)
            .withPriority(VALID_PRIORITY_BYTEDANCE).withRequirements(VALID_REQUIREMENTS_ONE, VALID_REQUIREMENTS_TWO)
            .withTags(VALID_TAG_TWO).build();
    public static final Application GRAB = new ApplicationBuilder().withCompany(VALID_NAME_GRAB)
            .withPosition(VALID_POSITION_GRAB).withDeadline(VALID_DEADLINE_GRAB)
            .withCompletion(VALID_COMPLETION_GRAB).withStatus(VALID_STATUS_GRAB)
            .withPriority(VALID_PRIORITY_GRAB).withRequirements(VALID_REQUIREMENTS_TWO)
            .withTags(VALID_TAG_ONE, VALID_TAG_THREE).build();
    public static final Application SHOPEE = new ApplicationBuilder().withCompany(VALID_NAME_SHOPEE)
            .withPosition(VALID_POSITION_SHOPEE).withDeadline(VALID_DEADLINE_SHOPEE)
            .withCompletion(VALID_COMPLETION_SHOPEE).withStatus(VALID_STATUS_SHOPEE)
            .withPriority(VALID_PRIORITY_SHOPEE).withRequirements(VALID_REQUIREMENTS_ONE, VALID_REQUIREMENTS_THREE)
            .withTags(VALID_TAG_TWO, VALID_TAG_THREE).build();

    private TypicalApplications() {} // prevents instantiation

    /**
     * Returns an {@code Internship} with all the typical applications.
     */
    public static Internship getTypicalInternship() {
        Internship internship = new Internship();
        for (Application application : getTypicalApplications()) {
            internship.addApplication(application);
        }
        return internship;
    }

    public static List<Application> getTypicalApplications() {
        return new ArrayList<>(Arrays.asList(AMAZON, BYTEDANCE, GRAB));
    }

}
