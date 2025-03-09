# 🍱 Tiffin - Food Delivery App

Tiffin is a web application that connects users with local messes and tiffin services. It allows mess owners to list their daily menus and users to order tiffins conveniently.

---

## 🚀 Features
- 🛒 **User Authentication** (Sign-up/Login for users and mess owners)
- 📋 **Mess Owner Dashboard** (Update daily menu, manage orders)
- 🍽 **Order Management** (Users can browse and order tiffins)
- 💳 **Payment Integration** (Coming soon)
- 📍 **Location-based Service** (Find mess services nearby)

---

## 🏗 Tech Stack
### **Frontend** (React)
- React.js
- React Router
- Axios (for API calls)
- Tailwind CSS (for styling)

### **Backend** (Spring Boot)
- Spring Boot (REST API)
- Spring Security (Authentication & Authorization)
- MySQL (Database)
- JPA/Hibernate (ORM)
- Swagger (API Documentation)

---

Tiffin-service/        # Root folder
│── frontend/         # React Frontend
│   ├── src/         # Source code (React components, pages, etc.)
│   │   ├── assets/   # Images, logos, and other static assets
│   │   ├── components/ # Reusable UI components
│   │   ├── pages/    # Page components (Home, Login, etc.)
│   │   ├── services/  #Api endpoint for login and signup (user and owner
│   │   ├── styles/    # Styling for every page components.
│   ├── public/       # Public assets (images)
│   ├── index.html       # Main html file
│   ├── package.json  # Dependencies and scripts
│   ├── .env          # Environment variables (API URLs, etc.)
│   ├── .gitignore    # Ignore unnecessary frontend files
│
│── backend/          # Spring Boot Backend
│   ├── src/          # Backend source code
│   │   ├── main/     # Main application logic
│   │   │   ├── java/com/tiffin/api/  # Java package structure
│   │   │   │   ├── config/  # SecurityConfig
│   │   │   │   ├── controller/  # API Controllers
│   │   │   │   ├── entity/  # entity for eachdatabase tables 
│   │   │   │   ├── services/     # Business logic
│   │   │   │   ├── repositories/ # Database queries
│   │   │   │   ├── models/       # Data Models (Entities)
│   │   ├── resources/  # Configuration files
│   │   │   ├── application.properties  # Spring Boot configuration
│   ├── pom.xml       # Maven dependencies
│   ├── .gitignore    # Ignore unnecessary backend files
│
│── README.md         # Project Overview and Documentation
│── .gitignore        # Ignore unnecessary global files

