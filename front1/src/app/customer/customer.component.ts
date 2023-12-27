import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent  implements OnInit{
  customer:any
  constructor(private http:HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:9999/customer-service/customers?projection=fullCustomer").subscribe(
      {
        next :(data)=>{
          this.customer=data;
        },error:()=>{}
      }
    )

  }

}
