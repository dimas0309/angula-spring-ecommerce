import { Component, OnInit } from '@angular/core';
import { ProductCategory } from './common/product-category';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'angular-app';
  
  /* hamburguer button and dropdowns
     event calls variables.         */
  navbarOpen: boolean = false;
  productOpen: boolean = false;

  productCategories: ProductCategory[];

  constructor(private productService: ProductService){ }

  ngOnInit(){
    this.listProductCategories();
  }
  
  /* hamburguer button and dropdowns event calls */
  toggleNavBar() {
    this.navbarOpen = !this.navbarOpen;
  }

  toggleProduct(){
    this.productOpen = !this.productOpen;
  }

  /* */
  listProductCategories(){

    this.productService.getProductCategories().subscribe(
      data => {
        console.log('Product Categories=' + JSON.stringify(data));
        this.productCategories = data;
      }
    );
  }

   

   
             

}

 
 