package com.example.bookstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public class BookRepo {
	@Autowired
	private JdbcTemplate jdbc;
	
	private RowMapper<Book> mapper = new RowMapper<Book>() {

		@Override
		public Book mapRow(ResultSet rs, int rowNum)  {
			Book book = new Book();
			try {
				book.setId(rs.getLong("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPublished_year(rs.getInt("published_year"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
			}
			
			
			return book;
		}
		
	};
	// save new book
	public int save(Book book) {
		String sqlQuery = "insert into books(title, author, price, quantity, published_year) "
				+ "values(?,?,?,?,?)";
		return jdbc.update(sqlQuery,
				book.getTitle(),
				book.getAuthor(),
				book.getPrice(),
				book.getQuantity(),
				book.getPublished_year());
	}
	// get all book
	public List<Book> getAll(){
		String sqlQuery = "select * from books";
		return jdbc.query(sqlQuery, mapper);
	}
	// get a book by its id
	public Book getById(Long id) {
		String sqlQuery = "Select * from books where id = ?";
		return jdbc.queryForObject(sqlQuery,mapper , id);
	}
	// update information of a book
	public int update(Book book) {
		String sql = "UPDATE books SET title = ?, author = ?, price = ?, quantity = ?, published_year = ? WHERE id = ?";
        return jdbc.update(sql, 
            book.getTitle(), 
            book.getAuthor(), 
            book.getPrice(), 
            book.getQuantity(), 
            book.getPublished_year(),
            book.getId());
		
	}
	// delete a book with specified id 
	public int deleteById(Long id) {
		String sqlQuery = "Delete from books where id = ?";
		return jdbc.update(sqlQuery, id);
	}
	// find by specified title
	public List<Book> findByTitle(String title){
		String sqlQuery = "Select * from books where title like ?";
		return jdbc.query(sqlQuery, mapper, "%"+title+"%");
		
	}
	// find by author
	public List<Book> findByAuthor(String author){
		String sqlQuery = "select * from books where author like ?";
		return jdbc.query(sqlQuery, mapper, "%"+ author+ "%");
	}
	
	
}
