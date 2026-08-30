# Test Plan — Selenium Java Automation

## 1. Document Information

| Item | Details |
|---|---|
| Project | Selenium Java Automation |
| Application | Sauce Demo Shopify storefront |
| Test Type | Web UI Functional & Regression Testing |
| Automation Tool | Selenium WebDriver |
| Language | Java |
| Test Framework | TestNG |
| Build Tool | Maven |
| Automation Pattern | Page Object Model (POM) |

## 2. Objective

The objective of this test plan is to validate the core user journeys of the demo e-commerce storefront through functional manual testing and automated UI testing.

The automation framework is designed to demonstrate maintainable Selenium automation, reusable page objects, explicit waits, assertions, reporting, screenshots, and CI execution.

## 3. Scope

### In Scope

- Application launch and basic navigation
- Product listing and product details
- Product selection
- Add-to-cart functionality
- Cart validation
- Checkout navigation
- UI element and text validation
- Functional regression scenarios
- Automated execution using Selenium WebDriver and TestNG

### Out of Scope

- Production payment processing
- Performance/load testing
- Security/penetration testing
- Database validation unless separately configured
- Real customer data validation

## 4. Test Approach

Testing follows a risk-based functional approach. Critical customer journeys are prioritized for automation.

### Manual Testing

- Positive scenarios
- Negative scenarios
- Boundary and validation checks where applicable
- Exploratory checks
- Defect documentation

### Automation Testing

- Smoke tests for basic application availability
- Functional UI scenarios
- End-to-end shopping flow validation
- Regression execution
- Screenshot capture on failures
- CI execution through GitHub Actions

## 5. Test Environment

- Operating System: Windows / CI Linux environment
- Browser: Google Chrome
- Java: JDK 11+
- Selenium WebDriver: 4.35.0
- TestNG: 7.11.0
- Maven: 3.8+

## 6. Entry Criteria

- Application is accessible
- Required test environment is available
- Test data is available
- Browser and required dependencies are configured
- Automation suite can be executed successfully

## 7. Exit Criteria

- Planned test scenarios are executed
- Critical defects are documented
- Automated regression suite completes
- Test results are reviewed
- Known limitations are documented

## 8. Deliverables

- Test Plan
- Test Cases
- Automated Test Scripts
- Bug Reports
- Screenshots / Test Evidence
- Automation Execution Reports
- CI/CD Execution Results

## 9. Risks and Mitigation

| Risk | Mitigation |
|---|---|
| UI changes may break locators | Maintain locators in page objects |
| Dynamic elements may cause timing issues | Use explicit waits |
| Demo application availability may vary | Record environment limitations |
| Test data may become unavailable | Use controlled test data |
| Browser/version differences | Execute tests in supported browser versions |

## 10. Automation Architecture

```text
TestNG Test Classes
        ↓
Page Object Classes
        ↓
Reusable Utilities / Base Test
        ↓
Selenium WebDriver
        ↓
Web Browser
        ↓
Application Under Test
```

## 11. Defect Management

Defects identified during testing should include:

- Defect ID
- Title
- Module
- Severity
- Priority
- Environment
- Preconditions
- Reproduction steps
- Expected result
- Actual result
- Evidence
- Status

## 12. Reporting

Test execution results are generated through the automation reporting mechanism. Screenshots and other evidence should be retained for failed scenarios where applicable.

## 13. Maintenance

The framework will be maintained as the application UI changes. Locators, test data, page objects, and reusable utilities should be updated without unnecessarily duplicating automation code.

---

**Author:** A P Chandan  
**Role:** Software Test Engineer
