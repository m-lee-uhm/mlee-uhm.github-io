---
layout: project
type: project
image: img/sudoku/sudoku-image.webp
title: "Sudoku Solver"
date: 2024-09-05
published: true
labels:
  - Java
summary: "A homework assignment I had for ICS211 where I created a program to solve sudoku problems."
---

Sudoku is a puzzle where you attempt to fill out a 9x9 square made up in 3x3 squares with the numbers 1-9. The goal of this puzzle is to find the solution where each row and column of the 9x9 square only contains a unique instance of a digit from 1-9. So for example, you cannot have a row in the 9x9 square containing two different 1s. Similarly, you cannot have a column in the 9x9 square containing two different 3s. In addition to the rule where you can only have one instance of a number in a row or column, the same rule applies to the 3x3 squares. Below is an example of a completed sudoku:

<img width="30%" 
     height="30%" 
     class="mx-auto d-block"
     src="/img/sudoku/solved-sudoku-puzzle.png">

This purpose of this project was to create a program that could take a sudoku problem as an input and solve it by testing each number from 1-9 and checking if that solution is a valid solution. If the solution is not valid, then continue to the next possible value for that cell. This assignment helped me understand how to work with other people when writing software and the importance of commenting our code. This is because for this project, our instructor created part of the code, which was included a method that checks if the solution is valid, along with a method that converts the data for in the sudoku puzzle into a readable string. He also included a program with sample sudokus to test my program with and validate that my program was correct. Everything provided to me was complex and taught me the importance of reading and understanding the code that was created by other people. I also know that I would have been confused on what each method was doing if it was not commented and learned the importance of commenting code.

For this project, I implemented the fillSudoku method in the program which would attempt to solve the sudoku using brute force and testing each possible variation of the sudoku. To help with this, I created a helper method called possibleCellValues which would return the possible values that the cell could be. This way we could reduce the number of variations that I would need to test, since if I learn that a cell has zero possible values, then something is wrong and I can move on to the next possible solution.

Here is a link to the source code if you wish to learn more about this project: [Sudoku src](https://github.com/mlee-uhm/mlee-uhm.github.io/tree/main/projects/sudoku/src).


