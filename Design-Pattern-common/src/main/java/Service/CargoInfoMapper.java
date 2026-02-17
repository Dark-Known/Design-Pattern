package Service;

import Utils.CargoInfo;
import Utils.IMapper;
import Utils.JsonObj;

public class CargoInfoMapper implements IMapper<CargoInfo> {
    private ExtractFamilyInfo extractor;
    private CargoParser cargoParser;

    CargoInfoMapper(ExtractFamilyInfo extractor , CargoParser cargoParser)
    {
        this.extractor=extractor;
        this.cargoParser=cargoParser;
    }
    @Override
    public CargoInfo map(JsonObj jsonObj) {
        return new CargoInfo(
                jsonObj.getTransportMode(),
                jsonObj.getCargo(),
                jsonObj.getDistance(),
                extractor.getInfo(cargoParser.getFamilyName(jsonObj.getCargo()))
        );
    }
}
