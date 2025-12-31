AI-Powered Voice Food Ordering System

Order food using your voice — built with Java & AI
-----------------------------------------------------------------------------------------------
📌 Project Overview

The AI-Powered Voice Food Ordering System is a full-stack application that allows users to place food orders and provide delivery addresses using voice commands.
It uses Java Spring Boot for backend processing, REST APIs for communication, and the Web Speech API on the frontend for speech recognition and voice responses.

An Admin Panel is included for managing menu items dynamically.
------------------------------------------------------------------------------------------------
🚀 Key Features

🎙️ Voice-based food ordering

🗣️ Voice confirmation and responses

📍 Voice-based delivery address capture

🧮 Automatic total amount calculation

🧑‍💼 Admin panel (Add / Update / Delete menu items)

🔐 Admin login & logout

💾 MySQL database integration

⚠️ Global exception handling

🔄 Conversational state management
-------------------------------------------------------------------------------------
🛠️ Tech Stack
Backend

Java

Spring Boot

REST APIs

JPA / Hibernate

Frontend

HTML

CSS

JavaScript

Web Speech API

Database

MySQL

Tools

Maven

Git

IntelliJ IDEA
--------------------------------------------------------------------------------------
🧠 Application Flow

User clicks Speak Order and places an order using voice

Backend processes the order and calculates total price

System asks for delivery address via voice

User clicks Speak Address and provides address

Order is saved in MySQL and confirmed via voice
---------------------------------------------------------------------
📂 Project Structure
backend/
 ├── controller/
 ├── service/
 ├── entity/
 ├── repository/
 └── exception/

frontend (static)/
 ├── index.html
 ├── style.css
 ├── admin.html
 ├── admin-login.html
 ├── admin.js
 └── admin.css
