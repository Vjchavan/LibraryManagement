package com.librarymanagement.controller;

import com.librarymanagement.model.Book;
import com.librarymanagement.repo.BooksRepo;
import com.librarymanagement.service.LibraryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryManagementController {

    @Autowired
    private LibraryManagementService service;
    @Autowired
    private BooksRepo booksRepo;

    @PostMapping("/storebook/")
    public ResponseEntity storeBook(@RequestBody Book book){
        Book storedBook = service.saveBook(book);
        return new ResponseEntity(storedBook,HttpStatus.OK);
    }

    @GetMapping("/getbooks")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> booksList = booksRepo.findAll();
        return new ResponseEntity(booksList,HttpStatus.OK);
    }

    @GetMapping("/getbook/{id}")
    public ResponseEntity<Book> getHello(@PathVariable int id){
        Optional<Book> book = service.getBookById(id);
        return new ResponseEntity(book,HttpStatus.OK);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        service.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteallbook")
    public ResponseEntity deleteAllBook(){
        service.deleteAllBook();
        return new ResponseEntity(HttpStatus.OK);
    }

}
