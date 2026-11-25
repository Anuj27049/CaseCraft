# CaseCraft - Java Console Detective Game

A simple, story-driven Java console game with five fictional investigation cases.

## Requirements
- JDK 17 or later
- Any Java IDE, or a terminal

## Run using terminal

Open a terminal in the `CaseCraft` folder and run:

```bash
javac -d out src/*.java
java -cp out Main
```

On Windows PowerShell, the same commands work if the JDK is on PATH.

## How to play
1. Start the game.
2. Select the unlocked case.
3. Explore the crime scene to collect evidence.
4. View and question every suspect.
5. Review your notes.
6. Make an accusation.

A case is marked complete when the correct suspect is selected. You need at least 50 points to unlock the next case.

## Project structure
- `Main.java`: program entry point
- `Game.java`: main menu, case progression and profile
- `Investigation.java`: investigation menu and gameplay
- `CaseManager.java`: contains the five case datasets
- `CaseData.java`: stores case information
- `Person.java`, `Suspect.java`: person model and inheritance
- `Evidence.java`: evidence model

## Saving progress
Completed case count and total score are saved automatically in `savegame.txt` in the folder from which you launch the game. Run the commands from the project root so the save file stays beside the `src` folder.

## Notes
The case stories and deduction rules are fictional and predefined.


## Push the project to GitHub

Run from the project root (the folder containing `src`):

```bash
git init
git add .
git commit -m "Initial CaseCraft Java console game"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/CaseCraft.git
git push -u origin main
```

Replace the remote URL with your actual GitHub repository URL. If Git is already initialized and a remote is configured, do not repeat `git init` or `git remote add`; use `git add .`, `git commit`, and `git push`.

The `.gitignore` file excludes compiled `.class` files, the output folder, and the local save file.
