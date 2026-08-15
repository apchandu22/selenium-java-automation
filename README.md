# 🖥️ Selenium Java Automation — Sauce Demo Shopify

A practical UI automation project using **Selenium WebDriver + Java + TestNG + Maven + Page Object Model (POM)** for a demo e-commerce storefront.

## 🎯 Objective

Demonstrate maintainable end-to-end web automation for product navigation, product selection, cart validation and checkout navigation.

## 🛠️ Tech Stack

- Java 11+
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Maven
- Page Object Model (POM)
- WebDriverWait / Explicit Waits
- XPath / CSS Selectors
- Assertions
- Git / GitHub
- GitHub Actions

## 📂 Project Structure

```text
selenium-java-automation/
├── pom.xml
├── testng.xml
├── README.md
├── src/
│   └── test/
│       └── java/
│           └── com/chandan/automation/
│               ├── base/
│               │   └── BaseTest.java
│               ├── pages/
│               │   ├── HomePage.java
│               │   ├── ProductPage.java
│               │   └── CartPage.java
│               └── tests/
│                   └── EcommerceFlowTest.java
└── .github/
    └── workflows/
        └── selenium-tests.yml
```

## 🧪 Automated Coverage

| Test ID | Scenario | Type |
|---|---|---|
| AUTO-001 | Launch storefront and verify title | Smoke |
| AUTO-002 | Open product from storefront | Functional |
| AUTO-003 | Verify product details | Functional |
| AUTO-004 | Add product to cart | Functional |
| AUTO-005 | Verify cart contains selected product | Functional |
| AUTO-006 | Navigate toward checkout | E2E |

## 🏗️ Framework Design

```text
Test Class
   ↓
Page Objects
   ↓
Reusable Locators / Actions
   ↓
Selenium WebDriver
   ↓
Browser
```

### Framework practices demonstrated

- Page Object Model for maintainability
- Reusable page objects
- Centralized browser setup/teardown
- Explicit waits for dynamic elements
- Meaningful TestNG assertions
- Maven dependency management
- TestNG suite execution
- CI-ready GitHub Actions workflow

## ▶️ Run Locally

### Prerequisites

- JDK 11+
- Maven 3.8+
- Chrome browser

### Execute tests

```bash
mvn clean test
```

### Execute TestNG suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## ⚙️ CI/CD

GitHub Actions runs the Maven/TestNG suite on repository pushes, pull requests, and manual workflow dispatch.

## ⚠️ Test Environment Note

This is a public demo storefront used for portfolio and learning purposes. UI selectors can change when the site changes.

## 👨‍💻 Author

**A P Chandan** — Software Test Engineer | Manual Testing | API Testing | Selenium Java | GenAI for QA
