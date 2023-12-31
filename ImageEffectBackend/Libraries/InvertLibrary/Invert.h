// Header guard to prevent multiple inclusion of the same header file.
#ifndef INVERT_H
#define INVERT_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyInvert function, which inverts colors in an image.
// Takes a 2D vector of Pixel objects as input and modifies it by inverting the colors.
void applyInvert(vector<vector<Pixel>> &imageVector);

#endif // INVERT_H
