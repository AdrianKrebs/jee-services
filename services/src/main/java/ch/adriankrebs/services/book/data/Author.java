package ch.adriankrebs.services.book.data;
// Generated Oct 28, 2015 11:29:04 AM by Hibernate Tools 4.3.1.Final


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Author generated by hbm2java
 */
@Entity
@Table(name = "Author")
public class Author implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "Firstname", nullable = false, length = 100)
	private String firstname;

	@Column(name = "Lastname", nullable = false, length = 45)
	private String lastname;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "bookAuthors")
	private Collection<Book> booksWrittenByAuthor;

	public Author() {
	}

	public Author(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Author(String firstname, String lastname, Collection bookAuthors) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.booksWrittenByAuthor = bookAuthors;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Collection<Book> getBooksWrittenByAuthor() {
		return booksWrittenByAuthor;
	}

@JsonIgnore
	public void setBooksWrittenByAuthor(Collection<Book> booksWrittenByAuthor) {
		this.booksWrittenByAuthor = booksWrittenByAuthor;
	}
	
	

}