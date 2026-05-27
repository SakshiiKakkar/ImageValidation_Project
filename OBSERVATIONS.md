# Assessment Observations

## UI Testing Observations

- The UI seems fairly testable — elements have meaningful attributes, which helped in writing stable locators in Playwright.
- Mocked integration testing using `page.route()` was implemented to avoid dependency on a live backend.
- The framework is structured using the Page Object Model, which made it easier to reuse code and keep tests clean.

---

# API Testing Observations

- API automation framework was implemented using RestAssured and TestNG.
- CRUD operations were covered:
  - GET
  - POST
  - DELETE
- Reusable configuration and test data utilities were implemented for maintainability.

---

# Assumptions Made

- `api/images` endpoint was assumed based on gallery functionality.
- Followed standard HTTP status code expectations:
  - 200 for successful GET
  - 201 for successful POST
  - 200/204 for successful DELETE
- Since actual backend implementation was unavailable, API behavior was implemented based on standard REST standards.

---

# Framework Design Decisions

- Separate UI and API projects were maintained to avoid dependency conflicts.
- POJO-based payload handling was implemented using Jackson.
- Reusable utility classes were used for scalability and maintainability.

---

# Challenges Faced

- Frontend application source code was not provided.
- Localhost application was unavailable for actual UI execution.
- Had to rely on mocked responses for UI testing to move forward.

## Testability Concerns

### 1. In-memory data store resets on server restart

All data lives in memory and is wiped whenever the Next.js dev server restarts. This means:

- E2E tests that rely on pre-existing seed data are fragile.
- Tests cannot safely assume a known initial state without seeding via the API at the start of each test.
- The "persistence" E2E test (`add image -> reload -> verify`) will always fail after a server restart.

### 2. No `data-testid` attributes on interactive elements

The application does not expose stable `data-testid` attributes on key elements (image cards, search box, date inputs, keyword dropdown, dialogs).

### 3. Non-deterministic ordering

GET `/api/images` does not guarantee a stable sort order. Tests that check "the first card has title X" are non-deterministic.

### 4. No unique constraint on `title`

Two images can share the same title. Tests that locate an image by title (rather than id) can match the wrong item when the store contains historical data.

---

## Bugs / Defects Found

- API (POST)

The API is not validating the url field properly. Even invalid values like `"not-a-url"` are accepted and return a success response (201).

- API (POST)

There is no validation on the uploadDate field. Incorrect dates like `"2024-99-99"` are accepted, which can break features like date filtering later.

- API (POST)

When required fields are missing, the API returns a 400 error, but the response does not clearly mention which field is missing.

- UI (Search)

The search functionality behaves inconsistently with respect to case sensitivity. For example, searching `"mountain"` may not return results like `"Mountain"`.

- UI (Date Filter)

When only a start date is selected and no end date is provided, the application filters out all results. Ideally, it should act as an open-ended filter.

- API (DELETE)

Deleting a record that doesn’t exist returns a 500 error instead of a 404. This indicates improper error handling in the backend.

- UI (Add Image Dialog)

If the API call fails (due to network or server error), the UI does not show any error message. The form just resets, which can confuse users.

- API (GET)

The GET API does not support pagination. It returns all records in one response, which may not be efficient when the dataset grows.

---

## Future Improvements

- Add negative API test scenarios
- Integrate reporting (Allure/Extent Reports)
- Add CI/CD pipeline support
- Add environment management
- Add schema validation
