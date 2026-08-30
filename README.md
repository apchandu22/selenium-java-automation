# 🤖 Selenium Java Automation Framework

![Java](https://img.shields.io/badge/Java-11%2B-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.35.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red)
![Maven](https://img.shields.io/badge/Maven-build-blue)
![CI](https://github.com/apchandu22/selenium-java-automation/actions/workflows/selenium-tests.yml/badge.svg)

A maintainable **Selenium WebDriver + Java + TestNG + Maven** UI automation framework built using the **Page Object Model (POM)**. This portfolio project demonstrates practical QA automation, reusable framework design, configuration management, explicit synchronization, assertions, reporting, screenshots and GitHub Actions CI.

> **Portfolio:** Designed to demonstrate hands-on Software Testing and Automation skills to recruiters, QA teams and freelance clients.

## 🎯 Project Objective

Automate and validate critical user journeys of a public demo e-commerce storefront using a maintainable, reusable and readable automation framework.

## 🧪 Current Test Coverage

| Area | Coverage |
|---|---|
| Application launch | Smoke validation |
| Product navigation | Functional |
| Product details | Functional |
| Add to cart | Functional |
| Cart validation | Functional |
| Checkout availability | E2E |

Detailed QA documentation is available under [`docs/`](docs/).

## 🛠️ Tech Stack

- **Language:** Java 11+
- **UI Automation:** Selenium WebDriver 4.35.0
- **Test Framework:** TestNG 7.11.0
- **Build:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Synchronization:** Explicit WebDriverWait
- **Locators:** XPath and CSS Selectors
- **Assertions:** TestNG
- **Reporting:** Extent Reports + Surefire/TestNG reports
- **Version Control:** Git / GitHub
- **CI:** GitHub Actions

## 🏗️ Framework Architecture

```text
TestNG Tests
     │
     ▼
  BaseTest
     │
     ├──────────────► ConfigReader
     │
     ▼
  Page Objects
     │
     ▼
  BasePage / Utilities
     │
     ▼
Selenium WebDriver
     │
     ▼
 Web Application
```

## 📂 Project Structure

```text
selenium-java-automation/
│
├── .github/workflows/
│   └── selenium-tests.yml
│
├── docs/
│   ├── test-plan/TestPlan.md
│   ├── test-cases/TestCases.md
│   ├── bug-reports/BugReports.md
│   └── screenshots/README.md
│
├── src/test/java/com/chandan/automation/
│   ├── base/
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   ├── data/
│   │   └── TestData.java
│   ├── pages/
│   │   ├── HomePage.java
│   │   ├── ProductPage.java
│   │   └── CartPage.java
│   ├── tests/
│   │   └── EcommerceFlowTest.java
│   └── utils/
│       ├── ConfigReader.java
│       ├── ExtentReportManager.java
│       ├── ScreenshotUtil.java
│       └── TestListener.java
│
├── src/test/resources/
│   └── config.properties
│
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

## 🔧 Framework Features

- Page Object Model for separation of test logic and locators
- Reusable `BasePage` Selenium actions
- Centralized browser setup and teardown
- Configuration-driven browser, URL and wait settings
- Explicit waits instead of relying on implicit synchronization
- Test data separated from page objects
- Meaningful TestNG assertions
- Failure screenshot capture
- Extent HTML reporting
- TestNG/Surefire reporting
- Maven execution
- Headless CI execution
- GitHub Actions integration

## ⚙️ Configuration

Execution settings are maintained in:

`src/test/resources/config.properties`

```properties
browser=chrome
headless=false
base.url=https://sauce-demo.myshopify.com/
implicit.wait=0
explicit.wait=20
```

Command-line overrides are supported for browser/headless execution, for example:

```bash
mvn clean test -Dheadless=true
```

## ▶️ Run Locally

### Prerequisites

- JDK 11 or later
- Maven 3.8+
- Google Chrome
- Internet connection to access the demo application

### Run the suite

```bash
mvn clean test
```

### Run headless

```bash
mvn clean test -Dheadless=true
```

## 🔄 CI/CD

GitHub Actions executes the Maven/TestNG suite on:

- Push
- Pull request
- Manual workflow dispatch

The workflow uploads available Surefire/TestNG reports, Extent reports and failure screenshots as CI artifacts.

## 📋 QA Documentation

| Document | Purpose |
|---|---|
| [Test Plan](docs/test-plan/TestPlan.md) | Scope, approach, environment, risks and exit criteria |
| [Test Cases](docs/test-cases/TestCases.md) | Functional scenarios and regression priorities |
| [Bug Reports](docs/bug-reports/BugReports.md) | Professional defect-reporting format |
| [Test Evidence](docs/screenshots/README.md) | Screenshot and execution-evidence guidelines |

## 📊 Test Results

Test results should be reported from actual executions. The repository intentionally does not publish fabricated pass/fail counts or invented defects.

## ⚠️ Test Environment Note

This project uses a public demo storefront for portfolio and learning purposes. Application UI changes or availability may require locator and workflow maintenance.

## 👨‍💻 Author

**A P Chandan**  
Software Test Engineer | Manual Testing | Selenium Java | API Testing | SQL

Open to **Software Test Engineer / QA Engineer** opportunities and freelance/contract QA projects.

🔗 [GitHub](https://github.com/apchandu22)  
💼 [LinkedIn](https://www.linkedin.com/in/a-p-chandan-1b0b3921b/)
