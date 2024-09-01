
# GG1 Loyalty System

## Overview

GG1 is a comprehensive loyalty management system built on a fully reactive stack, leveraging Spring WebFlux, R2DBC, and ReactJS. The system supports various functionalities, including user authentication, points management, reward management, purchase tracking, order management, and campaign management.

## Features

- **Authentication and Authorization**: Role-based user management with JWT token support.
- **Points Management**: Track, add, and redeem loyalty points.
- **Reward Management**: Manage rewards and allow users to redeem them using points.
- **Purchase Tracking**: Record and track user purchases.
- **Order Management**: Create and manage orders.
- **Campaign Management**: Manage marketing campaigns.
- **Single Sign-On (SSO)**: OAuth-based authentication for seamless user access.

## Tech Stack

- **Backend**:
    - **Spring Boot (WebFlux)**: Reactive web framework for building non-blocking applications.
    - **R2DBC**: Reactive Relational Database Connectivity for interacting with relational databases.
    - **JWT**: JSON Web Tokens for secure user authentication.
    - **OAuth**: Single Sign-On functionality.

- **Frontend**:
    - **ReactJS**: A JavaScript library for building user interfaces.

## API Endpoints

### 1. Authentication and Authorization
- **POST** `/auth/login`: Authenticate user and issue a token.
- **POST** `/auth/logout`: Log out user and invalidate token.
- **POST** `/auth/register`: Register a new user.
- **GET** `/auth/roles`: Retrieve all available roles.
- **POST** `/auth/assign-role`: Assign a role to a user.

### 2. Points Management
- **GET** `/points/{userId}`: Retrieve the points balance for a user.
- **POST** `/points/add`: Add points to a user's balance.
- **POST** `/points/redeem`: Redeem points from a user's balance.
- **GET** `/points/history/{userId}`: Get the points transaction history for a user.

### 3. Reward Management
- **GET** `/rewards`: Retrieve a list of available rewards.
- **POST** `/rewards/add`: Add a new reward to the system.
- **PUT** `/rewards/update/{rewardId}`: Update details of an existing reward.
- **DELETE** `/rewards/delete/{rewardId}`: Remove a reward from the system.
- **POST** `/rewards/redeem`: Redeem a reward using points.

### 4. Purchase Tracking
- **POST** `/purchases`: Record a new purchase transaction.
- **GET** `/purchases/{userId}`: Retrieve all purchases made by a user.
- **GET** `/purchases/details/{purchaseId}`: Get details of a specific purchase.

### 5. Order Management
- **POST** `/orders`: Create a new order.
- **GET** `/orders/{userId}`: Retrieve all orders placed by a user.
- **GET** `/orders/details/{orderId}`: Get details of a specific order.
- **PUT** `/orders/update/{orderId}`: Update an existing order.
- **DELETE** `/orders/cancel/{orderId}`: Cancel an existing order.

### 6. Campaign Management
- **GET** `/campaigns`: Retrieve a list of active campaigns.
- **POST** `/campaigns/add`: Create a new campaign.
- **PUT** `/campaigns/update/{campaignId}`: Update details of an existing campaign.
- **DELETE** `/campaigns/delete/{campaignId}`: Delete a campaign.
- **POST** `/campaigns/activate/{campaignId}`: Activate a campaign.
- **POST** `/campaigns/deactivate/{campaignId}`: Deactivate a campaign.

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-repo/gg1-loyalty-system.git
   cd gg1-loyalty-system
   ```

2. **Backend Setup:**
    - Ensure you have Java 17 or above installed.
    - Install dependencies:

      ```bash
      ./mvnw clean install
      ```

    - Run the application:

      ```bash
      ./mvnw spring-boot:run
      ```

3. **Frontend Setup:**
    - Ensure you have Node.js and npm installed.
    - Navigate to the `frontend` directory:

      ```bash
      cd frontend
      ```

    - Install dependencies:

      ```bash
      npm install
      ```

    - Run the development server:

      ```bash
      npm start
      ```

## Usage

- **Access the API documentation**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Frontend**: Access the React frontend at [http://localhost:3000](http://localhost:3000)

## Contributing

Contributions are welcome! Please create an issue or submit a pull request.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
