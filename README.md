# AhnafSadi CV Builder

A modern, user-friendly JavaFX application for creating, managing, and viewing professional CVs (Resumes). Built with JavaFX and SQLite, this application allows you to create beautiful CVs, save them to a database, and manage multiple CVs effortlessly.

## 📋 Overview

This CV Builder application provides a complete solution for creating and managing professional CVs. Whether you're a job seeker, student, or professional, this tool helps you create well-formatted CVs with ease. All your CVs are saved in a local SQLite database, so you can access, edit, or delete them anytime.

## ✨ Features

### 🎨 Create Professional CVs
- **Comprehensive Form**: Enter all your details including:
  - Personal Information (Name, Email, Phone, Address)
  - Education History
  - Skills
  - Work Experience
  - Projects
  - Profile Picture
- **Live Preview**: See your CV in a beautifully formatted preview before saving
- **Image Support**: Add your profile picture to make your CV stand out

### 💾 Database Integration
- **SQLite Database**: All CVs are saved locally in a SQLite database (`cv.db`)
- **Persistent Storage**: Your CVs are saved permanently and won't be lost
- **Fast & Reliable**: Lightweight database ensures quick operations

### 📊 Manage Multiple CVs
- **View All CVs**: See all your saved CVs in a convenient table view
- **Preview**: Click to preview any CV in a formatted view
- **Edit**: Update any CV with pre-filled form data
- **Delete**: Remove CVs you no longer need (with confirmation)
- **Search & Organize**: All CVs are organized by creation date

### 🚀 Modern User Interface
- **Clean Design**: Intuitive and user-friendly interface
- **Responsive Layout**: Works smoothly on different screen sizes
- **Professional Styling**: Modern JavaFX design with clean aesthetics

## 🛠️ Technology Stack

- **Java**: Core programming language
- **JavaFX 21**: Modern UI framework for desktop applications
- **SQLite**: Lightweight, serverless database
- **Maven**: Dependency management and build tool
- **FXML**: Declarative UI design

## 📦 Prerequisites

Before running this application, make sure you have:

- **Java JDK 21** or higher installed
- **Maven** (optional, for building from source)
- **IntelliJ IDEA** or any Java IDE (recommended)

## 🚀 Getting Started

### Running the Application

1. **Clone or Download** this repository to your local machine

2. **Open in IntelliJ IDEA**:
   - File → Open → Select the project folder
   - IntelliJ will automatically detect it as a Maven project

3. **Run the Application**:
   - Navigate to `src/main/java/com/example/ahnafsadi_cvbuilder/Launcher.java`
   - Right-click → Run 'Launcher.main()'
   - Or use the run button in your IDE

4. **Alternative: Command Line** (if Maven is installed):
   ```bash
   mvn clean javafx:run
   ```

### First Time Setup

When you run the application for the first time:
- The SQLite database (`cv.db`) will be automatically created in the project root
- The `cv` table will be initialized with all necessary columns
- You're ready to start creating CVs!

## 📖 How to Use

### Creating a New CV

1. Click **"Create your CV"** on the welcome screen
2. Fill in all the required fields:
   - **Full Name** and **Email** are required
   - Other fields are optional but recommended
3. Add your **Profile Picture** (optional) by clicking "Choose Image"
4. Click **"Create CV"** to save and preview your CV
5. Your CV is automatically saved to the database!

### Viewing All CVs

1. Click **"View All CVs"** on the welcome screen
2. You'll see a table with all your saved CVs
3. Each row shows the CV details

### Previewing a CV

1. In the "View All CVs" screen, click the **"Preview"** button for any CV
2. A new window opens showing the formatted CV
3. Close the window when done viewing

### Editing a CV

1. In the "View All CVs" screen, click the **"Edit"** button for any CV
2. The form opens with all fields pre-filled
3. Make your changes
4. Click **"Update CV"** to save changes
5. The table automatically refreshes with updated data

### Deleting a CV

1. In the "View All CVs" screen, click the **"Delete"** button for any CV
2. Confirm the deletion in the popup dialog
3. The CV is permanently removed from the database

## 📁 Project Structure

```
AhnafSadi_CVBuilder/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/ahnafsadi_cvbuilder/
│   │   │       ├── HelloApplication.java      # Main application entry
│   │   │       ├── Launcher.java             # Application launcher
│   │   │       ├── HelloController.java      # Welcome screen controller
│   │   │       ├── FormController.java       # CV form controller
│   │   │       ├── ShowCVController.java     # CV preview controller
│   │   │       ├── CVDataShowController.java  # CV list controller
│   │   │       ├── PersonCV.java             # CV data model
│   │   │       ├── DataBaseHelper.java        # Database operations
│   │   │       └── CVRepository.java         # Repository pattern for async operations
│   │   └── resources/
│   │       └── com/example/ahnafsadi_cvbuilder/
│   │           ├── hello-view.fxml           # Welcome screen UI
│   │           ├── form.fxml                 # CV form UI
│   │           ├── showcv.fxml               # CV preview UI
│   │           └── cv-data-show.fxml         # CV list UI
├── cv.db                                    # SQLite database (created automatically)
├── pom.xml                                  # Maven configuration
└── README.md                                # This file
```

## 🗄️ Database Schema

The application uses a SQLite database with the following structure:

**Table: `cv`**
- `id` (INTEGER, PRIMARY KEY, AUTOINCREMENT)
- `name` (TEXT)
- `email` (TEXT)
- `phone` (TEXT)
- `address` (TEXT)
- `education` (TEXT)
- `skills` (TEXT)
- `work` (TEXT)
- `project` (TEXT)
- `image_path` (TEXT)

## 🔧 Development

### Building the Project

```bash
mvn clean compile
```

### Running Tests

```bash
mvn test
```

### Creating a JAR

```bash
mvn clean package
```

## 🎯 Key Features Explained

### Asynchronous Operations
All database operations run on background threads to keep the UI responsive. The application uses JavaFX's `Platform.runLater()` to safely update the UI from background threads.

### Repository Pattern
The `CVRepository` class implements the repository pattern, providing a clean interface for database operations while handling threading concerns internally.

### Error Handling
The application includes comprehensive error handling:
- Database connection errors are caught and logged
- User-friendly error messages are displayed
- The application continues to work even if database operations fail

## 📝 Notes

- The database file (`cv.db`) is created in the project root directory
- Image paths are stored as file URIs in the database
- All CV data is stored locally - no cloud or external services required
- The application is designed to be lightweight and fast

## 🤝 Contributing

This is a personal project, but suggestions and improvements are welcome!

## 📄 License

This project is created for educational purposes.

## 👤 Author

**Ahnaf Sadi**
- Project: CV Builder Application
- Built with JavaFX and SQLite

## 🙏 Acknowledgments

- JavaFX team for the excellent UI framework
- SQLite for the lightweight database solution
- All the open-source libraries that made this project possible

---

**Happy CV Building! 🎉**

If you have any questions or need help, feel free to explore the code - it's well-commented and organized for easy understanding.

