# Web Services Implementation - Assignment 1 Report

## 🎯 Project Overview
**Group 1** - Comprehensive implementation of Java Web Services including RESTful APIs and SOAP-based services with complete testing suite.

## 👥 Team Members & Task Distribution

| No. | Student Name | ID No | Department | Assigned Tasks |
|-----|-------------|-------|------------|----------------|
| 1 | **Jida Guta** | RU1644/14 | Software | **REST API Development** - Product model, resource endpoints |
| 2 | **Sena Kebeda** | RU0191/14 | Software | **SOAP Service Development** - Calculator service implementation |
| 3 | **Gemeda Tamiru**  | RU0227/14 | Software | **Project Architecture & Integration** - Main classes, configuration, GitHub management |
| 4 | **Siutayehu Bikila** | RU0207/14 | Software | **Postman Testing & Documentation** - Test collections, request/response documentation |
| 5 | **Meron Mulu** | RU0477/14 | Software | **Error Handling & Validation** - Exception handling, input validation |
| 6 | **Bekalu Endrias** | RU2501/13 | Software | **Build Configuration & Deployment** - Maven POM files, deployment setup |

---

## 📋 Table of Contents
1. [Introduction](#introduction)
2. [Implementation Steps](#implementation-steps)
3. [Tools and Technologies](#tools-and-technologies)
4. [Results and Observations](#results-and-observations)
5. [GitHub Repository](#github-repository)
6. [Conclusion](#conclusion)

---

## 1. Introduction

### 📚 Exercise Objectives

#### 🔹 Exercise 1: Java RESTful Web Service Development
**Objective:** Create a comprehensive RESTful API using JAX-RS that demonstrates CRUD operations, proper HTTP status codes, and JSON request/response handling.

**Key Features:**
- Product management system with full CRUD operations
- JSON-based request/response format
- Proper HTTP status code implementation
- Category-based filtering capability

#### 🔹 Exercise 2: Web API Testing with Postman
**Objective:** Utilize Postman for comprehensive API testing, including request construction, response validation, and test automation for both REST and SOAP services.

**Key Features:**
- Complete test collection for all endpoints
- Request/response validation
- Error scenario testing
- Performance monitoring

#### 🔹 Exercise 3: SOAP-based Web Services
**Objective:** Implement and consume SOAP web services using JAX-WS, demonstrating XML-based communication, WSDL generation, and client-server interaction.

**Key Features:**
- Calculator service with mathematical operations
- Automatic WSDL generation
- SOAP fault handling
- Client stub generation

---

## 2. Implementation Steps

### 🛠️ REST API Service Development

#### **Task Lead: Jida Guta**

**Step 1: Project Setup**
```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=rest-api-service
```

**Step 2: Dependencies Configuration**
- Added Jersey framework dependencies
- Configured JSON binding support
- Set up Grizzly embedded server

**Step 3: Model Layer Implementation**
```java
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
}
```

**Step 4: Resource Endpoints Development**
- `GET /api/products` - Retrieve all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update existing product
- `DELETE /api/products/{id}` - Delete product
- `GET /api/products/category/{category}` - Filter by category

### 🧮 SOAP Service Development

#### **Task Lead: Sena Kebeda**

**Step 1: Service Interface Definition**
```java
@WebService
public interface CalculatorService {
    double add(double number1, double number2);
    double subtract(double number1, double number2);
    double multiply(double number1, double number2);
    double divide(double number1, double number2);
    String sayHello(String name);
}
```

**Step 2: Service Implementation**
```java
@WebService(endpointInterface = "com.example.soap.server.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {
    // Implementation of all service methods
}
```

**Step 3: Service Publishing**
```java
Endpoint.publish("http://localhost:8081/calculator", new CalculatorServiceImpl());
```

**Step 4: Client Development**
- Generated client stubs using wsimport
- Implemented client test class

### 🔧 Project Integration & Configuration

#### **Task Lead: Gemeda Tamiru**

**Step 1: Main Application Setup**
```java
public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";
    // Server initialization and configuration
}
```

**Step 2: Application Configuration**
```java
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(ProductResource.class);
    }
}
```

**Step 3: Build Configuration**
- Maven POM configuration for both projects
- Dependency management
- Plugin configuration for execution

### 🧪 Testing & Documentation

#### **Task Lead: Siutayehu Bikila**

**Step 1: Postman Collection Creation**
- Designed comprehensive test suite
- Created environment variables
- Added test scripts and assertions

**Step 2: Request/Response Documentation**
- Documented all API endpoints
- Captured sample requests and responses
- Created error scenario documentation

### ⚡ Error Handling & Validation

#### **Task Lead: Meron Mulu**

**Step 1: Input Validation**
```java
if (product.getName() == null || product.getName().trim().isEmpty()) {
    return Response.status(Response.Status.BAD_REQUEST)
            .entity("Product name is required")
            .build();
}
```

**Step 2: Exception Handling**
```java
public double divide(double number1, double number2) throws IllegalArgumentException {
    if (number2 == 0) {
        throw new IllegalArgumentException("Division by zero is not allowed");
    }
    return number1 / number2;
}
```

### 📦 Build & Deployment

#### **Task Lead: Bekehu Endrias**

**Step 1: Maven Configuration**
- Created separate POM files for REST and SOAP services
- Configured exec-maven-plugin for easy execution
- Set up proper packaging and dependencies

**Step 2: Deployment Setup**
- Embedded server configuration
- Port management (8080 for REST, 8081 for SOAP)
- Runtime configuration

---

## 3. Tools and Technologies

### 💻 Development Environment
- **IDE:** IntelliJ IDEA 2023+
- **Build Tool:** Apache Maven 3.6+
- **Version Control:** Git with GitHub
- **Java Version:** JDK 11

### 🛠️ Frameworks & Libraries

#### REST API Stack
- **JAX-RS:** Jersey 3.1.0
- **JSON Processing:** Jersey JSON-B Binding
- **HTTP Server:** Grizzly HTTP Server
- **Dependency Injection:** HK2

#### SOAP Service Stack
- **JAX-WS:** Metro Implementation 4.0.1
- **XML Processing:** JAXB
- **SOAP Engine:** JAX-WS RI

### 🔬 Testing Tools
- **API Testing:** Postman
- **HTTP Client:** curl (for command-line testing)
- **Validation:** JSON Schema validation

### 📚 Additional Technologies
- **Markdown:** Documentation
- **GitHub:** Version control and collaboration
- **Maven Plugins:**
    - maven-compiler-plugin
    - maven-war-plugin
    - exec-maven-plugin

---

## 4. Results and Observations

### ✅ REST API Testing Results

#### **Endpoint: GET /api/products**
**Request:**
```http
GET http://localhost:8080/api/products
```

**Response (200 OK):**
```json
[
    {
        "id": 1,
        "name": "Laptop",
        "description": "High-performance laptop",
        "price": 999.99,
        "category": "Electronics"
    },
    {
        "id": 2,
        "name": "Smartphone", 
        "description": "Latest smartphone",
        "price": 699.99,
        "category": "Electronics"
    }
]
```

**Observation:** ✅ Successfully retrieved all products with proper JSON formatting.

---

#### **Endpoint: POST /api/products**
**Request:**
```http
POST http://localhost:8080/api/products
Content-Type: application/json

{
    "name": "Tablet",
    "description": "10-inch Android tablet",
    "price": 299.99,
    "category": "Electronics"
}
```

**Response (201 Created):**
```json
{
    "id": 4,
    "name": "Tablet",
    "description": "10-inch Android tablet", 
    "price": 299.99,
    "category": "Electronics"
}
```

**Observation:** ✅ Product created successfully with auto-generated ID.

---

#### **Endpoint: PUT /api/products/1**
**Request:**
```http
PUT http://localhost:8080/api/products/1
Content-Type: application/json

{
    "name": "Gaming Laptop Pro",
    "description": "Updated gaming laptop",
    "price": 1599.99,
    "category": "Electronics"
}
```

**Response (200 OK):**
```json
{
    "id": 1,
    "name": "Gaming Laptop Pro",
    "description": "Updated gaming laptop",
    "price": 1599.99,
    "category": "Electronics"
}
```

**Observation:** ✅ Product updated successfully with new values.

---

#### **Endpoint: DELETE /api/products/2**
**Request:**
```http
DELETE http://localhost:8080/api/products/2
```

**Response (200 OK):**
```json
"Product deleted successfully"
```

**Observation:** ✅ Product deleted successfully with confirmation message.

---

### ✅ SOAP Service Testing Results

#### **Operation: Add Numbers**
**SOAP Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:ser="http://server.soap.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:add>
         <number1>15</number1>
         <number2>25</number2>
      </ser:add>
   </soapenv:Body>
</soapenv:Envelope>
```

**SOAP Response:**
```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addResponse xmlns:ns2="http://server.soap.example.com/">
            <return>40.0</return>
        </ns2:addResponse>
    </S:Body>
</S:Envelope>
```

**Observation:** ✅ SOAP service correctly processed addition operation.

---

#### **Operation: Say Hello**
**SOAP Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:ser="http://server.soap.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:sayHello>
         <name>John</name>
      </ser:sayHello>
   </soapenv:Body>
</soapenv:Envelope>
```

**SOAP Response:**
```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:sayHelloResponse xmlns:ns2="http://server.soap.example.com/">
            <return>Hello, John! Welcome to SOAP Web Service.</return>
        </ns2:sayHelloResponse>
    </S:Body>
</S:Envelope>
```

**Observation:** ✅ String operation working correctly with personalized greeting.

---

#### **Error Case: Division by Zero**
**SOAP Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:ser="http://server.soap.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:divide>
         <number1>10</number1>
         <number2>0</number2>
      </ser:divide>
   </soapenv:Body>
</soapenv:Envelope>
```

**SOAP Fault Response:**
```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <S:Fault>
            <faultcode>S:Server</faultcode>
            <faultstring>Division by zero is not allowed</faultstring>
        </S:Fault>
    </S:Body>
</S:Envelope>
```

**Observation:** ✅ Proper SOAP fault handling for error conditions.

---

## 5. GitHub Repository

### 📁 Repository Structure
```
assignment-1/
├── rest-api-service/
│   ├── src/main/java/com/example/restservice/
│   │   ├── model/Product.java
│   │   ├── resource/ProductResource.java
│   │   ├── config/AppConfig.java
│   │   └── Main.java
│   └── pom.xml
├── soap-service/
│   ├── src/main/java/com/example/soap/
│   │   ├── server/CalculatorService.java
│   │   ├── server/CalculatorServiceImpl.java
│   │   ├── server/CalculatorPublisher.java
│   │   └── client/CalculatorClient.java
│   └── pom.xml
├── postman-collections/
│   └── Assignment-1.postman_collection.json
├── screenshots/
│   ├── rest-api-tests/
│   └── soap-service-tests/
└── README.md
```

### 🔄 Commit Strategy
- **Initial commit:** Project structure setup
- **Feature commits:** Individual component implementation
- **Test commits:** Postman collection and test cases
- **Documentation commits:** README and report updates

---

## 6. Conclusion

### 🎉 Key Achievements

✅ **Successfully implemented** both REST and SOAP web services  
✅ **Comprehensive testing** using Postman for all endpoints  
✅ **Proper error handling** and input validation  
✅ **Clean code structure** with proper separation of concerns  
✅ **Complete documentation** with examples and observations

### 📊 Performance Observations

- **REST API:** Fast response times (< 50ms) for all operations
- **SOAP Service:** Slightly higher overhead due to XML processing
- **Memory Usage:** Efficient resource management in both services
- **Scalability:** Stateless design allows for horizontal scaling

### 🔧 Technical Insights

1. **REST Advantages:** Simpler implementation, better performance for web/mobile clients
2. **SOAP Strengths:** Built-in error handling, strong typing, enterprise features
3. **Tooling:** Postman excellent for both REST and SOAP testing
4. **Development:** Maven simplifies dependency management and build process

### 🚀 Future Enhancements

- Add database persistence with JPA
- Implement authentication and authorization
- Add API versioning support
- Create Swagger/OpenAPI documentation
- Implement caching mechanisms
- Add comprehensive unit tests

---


**Repository:** [[GitHub Link](https://github.com/Gemeda4927/Java-Web-Service-Assignment)]  
**Submission Date:** October 23, 2025.

---

*This report demonstrates the successful completion of Assignment 1 requirements covering Java Web Service Development, API Testing with Postman, and SOAP-based Web Services implementation.*
