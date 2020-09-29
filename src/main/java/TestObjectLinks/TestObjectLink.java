package TestObjectLinks;

public class TestObjectLink {
    public static void main(String[] args) {
        try {
            Book bookTolstoy = new Book("War and pease", "Lev Tolstoy");
            bookTolstoy.displayInfo();

            Book bookTurg = bookTolstoy.clone();
            bookTurg.setBook("Nov");
            bookTurg.setAuthor("Turgenev");
            bookTurg.displayInfo();

            bookTolstoy.displayInfo();

        }catch(CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }


    }
}

class Book implements Cloneable{
    private String book;
    private Author author;
    Book(String book, String name){
        this.book = book;
        this.author = new Author(name);
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setAuthor(String name){
        author.setName(name);
    }

    public void displayInfo(){
        System.out.printf("Book '%s' written by %s\n\n", book, author.getName());
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone();
        newBook.author = (Author) author.clone();
        return newBook;
    }
}

class Author implements Cloneable{
    private String name;
    Author(String name){
        this.name = name;
    }
    public String getName() {    return name;   }
    public void setName(String name) {    this.name = name;   }
    @Override
    public Author clone() throws CloneNotSupportedException{
        return (Author)super.clone();
    }
}
