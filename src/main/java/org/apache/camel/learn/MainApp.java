package org.apache.camel.learn;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new RouteBuilderHistorialPagos());
        main.run(args);
    }

    

}
