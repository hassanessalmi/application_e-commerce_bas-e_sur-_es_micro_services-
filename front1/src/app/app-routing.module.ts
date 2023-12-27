import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductComponent} from "./product/product.component";
import {CustomerComponent} from "./customer/customer.component";


const routes: Routes = [
  {  path :"products",component:ProductComponent},
  { path :"customer",component:CustomerComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
