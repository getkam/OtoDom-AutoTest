package enums;

public enum NavBarAdsItems{
    APARTAMENTS_FOR_SALE (0),
    APARTAMENTS_FOR_RENT(1),
    HOUSES_FOR_SALE(2),
    HOUSES_FOR_RENT(3),
    COMMERCIALS_FOR_RENT(4),
    PLOTS_FOR_SALE(5);
    private int index;
    NavBarAdsItems(int index){this.index = index;}

    public int getIndex() {return index; }
}
