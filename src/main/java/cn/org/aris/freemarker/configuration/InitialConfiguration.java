package cn.org.aris.freemarker.configuration;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 *
 * @author hwc
 */
public class InitialConfiguration {

    private static Configuration cfg = null;

    public static Configuration getConfiguration() {
        return cfg;
    }

    public static void config() throws IOException {
        // Create a Configuration instance
        cfg = new Configuration(Configuration.VERSION_2_3_26);

        // Specify the source where the template files come from
        cfg.setDirectoryForTemplateLoading(new File("templates"));

        // Set the preferred charset template files are stored in.
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker
        // that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);
    }

}
