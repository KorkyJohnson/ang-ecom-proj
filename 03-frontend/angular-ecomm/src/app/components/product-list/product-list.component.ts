import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  currentCategoryId: number;
  currentCategoryName: string;
  searchMode: boolean;

  constructor(private productService: ProductService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {

    // if there is a value passed from the search bar via the search component
    this.searchMode = this.route.snapshot.paramMap.has('keyword'); 

    if (this.searchMode) {
      this.handleSearchProducts();
    }
    else{
      this.handleListProducts();
    }
  }

  handleSearchProducts() {

    const theKeyword: string = this.route.snapshot.paramMap.get('keyword')!; // ! to avoid null errors

    this.productService.searchProducts(theKeyword).subscribe(
      data => {
        this.products = data;
      }
    )
  }

  handleListProducts() {
    // check if id parameter is avaiable
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      //  get the "id" param string and convert to a number using the "+" symbol
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!; // using the ! at the end means that the value won't be null

      // get the "name" param string
      this.currentCategoryName = this.route.snapshot.paramMap.get('name')!; // ! to confirm data won't be null
    }
    else {
      // if not available , default to category id = 1 / category name = Books
      this.currentCategoryId = 1;
      this.currentCategoryName = 'Books';
    }

    // now get the products for this category id
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    )
  }

}
function listProducts() {
  throw new Error('Function not implemented.');
}

