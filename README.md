# Spring Data JPA Library Management System

## Improvements & Things to Add
- Unit tests (i dont have any)
- Custom exceptions from last time
- Look into DTO (data transfer objects), it might be of use.
- Find a better way to test the CRUD operations, surely having so many postman requests is not the best way to do it 


## Project Structure
```
src/main/java/com/futurespace/springdata
├── controller
│   ├── entity
│   │   ├── AuthorController.java
│   │   ├── BookController.java
│   │   ├── GenreController.java
│   │   ├── PublisherController.java
│   ├── BaseController.java
│
├── entity
│   ├── Author.java
│   ├── Book.java
│   ├── Genre.java
│   ├── Publisher.java
│
├── repository
│   ├── AuthorRepository.java
│   ├── BookRepository.java
│   ├── GenreRepository.java
│   ├── PublisherRepository.java
│
├── service
│   ├── entity
│   │   ├── AuthorService.java
│   │   ├── BookService.java
│   │   ├── GenreService.java
│   │   ├── PublisherService.java
│   ├── BaseService.java
│
├── config
│   ├── DatabaseConfig.java
│
├── SpringDataApplication.java
```


### Clone Repository
```sh
git clone https://github.com/your-repo/library-management-system.git
cd library-management-system
```

### Configure Database
Modify `src/main/resources/application.properties`:
```properties
spring.application.name=springdata
spring.datasource.url= -- MySQL Server URL here --
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```


# !Below not yet finished!
## API Endpoints
### **Author API** (`/authors`)
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/authors` | Create an author |
| `POST` | `/authors/bulk` | Bulk insert authors |
| `GET` | `/authors/{id}` | Get author by ID |
| `PUT` | `/authors/{id}` | Update author |
| `DELETE` | `/authors/{id}` | Delete author |

### **Book API** (`/books`)
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/books` | Create a book |
| `POST` | `/books/bulk` | Bulk insert books |
| `GET` | `/books/{isbn}` | Get book by ISBN |
| `GET` | `/books/published-after?date=YYYY-MM-DD` | Get books published after a date |
| `GET` | `/books/published-between?start=YYYY-MM-DD&end=YYYY-MM-DD` | Get books published between dates |
| `GET` | `/books/fixed-isbn?isbn=87919878` | Get book by specific ISBN |
| `GET` | `/books/published-by?publisher=PLANETA` | Get books published by a specific publisher |
| `GET` | `/books/published-by-between?publisher=RBA&start=YYYY&end=YYYY` | Get books by publisher within a date range |

### **Genre API** (`/genres`)
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/genres` | Create a genre |
| `GET` | `/genres/{id}` | Get genre by ID |

### **Publisher API** (`/publishers`)
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/publishers` | Create a publisher |
| `GET` | `/publishers/{id}` | Get publisher by ID |

