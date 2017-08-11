package cn.org.aris.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class FMUtils {

    public static void writerTo(Map<String, Object> dataModel, String st, Writer writer) throws Exception {
        if (dataModel == null) {
            throw new Exception("The map " + dataModel + " should not be empty.");
        }

        try {
            Template temp = App.cfg.getTemplate(st);

            if (temp != null) {
                temp.process(dataModel, writer);
            }
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
