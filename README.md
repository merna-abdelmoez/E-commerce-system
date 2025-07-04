# e-commerce-system

## Overview
This project is a simple Java-based e-commerce system demonstrating core OOP concepts and features typically found in online shopping platforms.

It supports:
- Defining products with name, price, and quantity.
- Differentiating between expiring and non-expiring products.
- Managing shipping requirements with weight details for shippable products.
- Allowing customers to add products to their cart with quantity validation.
- Performing checkout with validation of stock, expiry, and customer balance.
- Generating a detailed checkout receipt including subtotal, shipping fees, total amount, and remaining customer balance.
- Handling shipping by collecting all shippable items and sending them to a `ShippingService`.

## Features
- **Product Types**: Expiring (e.g. Cheese, Biscuits) and non-expiring (e.g. TV, Mobile).
- **Shipping**: Some products require shipping with weight info, others do not.
- **Cart Management**: Customers can add available quantities of products to their cart.
- **Checkout Process**: Validates cart content, product stock and expiry, and customer balance.
- **Shipping Service**: Aggregates shippable items and calculates total shipment weight.
- **Console Output**: Displays shipping notice and detailed checkout receipt.

## Project Structure

- `Product` (abstract base class)
- `ExpiringProduct` (extends Product, supports expiry date)
- `NonExpiringProduct` (extends Product)
- `Shippable` (interface for shippable products)
- `Cart` (manages items and quantities)
- `Customer` (with balance tracking)
- `ShippingService` (handles shipping of shippable items)
- `Main` (demo usage and entry point)


## How to Run

1. **Compile all files**  
   Navigate to your project directory and run:  
   ```bash
   javac *.java
