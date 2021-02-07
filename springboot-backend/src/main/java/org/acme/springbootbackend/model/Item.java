package org.acme.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long item_no;

    @Column
    private String name;

    @Column
    private long amount;
    
	@Column
    private long inventory_code;

    public Item(){}

    public Item( String name,long amount, long inventory_code) {
		super();
        this.name = name;
        this.amount = amount;
		this.inventory_code = inventory_code;
	}

	public long getItemNo() {
		return item_no;
	}
	public void setItemNo(long item_no) {
		this.item_no = item_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEmail() {
		return inventory_code;
	}
	public void setEmail(long inventory_code) {
		this.inventory_code = inventory_code;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
