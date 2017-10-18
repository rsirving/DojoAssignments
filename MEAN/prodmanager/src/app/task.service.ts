import { Injectable } from '@angular/core';

@Injectable()
export class TaskService {

  product_id = 3;

  products = [
    {title: "Product 1", price: 1.99, image: "", id: 0},
    {title: "Product 2", price: 6.99, image: "", id: 1},
    {title: "Product 3", price: 10.99, image: "http://images2.onionstatic.com/onion/7954/original/600.jpg", id: 2}
  ];

  product = {
    title: "",
    price: 0,
    image: "",
    id: 0
  }

  constructor() { }

  getProducts(callback){
    let response = this.products;
    callback(response);
  }

  getSingleProduct(searchId){
    for (var i = 0; i < this.products.length; i++){
      if (this.products[i].id = searchId){
        return this.products[i];
      }
    }
  }

  addProduct(newProduct){
    console.log(this.product);
    this.product.title = newProduct.title;
    this.product.price = newProduct.price;
    this.product.image = newProduct.image;
    this.product.id = this.product_id;
    this.product_id++;
    this.products.push(this.product);
    console.log(this.product);
    console.log(this.products);
  }

  updateProduct(newProduct){
    this.product = this.getSingleProduct(newProduct.id);
    this.product = newProduct;
  }

  removeProduct(id){
    this.products.splice(id, 1);
  }

}
