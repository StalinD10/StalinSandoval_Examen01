package com.distribuida.servicios;

import com.distribuida.config.ConectionPool;
import com.distribuida.dao.BookDAO;
import com.distribuida.db.Books;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.SneakyThrows;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements IBookService {
    private Jdbi getJdbi() {
        Jdbi jdbi = Jdbi.create(ConectionPool.getConnection());
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @Override
    public Books findById(Integer id) {
        Books book = getJdbi().withExtension(BookDAO.class, dao -> {
            return dao.findById(id);
        });
        return book;
    }

    @Override
    public List<Books> findAll() {
        List<Books> books = getJdbi().withExtension(BookDAO.class, dao -> {
            return dao.findAll();
        });
        return books;
    }

    @SneakyThrows
    @Override
    public void createBook(Books book) {
        getJdbi().useExtension(BookDAO.class, dao -> {
            dao.saveBook(book);
        });
    }

    @Override
    public void updateBook(Books book) {
        getJdbi().useExtension(BookDAO.class, dao -> {
            dao.updateBook(book);
        });
    }

    @Override
    public void deleteBook(Integer id) {
        getJdbi().useExtension(BookDAO.class, dao -> {
            dao.deleteBook(id);
        });
    }

}
