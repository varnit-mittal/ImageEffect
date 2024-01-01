// Header guard to prevent multiple inclusion of the same header file.
#ifndef DOMINANTCOLOUR_H
#define DOMINANTCOLOUR_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyDominantColour function, which sets all pixels in an image to the dominant color.
// Takes a 2D vector of Pixel objects as input and modifies it to have a uniform dominant color.
void applyDominantColour(vector<vector<Pixel>>& image);

#endif // DOMINANTCOLOUR_H
