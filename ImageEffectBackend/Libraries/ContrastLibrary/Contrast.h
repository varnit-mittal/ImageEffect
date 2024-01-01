// Header guard to prevent multiple inclusion of the same header file.
#ifndef CONTRAST_H
#define CONTRAST_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyContrast function, which adjusts the contrast of an image.
// Takes a 2D vector of Pixel objects as input and modifies it based on the specified contrast amount.
void applyContrast(vector<vector<Pixel>> &imageVector, float amount);

#endif // CONTRAST_H
