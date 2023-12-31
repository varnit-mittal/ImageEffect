// Header guard to prevent multiple inclusion of the same header file.
#ifndef SHARPEN_H
#define SHARPEN_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applySharpen function, which applies a sharpening filter to an image.
// Takes a 2D vector of Pixel objects and a sharpening strength value as input.
void applySharpen(vector<vector<Pixel>> &image, float value);

#endif // SHARPEN_H
