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
        System.out.println("String".charAt(0));
        String a = "1fsdf";
        String b = "0safa";
        System.out.println(a.charAt(0)<b.charAt(0)? a : b);

    }
    
    static void changeName(Person o) {
    	o.setName("Vasiko");
    }
}

