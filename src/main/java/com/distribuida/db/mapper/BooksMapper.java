package com.distribuida.db.mapper;

import com.distribuida.db.Books;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksMapper implements RowMapper<Books> {

    public Books map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Books(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDouble(5)
        );
    }
}
