# E-commerce-system

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


## Project Structure
### model contains
- `Product` (abstract base class)
- `ExpiringProduct` (extends Product, supports expiry date)
- `NonExpiringProduct` (extends Product)
- `Cart` (manages items and quantities)
- `Customer` (with balance tracking)
- `Cartitem` (represents an individual item in the cart along with its quantity)

### service contains
- `ShippingService` (handles shipping of shippable items)
### interfaces contain
- `Expirable` (Interface for items that have an expiry date)
- `Shippable` (Interface for products that require shipping with a weight)
### Main
- `Main` (demo usage and entry point)



## How to Run

1. **Compile all files**  
   Navigate to your project directory and run:  
   ```bash
   javac *.java
