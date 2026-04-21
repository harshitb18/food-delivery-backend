# 🍔 Food Delivery Backend System

## 🚀 Overview

This project is a backend system for a Food Delivery application built using Spring Boot. It simulates real-world workflows such as user authentication, restaurant browsing, order placement, delivery assignment, and payment processing.

The system focuses on solving backend challenges like **order lifecycle management, concurrency handling, and scalable API design**.

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL (Dockerized)
* Redis (Caching - optional)

---

## 📌 Features

* User Authentication (Register/Login)
* Restaurant & Menu Management
* Order Creation and Lifecycle Management
* Restaurant Order Acceptance/Rejection
* Delivery Partner Assignment
* Payment Simulation
* Concurrency Handling
* Global Exception Handling & Validation

---

## 🔄 Order Lifecycle

```
CREATED → ACCEPTED → PREPARING → OUT_FOR_DELIVERY → DELIVERED
                  ↘
                 CANCELLED
```

---

## 🧩 System Architecture

Layered Architecture:

* Controller Layer → Handles API requests
* Service Layer → Business logic
* Repository Layer → Database operations

---

## 📡 API Endpoints

### 👤 User Management

```
POST   /api/auth/register
POST   /api/auth/login
GET    /api/users/{userId}
```

---

### 🍽️ Restaurant & Menu

```
GET    /api/restaurants
GET    /api/restaurants/{restaurantId}
GET    /api/restaurants/{restaurantId}/menu
```

---

### 📦 Order Management

```
POST   /api/orders
GET    /api/orders/{orderId}
PUT    /api/orders/{orderId}/status
PUT    /api/orders/{orderId}/cancel
```

---

### 🔄 Order Lifecycle & Restaurant Actions

```
PUT    /api/orders/{orderId}/accept
PUT    /api/orders/{orderId}/reject
PUT    /api/orders/{orderId}/prepare
PUT    /api/orders/{orderId}/out-for-delivery
PUT    /api/orders/{orderId}/deliver
```

---

### 🚴 Delivery Management

```
POST   /api/delivery/assign
GET    /api/delivery/{orderId}
PUT    /api/delivery/{orderId}/status
```

---

## 🗄️ Database Design (Planned)

### 🧑 User

* id (PK)
* name
* email
* password

---

### 🍽️ Restaurant

* id (PK)
* name
* location

---

### 📋 MenuItem

* id (PK)
* name
* price
* restaurant_id (FK)

---

### 📦 Order

* id (PK)
* user_id (FK)
* restaurant_id (FK)
* status
* total_amount
* created_at

---

### 🧾 OrderItem

* id (PK)
* order_id (FK)
* menu_item_id (FK)
* quantity

---

### 🚴 DeliveryPartner

* id (PK)
* name
* status

---

### 💳 Payment

* id (PK)
* order_id (FK)
* amount
* status

---

## ⚙️ Setup Instructions

### 1. Run MySQL using Docker

```
docker run --name food-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=food_delivery -p 3306:3306 -d mysql:8
```

---

### 2. Configure application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/food_delivery
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Run Application

* Open project in IntelliJ
* Run Spring Boot application

---

## 🔥 Key Highlights

* Implemented **order state machine** to ensure valid transitions
* Handled **concurrency issues** during order and delivery assignment
* Designed **scalable REST APIs**
* Used **layered architecture** for maintainability

---

## 🚀 Future Enhancements

* Real-time order tracking
* Microservices architecture
* Kafka for event-driven processing
* Advanced recommendation system

---

## 📌 Author

Harshith B
