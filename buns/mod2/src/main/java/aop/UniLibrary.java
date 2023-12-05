package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    public void getBook() {
        System.out.println("And we take a book from UniLibrary...");
        System.out.println("!-----------------------------------------------!");
    }

    public String returnBook() {
        System.out.println("Then we return a book back to UniLibrary...");
        return "War and Peace";
    }

    public void getMagazine() {
        System.out.println("And we take a magazine from UniLibrary...");
        System.out.println("!-----------------------------------------------!");
    }

    public void returnMagazine() {
        System.out.println("Then we return a magazine back to UniLibrary...");
        System.out.println("!-----------------------------------------------!");
    }

    public void addBook(String person_name, Book book) {
        System.out.println("This time we add a book from UniLibrary...");
        System.out.println("!-----------------------------------------------!");
    }

    public void addMagazine() {
        System.out.println("This time we add a magazine from UniLibrary...");
        System.out.println("!-----------------------------------------------!");
    }

}
