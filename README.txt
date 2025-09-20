# ToDoPro – Task Manager

## 📌 Introduction
**ToDoPro** is a simple yet powerful task management application built in Java with a Swing-based graphical user interface (GUI). It allows users to create, manage, and persist their tasks in a user-friendly way.  

The program is designed with an **MVC-like architecture**:
- **Model:** `ToDo` – represents tasks.  
- **Controller:** `ToDoProManager` – manages logic and task operations.  
- **View:** `NewJFrame` – provides an interactive GUI.  

---

## 📑 Table of Contents
1. [Features](#-features)  
2. [Installation](#-installation)  
3. [Usage](#-usage)  
4. [Dependencies](#-dependencies)  
5. [Configuration](#-configuration)  
6. [Examples](#-examples)  
7. [Troubleshooting](#-troubleshooting)  
8. [Contributors](#-contributors)  
9. [License](#-license)  

---

## ✨ Features
- Add new tasks with descriptions.  
- Mark tasks as completed/incomplete.  
- Delete individual tasks.  
- Clear all completed tasks at once.  
- Save tasks to a `.todos` file (Java serialization).  
- Load tasks from a `.todos` file.  
- Exit with save confirmation to prevent data loss.  
- User-friendly GUI with confirmation dialogs, status labels, and auto-clearing messages.  
- Task display includes creation and completion timestamps.  

---

## ⚙️ Installation
1. Clone or download this repository.  
2. Open the project in an IDE (e.g., **NetBeans** or **IntelliJ IDEA**).  
3. Ensure JDK 8+ is installed.  
4. Compile all `.java` files:
   ```bash
   javac ToDo.java ToDoProManager.java ToDoPro.java NewJFrame.java
   ```
5. Run the program:
   ```bash
   java ToDoPro
   ```

---

## 🖥️ Usage
1. Enter a task description in the **input field**.  
2. Use buttons to perform actions:  
   - **Add** → add new tasks  
   - **Mark Done** → mark selected task as completed  
   - **Delete** → remove selected task  
   - **Clear Completed** → remove all completed tasks  
   - **Save/Load** → persist tasks to/from file  
   - **Exit** → confirm exit and optionally save  

3. The **task list** displays all tasks with checkboxes and timestamps.  
4. A **status label** shows operation feedback and clears automatically after 3 seconds.  

---

## 📦 Dependencies
- **Java SE 8+**  
- Swing (built-in Java library, no external dependencies)  

---

## 🔧 Configuration
No external configuration is required.  
Tasks are saved using **Java serialization** into `.todos` files chosen by the user via file dialogs.  

---

## 📚 Examples
- **Adding a Task:**  
  Enter "Finish project report" → click *Add* → task appears in the list.  

- **Marking as Done:**  
  Select "Finish project report" → click *Mark Done* → task updates with `[✓]` and timestamp.  

- **Saving Tasks:**  
  Click *Save* → choose a location/file (e.g., `tasks.todos`).  

- **Loading Tasks:**  
  Click *Load* → select previously saved `tasks.todos`.  

---

## 🛠️ Troubleshooting
- **Empty input field error:** Ensure task description is not blank.  
- **No task selected:** Select a task before marking or deleting.  
- **File save/load errors:** Verify file permissions and correct `.todos` extension.  

---

## 👨‍💻 Contributors
- **You** (Project Author)  

---

## 📄 License
This project is provided for educational and personal use. You may extend and modify it freely. For redistribution or commercial use, please add an appropriate license.
