# Test Cases — Selenium Java Automation

> Functional test cases for the Sauce Demo Shopify demo storefront. Execution status should be updated only after an actual test run.

## Test Case Format

| Field | Description |
|---|---|
| ID | Unique test case identifier |
| Scenario | Business/functionality being validated |
| Preconditions | Required state before execution |
| Steps | Actions to perform |
| Expected Result | Expected application behavior |
| Priority | Business priority |
| Automation | Whether the scenario is a candidate for automation |

## Authentication & Navigation

| ID | Scenario | Preconditions | Steps | Expected Result | Priority | Automation |
|---|---|---|---|---|---|---|
| TC-001 | Launch storefront | Browser available | Open application URL | Storefront loads successfully | High | Yes |
| TC-002 | Verify page title | Application loaded | Read browser title | Expected title is displayed | Medium | Yes |
| TC-003 | Navigate to product details | Storefront loaded | Select a product | Product details page opens | High | Yes |
| TC-004 | Navigate back to storefront | Product details open | Use application/browser navigation | Storefront is displayed | Medium | Yes |
| TC-005 | Verify primary navigation | Storefront loaded | Inspect available navigation controls | Expected navigation controls are displayed and usable | Medium | Yes |

## Product Testing

| ID | Scenario | Preconditions | Steps | Expected Result | Priority | Automation |
|---|---|---|---|---|---|---|
| TC-006 | Verify product listing | Storefront loaded | Review available products | Products are displayed | High | Yes |
| TC-007 | Open a product | Product listing displayed | Click a product | Correct product details are displayed | High | Yes |
| TC-008 | Verify product name | Product details open | Read product name | Product name is displayed correctly | High | Yes |
| TC-009 | Verify product price | Product details open | Read product price | Product price is displayed correctly | High | Yes |
| TC-010 | Verify product description | Product details open | Read description | Product description is displayed | Medium | Yes |
| TC-011 | Verify product image | Product details open | Inspect product image | Product image is displayed | Low | Yes |
| TC-012 | Add product to cart | Product available | Select add-to-cart action | Product is added to cart | High | Yes |
| TC-013 | Add multiple products | Multiple products available | Add more than one product | Selected products are added to cart | High | Yes |
| TC-014 | Verify selected product information | Product added to cart | Open cart | Product name and relevant details match selection | High | Yes |

## Cart Testing

| ID | Scenario | Preconditions | Steps | Expected Result | Priority | Automation |
|---|---|---|---|---|---|---|
| TC-015 | Open cart | At least one product added | Open cart | Cart page is displayed | High | Yes |
| TC-016 | Verify cart product | Product added | Inspect cart | Correct product is present | High | Yes |
| TC-017 | Verify cart quantity | Product added | Inspect quantity | Quantity matches selected quantity | High | Yes |
| TC-018 | Verify cart price | Product added | Inspect price | Displayed price matches product price | High | Yes |
| TC-019 | Remove product from cart | Product present in cart | Remove product | Product is removed | High | Yes |
| TC-020 | Verify empty cart state | Cart contains no products | Open cart | Empty-cart state is handled correctly | Medium | Yes |
| TC-021 | Continue shopping | Cart page open | Select continue-shopping action | User returns to shopping experience | Medium | Yes |

## Checkout Testing

| ID | Scenario | Preconditions | Steps | Expected Result | Priority | Automation |
|---|---|---|---|---|---|---|
| TC-022 | Navigate to checkout | Product exists in cart | Select checkout | Checkout page/navigation is displayed | High | Yes |
| TC-023 | Verify checkout availability | Product exists in cart | Start checkout flow | Checkout flow is available according to application behavior | High | Yes |
| TC-024 | Verify checkout controls | Checkout page/flow available | Inspect required controls | Expected controls are displayed | Medium | Yes |
| TC-025 | Validate required checkout fields | Checkout form available | Leave required fields blank and continue | Appropriate validation is displayed | High | Yes |
| TC-026 | Enter valid checkout information | Checkout form available | Enter valid data | Data is accepted | High | Yes |
| TC-027 | Complete checkout flow | Valid checkout data available | Complete required steps | Order flow completes according to application behavior | High | Yes |

## Negative & Validation Testing

| ID | Scenario | Preconditions | Steps | Expected Result | Priority | Automation |
|---|---|---|---|---|---|---|
| TC-028 | Invalid checkout data | Checkout form available | Enter invalid data | Validation/error handling is displayed | High | Yes |
| TC-029 | Missing required product selection | No product selected | Attempt checkout where applicable | Application prevents invalid progression or displays appropriate handling | Medium | Yes |
| TC-030 | Invalid navigation state | Application loaded | Attempt unsupported/invalid navigation | Application handles navigation safely without unexpected failure | Medium | Manual |

## Regression Priorities

### P0 — Critical

- TC-001 Launch storefront
- TC-007 Open product
- TC-012 Add product to cart
- TC-015 Open cart
- TC-022 Navigate to checkout

### P1 — High

- TC-006 Product listing
- TC-008 Product name
- TC-009 Product price
- TC-013 Multiple products
- TC-016 Cart product
- TC-017 Cart quantity
- TC-018 Cart price
- TC-019 Remove product
- TC-025 Required checkout validation
- TC-026 Valid checkout information
- TC-027 Complete checkout

### P2 — Medium / Low

Navigation, presentation, empty-state and lower-risk validation scenarios.

## Execution Notes

The repository should report actual execution results separately from this design document. Do not mark a test as Passed or Failed here unless it has been executed against the current application version.

**Author:** A P Chandan  
**Role:** Software Test Engineer
