package homework2.no2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bookProduct")
public class BookProduct {
	  @Id
	  @Column(name="bookProductId")
	  private int bookProductId;
	  @JoinColumn(name = "bookId", referencedColumnName = "bookId")
	  @ManyToOne(optional = false, fetch = FetchType.LAZY)
	  private Book book;
	  @JoinColumn(name = "productId", referencedColumnName = "productId")
	  @ManyToOne(optional = false, fetch = FetchType.LAZY)
	  private Product product;
}
