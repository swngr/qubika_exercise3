# Automated Testing Solution for Qubika Website

## Overview
This project automates the workflow for validating key functionalities on the Qubika website (www.qubika.com) using Selenium, Java, and TestNG. The solution includes the following automated steps:

## Enhancements

### Design Improvements
- **Page Object Model (POM):**
  - Implemented a modular structure with dedicated page classes for easier maintainability and scalability.

- **Reusable Utilities:**
  - Introduced helper classes like `WaitForLoad` for consistent and efficient page load handling.

- **Validation Methods:**
  - Centralized validation logic for form fields and error messages.

### Reporting
- Integrated TestNG for structured test reporting, providing clear pass/fail statuses for each test step.

## Project Structure

```
project-root
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Helpers
│   │   │   │   └── WaitForLoad.java
│   │   │   ├── Pages
│   │   │   │   ├── ContactUsForm.java
│   │   │   │   └── HomePage.java
│   ├── test
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseTest.java
│   │   │   ├── homepage
│   │   │   │   └── HomePageTest.java
└── pom.xml
```

### Class Details
- **`WaitForLoad`**: A utility class for managing explicit waits during page and element loading.
- **`ContactUsForm`**: Handles interactions and validations related to the contact form.
- **`HomePage`**: Manages actions and verifications on the homepage.
- **`BaseTest`**: Sets up and tears down the test environment.
- **`HomePageTest`**: Contains test cases for homepage and contact form workflows.

## Prerequisites

Ensure the following tools are installed and configured:

- **Java Development Kit (JDK)**: Version 8 or higher.
- **IntelliJ IDEA (Community Edition)**
- **Selenium WebDriver**
- **TestNG**
- **Maven**: For dependency management.

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/swngr/qubika_exercise3
   cd <your-repository-directory>
   ```

2. Import the project into IntelliJ IDEA as a Maven project.

3. Install dependencies:
   ```bash
   mvn clean install
   ```

4. Configure WebDriver:
   - Download the appropriate WebDriver for your browser (e.g., ChromeDriver).
   - Update the driver path in `BaseTest.java`:
     ```java
     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
     ```

## Running Tests

1. Execute tests using IntelliJ:
   - Open the `HomePageTest` class.
   - Right-click on the class or specific methods and select **Run**.

2. Execute tests using Maven:
   ```bash
   mvn test
   ```

3. Execute tests using TestNG:
   ```bash
   To run an individual test, click Run in the gutter and select Run.
   To run all tests in a test class, click Run against the test class declaration and select Run.
   ```


## Execution Report

Upon test completion, a detailed TestNG report is generated in the `test-output` directory. Open the `xxxx.html` file in a browser to view the report.

---
