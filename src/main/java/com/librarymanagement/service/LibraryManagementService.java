package com.librarymanagement.service;

import com.librarymanagement.model.Book;
import com.librarymanagement.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryManagementService {

    @Autowired
    private BooksRepo booksRepo;
    public Optional<Book> getBookById(int id) {

        return booksRepo.findById(id);
    }

    public Book saveBook(Book book) {
        Book save = booksRepo.save(book);
        return save;
    }

    public void deleteBook(int id) {
        booksRepo.deleteById(id);
    }

    public void deleteAllBook() {
        booksRepo.deleteAll();
    }
}
