package homework2.no1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderItem")
public class OrderItem implements Serializable{
	@Id
	@Column(name = "orderItemId")
	private int orderItemId;
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Order order;
	@Column(name = "quantity")
	private int orderQuantity;

	public OrderItem() {
	}

	public OrderItem(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public OrderItem(int orderItemId, Order order) {
		this.orderItemId = orderItemId;
		this.order = order;
	}

	public OrderItem(int orderItemId, Order order, int orderQuantity) {
		this.orderItemId = orderItemId;
		this.order = order;
		this.orderQuantity = orderQuantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

}
