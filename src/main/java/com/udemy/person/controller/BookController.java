package com.udemy.person.controller;

import com.udemy.person.data.vo.BookVO;
import com.udemy.person.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookVO>> findAll() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookVO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BookVO> create(@RequestBody BookVO bookVO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(bookVO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookVO> update(@PathVariable Long id, @RequestBody BookVO bookVO) {
        return ResponseEntity.ok().body(bookService.update(id, bookVO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
