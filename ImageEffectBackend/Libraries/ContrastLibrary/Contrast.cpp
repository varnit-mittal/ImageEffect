// This C++ file includes necessary libraries, the "Contrast.h" header file, and likely the "Pixel.h" header file.
#include <vector>      // Standard C++ library for dynamic arrays (vectors).
#include <math.h>      // Standard C library for mathematical functions.
#include <stdio.h>     // Standard C library for input and output operations.
#include "Contrast.h"  // Custom header file that likely contains the definition of the Pixel structure.
#include "../Pixel.h" // Custom header file that likely contains the definition of the Pixel structure.

using namespace std;   // Using the standard namespace for convenience.

// Function to apply contrast adjustment to an image represented by a 2D vector of pixels.
void applyContrast(vector<vector<Pixel>> &imageVector, float amount)
{
    // Adjust the contrast using the specified formula.
    amount = 259 * (amount + 255) / (255 * (259 - amount));

    // Loop through each pixel in the image.
    for (int i = 0; i < imageVector.size(); i++)
    {
        for (int j = 0; j < imageVector[i].size(); j++)
        {
            // Apply contrast adjustment to the red component of the pixel.
            imageVector[i][j].r = max((float)0, min((float)255, (imageVector[i][j].r - 128) * amount + 128));

            // Apply contrast adjustment to the green component of the pixel.
            imageVector[i][j].g = max((float)0, min((float)255, (imageVector[i][j].g - 128) * amount + 128));

            // Apply contrast adjustment to the blue component of the pixel.
            imageVector[i][j].b = max((float)0, min((float)255, (imageVector[i][j].b - 128) * amount + 128));
        }
    }
}
