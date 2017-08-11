package cn.org.aris.freemarker.domain;

import java.util.Objects;

import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;

/**
 * This is the Person Object
 *
 * @author hwc
 */
public class Person {
    private String name;
    private int age;
    private int height;
    private Boolean married;

    public Person(TemplateScalarModel name, TemplateNumberModel age, TemplateNumberModel height,
            TemplateBooleanModel married) throws TemplateModelException {
        this.name = name.getAsString();
        this.age = (Integer) age.getAsNumber();
        this.height = (Integer) height.getAsNumber();
        this.married = married.getAsBoolean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, married);
    }

    @Override
    public String toString() {
        return "[name: " + name + ", age: " + age + ", height: " + height + ", isMarried: " + married + "]";
    }
}
