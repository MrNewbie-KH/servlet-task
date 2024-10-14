# servlet-task
# Shop Application
### Week 2 task Fawry intern
A simple web-based shop application built using **Java Servlets**. This application allows users to add products, view a list of products, and manage sessions for a better user experience.

## Features

- **Add Product**: Easily add a new product by providing the product details.
- **List Products**: View all the products added to the shop.
- **Session Management**: Session-based management to track user actions.
- **Servlet Filters**: Protect certain paths in the application (e.g., catalog).

## Technologies Used

- Java Servlets
- JSP (JavaServer Pages)
- HTML/CSS for basic frontend
- Session Management in Servlets

## Application Structure

### Servlets

1. **LoginServlet**: Handles user login and initializes the session.
2. **AddProductServlet**: Allows the addition of products with necessary details.
3. **ListProductsServlet**: Displays a list of all products added.
4. **StatsServlet**: Provides statistics about products and user actions.

### Filters

- **CatalogFilter**: Protects URLs that start with `/catalog`, ensuring only authenticated users can access.

### Session Management

- User session is created and maintained after a successful login, tracking product additions and interactions.

## Endpoints

1. `/login` - Login page.
2. `/addProduct` - Add a new product to the shop.
3. `/listProducts` - View the list of products.
4. `/catalog/stats` - View product statistics (protected by filter).

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/MrNewbie-KH/servlet-task

