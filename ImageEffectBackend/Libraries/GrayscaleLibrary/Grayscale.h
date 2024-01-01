// Header guard to prevent multiple inclusion of the same header file.
#ifndef GRAYSCALE_H
#define GRAYSCALE_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyGrayscale function, which converts an image to grayscale.
// Takes a 2D vector of Pixel objects as input and modifies it.
void applyGrayscale(vector<vector<Pixel>> &imageVector);

#endif // GRAYSCALE_H
