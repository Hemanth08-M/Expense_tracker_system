# Maven Installation Guide for Windows

## Quick Alternative Solution

Since Maven installation is complex, here are **3 easier alternatives**:

---

## **Option A: Use VS Code Extensions (EASIEST - NO INSTALLATION)**

### Step 1: Install Extensions in VS Code
1. Press `Ctrl + Shift + X` (Extensions)
2. Search and install:
   - ✅ **Extension Pack for Java** (by Microsoft)
   - ✅ **Maven for Java** (by Microsoft)
   - ✅ **Project Manager for Java** (by Microsoft)

### Step 2: Reload VS Code
- Press `Ctrl + Shift + P`
- Type: `Developer: Reload Window`
- Press Enter

### Step 3: The extensions will:
- ✅ Automatically download Servlet API libraries
- ✅ Fix all red import errors
- ✅ Enable project compilation

**This should take 2-3 minutes automatically!**

---

## **Option B: Download Maven Manually (5 minutes)**

### Step 1: Download Maven
1. Go to: https://maven.apache.org/download.cgi
2. Download: `apache-maven-3.9.0-bin.zip`
3. Extract to: `C:\Program Files\apache-maven`

### Step 2: Set PATH Environment Variable
1. Press `Win + X` → System
2. Click "Advanced system settings"
3. Click "Environment Variables"
4. Under "System variables", click "New"
5. Variable name: `MAVEN_HOME`
6. Variable value: `C:\Program Files\apache-maven`
7. Click OK

### Step 3: Add to PATH
1. In Environment Variables, find `Path`
2. Click "Edit"
3. Click "New"
4. Add: `C:\Program Files\apache-maven\bin`
5. Click OK → OK

### Step 4: Verify Installation
```powershell
mvn -version
```

### Step 5: Run Maven
```powershell
cd "C:\Users\Hemanth\Desktop\Expense tracker"
mvn clean install
```

---

## **Option C: Use Eclipse IDE (AUTOMATIC)**

Just use Eclipse instead:
1. Create Dynamic Web Project
2. Add Apache Tomcat as Runtime
3. All libraries auto-load! ✅

---

## **My Recommendation: Try Option A First!**
It's automatic, no downloads, takes 2 minutes. Just install extensions and reload VS Code.

**Try it now and let me know if errors disappear!** 👍
