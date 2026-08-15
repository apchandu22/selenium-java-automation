# Selenium Java Automation — E-commerce UI Testing

A maintainable UI automation framework built with **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)**. The project demonstrates realistic e-commerce test automation, reusable framework components, configurable test execution, and CI execution with GitHub Actions.

## Objective

Automate critical e-commerce user journeys including:

- Storefront validation
- Product navigation
- Product selection
- Add-to-cart validation
- Checkout availability

## Tech Stack

- Java 11
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Maven
- Page Object Model (POM)
- Explicit waits / WebDriverWait
- XPath and CSS selectors
- Git / GitHub
- GitHub Actions

## Project Structure

```text
selenium-java-automation/
├── pom.xml
├── testng.xml
├── README.md
├── src/
│   └── test/
│       ├── java/
│       │   └── com/chandan/automation/
│       │       ├── base/
│       │       │   └── BaseTest.java
│       │       ├── pages/
│       │       │   ├── HomePage.java
│       │       │   ├── ProductPage.java
│       │       │   └── CartPage.java
│       │       ├── tests/
│       │       │   └── EcommerceFlowTest.java
│       │       └── utils/
│       │           └── ConfigReader.java
│       └── resources/
│           └── config.properties
└── .github/
    └── workflows/
        └── selenium-tests.yml
```

## Automated Test Coverage

| Test ID | Scenario | Type |
|---|---|---|
| AUTO-001 | Verify storefront loads | Smoke |
| AUTO-002 | Open product from storefront | Functional |
| AUTO-003 | Add product to cart and verify cart item | Functional |
| AUTO-004 | Verify checkout is available from cart | E2E |

## Framework Design

```text
TestNG Test
    ↓
BaseTest
    ↓
ConfigReader → config.properties
    ↓
Page Objects
    ↓
Selenium WebDriver
    ↓
Chrome Browser
```

### Framework practices

- Page Object Model for separation of test logic and locators
- Centralized browser setup and teardown
- Configuration-driven base URL and browser settings
- Explicit waits for dynamic UI elements
- Reusable page objects and methods
- Meaningful TestNG assertions
- Maven dependency management
- TestNG XML suite execution
- Git version control
- GitHub Actions CI execution

## Configuration

Test execution settings are maintained in:

`src/test/resources/config.properties`

Example:

```properties
browser=chrome
headless=false
base.url=https://sauce-demo.myshopify.com/
implicit.wait=0
explicit.wait=20
```

The framework reads these values through `ConfigReader` instead of hardcoding execution settings in test classes.

## Run Locally

### Prerequisites

- JDK 11+
- Maven 3.8+
- Google Chrome

### Run the complete suite

```bash
mvn clean test
```

### Run the TestNG suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## CI/CD

GitHub Actions executes the Maven/TestNG suite on:

- Push
- Pull request
- Manual workflow dispatch

Workflow:

`.github/workflows/selenium-tests.yml`

## Test Environment Note

This project uses a public demo e-commerce storefront for portfolio and learning purposes. UI selectors may require maintenance if the application changes.

## Author

**A P Chandan**  
Software Test Engineer | Manual Testing | Automation Testing | Selenium Java | API Testing | GenAI for QA
