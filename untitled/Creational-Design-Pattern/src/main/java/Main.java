import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureInfo;
import BuilderDesignPattern.CargoInfoNotification;
import BuilderDesignPattern.CargoNotificationBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // after some server side ops we get jsonObj
        JsonObj res1 = new JsonObj("Road", 500, "modern chair");
        JsonObj res2 = new JsonObj("Water", 3000, "Victoria Sofa");
        JsonObj res3 = new JsonObj("Air", 5000, "modern sofa");
        ArrayList<JsonObj> responseQueue = new ArrayList<>(
                Arrays.asList(res1, res2, res3)
        );

//
//         using factory Method
        responseQueue.forEach((JsonObj res) -> {


            FieldMapper fieldMapper= new FieldMapper(res);

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
            NotificationService notificationService= new NotificationService()


        });







    }
}