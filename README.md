# 📱 Android Calculator App

Android calculator app with a responsive layout and circular buttons. Uses GridLayout and Java for basic operations like +, -, ×, ÷. Buttons resize based on screen width to fit all devices. Clean black UI with color-coded keys and right-aligned display for expression and result.

A fully responsive Android calculator app inspired by the iOS design, featuring circular buttons, dynamic layout, and a clean modern UI.

---

## ✨ Features

- 📐 Fully Responsive (works on all screen sizes)
- 🔘 Perfect Circular Buttons (always square → circle)
- 🔢 Dynamic Button Sizing (based on screen width)
- 🧮 Basic Operations (+, −, ×, ÷)
- 📊 Expression + Result Display
- ⬆️ Expression shifts up after calculation
- 🎯 Bottom-aligned button grid
- 🎨 Clean iOS-style UI

---

## 🎨 Color Theme

| Element | Color |
|--------|------|
| Background | `#000000` |
| Operators (+ − × ÷ =) | `#FF9200` |
| AC / DEL / % | `#5B5B5B` |
| Numbers | `#2F2F2F` |
| Result Text | `#FFFFFF` |
| Expression (shifted) | `#818186` |

---

## ⚙️ Technologies Used

- **Java** – Core logic  
- **XML** – UI design  
- **Android SDK**  
- **GridLayout** – Button grid  
- **LinearLayout** – Layout structure  
- **Drawable Shapes** – Circular buttons  
- **Styles & Themes** – UI consistency  

---

## 🧠 How It Works

### 1. Responsive Button System

Button size is calculated dynamically:


buttonSize = (screenWidth - totalMargins) / numberOfColumns


This ensures:
- Equal button width  
- Perfect square shape → circle  
- Consistent spacing (~2dp)  

---

### 2. Layout Structure


Top Section:
Expression + Result

Bottom Section:
GridLayout (Calculator Buttons)


- Top expands based on screen size  
- Grid always stays at the bottom  

---

### 3. Circular Buttons

- Custom drawable with large corner radius  
- Width = Height → always circular  

---

### 4. Calculation Logic

- Stores:
  - First number  
  - Operator  
  - Second number  
- Performs operation on "="  
- Updates result and shifts expression  

---

## 📂 Project Structure


app/
├── java/com/example/calculator/
│ └── MainActivity.java
├── res/
│ ├── layout/
│ │ └── activity_main.xml
│ ├── values/
│ │ ├── colors.xml
│ │ ├── styles.xml
│ │ └── themes.xml
│ └── drawable/
│ └── btn_circle.xml
└── AndroidManifest.xml


---

## 🚀 How to Run

1. Open project in **Android Studio**  
2. Sync Gradle  
3. Connect emulator or physical device  
4. Click **Run ▶**  

---

## ⚠️ Notes

- Uses **NoActionBar theme** (no blue header)  
- Material tint is disabled to preserve custom colors  
- Layout adapts automatically to all screen sizes  
- Buttons always remain circular  

---

## 🔮 Future Improvements

- DEL button functionality  
- Percentage (%) support  
- +/- toggle  
- iOS-style button animations  
- Scientific calculator mode  

---

## 📸 Preview

_Add screenshots of your app here_

---

## 👨‍💻 Author

Abhinav
