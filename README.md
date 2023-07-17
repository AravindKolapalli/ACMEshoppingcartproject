# ACMEshoppingcartproject

Firstly this is a Shopping cart concept which needs bovisous improvements if we have special cases. 

Consider you have two roles ADMIN and CUSTOMER.
Only admins can add, update, delete products to catalogue.
Similarly, the news can also be added by admins only.
The application gets a list of products.
The products may have a name, description, price etc.

This supports a shopping cart functionality for CUSTOMER role. Customers can add products here from the catalogue to their cart.
A customer can have multiple orders.
We might need an order summary on checkout. It may contain information like items, cost, etc.

Additional work can pogress like this
Consider we have 5000 products in catalogue, we might need a filtering option in the API as well.
The filter can work on product name as free search.
We can think of having pagination support in API.

There can be numerous validations and edge cases missing so please keep in mind before stepping in.
The Project is focused mainly on 
I have used H2 database with SpringBoot JPA and the details are attached in applications.properties file
