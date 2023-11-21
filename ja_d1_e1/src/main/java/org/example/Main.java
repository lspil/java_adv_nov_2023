// JVM - Java Virtual Machine (proces)
// Mediu de executie al aplicatiilor Java
// Java / Kotlin --> compilator (ex. javac) --> bytecode (JVM) ---> OS
// GC, threads (virtual threads)

// app ----> bytecode, dependinte (classpath) --> (IoC)

// app ----> Spring, beans

// Java Reflection

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

void main() {
    // Object, Class, Constructor, Field, Method...
    try {
        Class catClass = Class.forName("org.example.beans.Cat");

        Constructor constructor = catClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Object cat = constructor.newInstance(); // apel constructor

        Field f1 = catClass.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(cat, "Tom");

        Method m1 = catClass.getDeclaredMethod("sayMeow");
        m1.setAccessible(true);
        m1.invoke(cat);

        System.out.println(cat);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
