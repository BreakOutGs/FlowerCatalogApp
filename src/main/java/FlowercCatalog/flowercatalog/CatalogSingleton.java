package FlowercCatalog.flowercatalog;

import flowercatalog.Catalog;

public class CatalogSingleton {
    private static Catalog catalog;

    public static Catalog getInstance() {
        if(catalog!=null)
            return catalog;
        else {
            catalog = new Catalog();
            return  catalog;
        }
    }
}
