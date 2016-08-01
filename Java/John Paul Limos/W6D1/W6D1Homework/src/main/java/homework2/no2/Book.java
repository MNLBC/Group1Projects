package homework2.no2;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	@Id
	@Column(name = "bookId")
	private int bookId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.LAZY)
	private List<BookProduct> bookProductList;
}
