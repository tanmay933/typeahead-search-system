# 🔍 Typeahead Search System

> A real-time autocomplete search engine inspired by systems like Google Search — built using Spring Boot, React, MySQL, caching strategies, and batch-processing concepts.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square\&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen?style=flat-square\&logo=springboot)
![React](https://img.shields.io/badge/React-18-blue?style=flat-square\&logo=react)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square\&logo=mysql)
![Vite](https://img.shields.io/badge/Vite-Frontend-purple?style=flat-square\&logo=vite)

---

# 📌 Overview

The **Typeahead Search System** is a full-stack project that simulates how modern search engines provide instant search suggestions while users type.

The project focuses heavily on backend engineering and system-design concepts such as:

* Real-time autocomplete
* Prefix-based search matching
* Ranking using popularity and recency
* Trending searches
* Distributed cache simulation
* Batch database writes
* Low-latency reads

The goal of the system is to balance:

* ⚡ Fast suggestion retrieval
* 📦 Reduced database load
* 🔄 Fresh ranking updates
* 🧠 Scalable architecture concepts

while still maintaining a clean and responsive frontend experience.

---

# ✨ Features

* ⚡ Real-time autocomplete suggestions
* 🔤 Prefix-based query matching
* 📈 Ranking using popularity + recency
* 🔥 Trending searches section
* 🗂️ Simulated distributed cache nodes
* 🔀 Hash-based cache routing
* ♻️ Cache invalidation
* 📦 Batch database updates
* 🗄️ MySQL persistence
* 🛠️ Cache debug API
* 🖥️ React frontend with live suggestions
* ⏱️ Debounced frontend requests

---

# 🛠️ Tech Stack

| Layer      | Technology                      |
| ---------- | ------------------------------- |
| Backend    | Java 21, Spring Boot            |
| ORM        | Spring Data JPA / Hibernate     |
| Database   | MySQL                           |
| Frontend   | React + Vite                    |
| Build Tool | Maven                           |
| Cache      | In-memory simulated cache nodes |
| Scheduling | Spring `@Scheduled`             |

---

# 🏗️ System Architecture

```text
Frontend (React + Vite)
        │
        ▼
Spring Boot REST APIs
        │
        ├── Suggest API
        ├── Search API
        ├── Trending API
        └── Cache Debug API
        │
        ▼
Distributed Cache Simulation
(Node-A / Node-B / Node-C)
        │
        ▼
Batch Update Buffer
        │
        ▼
MySQL Database
```

---

# ⚙️ How the System Works

## 1. User Types in Search Box

As the user types, the frontend waits briefly using debounce logic before sending a request to:

```http
GET /api/search/suggest?q=prefix
```

---

## 2. Cache Lookup

The backend first checks the cache.

The prefix is routed using:

```text
hash(prefix) % 3
```

This determines which simulated cache node owns the prefix.

Example:

```text
"iph" → Node-B
"bat" → Node-A
```

---

## 3. Cache Hit / Miss

### Cache Hit

Suggestions are returned immediately from memory.

### Cache Miss

The backend:

* queries MySQL
* ranks suggestions
* stores results in cache
* returns suggestions to frontend

---

## 4. Search Submission

When the user submits a search:

```http
POST /api/search
```

the query is added to an in-memory batch buffer.

Instead of writing directly to the database on every request, updates are grouped together and periodically flushed.

This reduces database pressure significantly.

---

## 5. Trending Searches

Trending searches are generated using:

* overall popularity
* recent activity

The system combines search frequency and recency to rank trending results.

---

# 📡 API Reference

---

## 🔹 Get Suggestions

```http
GET /api/search/suggest?q=iph
```

### Sample Response

```json
[
  "iphone",
  "iphone 15",
  "iphone charger"
]
```

---

## 🔹 Submit Search

```http
POST /api/search
```

### Request Body

```json
{
  "query": "chatgpt"
}
```

### Response

```json
{
  "message": "Search recorded successfully"
}
```

---

## 🔹 Trending Searches

```http
GET /api/search/trending
```

### Sample Response

```json
[
  "youtube",
  "chatgpt",
  "gmail"
]
```

---

## 🔹 Cache Debug API

```http
GET /api/search/cache/debug?prefix=iphone
```

### Sample Response

```json
{
  "prefix": "iphone",
  "cacheNode": "Node-A"
}
```

---

# 📦 Batch Write Strategy

Instead of updating MySQL for every search request:

1. Search events are temporarily buffered in memory
2. A scheduled task flushes updates periodically
3. Multiple updates are grouped together before persistence

### Benefits

* Reduced DB writes
* Better scalability
* Lower write pressure
* Faster request handling

---

# 🗂️ Distributed Cache Simulation

The system simulates distributed caching using multiple in-memory cache nodes:

* Node-A
* Node-B
* Node-C

Routing logic:

```text
hash(prefix) % 3
```

This ensures:

* deterministic routing
* even distribution
* scalable cache design concepts

---

# 📁 Project Structure

```text
typeahead/
│
├── typeahead-backend/
│   ├── src/main/java/com/tanmay/typeahead_backend
│   │
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── cache/
│   ├── batch/
│   └── config/
│
├── typeahead-frontend/
│   ├── src/
│   ├── App.jsx
│   ├── App.css
│   └── main.jsx
│
└── README.md
```

---

# 🚀 Setup Instructions

## Backend Setup

### 1. Create Database

```sql
CREATE DATABASE typeahead_db;
```

---

### 2. Configure MySQL

Update:

```text
src/main/resources/application.yaml
```

with your MySQL credentials.

---

### 3. Run Backend

```bash
cd typeahead-backend

./mvnw spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

# 💻 Frontend Setup

```bash
cd typeahead-frontend

npm install

npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

---

# 🔮 Future Improvements

* Redis integration
* Elasticsearch support
* Trie-based indexing
* Kafka event streaming
* Real-time analytics dashboard
* Advanced ranking algorithms
* Keyboard navigation support
* Docker deployment

---

# Typeahead Search

## Run with Docker

```bash
docker compose up --build

# 📚 Key Engineering Concepts Demonstrated

* Distributed caching
* Cache partitioning
* Cache invalidation
* Batch processing
* Ranking systems
* Debouncing
* REST API design
* Full-stack integration
* Backend scalability concepts

---

# ✅ Conclusion

This project demonstrates how a modern autocomplete system can be designed using scalable backend concepts while maintaining fast and responsive user experience.

Although simplified for academic purposes, the architecture mirrors several real-world engineering patterns used in production search systems.

---

# 👨‍💻 Author

**Tanmay Mittal**

Computer Science Student | Scaler School of Technology × BITS Pilani

Built as part of my learning journey in:
- Backend Development
- Distributed Systems
- Caching Strategies
- System Design
- Full-Stack Engineering

GitHub: https://github.com/tanmay933

---
