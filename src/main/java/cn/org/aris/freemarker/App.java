package cn.org.aris.freemarker;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.aris.freemarker.configuration.InitialConfiguration;
import cn.org.aris.freemarker.examples.datamodel.DataModelUsage;
import freemarker.template.Configuration;

public class App {

    private static Log logger = LogFactory.getLog(App.class);
    public static Configuration cfg = null;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            InitialConfiguration.config();
        } catch (IOException e) {
            logger.error(e);
        }
        cfg = InitialConfiguration.getConfiguration();

        // UsageOne.execute();
        // System.out.println("\r\n");
        // UsageTwo.execute();

        DataModelUsage.execute();
    }
}
