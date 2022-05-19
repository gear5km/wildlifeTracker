import org.junit.jupiter.api.Test;

import java.util.List;

public class checkForItemsInTable {
    @Test
    public void checkContent(){
        System.out.println("TESTING DATABASE FOR ITEMS");
        List<Animals> checkForData = connectionDao.displayReports();
    }

}
