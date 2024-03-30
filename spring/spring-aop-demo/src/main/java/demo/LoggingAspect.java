package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* demo.ShoppingCart.checkOut(..))")
    public  void beforeLogger(JoinPoint jp){
        System.out.println(jp.getSignature());
        String str = jp.getArgs()[0].toString();
        System.out.println(str);
        System.out.println("Before Logger was called");
    }
    @After("execution(* demo.ShoppingCart.checkOut(..))")
    public  void afterLogger(){
        System.out.println("After Logger was called");
    }
    @Pointcut("within(demo..*)")
    public void authenticatingPointcut(){

    }
    @Pointcut("within(demo..*)")
    public void authorizingPointcut(){

    }
    @Before("authenticatingPointcut()")
    public  void authentication(){
        System.out.println("Authenticating the request");
    }
    @Before("authorizingPointcut()")
    public  void authorization(){
        System.out.println("Authorizing the request");
    }

//    @Pointcut("within(demo.ShoppingCart)")
//    public void returnValPointcut(){
//    }
@Pointcut("execution(* demo.ShoppingCart.quantity(..))")
   public void returnValPointcut(){

}

    @AfterReturning(pointcut = "returnValPointcut()",returning = "retVal")
    public void retValFunction(Object retVal){
        System.out.println(retVal);
    }


}
/*

In AspectJ pointcut expressions, the ".." notation represents a wildcard that matches any number of subpackages. Let's break down demo..*:

demo: This is a specific package name.
..: This notation matches any number of subpackages.
*: This matches any class within the demo package or its subpackages.
So, demo..* would match any class within the demo package or any of its subpackages. For example:

demo.MyClass
demo.subpackage1.AnotherClass
demo.subpackage2.YetAnotherClass
All these classes would match the pointcut expression demo..*.
*/
