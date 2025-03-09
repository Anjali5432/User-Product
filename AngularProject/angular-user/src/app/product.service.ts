import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product'; // Product model file path

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseURL = 'http://localhost:8082/api/products';
  constructor(private httpClient: HttpClient) { }


  // Fetch all products
  getProductList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseURL}`);
  }

  // Delete a product
  deleteProduct(pid: number): Observable<any> {
    return this.httpClient.delete<boolean>(`${this.baseURL}/${pid}`, { observe: 'body' }); 
  }
}
