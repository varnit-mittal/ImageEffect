// Header guard to prevent multiple inclusion of the same header file.
#ifndef FLIP_H
#define FLIP_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyFlip function, which performs horizontal and vertical flips on an image.
// Takes a 2D vector of Pixel objects as input and modifies it based on horizontal and vertical flip values.
void applyFlip(vector<vector<Pixel>>& image, int horizontalFlipValue, int verticalFlipValue);

#endif // FLIP_H
