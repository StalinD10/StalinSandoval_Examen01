package com.distribuida.servicios;

import com.distribuida.db.Books;

import java.util.List;

public interface IBookService {
    public Books findById(Integer id);

    public void createBook(Books book);

    public List<Books> findAll();

    public void updateBook(Books book);

    public void deleteBook(Integer id);
}
