package sample.demo;

import java.sql.*;

public class JdbcWithMaven {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		String url="jdbc:mysql://localhost:3306/j2ee"; 
		String uname="root";
		String pass="Aj@080123";
		Connection con = DriverManager.getConnection(url, uname, pass); 
		
		System.out.println("Connection Established to DBMS ");
		
		String sql = "SELECT * FROM student";
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		System.out.println("Data received: ");
		
		while(rs.next()) {
			System.out.print("Roll: " + rs.getInt(1) + " | ");
			System.out.print("Name: " + rs.getString(2));
			System.out.println();
		}
	}
}

/*
 *  Build and Run the Project Properly
Make sure you're not accidentally trying to run the project in a test configuration or without Maven building it correctly.

Try clean and build:
Right-click project → Run As → Maven build → In Goals, enter:

nginx
Copy
Edit
clean install
Then click Run.

Then run the class:
Right-click JdbcWithMaven.java → Run As → Java Application
 
 * 
 * 

---

## ✅ Steps to Create a Maven Project in Eclipse

### 📝 **1. Create a New Maven Project**
1. Open **Eclipse**
2. Go to:  
   `File` → `New` → `Other...`
3. In the dialog, type **Maven** and choose:  
   `Maven Project` → Click **Next**

---

### 🏗️ **2. Configure the Maven Project**
choose catalogue - internal and select maven-archtype-quickstart

---

### 📦 **3. Enter Project Info**
Fill in the following:
- **Group Id**: e.g., `com.example` - is like the package name
- **Artifact Id**: e.g., `demo` - is like the project name
- **Version**: default is fine (`0.0.1-SNAPSHOT`)
- Click **Finish**

Now Eclipse will create a project structure like this:

```
demo/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       └── java/
├── pom.xml
```

---

### ⚙️ **4. Add Dependencies**
Open the `pom.xml` and add any required dependencies inside the `<dependencies>` tag. For example, for MySQL:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.2.0</version>
</dependency>
```

Don't forget to **save the `pom.xml`**!

---

### 🔁 **5. Update Maven Project**
To download and link dependencies:

> Right-click your project → **Maven** → **Update Project...**  
> ✅ Check **Force Update**  
> Click **OK**

---

### 🧪 **6. Create Your Java Class**
Inside `src/main/java`, create your Java packages and classes like normal.

Example:
```java
package com.example.demo;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Maven!");
    }
}
```

---

### ▶️ **7. Run the Project**
Right-click on your class → **Run As** → **Java Application**

 */