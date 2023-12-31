// Header guard to prevent multiple inclusion of the same header file.
#ifndef HUE_SATURATION_H
#define HUE_SATURATION_H

// Include necessary libraries and files for the header.
#include <vector>       // Standard C++ library for dynamic arrays (vectors).
#include "../Pixel.h"   // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;    // Using the standard namespace for convenience.

// Function declaration for the applyHueSaturation function, which adjusts hue and saturation of an image.
// Takes a 2D vector of Pixel objects as input and modifies it based on specified saturation and hue values.
void applyHueSaturation(vector<vector<Pixel>> &image, float saturationValue, float hueValue);

#endif // HUE_SATURATION_H
