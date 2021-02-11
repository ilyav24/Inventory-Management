import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/Item';
import { ItemService } from 'src/app/services/item.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  items: any;

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    let resp=this.itemService.getAll();
    resp.subscribe((data)=>this.items=data);
  }

  public delteItem(id:number){
    let resp= this.itemService.delete(id);
    resp.subscribe((data)=>this.items=data);
   }
}
