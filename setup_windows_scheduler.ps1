# Setup Windows Task Scheduler for Daily Commits
# Run this script as Administrator to schedule daily commits

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Windows Task Scheduler Setup" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Check if running as administrator
$isAdmin = ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)

if (-not $isAdmin) {
    Write-Host "WARNING: Not running as Administrator!" -ForegroundColor Red
    Write-Host "Some operations may require elevated privileges." -ForegroundColor Yellow
    Write-Host ""
}

$scriptPath = Join-Path $PWD "daily_commit_scheduler.ps1"
$taskName = "DSA-Daily-Commit"
$description = "Automatically commits 12 DSA files daily and pushes to GitHub"

Write-Host "Script Path: $scriptPath" -ForegroundColor Yellow
Write-Host "Task Name: $taskName" -ForegroundColor Yellow
Write-Host ""

# Check if task already exists
$existingTask = Get-ScheduledTask -TaskName $taskName -ErrorAction SilentlyContinue

if ($existingTask) {
    Write-Host "Task already exists. Removing old task..." -ForegroundColor Yellow
    Unregister-ScheduledTask -TaskName $taskName -Confirm:$false
    Write-Host "✓ Old task removed" -ForegroundColor Green
    Write-Host ""
}

# Create action (run PowerShell script)
$action = New-ScheduledTaskAction -Execute "PowerShell.exe" `
    -Argument "-NoProfile -ExecutionPolicy Bypass -File `"$scriptPath`" -PushToGitHub"

# Create trigger (daily at 9:00 AM)
$trigger = New-ScheduledTaskTrigger -Daily -At "9:00AM"

# Create settings
$settings = New-ScheduledTaskSettingsSet `
    -AllowStartIfOnBatteries `
    -DontStopIfGoingOnBatteries `
    -StartWhenAvailable `
    -RunOnlyIfNetworkAvailable

# Create principal (run as current user)
$principal = New-ScheduledTaskPrincipal -UserId "$env:USERDOMAIN\$env:USERNAME" -LogonType Interactive

# Register the task
try {
    Register-ScheduledTask `
        -TaskName $taskName `
        -Action $action `
        -Trigger $trigger `
        -Settings $settings `
        -Principal $principal `
        -Description $description | Out-Null
    
    Write-Host "✓ Task scheduled successfully!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Task Details:" -ForegroundColor Cyan
    Write-Host "  Name: $taskName" -ForegroundColor White
    Write-Host "  Schedule: Daily at 9:00 AM" -ForegroundColor White
    Write-Host "  Action: Run daily_commit_scheduler.ps1" -ForegroundColor White
    Write-Host ""
    Write-Host "To view the task:" -ForegroundColor Yellow
    Write-Host "  Get-ScheduledTask -TaskName '$taskName'" -ForegroundColor White
    Write-Host ""
    Write-Host "To remove the task:" -ForegroundColor Yellow
    Write-Host "  Unregister-ScheduledTask -TaskName '$taskName' -Confirm:`$false" -ForegroundColor White
    Write-Host ""
    Write-Host "To test the task manually:" -ForegroundColor Yellow
    Write-Host "  Start-ScheduledTask -TaskName '$taskName'" -ForegroundColor White
    
} catch {
    Write-Host "✗ Failed to schedule task: $_" -ForegroundColor Red
    Write-Host ""
    Write-Host "Alternative: Run manually with:" -ForegroundColor Yellow
    Write-Host "  .\daily_commit_scheduler.ps1 -PushToGitHub" -ForegroundColor White
}

