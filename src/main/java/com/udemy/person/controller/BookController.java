package com.udemy.person.controller;

import com.udemy.person.data.vo.BookVO;
import com.udemy.person.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book", description = "End Points to Book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Create a book")
    @GetMapping
    public ResponseEntity<List<BookVO>> findAll() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @Operation(summary = "Find one by id")
    @GetMapping("/{id}")
    public ResponseEntity<BookVO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @Operation(summary = "List all books")
    @PostMapping
    public ResponseEntity<BookVO> create(@RequestBody BookVO bookVO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(bookVO));
    }

    @Operation(summary = "Update a book")
    @PutMapping("/{id}")
    public ResponseEntity<BookVO> update(@PathVariable Long id, @RequestBody BookVO bookVO) {
        return ResponseEntity.ok().body(bookService.update(id, bookVO));
    }

    @Operation(summary = "Delete one book")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
