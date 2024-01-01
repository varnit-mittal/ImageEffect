// Header guard to prevent multiple inclusion of the same header file.
#ifndef ROTATION_H
#define ROTATION_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyRotation function, which rotates an image based on the specified value.
// Takes a 2D vector of Pixel objects and an angle value (1, 2, or 3) as input.
// Returns the rotated version of the input image based on the specified angle.
vector<vector<Pixel>> applyRotation(vector<vector<Pixel>> &imageVector, int value);

#endif // ROTATION_H
