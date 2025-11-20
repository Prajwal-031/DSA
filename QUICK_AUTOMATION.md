# ⚡ Quick Automation Reference

## 🎯 One-Command Daily Commits

```powershell
# Commit 12 files and push to GitHub (run this daily)
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub
```

---

## 🆕 Add New Topic (3 Steps)

```powershell
# Step 1: Create topic structure
.\add_new_topic.ps1 -TopicName "Strings"

# Step 2: Add your code (edit files in the new folder)

# Step 3: Commit automatically
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub
```

---

## 🤖 Setup Automatic Daily Commits (One Time)

```powershell
# Run as Administrator (optional)
.\setup_windows_scheduler.ps1

# Now it runs automatically every day at 9 AM!
```

---

## 📋 What Gets Committed?

- ✅ Python files (`.py`)
- ✅ Java files (`.java`)
- ✅ Documentation (`.md`)
- ❌ Automation scripts (filtered out)
- ❌ Log files (ignored)

**12 files per day automatically!**

---

## 🔄 Complete Workflow

```powershell
# 1. Create new topic
.\add_new_topic.ps1 -TopicName "LinkedLists"

# 2. Add code throughout the day
# (Edit files in 03_LinkedLists/)

# 3. Daily commit (runs automatically or manually)
.\daily_commit_scheduler.ps1 -FilesPerDay 12 -PushToGitHub
```

---

## 📊 View Progress

```powershell
# Check commit log
cat commit_log.txt

# View git history
git log --oneline

# Check remaining files
git status
```

---

**That's it! Your repository commits 12 files daily automatically! 🚀**

