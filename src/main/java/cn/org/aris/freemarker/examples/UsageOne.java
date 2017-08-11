package cn.org.aris.freemarker.examples;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.prism.Texture.Usage;

import cn.org.aris.freemarker.App;
import cn.org.aris.freemarker.domain.Product;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class UsageOne {

    private static Log logger = LogFactory.getLog(Usage.class);

    public static void execute() {
        try {

            Map<String, Object> root = new HashMap<String, Object>();
            root.put("user", "Xiaohu");

            Product latest = new Product();
            latest.setUrl("products/greenhourse.html");
            latest.setName("green hourse");
            root.put("latestProduct", latest);

            Template temp = App.cfg.getTemplate("index.ftlh");

            Writer out = new OutputStreamWriter(System.out);
            temp.process(root, out);

        } catch (IOException e) {
            logger.error(e);
        } catch (TemplateException e) {
            logger.error(e);
        }
    }

}
