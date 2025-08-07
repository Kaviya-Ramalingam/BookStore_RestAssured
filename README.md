# BookStore RestAssured API Test Automation

This repository contains automated API tests for the [BookStore API](https://bookstore.toolsqa.com/) using **Rest Assured**, **Cucumber BDD**, and **Java**. The framework is data-driven and follows best practices for maintainable and scalable test automation.

## Features

- **REST Assured** for HTTP requests and assertions
- **Cucumber BDD** for human-readable test scenarios
- **Data-driven testing** using Excel for test data
- **Modular step definitions** for reusability
- **Utility classes** for common actions and payload management
- **Extensible structure** to support user and book modules (create, update, delete, fetch)

## Project Structure

```
src/
  main/
    java/
      API/BookStore_RestAssured/    # (Optional) Project entry point placeholder
  test/
    java/
      features/                     # Cucumber .feature files
      stepDefinitions/              # Cucumber step definition classes
      utilities/                    # Utility and helper classes (Excel, TestData, etc.)
    resources/
      BookStore_API.xlsx            # Excel file for test data
```

## Setup

### Prerequisites

- Java 8 or above
- Maven (for dependency management and build)
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Dependencies

Key dependencies (see `pom.xml` for full list):
- `rest-assured`
- `cucumber-java`
- `cucumber-junit`
- `junit`
- `poi` (for Excel reading)

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/Kaviya-Ramalingam/BookStore_RestAssured.git
    cd BookStore_RestAssured
    ```

2. **Install dependencies:**
    ```bash
    mvn clean install
    
## Running Tests

You can run the tests using Maven:

```bash
mvn test
```

Or from your IDE, run the Cucumber runner or individual feature files.



## Logging & Debugging

- HTTP requests and responses are logged using Rest Assured’s `.log().all()` for easy debugging.
- For custom debug messages, consider using a logger (e.g., SLF4J).


## License

[MIT](LICENSE)  
(C) Kaviya Ramalingam

---

**Happy Testing!**
