package Studing01;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //System.out.println( "Hello World!" );
        
        Person person = new Person("Lizi");
        person.displayName();
        changeName(person);
        person.displayName();
        
    }
    
    static void changeName(Person o) {
    	o.setName("Vasiko");
    }
}

