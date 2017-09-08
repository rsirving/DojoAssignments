import numpy as np
import random
# Creates a checkerboard of 0s, randomly places a 1, returns where that 1 is.
def hideandseek(board):
    grid = np.zeros((board,board))
    xcoord = random.randint(0, board-1)
    ycoord = random.randint(0, board-1)
    grid[ycoord][xcoord] = 1
    print grid

hideandseek(5)
hideandseek(10)