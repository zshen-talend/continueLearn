package JNDI;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Lookup {

    public static void main(String[] args) {
        Hashtable env = new Hashtable();
        String name = "C:/aaa1.txt";
        try {
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory"); // use the file
                                                                                                    // system as service
                                                                                                    // provider
            Context ctx = new InitialContext(env);
            Object obj = ctx.lookup(name);
            System.out.println("the name " + name + " is bound to object:" + obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}