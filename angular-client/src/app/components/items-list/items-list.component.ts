import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  items: any;

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    let resp = this.itemService.getAll();
    resp.subscribe((data) => this.items = data);
  }

  public deleteItem(id: number) {
    let resp = this.itemService.delete(id);
    resp.subscribe((data) => this.items = data);
  }

  public updateAmount(id: number) {
    let howMuch: number;
    howMuch = Number(prompt("Enter a positive or negative number:"))
    let resp = this.itemService.update(id, howMuch);
    resp.subscribe((data) => this.items = data);
  }

}
