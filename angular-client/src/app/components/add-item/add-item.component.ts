import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/Item';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  item: Item = {
    item_no: 0,
    name: "",
    amount: 0,
    inventoryCode: 0
  }
  message: any;

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {

  }

  public addNow() {
    let resp = this.itemService.create(this.item);
    resp.subscribe((data) => this.message = data);
  }
}
