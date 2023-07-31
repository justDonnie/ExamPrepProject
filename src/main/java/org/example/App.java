package org.example;

import org.example.config.DataBaseConfig;
import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.Publisher;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.services.AuthorService;
import org.example.services.BookService;
import org.example.services.PublisherService;
import org.example.services.serviceImpl.AuthorServiceImpl;
import org.example.services.serviceImpl.BookServiceImpl;
import org.example.services.serviceImpl.PublisherServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DataBaseConfig.getEntityManager();
        PublisherService publisherService = new PublisherServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();

        while (true) {
            System.out.println("""
                    Press to 1 to save the Publisher
                    Press to 2 to find the Publisher by ID
                    Press to 3 to get all list of Publishers
                    Press to 4 to update the Publisher
                    Press to 5 to delete Publisher by name
                    Press to 6 to save the Author
                    Press to 7 to get the Author by ID
                    Press to 8 to delete the Author by ID
                    Press to 9 to update the Author by ID
                    Press to 10 to assign the Authors to Publishers
                    Press to 11 to get Authors from Publishers
                    Press to 12 to save the Book with Author's
                    Press to 13 to update Author of Book
                    Press to 14 to get Books and Publishers by Book's ID
                    Press to 15 to delete Book by Author's ID
                    """);
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    System.out.println("Write the Publisher's name: ");
                    String publisherName = new Scanner(System.in).nextLine();
                    System.out.println("Write the Publisher's address: ");
                    String publisherAddress = new Scanner(System.in).nextLine();
                    System.out.println(publisherService.savePublisher(new Publisher(
                            publisherName,
                            publisherAddress
                    )));
                }
                case "2" -> {
                    System.out.println("Input the publisher's ID to get the publisher: ");
                    System.out.println(publisherService.getPublisherById(new Scanner(System.in).nextLong()));

                    ;
                }
                case "3" -> {
                    System.out.println(publisherService.getAllPublishers());
                }
                case "4" -> {
                    System.out.print("Input the publisher's ID to update: ");
                    Long ID = new Scanner(System.in).nextLong();
                    System.out.print("Write a new name of publisher: ");
                    String newName = new Scanner(System.in).nextLine();
                    System.out.print("Write a new address of publisher: ");
                    String newAddress = new Scanner(System.in).nextLine();
                    System.out.println(publisherService.updatePublisher(ID, new Publisher(newName, newAddress)));
                }
                case "5" ->{
                    System.out.print("Write publisher's name to delete: ");
                    String publisherName = new Scanner(System.in).nextLine();
                    System.out.println(publisherService.deletePublisherByName(publisherName));
                }
                case "6" ->{
                    System.out.println(
                            authorService.saveAuthor(
                            new Author("Chyngyz","Aitmatov","chyngyz@gmail.com", LocalDate.of(1928,12,12),"Kyrgyzstan",Gender.valueOf("MALE"))));
                }
                case "7" ->{
                    System.out.print("Write the author's ID to get the author: ");
                    Long authorID = new Scanner(System.in).nextLong();
                    System.out.println(authorService.getAuthorById(authorID));
                }
                case "8" ->{
                    System.out.println("Input the author's ID to delete the author: ");
                    Long authorId = new Scanner(System.in).nextLong();
                    System.out.println(authorService.deleteAuthorById(authorId));
                }
                case "9" ->{
                    System.out.println("Input the author's ID to update: ");
                    Long authorID = new Scanner(System.in).nextLong();
                    System.out.println(authorService.updateAuthor(authorID,new Author("Leo","Tolstoy","leo@gmail.com",LocalDate.of(1876,9,23),"Russia",Gender.valueOf("MALE"))));
                }
                case "10" ->{
                    System.out.println(authorService.assignAuthorToPublisher(1L, 1L));
                }
                case "11" ->{
                    System.out.print("Input the Publishers ID to get Authors: ");
                    Long publisherId = new Scanner(System.in).nextLong();
                    System.out.println(authorService.getAuthorsByPublisherId(publisherId));
                }

                case "12" ->{
                    Book book = new Book("Harry Potter","USA",LocalDate.of(2009,6,24),2000, Genre.valueOf("MYSTERY") );
                    Author author = new Author("Joan","Rowling","joan@gmail.com",LocalDate.of(1966,4,22),"UK",Gender.valueOf("FEMALE"));
                    book.setAuthor(author);
                    bookService.saveBook(book);
                }
                case "13" ->{
                    bookService.updateBookAuthor(3L,6L);
                }
                case "14" ->{
                    System.out.print("Input the book's ID to get the Publishers: ");
                    System.out.println(bookService.getBookAndPublisherByBookId(new Scanner(System.in).nextLong()));
                }
                case "15" -> {
                    System.out.print("Input the Author's ID to delete the book: ");
                    bookService.deleteBookByAuthorId(new Scanner(System.in).nextLong());
                }


            }
        }
    }
}
