import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TimerTask;

public class TimerCleanTask extends TimerTask {

    private Store store;

    public TimerCleanTask(Store store) {
        this.store = store;
    }

    public void run() {

        store.setPurchasedProductList(new ArrayList<>());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
