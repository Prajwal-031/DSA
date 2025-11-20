# 🤖 Automation Guide - Daily Commits to GitHub

This guide explains how to automate adding new topics and committing 12 files daily to GitHub.

---

## 📋 Overview

The automation system includes:
1. **Daily Commit Scheduler** - Commits 12 files per day automatically
2. **New Topic Creator** - Automatically creates topic structure
3. **Windows Task Scheduler** - Runs daily commits automatically
4. **Smart Commit Messages** - Auto-generates proper commit messages

---

## 🚀 Quick Start

### **Step 1: Initial Setup (One Time)**

```powershell
# Navigate to your DSA folder
cd C:\Users\prajw\Documents\program\DSA

# Configure Git (if not done)
git config user.name "Your Name"
git config user.email "your.email@example.com"

# Add GitHub remote
git remote add origin https://github.com/YOUR_USERNAME/DSA.git
git branch -M main
```

### **Step 2: Test Daily Commit (Manual)**

```powershell
# Test committing 12 files
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub
```

### **Step 3: Schedule Automatic Daily Commits**

```powershell
# Run as Administrator (optional, for Windows Task Scheduler)
.\setup_windows_scheduler.ps1
```

---

## 📝 Adding New Topics Automatically

### **Method 1: Interactive**

```powershell
# Add a new topic (e.g., Strings)
.\add_new_topic.ps1 -TopicName "Strings"

# It will:
# - Auto-detect next topic number
# - Create folder structure
# - Create template files
# - Ready for you to add code
```

### **Method 2: With Auto-Commit**

```powershell
# Add topic and commit immediately
.\add_new_topic.ps1 -TopicName "Strings" -AutoCommit -PushToGitHub
```

### **Method 3: Specify Topic Number**

```powershell
# Add topic with specific number
.\add_new_topic.ps1 -TopicName "LinkedLists" -TopicNumber 3
```

---

## 🔄 Daily Commit Workflow

### **Manual Daily Commit**

```powershell
# Commit 12 files and push to GitHub
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub

# Or commit without pushing
.\daily_commit_scheduler.ps1 -FilesPerDay 12
```

### **Automatic Daily Commit (Windows Task Scheduler)**

1. **Setup (One Time):**
   ```powershell
   # Run as Administrator
   .\setup_windows_scheduler.ps1
   ```

2. **The task will:**
   - Run daily at 9:00 AM
   - Commit 12 files automatically
   - Push to GitHub
   - Log all activities

3. **View/Manage Task:**
   ```powershell
   # View task
   Get-ScheduledTask -TaskName "DSA-Daily-Commit"
   
   # Run manually
   Start-ScheduledTask -TaskName "DSA-Daily-Commit"
   
   # Remove task
   Unregister-ScheduledTask -TaskName "DSA-Daily-Commit" -Confirm:$false
   ```

---

## 📊 How It Works

### **File Selection:**
- Automatically finds uncommitted files
- Filters out automation scripts
- Commits 12 files per day
- Generates proper commit messages

### **Commit Messages:**
Automatically generates messages like:
- `feat(python): Add arrays two sum problem`
- `feat(java): Add strings reverse problem`
- `docs: Add linked lists topic README with concepts and patterns`

### **Smart Organization:**
- Detects topic from folder path
- Identifies file type (Python/Java/Docs)
- Creates descriptive commit messages

---

## 🎯 Complete Workflow Example

### **Scenario: Adding "Strings" Topic**

```powershell
# 1. Create new topic structure
.\add_new_topic.ps1 -TopicName "Strings"

# 2. Add your code implementations
# Edit files in: 02_Strings/

# 3. Commit 12 files daily
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub

# Or let it run automatically (if scheduled)
```

---

## 📁 File Structure After Automation

```
DSA/
├── 01_Arrays/          (Topic 1)
│   ├── README.md
│   ├── PRACTICE_PROBLEMS.md
│   ├── python/
│   └── java/
├── 02_Strings/         (Topic 2 - Auto-created)
│   ├── README.md
│   ├── PRACTICE_PROBLEMS.md
│   ├── python/
│   └── java/
├── 03_LinkedLists/     (Topic 3 - Auto-created)
│   └── ...
├── daily_commit_scheduler.ps1
├── add_new_topic.ps1
└── commit_log.txt      (Auto-generated)
```

---

## 🔧 Configuration Options

### **Daily Commit Scheduler Parameters:**

```powershell
# Change number of files per day
.\daily_commit_scheduler.ps1 -FilesPerDay 15

# Commit without pushing
.\daily_commit_scheduler.ps1 -FilesPerDay 12

# Commit and push
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub
```

### **New Topic Creator Parameters:**

```powershell
# Basic usage
.\add_new_topic.ps1 -TopicName "Trees"

# With auto-commit
.\add_new_topic.ps1 -TopicName "Trees" -AutoCommit

# With auto-commit and push
.\add_new_topic.ps1 -TopicName "Trees" -AutoCommit -PushToGitHub

# Specify topic number
.\add_new_topic.ps1 -TopicName "Graphs" -TopicNumber 5
```

---

## 📝 Commit Log

All commits are logged in `commit_log.txt`:
```
[2024-01-15 09:00:00] Daily commit started - Target: 12 files
[2024-01-15 09:00:01] Committed: 02_Strings/python/01_basics.py
[2024-01-15 09:00:02] Committed: 02_Strings/java/StringsBasics.java
...
[2024-01-15 09:00:12] Total commits: 12
[2024-01-15 09:00:13] Pushed to GitHub successfully
```

---

## 🐛 Troubleshooting

### **Issue: "No uncommitted files found"**
- **Solution:** Add new files or create new topic

### **Issue: "Failed to push to GitHub"**
- **Solution:** Check remote configuration:
  ```powershell
  git remote -v
  git remote set-url origin https://github.com/YOUR_USERNAME/DSA.git
  ```

### **Issue: "Task Scheduler not working"**
- **Solution:** Run manually:
  ```powershell
  .\daily_commit_scheduler.ps1 -PushToGitHub
  ```

### **Issue: "Permission denied"**
- **Solution:** Run PowerShell as Administrator

---

## ✅ Best Practices

1. **Daily Routine:**
   - Add code throughout the day
   - Let scheduler commit 12 files daily
   - Review commits on GitHub

2. **Topic Creation:**
   - Use `add_new_topic.ps1` for consistency
   - Follow naming convention (e.g., "Strings", "LinkedLists")
   - Let auto-commit handle the rest

3. **Commit Messages:**
   - Automatically generated (no need to write manually)
   - Follows conventional commit format
   - Includes topic and file type

4. **GitHub Sync:**
   - Push daily to keep GitHub updated
   - Review commits regularly
   - Maintain clean commit history

---

## 🎓 Example: Complete Daily Workflow

```powershell
# Morning: Create new topic
.\add_new_topic.ps1 -TopicName "Stacks"

# Day: Add code implementations
# (Edit files in 04_Stacks/)

# Evening: Commit and push (or let scheduler do it)
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub

# Next day: Scheduler runs automatically at 9 AM
# (No action needed)
```

---

## 📚 Scripts Overview

| Script | Purpose | Usage |
|--------|---------|-------|
| `daily_commit_scheduler.ps1` | Commits 12 files daily | Run daily or schedule |
| `add_new_topic.ps1` | Creates new topic structure | When adding new topic |
| `setup_windows_scheduler.ps1` | Sets up Windows Task Scheduler | One-time setup |
| `automate_commits.ps1` | Flexible batch committing | Manual batch commits |

---

**Happy Automating! 🚀**

Your DSA repository will now automatically commit 12 files daily and push to GitHub!

