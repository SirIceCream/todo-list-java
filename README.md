# To-Do Application

This project is a web application that manages to-do items, connecting to MongoDB for data storage.

## Features

- Save new todos
- Display all existing todos
- Mark a todo as done
- Delete a todo

## Technical Details

- **Backend**: Java with Spring Boot
- **Database**: MongoDB
- **Port**: 9000

## API Endpoints

- `GET /todos`: Retrieve all todos
- `GET /todos/{id}`: Retrieve a specific todo
- `POST /todos`: Create a new todo
- `PUT /todos/{id}/done`: Mark a todo as done
- `DELETE /todos/{id}`: Delete a todo

## Key Components

- `ToDo` data class
- `ToDoRepository` for database operations
- `ToDoManager` and `ToDosEndpoint` beans for business logic and API handling
- `CorsConfiguration` for security settings

## Highlighted Code

The `CorsConfiguration` class showcases how the application handles Cross-Origin Resource Sharing (CORS):

```java
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
   @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE");
   }
}
```

This configuration allows external applications to interact with the To-Do API, enabling a separate frontend to communicate with this backend service.

## Testing

The project includes unit tests for `ToDoManager` and `ToDosEndpoint` to ensure reliability.
