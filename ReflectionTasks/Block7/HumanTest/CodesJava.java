
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


/**
 *
 * @author Ilia_Dukhov
 */
public class CodesJava {
    public static void main(String[] args) throws Exception{
        
    }
    public static List fieldCollection(Object object){
        Class obj = object.getClass();
        List<Field> lst = new ArrayList<>(Arrays.asList(obj.getDeclaredFields()));
        while(obj.getSuperclass()!=Object.class){
            obj = obj.getSuperclass();
            lst.addAll(Arrays.asList(obj.getDeclaredFields()));
        }
        return lst;
    }
    public static void validate(Object object, Class testClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        for(Method method:testClass.getDeclaredMethods()){
            method.invoke(testClass.newInstance(), object);
        }
    }
    
}
    
    

