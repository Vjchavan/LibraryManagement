package com.librarymanagement.repo;

import com.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Book,Integer> {

}
