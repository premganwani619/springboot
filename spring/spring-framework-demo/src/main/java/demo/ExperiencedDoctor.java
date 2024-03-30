package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//if we don't add @Component Annotation here we have to declare it as a Bean in either
//BeanConfig.java or Spring.xml
@Scope(scopeName = "prototype")
@Component
public class ExperiencedDoctor implements  BeanNameAware {
private  String qualification;

    @Override
    public String toString() {
        return "ExperiencedDoctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void assist() {
        System.out.println("Exp. doctor is assisting");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name aware method called");
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Post cons. method called");
    }
    @PreDestroy
    //it may not execute because it executes when garbage collector hits
    //and for small number of objects garbage collector does not hit instantly
    public void preDestroy(){
        System.out.println("Post destroy. method called");
    }
}
