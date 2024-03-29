
package codesjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Reflection.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Ilia_Dukhov
 */
public class CodesJava {
    public static void main(String[] args) throws Exception{
        C c = new C();
//        System.out.println(fieldCollection(c));
        //System.out.println(collector(C.class));
        A a = new A();
        System.out.println(a);
        Human h = new Human(200, 20000);
        validate(h);
        
    }
    
    public static void validate(Object someObject) throws Exception {
        Class<?> objClass = someObject.getClass();
        Class<?>[] testClasses = objClass.getAnnotation(Validate.class).value();
        List<Method> testMethods;
        if(objClass.isAnnotationPresent(Validate.class)){
            for (Class<?> testClass : testClasses){
                testMethods = Arrays.asList(testClass.getDeclaredMethods());
                for (Method method : testMethods){
                    method.invoke(null, someObject);
                }
            }
        }
    }
    
    
    public static Map<String, Object> collector(Class clz) throws Exception{
        Map<String, Object> map = new HashMap<>();
        List<Method> methods = new ArrayList<>(Arrays.asList(clz.getDeclaredMethods()));
        for(Method method :methods){
            if(method.isAnnotationPresent(Invoke.class)){
                method.setAccessible(true);
                map.put(method.getName(), method.invoke(clz.newInstance()));
            }
        }
        return map;
    }
    
    public static void reset(Object obj)throws Exception{
        List<Field> fields = new ArrayList<>();
        Class<?> defaultClass=null;
        Class<?> objClass = obj.getClass();

        while (objClass.getSuperclass() != Object.class){
            objClass = objClass.getSuperclass();
            for(Field field: Arrays.asList(objClass.getDeclaredFields())){
                if(field.isAnnotationPresent(Default.class)){
                    fields.add(field);
                }
            }
        }

        if (obj.getClass().isAnnotationPresent(Default.class)){
            fields.addAll(Arrays.asList(obj.getClass().getDeclaredFields()));
            defaultClass = obj.getClass().getAnnotation(Default.class).value();
        }
        for (Field field : fields) {
            field.setAccessible(true);
            if (defaultClass == null){
                field.set(obj, field.getAnnotation(Default.class).value()
                     .getDeclaredField(field.getName()).get(null));
            } else {
                field.set(obj, defaultClass.
                        getDeclaredField(field.getName()).get(null));
            }
        }
    }
    
    
}
    
    

