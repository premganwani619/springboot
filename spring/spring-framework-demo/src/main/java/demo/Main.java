package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {
        //instead of Doctor doctor = new Doctor();
        //we are using IOC(Inversion of control)
        //and that we are doing by dependency injection
        //benefits of dependency injection
        //1) you don't have to always create obj by new keyword
        //2)helps to remove tight coupling
        //2)helps in unit testing
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        Staff doctor = context.getBean(Doctor.class);
        doctor.assist();
        Staff nurse = context.getBean(Nurse.class);
        nurse.assist();
        Doctor doctor1 = (Doctor) context.getBean("doctor");
        doctor1.assist();
        System.out.println(doctor1.random);
        System.out.println(doctor1.qualification);
        //Annotations Based configuration
        ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        ExperiencedDoctor expDoctor = appContext.getBean(ExperiencedDoctor.class);
        expDoctor.assist();
        ExperiencedDoctor expDoctor1 = appContext.getBean(ExperiencedDoctor.class);
        expDoctor1.setQualification("MBBS");
        System.out.println(expDoctor1);
        ExperiencedDoctor expDoctor2 = appContext.getBean(ExperiencedDoctor.class);
        System.out.println(expDoctor2);
    }
}
