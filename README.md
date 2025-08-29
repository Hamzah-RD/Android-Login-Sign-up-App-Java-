# Android Login & Sign-up App (Java)

This is a simple Android application demonstrating **Login** and **Sign-up** functionality using **Java* and **XML layouts**.  
It features **form validation**, **error handling**, and **navigation between activities**.



## ✨ Features
- ✅ Sign-up screen with:
  - Full Name, Email, Password, Confirm Password
  - Password validation (min 6 characters)
  - Confirm password check
  - Terms & Conditions checkbox
- ✅ Login screen with:
  - Email & Password validation
  - Remember Me option
  - Forgot password click handler
- ✅ Input error handling (shows inline error messages)
- ✅ Smooth navigation between Login, Sign-up, and Home screen
- ✅ Clean and responsive UI with CardView & Material styling

<img width="372" height="662" alt="Screenshot 2025-08-28 134946" src="https://github.com/user-attachments/assets/3aceb769-82ee-470a-8864-3de11a277661" />
<img width="278" height="491" alt="Screenshot 2025-08-28 135017" src="https://github.com/user-attachments/assets/b8de7b5b-a5e8-4a94-b428-de51d5a6e75f" />

## 📂 Project Structure
app/
├── java/com/example/mylogin/
│ ├── MainActivity.java # Login screen
│ ├── Sign_up.java # Sign-up screen
│ └── HomeActivity.java # (dummy Home screen after login)
├── res/layout/
│ ├── activity_main.xml # Login UI
│ └── activity_sign_up.xml # Sign-up UI
├── res/drawable/ # Backgrounds & icons
└── res/values/strings.xml # Strings & labels

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-username/Login-Signup-App.git
cd Login-Signup-App
