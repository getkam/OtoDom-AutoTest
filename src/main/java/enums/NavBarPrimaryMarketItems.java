package enums;

public enum NavBarPrimaryMarketItems {
    NEW_FLATS(0),
    NEW_HOUSES(1),
    TOP_DEVELOPERS(2);

    private int index;
    NavBarPrimaryMarketItems(int index){this.index = index;}

    public int getIndex() {return index; }
}
