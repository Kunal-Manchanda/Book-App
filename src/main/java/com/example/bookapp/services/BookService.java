package com.example.bookapp.services;

import java.util.List;

import com.example.bookapp.dao.BookRepository;
import com.example.bookapp.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(123, "Java", "xyz"));
    //     list.add(new Book(124, "Python", "abc"));
    //     list.add(new Book(125, "C++", "pqr"));
    // }




    //get all books
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get book by id
    public Book getBookById(int id){
        Book book = null;
        try{
            book = this.bookRepository.findById(id);
            // book = list.stream().filter(e->e.getBookId() == id).findFirst().get();
        } catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //create a book
    public Book addBook(Book book){
        Book result = this.bookRepository.save(book);
        // list.add(book);
        return result;
    }

    //delete a book
    public void deleteBook(int id){
        this.bookRepository.deleteById(id);
        // list = list.stream().filter(book->book.getBookId() != id).collect(Collectors.toList());
    }

    //update a book
    public void updateBook(Book book, int id){
        book.setId(id);
        this.bookRepository.save(book);
        // list = list.stream().map(b->{
        //     if(b.getBookId() == id){
        //         b.setAuthor(book.getAuthor());
        //         b.setTitle(book.getTitle());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
    }
}
