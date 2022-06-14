package fr.m2i.crm.model;

import fr.m2i.crm.state.OrderState;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "designation", length = 100)
	private String designation;
	
	@Column (name = "nb_days")
	private int nb_days;
	
	@Column (name = "total_exclude_taxe", precision = 9, scale = 2) // Précision : nombre de chiffres (excluant la ,) Scale: nombre chiffres après virgule
	private double totalExcludeTaxe;
	
	@Column (name="total_with_taxe", precision = 9, scale = 2)
	private double totalWithTaxe;
	
	@Column(name = "type_presta", length = 100)
	private String typePresta;
	
	@Column (name = "unit_price", precision = 9, scale = 2)
	private double unitPrice;
	
	@Column (name = "state")
	@Enumerated(EnumType.ORDINAL)
	private OrderState state;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setNb_days(int nb_days) {
		this.nb_days = nb_days;
	}
	
	public void setTotalExcludeTaxe(double totalExcludeTaxe) {
		this.totalExcludeTaxe = totalExcludeTaxe;
	}
	
	public void setTotalWithTaxe(double totalWithTaxe) {
		this.totalWithTaxe = totalWithTaxe;
	}
	
	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void setState(OrderState state) {
		this.state = state;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Order{");
		sb.append("id=").append(id);
		sb.append(", designation='").append(designation).append('\'');
		sb.append(", nb_days=").append(nb_days);
		sb.append(", totalExcludeTaxe=").append(totalExcludeTaxe);
		sb.append(", totalWithTaxe=").append(totalWithTaxe);
		sb.append(", typePresta='").append(typePresta).append('\'');
		sb.append(", unitPrice=").append(unitPrice);
		sb.append(", state=").append(state);
		sb.append(", customer=").append(customer);
		sb.append('}');
		return sb.toString();
	}
}
