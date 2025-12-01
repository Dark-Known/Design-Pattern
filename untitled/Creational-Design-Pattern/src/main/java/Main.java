import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // after some server side ops we get jsonObj
        JsonObj res1 = new JsonObj("Road", 500, "modern chair");
        JsonObj res2 = new JsonObj("Water", 3000, "Victoria Sofa");
        JsonObj res3 = new JsonObj("Air", 5000, "modern sofa");
        ArrayList<JsonObj> responseQueue = new ArrayList<>(
                Arrays.asList(res1, res2, res3)
        );


        // using factory Method
        responseQueue.forEach((JsonObj res) -> {
            NotificationService.pushNotification(res.getTransportMode(),res.getCargo());
        });


    }
}