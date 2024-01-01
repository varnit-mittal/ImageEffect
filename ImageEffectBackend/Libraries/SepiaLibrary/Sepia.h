// Header guard to prevent multiple inclusion of the same header file.
#ifndef SEPIA_H
#define SEPIA_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applySepia function, which applies sepia tone to an image.
// Takes a 2D vector of Pixel objects as input and modifies it by applying the sepia effect.
void applySepia(vector<vector<Pixel>> &imageVector);

#endif // SEPIA_H
