@echo off
cd /d "%~dp0"

if not exist out mkdir out

echo Compiling CaseCraft...
javac -d out src\*.java

if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo.
echo Starting CaseCraft...
echo.

java -cp out Main

pause