package com.udemy.person.services;

import com.udemy.person.adapter.mapper.DozerAdapter;
import com.udemy.person.data.model.Book;
import com.udemy.person.data.vo.BookVO;
import com.udemy.person.exception.NotFoundException;
import com.udemy.person.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookVO create(BookVO bookVO) {
        var entity = DozerAdapter.parseObject(bookVO, Book.class);
        return DozerAdapter.parseObject(bookRepository.save(entity), BookVO.class);
    }

    public BookVO findById(Long id) {
        var entity = bookRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
        return DozerAdapter.parseObject(entity, BookVO.class);
    }

    public List<BookVO> findAll() {
        return DozerAdapter.parseListObjects(bookRepository.findAll(), BookVO.class);
    }

    public BookVO update(Long id, BookVO bookVO) {
        findById(id);
        bookVO.setId(id);
        var book = bookRepository.save(DozerAdapter.parseObject(bookVO, Book.class));
        return DozerAdapter.parseObject(book, BookVO.class);
    }

    public void delete(Long id) {
        findById(id);
        bookRepository.deleteById(id);
    }
}
