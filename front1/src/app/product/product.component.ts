import {Component, OnInit} from '@angular/core';
import {Init} from "v8";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent  implements  OnInit{
  products:any
constructor(private http:HttpClient) {
}
  ngOnInit() {
  this.http.get("http://localhost:9999/inventory-service/products?projection=fullProduct").subscribe(
    {
      next :(data)=>{
          this.products=data;
      },error:()=>{}
    }
  )

  }

}
