// This C++ file includes necessary libraries, the "Rotation.h" header file, and the "Pixel.h" header file.
#include "Rotation.h"   // Header file for the image rotation functions.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include <cmath>        // Standard C library for mathematical functions.
#include <algorithm>    // Standard C++ library for algorithms.
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function to transpose a matrix of Pixels.
// Takes a 2D vector of Pixel objects as input and returns its transposed version.
vector<vector<Pixel>> applyTransposeToMatrix(vector<vector<Pixel>> &matrix)
{
    int rows = static_cast<int>(matrix.size());
    int cols = rows > 0 ? static_cast<int>(matrix[0].size()) : 0;

    // Create a new transposed matrix with swapped rows and columns.
    vector<vector<Pixel>> transposedMatrix(cols, vector<Pixel>(rows));

    // Copy the elements from the original matrix to the transposed matrix.
    for (int y = 0; y < rows; ++y)
        for (int x = 0; x < cols; ++x)
            transposedMatrix[x][y] = matrix[y][x];

    return transposedMatrix;
}

// Function to apply a horizontal flip to a matrix of Pixels about its central column.
// Takes a 2D vector of Pixel objects as input and modifies it by applying the flip.
void applyFlipToMatrixAboutCentralColumn(vector<vector<Pixel>> &matrix)
{
    int rows = static_cast<int>(matrix.size());
    int cols = rows > 0 ? static_cast<int>(matrix[0].size()) : 0;

    // Iterate through each row and swap elements around the central column.
    for (int y = 0; y < rows; ++y)
    {
        for (int x = 0; x < cols / 2; ++x)
        {
            // Swap elements on opposite sides of the central column.
            auto temp = matrix[y][x];
            matrix[y][x] = matrix[y][cols - x - 1];
            matrix[y][cols - x - 1] = temp;
        }
    }
}

// Function to apply rotation to an image.
// Takes a 2D vector of Pixel objects and an angle value (1, 2, or 3) as input.
// Returns the rotated version of the input image based on the specified angle.
vector<vector<Pixel>> applyRotation(vector<vector<Pixel>> &imageVector, int value)
{
    int rows = static_cast<int>(imageVector.size());
    int cols = rows > 0 ? static_cast<int>(imageVector[0].size()) : 0;

    int angle = 0;

    // Determine the angle of rotation based on the specified value.
    if (value == 1)
    {
        angle = 90;
        // Transpose the matrix, flip it about the central column, and return the result.
        vector<vector<Pixel>> transposedMatrix = applyTransposeToMatrix(imageVector);
        applyFlipToMatrixAboutCentralColumn(transposedMatrix);
        return transposedMatrix;
    }
    else if (value == 2)
    {
        angle = 180;
        // Reverse the order of rows in the matrix and return the result.
        reverse(imageVector.begin(), imageVector.end());
        return imageVector;
    }
    else if (value == 3)
    {
        angle = 270;
        // Transpose the matrix, reverse each row, flip it about the central column, and return the result.
        vector<vector<Pixel>> transposedMatrix = applyTransposeToMatrix(imageVector);
        for (int i = 0; i < transposedMatrix.size(); ++i)
        {
            reverse(transposedMatrix[i].begin(), transposedMatrix[i].end());
        }
        applyFlipToMatrixAboutCentralColumn(transposedMatrix);
        return transposedMatrix;
    }
    else
    {
        // No rotation, return the original image.
        return imageVector;
    }
}
