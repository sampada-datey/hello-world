#!/bin/bash

# Script to update all files within the specified folder
# Usage: ./update_reports.sh <folder_path>

folder_path="Reports"  # Get folder path from argument

if [ -d "$folder_path" ]; then
    # Check if the folder exists
    echo "Updating files in $folder_path"
    
    # Your logic to update files within the folder goes here...
    # For example, let's pretend we're appending a line to each file:
    for file in "$folder_path"/*; do
        echo "Updating $file"
        echo "<p>Test results appended</p>" >> "$file"
    done
    
    echo "Files updated successfully."
else
    echo "Folder not found: $folder_path"
    exit 1
fi
