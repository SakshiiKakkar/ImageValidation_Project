# Image Gallery Automation Framework

## Project Overview

This project contains UI and API automation frameworks developed for the Image Gallery assessment.

The framework covers:

- UI Integration Testing using Playwright + TypeScript
- API Automation Testing using Java + RestAssured + TestNG
- Mocked API integration using `page.route()`
- CRUD API validations
- Reusable Page Object Model architecture

---

# Tech Stack

## UI Automation

- Playwright
- TypeScript

## API Automation

- Java
- RestAssured
- TestNG
- Jackson

---

# Project Structure

```text
ImageValidations
│
├── api-tests
│   └── src/test/java
│       ├── models
│       ├── tests
│       └── utils
│
└── ui-tests
    ├── fixtures
    ├── pages
    ├── tests
    │   ├── integration
    │   └── e2e
    └── playwright.config.ts
# UI Test Coverage

## Integration Tests

- Verify gallery loads successfully
- Verify search functionality
- Verify add image functionality

### Key Concepts Used

- Page Object Model (POM)
- Reusable BasePage
- Mocked APIs using `page.route()`
- Semantic locators
- Reusable utilities

---

# API Test Coverage

## GET API

- Validate status code
- Validate response body
- Validate response time
- Validate content type

## POST API

- Validate image creation
- Validate response payload
- Validate response status

## DELETE API

- Validate image deletion
- Validate response status

---

# Framework Features

- Modular architecture
- Reusable utilities
- Config-driven endpoints
- Test data separation
- POJO-based payload handling
- Jackson serialization/deserialization

---

# Execution Commands

## UI Tests

```bash
npx playwright test

# Assumptions

- Frontend application source code was not provided as part of the assessment.
- API endpoints were implemented based on assessment requirements.
- Localhost configuration (`http://localhost:3000`) was used as per documentation.
- Mocked APIs were implemented for UI integration testing.

---

# Author

Sakshi Kakkar
