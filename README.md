
# 🛒 Spring Boot Product Management App

This is a **Spring Boot + Thymeleaf** web application for managing products. It includes full CRUD operations, form validation, search functionality, and secure role-based access using Spring Security.

## 🚀 Features

- 🔐 Login system with `USER` and `ADMIN` roles
- 📦 Product CRUD: add, edit, delete, list
- 🔍 Search products by name
- ✅ Form validation with error messages
- 🌐 Thymeleaf layout with Bootstrap styling
- 🛡️ Spring Security with CSRF protection
- 📄 H2 + MySQL support

## 📸 Screenshots

### 🔑 Login Page
![Login](screenshots/login.png)

### 📦 Product Listing
![Product List](screenshots/list.png)

### ➕ Add New Product
![Add Product](screenshots/add.png)

### ✏️ Edit Product
![Edit Product](screenshots/edit.png)

### 🚫 Access Denied

![Not Authorized](screenshots/access_denied.png)

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.4.5
- Spring Web / Security / Data JPA / Validation
- Thymeleaf with Layout Dialect
- Bootstrap 5 via WebJars
- H2 (runtime) + MySQL (runtime)
- Lombok

## 🛠️ Run Locally

```bash
git clone https://github.com/MasaafKhaoula/spring-enset-mvc.git
cd -bdcc-spring-enset-mvc
mvn spring-boot:run
```

Visit: `http://localhost:8094`

## 👤 Default Users

| Username | Password | Role  |
|----------|----------|-------|
| kham     | 1234     | USER  |
| admin    | 1234     | ADMIN |
| user2    | 1234     | USER  |

## 📁 Folder Structure

```
src
├── main
│   ├── java/ma/enset/masaafbddcapp
│   │   ├── web          # Spring MVC Controllers
│   │   ├── entities     # JPA Entities
│   │   ├── repository   # JPA Repositories
│   │   └── security     # Spring Security config
│   └── resources/templates
│       ├── layout1.html
│       ├── products.html
│       ├── newProduct.html
│       ├── editProduct.html
│       ├── login.html
│       └── notAuthorized.html
```

## Author
Masaaf Khaoula
