import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // For *ngFor, *ngIf
import { ProductService } from '../product.service'; // Service for fetching product data
import { Product } from '../product'; // Product model
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {

  products: Product[] = []; // Store product list

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  // Fetch products from the backend
  private getProducts(): void {
    this.productService.getProductList().subscribe(
      data => {
        this.products = data;
      },
      error => {
        console.error('Error fetching product data:', error);
      }
    );
  }

 // Delete product with confirmation popup
 deleteProduct(productId: number): void {
  const isConfirmed = window.confirm('Are you sure you want to delete this record?');
  if (isConfirmed) {
    this.productService.deleteProduct(productId).subscribe(
      (response: boolean) => {
        if (response) {
          alert("You can't delete the product because it is already used by a user.");
        } else {
          alert('Product deleted successfully!');
          this.getProducts();
        }
      },
      error => {
        console.error('Error deleting product:', error); // Log the error details
        alert(`An error occurred while trying to delete the product. Error: ${error.message}`);
      }
    );
  }
}

}
//done