# 🤖 Selenium Java Automation — E-commerce UI Testing

A maintainable **Selenium WebDriver + Java + TestNG + Maven** automation framework built using the **Page Object Model (POM)**. The project demonstrates practical UI automation, reusable framework components, configuration management, reporting and CI execution with GitHub Actions.

> **Portfolio project:** Built to demonstrate real-world QA automation practices for recruiters, QA teams and freelance clients.

## 🎯 Project Objective

Automate critical e-commerce user journeys and validate the application through reusable, maintainable and readable automated tests.

### Current coverage

- Storefront validation
- Product navigation
- Product details validation
- Product selection
- Add-to-cart validation
- Cart validation
- Checkout navigation

## 🛠️ Tech Stack

- **Language:** Java 11+
- **Automation:** Selenium WebDriver 4.35.0
- **Test Framework:** TestNG 7.11.0
- **Build:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Synchronization:** Explicit Wait / WebDriverWait
- **Locators:** XPath, CSS Selectors
- **Assertions:** TestNG Assertions
- **Reporting:** Extent Reports
- **Version Control:** Git / GitHub
- **CI:** GitHub Actions

## 🏗️ Framework Architecture

```text
                    TestNG Tests
                         │
                         ▼
                     BaseTest
                         │
              ┌──────────┴──────────┐
              ▼                     ▼
        ConfigReader          Test Utilities
              │              / Screenshot / Reports
              ▼                     │
        Page Objects ◄──────────────┘
              │
              ▼
        Selenium WebDriver
              │
              ▼
          Web Browser
```

## 📂 Project Structure

```text
selenium-java-automation/
│
├── .github/
│   └── workflows/
│       └── selenium-tests.yml
│
├── src/
│   └── test/
│       ├── java/
│       │   └── com/chandan/automation/
│       │       ├── base/
│       │       │   └── BaseTest.java
│       │       ├── data/
│       │       │   └── TestData.java
│       │       ├── pages/
│       │       │   ├── HomePage.java
│       │       │   ├── ProductPage.java
│       │       │   └── CartPage.java
│       │       ├── tests/
│       │       │   └── EcommerceFlowTest.java
│       │       └── utils/
│       │           ├── ConfigReader.java
│       │           ├── ExtentReportManager.java
│       │           ├── ScreenshotUtil.java
│       │           └── TestListener.java
│       │
│       └── resources/
│           └── config.properties
│
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

## 🧪 Automated Test Coverage

| Test ID | Scenario | Type |
|---|---|---|
| AUTO-001 | Verify storefront loads | Smoke |
| AUTO-002 | Open product from storefront | Functional |
| AUTO-003 | Verify product details | Functional |
| AUTO-004 | Add product to cart and verify cart item | Functional |
| AUTO-005 | Verify checkout is available from cart | E2E |

> Test coverage will be expanded as the framework evolves. Test IDs are maintained so the automated suite can be mapped to documented QA test cases.

## 🔧 Framework Features

- Page Object Model for separation of test logic and locators
- Centralized browser setup and teardown
- Configuration-driven browser and URL settings
- Explicit waits for dynamic elements
- Reusable page actions
- Meaningful TestNG assertions
- Test data management
- Failure screenshot capture
- Extent HTML reporting
- TestNG suite execution
- Maven dependency management
- GitHub Actions CI execution
- Headless execution support for CI

## ⚙️ Configuration

Execution settings are maintained in:

`src/test/resources/config.properties`

Example:

```properties
browser=chrome
headless=false
base.url=https://sauce-demo.myshopify.com/
implicit.wait=0
explicit.wait=20
```

Headless execution can also be overridden from the command line:

```bash
mvn clean test -Dheadless=true
```

## ▶️ Run Locally

### Prerequisites

- JDK 11 or later
- Maven 3.8+
- Google Chrome

### Run the complete TestNG suite

```bash
mvn clean test
```

### Run using the TestNG suite file

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## 🔄 CI/CD

GitHub Actions runs the Maven/TestNG suite on:

- Push
- Pull request
- Manual workflow dispatch

The workflow also uploads test reports and failure screenshots as CI artifacts when available.

Workflow file:

`.github/workflows/selenium-tests.yml`

## 📊 Reporting & Evidence

The framework supports:

- TestNG/Surefire execution reports
- Extent HTML reports
- Failure screenshots

QA documentation and additional evidence will be maintained under `docs/` as the portfolio expands.

## 📋 Planned Portfolio Documentation

```text
docs/
├── test-plan/
├── test-cases/
├── bug-reports/
└── screenshots/
```

These documents will demonstrate not only automation skills, but also practical QA activities such as test planning, test-case design, defect reporting and execution evidence.

## ⚠️ Test Environment Note

This project uses a public demo e-commerce storefront for portfolio and learning purposes. UI selectors and workflows may require maintenance if the application changes.

## 👨‍💻 Author

**A P Chandan**  
Software Test Engineer | Manual Testing | Selenium Java | API Testing | SQL

Open to **Software Test Engineer / QA Engineer opportunities** and suitable freelance / contract QA projects.
