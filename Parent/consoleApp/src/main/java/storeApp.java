public class storeApp {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Store store = new Store();
        RandomStorePopulator rand = new RandomStorePopulator();
        store.printStoreData();

    }
}
