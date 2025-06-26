# OpenWeatherMap API Spring Boot Application

This is a Spring Boot application that provides a RESTful API to fetch weather information using the OpenWeatherMap API.

## Features

- Fetch current weather data by city name
- RESTful API endpoints
- Spring Boot 3.5.3 implementation
- Easy configuration through application properties

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- OpenWeatherMap API key

## Configuration

1. Clone the repository
2. Update `src/main/resources/application.properties` with your OpenWeatherMap API key:
   ```properties
   openweathermap.api.key=YOUR_API_KEY
   ```

## Building the Application

To build the application, run:

```bash
mvn clean install
```

## Running the Application

To start the application, run:

```bash
mvn spring-boot:run
```

The application will start on the default port 8080.

## API Endpoints

### Get Weather by City

```
GET /weather/{city}
```

Example:
```
GET /weather/London
```

Response:
```json
{
    "weather information will be returned here"
}
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── openweathermap/
│   │           ├── controller/
│   │           │   └── WeatherController.java
│   │           ├── model/
│   │           │   └── WeatherResponse.java
│   │           ├── service/
│   │           │   └── WeatherService.java
│   │           └── OpenweathermapApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── openweathermap/
                └── OpenweathermapApplicationTests.java
```

## Technologies Used

- Spring Boot 3.5.3
- Spring Web
- Maven
- OpenWeatherMap API

## License

This project is available under the [insert license] license.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
