# Ecocycle: Rust Detection from Workshop Waste from Bangkit Academy Capstone Project

Welcome to the GitHub repository for **Ecocycle**, a capstone project developed in collaboration with the **Machine Learning** and **Cloud Computing** cohorts of Bangkit Academy 2023. This mobile application is designed to detect rust in workshop waste materials using machine learning models and cloud computing services. The project is a joint effort between mobile app developers, machine learning engineers, and cloud computing specialists.

## Project Overview

Ecocycle aims to assist workshops in identifying and managing rusted materials by providing an easy-to-use tool for rust detection. The application integrates a machine learning model that identifies rust from images, leveraging cloud-based processing for accuracy and scalability.

### Key Features

- **Rust Detection**: Capture or upload images of materials, and the app will identify and highlight rusted areas.
- **User Authentication**: Secure login and registration system with session management.
- **Image Storage**: Captured and processed images are stored securely in the cloud.
- **Material Management**: Users can save, view, and manage detected rust instances for future reference.
- **Smooth Animations**: Utilizes MotionLayout for fluid animations and transitions, enhancing the user experience.

## Application Layout

<p align="center">
  <img src="https://github.com/user-attachments/assets/1d5f0efc-74fa-424d-b7ee-baaf0f59e176" width="200" alt="Splash">
  <img src="https://github.com/user-attachments/assets/f2c21ba6-4f50-4f9c-a828-eb1cf66634b4" width="200" alt="Get Start">
  <img src="https://github.com/user-attachments/assets/330235db-1e1c-4077-b551-d2deee2c16e6" width="200" alt="Headline 1">
  <img src="https://github.com/user-attachments/assets/3e82aeb3-d44a-4b85-b95a-2fb58e84f58f" width="200" alt="Headline 2">
  <img src="https://github.com/user-attachments/assets/5dd3c520-df1b-4b77-afde-459de0e6c3ed" width="200" alt="Welcome">
  <img src="https://github.com/user-attachments/assets/e1e278e8-8d0f-4dba-abf2-541cac919d58" width="200" alt="Signup">
  <img src="https://github.com/user-attachments/assets/fa0f7354-2de1-405a-a01e-af5c13a6e53e" width="200" alt="Login">
  <img src="https://github.com/user-attachments/assets/0b11d528-2fb3-482d-9620-a985b412adb6" width="200" alt="Main">
</p>

## Libraries and Technologies Used

The application is built using modern Android development tools and best practices, including:

- **Android Jetpack Components**:
  - `core-ktx`: Provides Kotlin extensions for core Android libraries.
  - `appcompat`: Ensures backward compatibility for Android components.
  - `constraintlayout`: Used for building complex layouts with flat hierarchies.
  - `activity-ktx`: Simplifies common tasks with Activity API.
  - `lifecycle-livedata-ktx`: Facilitates data handling with lifecycle awareness.
  - `lifecycle-viewmodel-ktx`: Manages UI-related data in a lifecycle-conscious way.

- **Networking**:
  - `Retrofit`: A type-safe HTTP client for Android and Java.
  - `Gson Converter`: Converts JSON to Java objects for use with Retrofit.
  - `OkHttp Logging Interceptor`: Logs HTTP request and response data.

- **Data Persistence**:
  - `DataStore`: A data storage solution that stores key-value pairs or typed objects.
  
- **Image Loading and Processing**:
  - `Glide`: Efficient image loading and caching.
  - `Lottie`: Used for rendering animations from JSON files exported from Adobe After Effects.

- **Permissions Handling**:
  - `Runtime Permission`: Simplifies Android runtime permissions.

- **Animation**:
  - `MotionLayout`: Used for creating complex motion and widget animations.

## Architecture

The application follows the **Model-View-ViewModel (MVVM)** architecture, ensuring a clear separation of concerns and making the codebase more maintainable and testable.

### Key Components

- **View**: Activities and Fragments that handle UI and user interactions.
- **ViewModel**: Manages UI-related data and communicates with the Model layer.
- **Model**: Encapsulates the application's data and business logic, including repositories and data sources.
