package Utils;

import Service.CurrentTimeService;

public enum ModernFamilyInfo {
    MANF_NAME("Modern COMPANY"),
    MANF_ADD("Modern ADDRESS"),
    MATERIAL("silk"),
    CHAIR_LEGS(3),
    SOFA_LEGS(4);
    private String name;
    private int count;

    ModernFamilyInfo(String name) {
        this.name = name;
    }

    ModernFamilyInfo(int count) {
        this.count = count;
    }

    public static FurnitureInfo buildInfo() {
        CurrentTimeService timeService = new CurrentTimeService();
        return new FurnitureInfo(
                ModernFamilyInfo.MANF_NAME.getName(),
                ModernFamilyInfo.MANF_ADD.getName(),
                ModernFamilyInfo.MATERIAL.getName(),
                timeService.getDate());
    }
    public static FurnitureInfo buildInfo(String manfDate)
    {
        return new FurnitureInfo(
                ModernFamilyInfo.MANF_NAME.getName(),
                ModernFamilyInfo.MANF_ADD.getName(),
                ModernFamilyInfo.MATERIAL.getName(),
                manfDate);

    }
    public static FurnitureInfo buildInfo(CurrentTimeService timeService)
    {
        return new FurnitureInfo(
                ModernFamilyInfo.MANF_NAME.getName(),
                ModernFamilyInfo.MANF_ADD.getName(),
                ModernFamilyInfo.MATERIAL.getName(),
                timeService.getTimeStamp());

    }

    public String getName() {
        return this.name;

    }

    public int getValue() {
        return this.count;
    }
}
