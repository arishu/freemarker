package cn.org.aris.freemarker.examples.datamodel;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.aris.freemarker.FMUtils;
import cn.org.aris.freemarker.Versions;
import cn.org.aris.freemarker.domain.Person;
import cn.org.aris.freemarker.domain.Phone;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleCollection;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleNumber;
import freemarker.template.SimpleObjectWrapper;
import freemarker.template.SimpleScalar;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateCollectionModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateModelIterator;
import freemarker.template.TemplateNotFoundException;

public class DataModelUsage {
    private static Log logger = LogFactory.getLog(DataModelUsage.class);

    public static void execute() throws TemplateNotFoundException, TemplateModelException {

        // demonstrate the usage of scalars
        scalarsUsage();

        // demonstrate the usage of hashes
        hashesUsage();

        // demonstrate the usage of sequences
        sequencesUsage();

        // demonstrate the usage of collections
        collectionsUsage();

    }

    private static void scalarsUsage() throws TemplateModelException {
        Map<String, Object> dm = new HashMap<String, Object>();
        dm.put("name", "姓名");
        dm.put("age", "年龄");
        dm.put("height", "身高");
        dm.put("married", "结婚与否");
        dm.put("pOne", new Person(SimpleScalar.newInstanceOrNull("xiaoming"), new SimpleNumber(25),
                new SimpleNumber(170), TemplateBooleanModel.FALSE));
        dm.put("pTwo", new Person(SimpleScalar.newInstanceOrNull("xiaohome"), new SimpleNumber(23),
                new SimpleNumber(165), TemplateBooleanModel.FALSE));
        dm.put("pThree", new Person(SimpleScalar.newInstanceOrNull("xiaoqing"), new SimpleNumber(27),
                new SimpleNumber(175), TemplateBooleanModel.TRUE));
        String st = "datamodel/scalar.ftlh";

        try {
            FMUtils.writerTo(dm, st, new FileWriter(new File("WebContent/datamodel/scalar.html")));
        } catch (Exception e) {
            logger.error(e);
        }
    }

    private static void hashesUsage() throws TemplateModelException {

        System.out.println("\r\nBeansWrapper Usage:");
        Map<String, Phone> dm = new HashMap<String, Phone>();
        dm.put("861695004001000", new Phone("861695004001000", "xiaozhang", "13761001000"));
        dm.put("861695004001001", new Phone("861695004001001", "xiaowang", "13761001001"));
        dm.put("861695004001002", new Phone("861695004001002", "xiaohuang", "13761001002"));
        SimpleHash sh = new SimpleHash(dm, new BeansWrapperBuilder(Versions.COMPVERSION).build());
        logger.info("xiaozhang: " + sh.get("861695004001000"));
        logger.info("xiaowang: " + sh.get("861695004001001"));
        logger.info("xiaohuang: " + sh.get("861695004001002"));

        // will throw exception because Phone Object is not a simple object
        // sh = new SimpleHash(dm, new SimpleObjectWrapper(Versions.COMPVERSION));
        // logger.info("xiaozhang: " + sh.get("861695004001000"));
        // logger.info("xiaowang: " + sh.get("861695004001001"));
        // logger.info("xiaohuang: " + sh.get("861695004001002"));

        System.out.println("\r\nSimpleObjectWrapper Usage:");

        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap.put("name", "xiaohu");
        myMap.put("age", 26);
        sh = new SimpleHash(myMap, new SimpleObjectWrapper(Versions.COMPVERSION));
        logger.info("[name:" + sh.get("name") + "," + "age:" + sh.get("age") + "]");

        System.out.println("\r\nDefaultObjectWrapper Usage:");
        sh = new SimpleHash(dm, new DefaultObjectWrapperBuilder(Versions.COMPVERSION).build());
        logger.info("xiaozhang: " + sh.get("861695004001000"));
        logger.info("xiaowang: " + sh.get("861695004001001"));
        logger.info("xiaohuang: " + sh.get("861695004001002"));
    }

    private static void sequencesUsage() throws TemplateModelException {

        System.out.println("\r\nSimpleSequence(ObjectWrapper) usage");
        SimpleSequence ss = new SimpleSequence(new DefaultObjectWrapper(Versions.COMPVERSION));
        ss.add("xiaohu");
        ss.add("Hello");
        for (int i = 0; i < ss.size(); i++) {
            logger.info(ss.get(i));
        }

        System.out.println("\r\nSimpleSequence(Collection, ObjectWrapper) usage");
        ss = new SimpleSequence(Arrays.asList(1, 2, 3, 4, 5), new SimpleObjectWrapper(Versions.COMPVERSION));
        for (int i = 0; i < ss.size(); i++) {
            logger.info(ss.get(i));
        }

        System.out.println("\r\nSimpleSequence(int, ObjectWrapper) usage");
        ss = new SimpleSequence(3, new BeansWrapperBuilder(Versions.COMPVERSION).build());
        Map<String, Phone> dm = new HashMap<String, Phone>();
        dm.put("861695004001000", new Phone("861695004001000", "xiaozhang", "13761001000"));
        dm.put("861695004001001", new Phone("861695004001001", "xiaowang", "13761001001"));
        dm.put("861695004001002", new Phone("861695004001002", "xiaohuang", "13761001002"));
        ss.add(dm);
        for (int i = 0; i < ss.size(); i++) {
            logger.info(ss.get(i));
        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            logger.error(e);
        }

        System.out.println("\r\nSimpleSequence(TemplateCollectionModel) usage");
        List<String> list = new ArrayList<String>();
        list.add("yangtou");
        list.add("gourou");
        TemplateCollectionModel tcm = new SimpleCollection(list, new DefaultObjectWrapper(Versions.COMPVERSION));
        ss = new SimpleSequence(tcm);
        for (int i = 0; i < ss.size(); i++) {
            logger.info(ss.get(i));
        }
    }

    private static void collectionsUsage() throws TemplateModelException {

        System.out.println("\r\nSimpleCollection(Collection, ObjectWrapper)");
        Set<String> set = new HashSet<String>();
        set.add("mango");
        set.add("apple");
        SimpleCollection sc = new SimpleCollection(set, new SimpleObjectWrapper(Versions.COMPVERSION));
        for (TemplateModelIterator iter = sc.iterator(); iter.hasNext();) {
            logger.info(iter.next());
        }

        System.out.println("\r\nSimpleCollection(Iterator, ObjectWrapper)");
        sc = new SimpleCollection(set.iterator(), new SimpleObjectWrapper(Versions.COMPVERSION));
        for (TemplateModelIterator iter = sc.iterator(); iter.hasNext();) {
            logger.info(iter.next());
        }
    }

}
