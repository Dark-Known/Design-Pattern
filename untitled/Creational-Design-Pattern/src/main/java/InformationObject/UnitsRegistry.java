package InformationObject;

public class UnitsRegistry {
    private final InMemoryModernFamilyUnits inMemoryModernFamilyRegistry;
    private final InMemoryVictoriaFamilyUnits inMemoryVictoriaFamilyRegistry;


    UnitsRegistry(){
        this.inMemoryModernFamilyRegistry=new InMemoryModernFamilyUnits();
        this.inMemoryVictoriaFamilyRegistry=new InMemoryVictoriaFamilyUnits();
    }

    public  InMemoryModernFamilyUnits getModernFamilyRegistry(){
        return inMemoryModernFamilyRegistry;
    }
    public  InMemoryVictoriaFamilyUnits getVictoriaFamilyRegistry(){
        return inMemoryVictoriaFamilyRegistry;
    }



}
