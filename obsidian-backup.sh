!/bin/bash

# Path to your Obsidian vault
VAULT_PATH="/home/user/Desktop/"
LOG_FILE="/home/user/Desktop/obsidian-backup.log"

# Function to log messages
log_message() {
	echo "$(date "+%Y-%m-%d %H:%M:%S") - $1" >> "$LOG_FILE"
}

# Navigate to your vault
cd "$VAULT_PATH" || {
	log_message "ERROR: Could not navigate to $VAULT_PATH"
}

# Check if there are any changes to commit
if git status --porcelain | grep -q .; then
    # Add all changes
    git add .

    # Get current timestamp for commit message
    TIMESTAMP=$(date "+%Y-%m-%d %H:%M:%S")

    # Commit changes with timestamp
    git commit -m "Automatic backup: $TIMESTAMP"

    # Push to GitHub
    if git push origin main; then
        log_message "SUCCESS: Backup completed successfully"
    else
        log_message "ERROR: Failed to push to GitHub"
    fi
else
    log_message "INFO: No changes to commit"
fi
