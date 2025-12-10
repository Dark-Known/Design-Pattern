package InformationObject;

public class CounterServiceRegistry {
    private static  InMemoryModernFamilyUnits inMemoryModernFamilyRegistry=new InMemoryModernFamilyUnits();
    private static InMemoryVictoriaFamilyUnits inMemoryVictoriaFamilyRegistry=new InMemoryVictoriaFamilyUnits();

    public static InMemoryModernFamilyUnits getModernFamilyRegistry(){
        return inMemoryModernFamilyRegistry;
    }
    public static InMemoryVictoriaFamilyUnits getVictoriaFamilyRegistry(){
        return inMemoryVictoriaFamilyRegistry;
    }



}
