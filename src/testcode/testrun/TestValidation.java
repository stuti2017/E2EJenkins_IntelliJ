package testcode.testrun;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestValidation {
    @Test
    public void testDuplicateCount() {
        List<String> duplicateItemsList = new ArrayList<String>();
        duplicateItemsList.add("A");
        duplicateItemsList.add("B");
        duplicateItemsList.add("Z");
        duplicateItemsList.add("Z");
        duplicateItemsList.add("C");
        duplicateItemsList.add("B");
        duplicateItemsList.add("Z");

    }
}
