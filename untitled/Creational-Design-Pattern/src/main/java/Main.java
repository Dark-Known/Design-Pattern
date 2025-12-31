import InformationObject.*;
import Service.CurrentTimeService;
import Service.FieldMapper;
import Service.NotificationService;
import Service.StorageService;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private enum TesterEnum{
        MODERN,
        VICTORIA,
        CHAIR,
        SOFA
    }
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
        JsonObj res4 = new JsonObj("Air", 10000, "Victoria Chair",
                "User4", "Address4",
                "SourceAddress4","destinationAddress4");
        JsonObj res5 = new JsonObj("Road", 500, "modern chair",
                "User1", "Address1",
                "SourceAddress1","destinationAddress1");
        JsonObj res6 = new JsonObj("Water", 3000, "Victoria Sofa",
                "User2", "Address2",
                "SourceAddress2","destinationAddress2");
        JsonObj res7 = new JsonObj("Air", 5000, "modern sofa",
                "User3", "Address3",
                "SourceAddress3","destinationAddress3");
        JsonObj res8 = new JsonObj("Air", 10000, "Victoria Chair",
                "User4", "Address4",
                "SourceAddress4","destinationAddress4");

        ArrayList<JsonObj> responseQueue = new ArrayList<>(
                Arrays.asList(res1, res2, res3,res4,res5,res6,res7,res8)
        );



        // IN Memory Units
//        InMemoryFamilyUnits inMemoryModernFamilyUnits= new InMemoryModernFamilyUnits();
//        InMemoryFamilyUnits inMemoryVictoriaFamilyUnits= new InMemoryVictoriaFamilyUnits();
        FamilyRegistry familyRegistry= new FamilyRegistry();
        StorageService storage= new StorageService(familyRegistry);
//         using factory Method
        responseQueue.forEach((JsonObj res) -> {
            // extract info from jsonObjs and distribute to individual information objs
            FieldMapper fieldMapper= new FieldMapper(res);
            String timeStamp= CurrentTimeService.getNow();

            try {
                fieldMapper.map();
                NotificationService notificationService= new NotificationService(timeStamp,fieldMapper.getUserInfoObj(),
                        fieldMapper.getAddressInfoObj(),fieldMapper.getCargoInfoObj());
                notificationService.pushNotification();
                //Extract cargo info from fieldMapper

                CargoInfo cargoInfoObj= fieldMapper.getCargoInfoObj();
                String cargoName= cargoInfoObj.getCargoName();


            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }




        });








    }
}