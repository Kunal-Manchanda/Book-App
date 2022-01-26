package com.example.bookapp.dao;

import com.example.bookapp.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
