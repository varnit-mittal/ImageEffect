// This C++ file includes necessary libraries, the "Invert.h" header file, and the "Pixel.h" header file.
#include "Invert.h"   // Header file for the color inversion function.
#include <vector>      // Standard C++ library for dynamic arrays (vectors).
#include <math.h>      // Standard C library for mathematical functions.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;   // Using the standard namespace for convenience.

// Function to apply color inversion to an image.
// Takes a 2D vector of Pixel objects as input and modifies it by inverting the colors.
void applyInvert(vector<vector<Pixel>> &imageVector)
{
    // Get the dimensions of the image (rows and columns).
    int m = imageVector.size();
    int n = imageVector[0].size();

    // Iterate through each pixel in the image.
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            // Invert the red, green, and blue components of the pixel.
            imageVector[i][j].r = 255 - imageVector[i][j].r;
            imageVector[i][j].g = 255 - imageVector[i][j].g;
            imageVector[i][j].b = 255 - imageVector[i][j].b;
        }
    }
}
