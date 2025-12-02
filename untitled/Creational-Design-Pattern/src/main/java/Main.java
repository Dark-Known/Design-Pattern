import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureInfo;
import BuilderDesignPattern.CargoInfoNotification;
import BuilderDesignPattern.CargoNotificationBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // after some server side ops we get jsonObj
        JsonObj res1 = new JsonObj("Road", 500, "modern chair",
                                    "User1", "Address1",
                                        "SourceAddress1","destinationAddress1");
        JsonObj res2 = new JsonObj("Water", 3000, "Victoria Sofa",
                                    "User2", "Address2",
                                "SourceAddress2","destinationAddress2");
        JsonObj res3 = new JsonObj("Air", 5000, "modern sofa",
                                    "User3", "Address3",
                                    "SourceAddress3","destinationAddress3");
        ArrayList<JsonObj> responseQueue = new ArrayList<>(
                Arrays.asList(res1, res2, res3)
        );

//
//         using factory Method
        responseQueue.forEach((JsonObj res) -> {


            FieldMapper fieldMapper= new FieldMapper(res);
            String timeStamp= CurrentTimeService.getNow();


            try {
                if (!fieldMapper.IsSet()) {
                   fieldMapper.map();
                }
                else
                {
                    throw new Exception("Cant modify this object as it already exists");
                }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            NotificationService notificationService= new NotificationService(timeStamp,fieldMapper.getUserInfoObj(),
                    fieldMapper.getAddressInfoObj(),fieldMapper.getCargoInfoObj());
            notificationService.pushNotification();

        });







    }
}