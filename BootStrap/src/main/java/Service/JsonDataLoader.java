package Service;

import Utils.JsonObj;

import java.util.ArrayList;
import java.util.Arrays;

public class JsonDataLoader {

    public ArrayList<JsonObj> loadData() {
        // after some server side ops we get jsonObj
        JsonObj res1 = new JsonObj("Road", 500, "modern chair",
                "User1", "Address1",
                "SourceAddress1", "destinationAddress1");
        JsonObj res2 = new JsonObj("Water", 3000, "Victoria Sofa",
                "User2", "Address2",
                "SourceAddress2", "destinationAddress2");
        JsonObj res3 = new JsonObj("Air", 5000, "modern sofa",
                "User3", "Address3",
                "SourceAddress3", "destinationAddress3");
        JsonObj res4 = new JsonObj("Air", 10000, "Victoria Chair",
                "User4", "Address4",
                "SourceAddress4", "destinationAddress4");
        JsonObj res5 = new JsonObj("Road", 500, "modern chair",
                "User1", "Address1",
                "SourceAddress1", "destinationAddress1");
        JsonObj res6 = new JsonObj("Water", 3000, "Victoria Sofa",
                "User2", "Address2",
                "SourceAddress2", "destinationAddress2");
        JsonObj res7 = new JsonObj("Air", 5000, "modern sofa",
                "User3", "Address3",
                "SourceAddress3", "destinationAddress3");
        JsonObj res8 = new JsonObj("Air", 10000, "Victoria Chair",
                "User4", "Address4",
                "SourceAddress4", "destinationAddress4");
        return new ArrayList<>(
                Arrays.asList(res1, res2, res3, res4, res5, res6, res7, res8)
        );
    }
}
