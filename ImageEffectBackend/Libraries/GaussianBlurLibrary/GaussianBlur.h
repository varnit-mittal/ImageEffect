// Header guard to prevent multiple inclusion of the same header file.
#ifndef GAUSSIAN_BLUR_H
#define GAUSSIAN_BLUR_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyGaussianBlur function, which performs Gaussian blur on an image.
// Takes a 2D vector of Pixel objects as input and modifies it based on the specified blur radius.
void applyGaussianBlur(vector<vector<Pixel>> &image, float radius);

#endif // GAUSSIAN_BLUR_H
