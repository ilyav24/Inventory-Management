package org.acme.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Items")
@ApiModel(description = "Details about the item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The unique number of the item")
    private long item_no;

    @Column
	@ApiModelProperty(notes = "The item's name")
    private String name;

    @Column
	@ApiModelProperty(notes = "The amount you have of this item")
    private long amount;
    
	@Column
	@ApiModelProperty(notes = "This item's inventory code")
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
	public long getInventoryCode() {
		return inventory_code;
	}
	public void setInventoryCode(long inventory_code) {
		this.inventory_code = inventory_code;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void changeAmount(long amount){
		this.amount+=amount;
	}
	
}
